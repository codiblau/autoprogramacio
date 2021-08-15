package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.programacio.Paragraf;
import com.codiblau.autoprogramacio.model.programacio.Programacio;
import com.codiblau.autoprogramacio.model.programacio.Seccio;
import com.codiblau.autoprogramacio.repository.ModulRepository;
import com.codiblau.autoprogramacio.repository.ParagrafRepository;
import com.codiblau.autoprogramacio.repository.SeccioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SeccioService {
    @Autowired
    SeccioRepository seccioRepository;

    @Autowired
    ParagrafRepository paragrafRepository;

    public Seccio save(Seccio s){
        return seccioRepository.save(s);
    }

    public void save(String titol, Integer ordre, Integer heading, List<String> paragrafs, Programacio programacio){
        Seccio s1 = new Seccio();
        s1.setProgramacio(programacio);
        s1.setTitol(titol);
        s1.setHeading(heading);
        s1.setOrdre(ordre);
        s1.setAfegirContinguts(false);
        s1.setAfegirCriterisAvaluacio(false);

        Seccio s2 = seccioRepository.save(s1);

        for(String paragraf: paragrafs){
            Paragraf p1 = new Paragraf();
            p1.setDescripcio(paragraf);
            p1.setSeccio(s2);
            paragrafRepository.save(p1);
        }
    }

}

