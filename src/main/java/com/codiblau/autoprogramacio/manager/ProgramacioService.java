package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.programacio.Programacio;
import com.codiblau.autoprogramacio.repository.ModulRepository;
import com.codiblau.autoprogramacio.repository.ProgramacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramacioService {
    @Autowired
    ProgramacioRepository programacioRepository;

    public Programacio save(Programacio p){
        return programacioRepository.save(p);
    }

    public Programacio getprogramacio(Long id){
        Programacio p = programacioRepository.findById(id).get();
        //TODO: canviar després, agafem la darrera sempre per no haver de canviar cada vegada
        List<Programacio> programacions = programacioRepository.findAll();
        programacions.sort((o1, o2) -> (int)(o2.getIdprogramacio() - o1.getIdprogramacio()));
        return programacions.get(0);
    }

}

