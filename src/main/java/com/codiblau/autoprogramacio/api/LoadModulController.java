package com.codiblau.autoprogramacio.api;

import com.codiblau.autoprogramacio.manager.CompetenciaProfessionalService;
import com.codiblau.autoprogramacio.manager.ContingutService;
import com.codiblau.autoprogramacio.manager.ModulService;
import com.codiblau.autoprogramacio.manager.ResultatAprenentatgeCicleService;
import com.codiblau.autoprogramacio.model.CompetenciaProfessional;
import com.codiblau.autoprogramacio.model.Contingut;
import com.codiblau.autoprogramacio.model.Modul;
import com.codiblau.autoprogramacio.model.ResultatAprenentatgeCicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoadModulController {
    @Autowired
    ModulService modulService;

    @Autowired
    CompetenciaProfessionalService competenciaProfessionalService;

    @Autowired
    ResultatAprenentatgeCicleService resultatAprenentatgeCicleService;

    @Autowired
    ContingutService contingutService;


    @GetMapping("/load/misox")
    public ResponseEntity loadSistemesOperatiusMonoestacio(HttpServletRequest request){
        Modul m = new Modul();
        m.setNom("Sistemes Operatius Monoestació");
        //Retornem m2 per tenir la id del mòdul per Hibernate
        Modul m2 = modulService.save(m);

        this.loadCompetenciesCFGMInformatica(m2);
        this.loadResultatsAprenentatgeCicleMISOX(m2);
        this.loadContinguts(m2);

        return new ResponseEntity<>(m.getNom()+" carregat amb èxit", HttpStatus.OK);
    }

    private void loadCompetenciesCFGMInformatica(Modul m){
        List<String> competencies = new ArrayList<>();
        competencies.add("a) Determinar la logística asociada a las operaciones de instalación, configuración y mantenimiento de sistemas microinformáticos, interpretando la documentación técnica asociada y organizando los recursos necesarios.");
        competencies.add("b) Montar y configurar ordenadores y periféricos, asegurando su funcionamiento en condiciones de calidad y seguridad.");
        competencies.add("c) Instalar y configurar software básico y de aplicación, asegurando su funcionamiento en condiciones de calidad y seguridad.");
        competencies.add("d) Replantear el cableado y la electrónica de redes locales en pequeños entornos y su conexión con redes de área extensa canalizando a un nivel superior los supuestos que así lo requieran.");
        competencies.add("e) Instalar y configurar redes locales cableadas, inalámbricas o mixtas y su conexión a redes públicas, asegurando su funcionamiento en condiciones de calidad y seguridad.");
        competencies.add("f) Instalar, configurar y mantener servicios multiusuario, aplicaciones y dispositivos compartidos en un entorno de red local, atendiendo a las necesidades y requerimientos especificados.");
        competencies.add("g) Realizar las pruebas funcionales en sistemas microinformáticos y redes locales, localizando y diagnosticando disfunciones, para comprobar y ajustar su funcionamiento.");
        competencies.add("h) Mantener sistemas microinformáticos y redes locales, sustituyendo, actualizando y ajustando sus componentes, para asegurar el rendimiento del sistema en condiciones de calidad y seguridad.");
        competencies.add("i) Ejecutar procedimientos establecidos de recuperación de datos y aplicaciones ante fallos y pérdidas de datos en el sistema, para garantizar la integridad y disponibilidad de la información.");
        competencies.add("j) Elaborar documentación técnica y administrativa del sistema, cumpliendo las normas y reglamentación del sector, para su mantenimiento y la asistencia al cliente.");
        competencies.add("k) Elaborar presupuestos de sistemas a medida cumpliendo los requerimientos del cliente.");
        competencies.add("l) Asesorar y asistir al cliente, canalizando a un nivel superior los supuestos que lo requieran, para encontrar soluciones adecuadas a las necesidades de éste.");
        competencies.add("m) Organizar y desarrollar el trabajo asignado manteniendo unas relaciones profesionales adecuadas en el entorno de trabajo.");
        competencies.add("n) Mantener un espíritu constante de innovación y actualización en el ámbito del sector informático.");
        competencies.add("ñ) Utilizar los medios de consulta disponibles, seleccionando el más adecuado en cada caso, para resolver en tiempo razonable supuestos no conocidos y dudas profesionales.");
        competencies.add("o) Aplicar los protocolos y normas de seguridad, calidad y respeto al medio ambiente en las intervenciones realizadas.");
        competencies.add("p) Cumplir con los objetivos de la producción, colaborando con el equipo de trabajo y actuando conforme a los principios de responsabilidad y tolerancia.");
        competencies.add("q) Adaptarse a diferentes puestos de trabajo y nuevas situaciones laborales originados por cambios tecnológicos y organizativos en los procesos productivos.");
        competencies.add("r) Resolver problemas y tomar decisiones individuales siguiendo las normas y procedimientos establecidos definidos dentro del ámbito de su competencia.");
        competencies.add("s) Ejercer sus derechos y cumplir con las obligaciones derivadas de las relaciones laborales, de acuerdo con lo establecido en la legislación vigente.");
        competencies.add("t) Gestionar su carrera profesional, analizando las oportunidades de empleo, autoempleo y aprendizaje.");
        competencies.add("u) Crear y gestionar una pequeña empresa, realizando un estudio de viabilidad de productos, planificación de la producción y comercialización.");
        competencies.add("v) Participar de forma activa en la vida económica, social y cultural, con una actitud crítica y responsable.");

        Integer index = 1;
        for(String s: competencies){
            CompetenciaProfessional cp = new CompetenciaProfessional();
            cp.setOrdre(index);
            cp.setNomES(s);
            cp.setNomCA("");
            cp.setModul(m);

            competenciaProfessionalService.save(cp);

            index++;
        }
    }

    private void loadResultatsAprenentatgeCicleMISOX(Modul m){
        System.out.println("Modul de resultat es"+m.getIdmodul());
        List<String> ra = new ArrayList<>();
        ra.add("1. Reconoce las características de los sistemas de archivo, describiendo sus tipos y aplicaciones.");
        ra.add("2. Instala sistemas operativos, relacionando sus características con el hardware del equipo y el software de aplicación.");
        ra.add("3. Realiza tareas básicas de configuración de sistemas operativos, interpretando requerimientos y describiendo los procedimientos seguidos.");
        ra.add("4. Realiza operaciones básicas de administración de sistemas operativos, interpretando requerimientos y optimizando el sistema para su uso.");
        ra.add("5. Crea máquinas virtuales identificando su campo de aplicación e instalando software específico.");

        Integer index = 1;
        for(String s: ra){
            ResultatAprenentatgeCicle r = new ResultatAprenentatgeCicle();
            r.setNomES(s);
            r.setNomCA("");
            r.setOrdre(index);
            r.setModul(m);

            resultatAprenentatgeCicleService.save(r);

            index++;
        }
    }

    private void loadContinguts(Modul m){
        ResultatAprenentatgeCicle r1 = resultatAprenentatgeCicleService.findByOrdreAndModul(1,m);
        Contingut c = new Contingut();
        c.setNomES("Caracterización de sistemas operativos");
        c.setNomCA("");
        c.setBasic(true);
        c.setExcepcio(false);
        c.setOrdre(1);
        c.setResultatAprenentatgeCicle(r1);

        contingutService.save(c);
    }
}