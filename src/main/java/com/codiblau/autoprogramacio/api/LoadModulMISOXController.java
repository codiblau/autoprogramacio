package com.codiblau.autoprogramacio.api;

import com.codiblau.autoprogramacio.manager.*;
import com.codiblau.autoprogramacio.model.boe.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class LoadModulMISOXController {
    private static final String GOOGLE_ESPANOL = "es";

    private static final String GOOGLE_CATALA = "ca";

    @Autowired
    ModulService modulService;

    @Autowired
    CompetenciaProfessionalService competenciaProfessionalService;

    @Autowired
    ResultatAprenentatgeCicleService resultatAprenentatgeCicleService;

    @Autowired
    ResultatAprenentatgeGeneralService resultatAprenentatgeGeneralService;

    @Autowired
    ContingutService contingutService;

    @Autowired
    CriteriAvaluacioService criteriAvaluacioService;

    @Autowired
    GoogleCloudManager googleCloudManager;


    @GetMapping("/load/misox")
    @Transactional
    public ResponseEntity loadSistemesOperatiusMonoestacio(HttpServletRequest request) throws IOException {

        Modul m = this.loadModul();
        this.loadResultatsAprenentatgeCicle(m);
        this.loadResultatsAprenentatgeGenerals(m);
        //this.loadCompetencies(m);
        this.loadContinguts(m);
        //this.loadCriterisAvaluacio(m);

        return new ResponseEntity<>(m.getNom() + " carregat amb èxit", HttpStatus.OK);
    }

    private Modul loadModul() {
        Modul m = new Modul();
        m.setNom("Sistemes Operatius Monoestació");
        return modulService.save(m);
    }

    private void loadResultatsAprenentatgeCicle(Modul m) throws IOException {
        List<String> ra = new ArrayList<>();
        ra.add("1. Reconoce las características de los sistemas de archivo, describiendo sus tipos y aplicaciones.");
        ra.add("2. Instala sistemas operativos, relacionando sus características con el hardware del equipo y el software de aplicación.");
        ra.add("3. Realiza tareas básicas de configuración de sistemas operativos, interpretando requerimientos y describiendo los procedimientos seguidos.");
        ra.add("4. Realiza operaciones básicas de administración de sistemas operativos, interpretando requerimientos y optimizando el sistema para su uso.");
        ra.add("5. Crea máquinas virtuales identificando su campo de aplicación e instalando software específico.");

        Integer index = 1;
        for (String s : ra) {
            String s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
            resultatAprenentatgeCicleService.save(index, s, s_ca, m);
            index++;
        }
    }

    private void loadResultatsAprenentatgeGenerals(Modul m) {
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
            String s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
            Set<ResultatAprenentatgeCicle> rac = new HashSet<>();
            //rac.add(resultatAprenentatgeCicleService.findByOrdreAndModul(1,m));

            resultatAprenentatgeGeneralService.save(index, s, s_ca, m, rac);

            index++;
        }
    }

    private void loadCompetencies(Modul m) {
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
            String s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
            competenciaProfessionalService.save(index, s, s_ca, m);

            index++;
        }
    }

    private void loadContinguts(Modul m) {
        String s = "Caracterización de sistemas operativos: El sistema informático.";
        String s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.1, s, s_ca, true, false, m);

        s = "Caracterización de sistemas operativos: Software de base de un sistema informático.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.2, s, s_ca, true, false, m);

        s = "Caracterización de sistemas operativos: Concepto de sistema operativo. Elementos y estructura del Sistema Operativo.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.3, s, s_ca, true, false, m);

        s = "Caracterización de sistemas operativos: Funciones del sistema operativo. Recursos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.4, s, s_ca, true, false, m);

        s = "Caracterización de sistemas operativos: Utilización del sistema operativo: modo orden, modo gráfico.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.5, s, s_ca, true, false, m);

        s = "Caracterización de sistemas operativos: Procesos del sistema operativo. Estados de los procesos. Prioridad.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.6, s, s_ca, true, false, m);

        s = "Caracterización de sistemas operativos: Sistemas operativos actuales. Sistemas operativos libres y propietarios.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.7, s, s_ca, true, false, m);

        s = "Caracterización de sistemas operativos: Comparativa entre sistemas operativos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.8, s, s_ca, false, false, m);

        s = "Caracterización de sistemas operativos: Características comunes.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.9, s, s_ca, false, false, m);

        s = "Caracterización de sistemas operativos: Características comunes.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(1.10, s, s_ca, false, false, m);

        s = "Operación de sistemas de archivos: Sistemas de archivos, archivo, directorio, atributos, permisos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(2.1, s, s_ca, true, false, m);

        s = "Operación de sistemas de archivos: Operación con archivos: nombre y extensión, comodines, atributos, tipos. Operaciones más comunes.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(2.2, s, s_ca, true, false, m);

        s = "Operación de sistemas de archivos: Operación con directorios: nombre, atributos, permisos. Operaciones más comunes.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(2.3, s, s_ca, true, false, m);

        s = "Operación de sistemas de archivos: Selección de un sistema de archivos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(2.4, s, s_ca, true, false, m);

        s = "Operación de sistemas de archivos: Tipo de sistemas de archivos y sus características.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(2.5, s, s_ca, true, false, m);

        s = "Operación de sistemas de archivos: Transacciones. Sistemas transaccionales.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(2.6, s, s_ca, true, false, m);

        s = "Operación de sistemas de archivos: Operaciones en sistemas operativos libres.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(2.7, s, s_ca, false, false, m);

        s = "Operación de sistemas de archivos: Operaciones en sistemas operativos propietarios.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(2.8, s, s_ca, false, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: El sistema informático. Características técnicas del hardware para la instalación.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.1, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Software de base de un sistema informático.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.2, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Sistema operativo. Elementos y estructura del Sistema Operativo.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.3, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Funciones del sistema operativo. Recursos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.4, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Utilización del sistema operativo: modo orden, modo gráfico.\n";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.5, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Procesos del sistema operativo. Estados de los procesos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.6, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Sistemas operativos actuales.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.7, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Requisitos técnicos del sistema operativo.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.8, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Planificación de la instalación: particiones, sistema de archivos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.9, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Selección de aplicaciones básicas a instalar.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.10, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Parámetros básicos de la instalación. Requerimientos en función de las aplicaciones.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.11, s, s_ca, true, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Instalación de sistemas operativos libres.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.12, s, s_ca, false, false, m);

        s = "Instalación de sistemas operativos libres y propietarios: Caracterización de sistemas operativos: Instalación de sistemas operativos propietarios.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(3.13, s, s_ca, false, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Arranque y parada del sistema. Sesiones.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.1, s, s_ca, true, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Interfaces de usuario: tipos, propiedades y usos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.2, s, s_ca, true, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Configuración de las preferencias de escritorio.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.3, s, s_ca, true, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Estructura del árbol de directorios.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.4, s, s_ca, true, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Compresión/Descompresión.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.5, s, s_ca, true, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Actualización del sistema operativo.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.6, s, s_ca, true, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Agregar / eliminar / actualizar software del sistema operativo.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.7, s, s_ca, true, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Operaciones con sistemas operativos libres.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.8, s, s_ca, false, false, m);

        s = "Realización de tareas básicas sobre sistemas operativos libres y propietarios: Operaciones con sistemas operativos propietarios.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(4.9, s, s_ca, false, false, m);

        s = "Administración de los sistemas operativos: Gestión de perfiles de usuarios y grupos locales. Contraseñas.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.1, s, s_ca, true, false, m);

        s = "Administración de los sistemas operativos: Gestión del sistema de archivos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.2, s, s_ca, true, false, m);

        s = "Administración de los sistemas operativos: Gestión de los procesos del sistema y de usuario.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.3, s, s_ca, true, false, m);

        s = "Administración de los sistemas operativos: Rendimiento del sistema. Seguimiento de la actividad del sistema.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.4, s, s_ca, true, false, m);

        s = "Administración de los sistemas operativos: Activación y desactivación de servicios.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.5, s, s_ca, true, false, m);

        s = "Administración de los sistemas operativos: Compartición de recursos.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.6, s, s_ca, true, false, m);

        s = "Administración de los sistemas operativos: Base de datos de configuración y comportamiento del sistema operativo, hardware instalado y aplicaciones.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.7, s, s_ca, true, false, m);

        s = "Administración de los sistemas operativos: Operaciones de administración en sistemas operativos libres.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.8, s, s_ca, false, false, m);

        s = "Administración de los sistemas operativos: Operaciones de administración en sistemas operativos propietarios.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(5.9, s, s_ca, false, false, m);

        s = "Configuración de máquinas virtuales: Virtualización y máquina virtual: ventajas e inconvenientes.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(6.1, s, s_ca, true, false, m);

        s = "Configuración de máquinas virtuales: Software (propietario y libre) para la creación de máquinas virtuales: instalación.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(6.2, s, s_ca, true, false, m);

        s = "Configuración de máquinas virtuales: Creación de máquinas virtuales para sistemas operativos propietarios y libres.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(6.3, s, s_ca, true, false, m);

        s = "Configuración de máquinas virtuales: Configuración y utilización de máquinas virtuales.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(6.4, s, s_ca, true, false, m);

        s = "Configuración de máquinas virtuales: Aplicaciones típicas de las máquinas virtuales.";
        s_ca = ""; //googleCloudManager.translate(GOOGLE_ESPANOL, GOOGLE_CATALA, s);
        contingutService.save(6.5, s, s_ca, false, false, m);

    }

    private void loadCriterisAvaluacio(Modul m) {
        ResultatAprenentatgeCicle r1 = resultatAprenentatgeCicleService.findByOrdreAndModul(1, m);

        CriteriAvaluacio ca1a = new CriteriAvaluacio();
        ca1a.setOrdre(1);
        ca1a.setNomES("a) Se han identificado y descrito los elementos funcionales de un sistema informático.");
        ca1a.setNomCA("");
        ca1a.setExcepcio(false);
        ca1a.setResultatAprenentatgeCicle(r1);
        criteriAvaluacioService.save(ca1a);

        CriteriAvaluacio ca1b = new CriteriAvaluacio();
        ca1b.setOrdre(2);
        ca1b.setNomES("b) Se ha codificado y relacionado la información en los diferentes sistemas de representación.");
        ca1b.setNomCA("");
        ca1b.setExcepcio(false);
        ca1b.setResultatAprenentatgeCicle(r1);
        criteriAvaluacioService.save(ca1b);

        CriteriAvaluacio ca1c = new CriteriAvaluacio();
        ca1c.setOrdre(3);
        ca1c.setNomES("c) Se han identificado los procesos y sus estados.");
        ca1c.setNomCA("");
        ca1c.setExcepcio(false);
        ca1c.setResultatAprenentatgeCicle(r1);
        criteriAvaluacioService.save(ca1c);

        CriteriAvaluacio ca1d = new CriteriAvaluacio();
        ca1d.setOrdre(4);
        ca1d.setNomES("d) Se ha descrito la estructura y organización del sistema de archivos.");
        ca1d.setNomCA("");
        ca1d.setExcepcio(false);
        ca1d.setResultatAprenentatgeCicle(r1);
        criteriAvaluacioService.save(ca1d);

        CriteriAvaluacio ca1e = new CriteriAvaluacio();
        ca1e.setOrdre(5);
        ca1e.setNomES("e) Se han distinguido los atributos de un archivo y un directorio.");
        ca1e.setNomCA("");
        ca1e.setExcepcio(false);
        ca1e.setResultatAprenentatgeCicle(r1);
        criteriAvaluacioService.save(ca1e);

        CriteriAvaluacio ca1f = new CriteriAvaluacio();
        ca1f.setOrdre(6);
        ca1f.setNomES("f) Se han reconocido los permisos de archivos y directorios.");
        ca1f.setNomCA("");
        ca1f.setExcepcio(false);
        ca1f.setResultatAprenentatgeCicle(r1);
        criteriAvaluacioService.save(ca1f);

        CriteriAvaluacio ca1g = new CriteriAvaluacio();
        ca1g.setOrdre(7);
        ca1g.setNomES("g) Se ha constatado la utilidad de los sistemas transaccionales y sus repercusiones al seleccionar un sistema de archivos");
        ca1g.setNomCA("");
        ca1g.setExcepcio(false);
        ca1g.setResultatAprenentatgeCicle(r1);
        criteriAvaluacioService.save(ca1g);


    }
}