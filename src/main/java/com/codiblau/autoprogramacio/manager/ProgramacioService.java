package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.programacio.Programacio;
import com.codiblau.autoprogramacio.repository.ModulRepository;
import com.codiblau.autoprogramacio.repository.ProgramacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgramacioService {
    @Autowired
    ProgramacioRepository programacioRepository;

    public Programacio save(Programacio p){
        return programacioRepository.save(p);
    }

    public Programacio getprogramacio(Long id){
        Programacio p = programacioRepository.getById(id);
        return p;
    }

}

