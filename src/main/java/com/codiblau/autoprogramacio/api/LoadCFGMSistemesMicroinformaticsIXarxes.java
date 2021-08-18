package com.codiblau.autoprogramacio.api;

import com.codiblau.autoprogramacio.manager.*;
import com.codiblau.autoprogramacio.model.boe.*;
import com.codiblau.autoprogramacio.model.programacio.Programacio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class LoadCFGMSistemesMicroinformaticsIXarxes {
    private static final String GOOGLE_ESPANOL = "es";

    private static final String GOOGLE_CATALA = "ca";

    @Autowired
    CicleFormatiuService cicleFormatiuService;

    @Autowired
    ResultatAprenentatgeGeneralService resultatAprenentatgeGeneralService;

    @Autowired
    CompetenciaProfessionalService competenciaProfessionalService;

    @Autowired
    GoogleCloudManager googleCloudManager;

    @GetMapping("/load/cfgmsmx")
    @Transactional
    public ResponseEntity<String> loadCFGMSistemesMicroinformaticsIXarxes(HttpServletRequest request) throws IOException {

        CicleFormatiu cf = this.loadCicleFormatiu();
        this.loadResultatsAprenentatgeGenerals(cf);
        this.loadCompetencies(cf);
        return new ResponseEntity<>("Cicle Formatiu carregat amb èxit", HttpStatus.OK);
    }

    private CicleFormatiu loadCicleFormatiu(){
        return cicleFormatiuService.save("cfgmsmx","Sistemes Microinformàtics i Xarxes");
    }
    private void loadResultatsAprenentatgeGenerals(CicleFormatiu cf) throws IOException {
        List<String> resultatsaprenentatge = new ArrayList<>();
        resultatsaprenentatge.add("a) Organizar los componentes físicos y lógicos que forman un sistema microinformático, interpretando su documentación técnica, para aplicar los medios y métodos adecuados a su instalación, montaje y mantenimiento.");
        resultatsaprenentatge.add("b) Identificar, ensamblar y conectar componentes y periféricos utilizando las herramientas adecuadas, aplicando procedimientos, normas y protocolos de calidad y seguridad, para montar y configurar ordenadores y periféricos.");
        resultatsaprenentatge.add("c) Reconocer y ejecutar los procedimientos de instalación de sistemas operativos y programas de aplicación, aplicando protocolos de calidad, para instalar y configurar sistemas microinformáticos.");
        resultatsaprenentatge.add("d) Representar la posición de los equipos, líneas de transmisión y demás elementos de una red local, analizando la morfología, condiciones y características del despliegue, para replantear el cableado y la electrónica de la red.");
        resultatsaprenentatge.add("e) Ubicar y fijar equipos, líneas, canalizaciones y demás elementos de una red local cableada, inalámbrica o mixta, aplicando procedimientos de montaje y protocolos de calidad y seguridad, para instalar y configurar redes locales.");
        resultatsaprenentatge.add("f) Interconectar equipos informáticos, dispositivos de red local y de conexión con redes de área extensa, ejecutando los procedimientos para instalar y configurar redes locales.");
        resultatsaprenentatge.add("g) Localizar y reparar averías y disfunciones en los componentes físicos y lógicos para mantener sistemas microinformáticos y redes locales.");
        resultatsaprenentatge.add("h) Sustituir y ajustar componentes físicos y lógicos para mantener sistemas microinformáticos y redes locales.");
        resultatsaprenentatge.add("i) Interpretar y seleccionar información para elaborar documentación técnica y administrativa.");
        resultatsaprenentatge.add("j) Valorar el coste de los componentes físicos, lógicos y la mano de obra, para elaborar presupuestos.");
        resultatsaprenentatge.add("k) Reconocer características y posibilidades de los componentes físicos y lógicos, para asesorar y asistir a clientes.");
        resultatsaprenentatge.add("l) Detectar y analizar cambios tecnológicos para elegir nuevas alternativas y mantenerse actualizado dentro del sector.");
        resultatsaprenentatge.add("m) Reconocer y valorar incidencias, determinando sus causas y describiendo las acciones correctoras para resolverlas.");
        resultatsaprenentatge.add("n) Analizar y describir procedimientos de calidad, prevención de riesgos laborales y medioambientales, señalando las acciones a realizar en los casos definidos para actuar de acuerdo con las normas estandarizadas.");
        resultatsaprenentatge.add("ñ) Valorar las actividades de trabajo en un proceso productivo, identificando su aportación al proceso global para conseguir los objetivos de la producción.");
        resultatsaprenentatge.add("o) Identificar y valorar las oportunidades de aprendizaje y empleo, analizando las ofertas y demandas del mercado laboral para gestionar su carrera profesional.");
        resultatsaprenentatge.add("p) Reconocer las oportunidades de negocio, identificando y analizando demandas del mercado para crear y gestionar una pequeña empresa.");
        resultatsaprenentatge.add("q) Reconocer sus derechos y deberes como agente activo en la sociedad, analizando el marco legal que regula las condiciones sociales y laborales para participar como ciudadano democrático.");

        Integer index = 1;
        for (String s : resultatsaprenentatge) {
            String s_ca = googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
            //Set<ResultatAprenentatgeCicle> rac = new HashSet<>();
            //rac.add(resultatAprenentatgeCicleService.findByOrdreAndModul(1,m));

            resultatAprenentatgeGeneralService.save(index, s, s_ca, cf, null);

            index++;
        }
    }

    private void loadCompetencies(CicleFormatiu cf) throws IOException {
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
        for (String s : competencies) {
            String s_ca = googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
            competenciaProfessionalService.save(index, s, s_ca, cf);

            index++;
        }
    }

}