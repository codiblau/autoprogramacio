package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.CriteriAvaluacio;
import com.codiblau.autoprogramacio.repository.CriteriAvaluacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriteriAvaluacioService {
    @Autowired
    CriteriAvaluacioRepository criteriAvaluacioRepository;

    public void save(CriteriAvaluacio c){
        criteriAvaluacioRepository.save(c);
    }

}

