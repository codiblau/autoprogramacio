package com.codiblau.autoprogramacio.api;

import com.codiblau.autoprogramacio.manager.ResultatAprenentatgeCicleService;
import com.codiblau.autoprogramacio.model.ResultatAprenentatgeCicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ResultatAprenentatgeCicleController {
    @Autowired
    ResultatAprenentatgeCicleService resultatAprenentatgeCicleService;

    @GetMapping("/hello")
    public ResponseEntity hello(HttpServletRequest request){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}