package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.repository.ModulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModulService {
    @Autowired
    ModulRepository modulRepository;

    public Modul save(Modul m){
        return modulRepository.save(m);
    }


}

