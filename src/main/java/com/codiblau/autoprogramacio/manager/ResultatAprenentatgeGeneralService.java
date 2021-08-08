package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeGeneral;
import com.codiblau.autoprogramacio.repository.ResultatAprenentatgeCicleRepository;
import com.codiblau.autoprogramacio.repository.ResultatAprenentatgeGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultatAprenentatgeGeneralService {
    @Autowired
    ResultatAprenentatgeGeneralRepository resultatAprenentatgeGeneralRepository;

    public void save(ResultatAprenentatgeGeneral r){
        resultatAprenentatgeGeneralRepository.save(r);
    }


}

