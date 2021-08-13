package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.programacio.Seccio;
import com.codiblau.autoprogramacio.repository.ModulRepository;
import com.codiblau.autoprogramacio.repository.SeccioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccioService {
    @Autowired
    SeccioRepository seccioRepository;

    public Seccio save(Seccio s){
        return seccioRepository.save(s);
    }


}

