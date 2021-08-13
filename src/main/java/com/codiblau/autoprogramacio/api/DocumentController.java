package com.codiblau.autoprogramacio.api;

import com.codiblau.autoprogramacio.manager.ProgramacioService;
import com.codiblau.autoprogramacio.model.boe.Contingut;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.programacio.Programacio;
import com.codiblau.autoprogramacio.model.programacio.Seccio;
import org.docx4j.jaxb.Context;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Set;

@RestController
public class DocumentController {
    @Autowired
    ProgramacioService programacioService;

    @GetMapping("/document/test")
    public ResponseEntity test(HttpServletRequest request) throws Docx4JException {
        WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
        mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
        mainDocumentPart.addParagraphOfText("Welcome To Baeldung1");

        ObjectFactory factory = Context.getWmlObjectFactory();
        P p = factory.createP();
        R r = factory.createR();
        Text t = factory.createText();
        t.setValue("Welcome To Baeldung2");
        r.getContent().add(t);
        p.getContent().add(r);
        int writableWidthTwips = wordPackage.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        int columnNumber = 3;
        Tbl tbl = TblFactory.createTable(3, 3, writableWidthTwips/columnNumber);
        List<Object> rows = tbl.getContent();
        for (Object row : rows) {
            Tr tr = (Tr) row;
            List<Object> cells = tr.getContent();
            for(Object cell : cells) {
                Tc td = (Tc) cell;
                td.getContent().add(p);
            }
        }
        mainDocumentPart.getContent().add(tbl);

        File exportFile = new File("welcome.docx");
        wordPackage.save(exportFile);
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/document/programacio")
    public ResponseEntity programaciodoc(HttpServletRequest request) throws Docx4JException {
        Programacio programacio = programacioService.getprogramacio(1L);
        Set<Seccio> seccions = programacio.getSeccions();

        WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
        mainDocumentPart.addStyledParagraphOfText("Title", programacio.getModul().getNom());
        mainDocumentPart.addStyledParagraphOfText("Subtitle", programacio.getCurs());





        File exportFile = new File("welcome.docx");
        wordPackage.save(exportFile);

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    private Tbl getTaulaContinguts(Modul m,WordprocessingMLPackage wordPackage){
        Set<Contingut> continguts = m.getContinguts();

        ObjectFactory factory = Context.getWmlObjectFactory();

        int writableWidthTwips = wordPackage.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        int columnNumber = 3;
        Tbl tbl = TblFactory.createTable(3, 3, writableWidthTwips/columnNumber);
        List<Object> rows = tbl.getContent();
        for (Object row : rows) {
            Tr tr = (Tr) row;
            List<Object> cells = tr.getContent();
            for(Object cell : cells) {
                Tc td = (Tc) cell;

                P p = factory.createP();
                R r = factory.createR();
                Text t = factory.createText();
                t.setValue("Welcome To Baeldung2");
                r.getContent().add(t);
                p.getContent().add(r);

                td.getContent().add(p);
            }
        }
        return tbl;
    }
}
