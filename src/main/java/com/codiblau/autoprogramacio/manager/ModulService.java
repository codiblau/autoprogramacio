package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.Modul;
import com.codiblau.autoprogramacio.model.ResultatAprenentatgeCicle;
import com.codiblau.autoprogramacio.repository.ModulRepository;
import com.codiblau.autoprogramacio.repository.ResultatAprenentatgeCicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModulService {
    @Autowired
    ModulRepository modulRepository;

    public void save(Modul m){
        modulRepository.save(m);
    }

}

