package com.codiblau.autoprogramacio.api;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class DocumentController {
    @GetMapping("/document/test")
    public ResponseEntity test(HttpServletRequest request) throws Docx4JException {
        WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
        mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
        mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
        File exportFile = new File("welcome.docx");
        wordPackage.save(exportFile);
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
