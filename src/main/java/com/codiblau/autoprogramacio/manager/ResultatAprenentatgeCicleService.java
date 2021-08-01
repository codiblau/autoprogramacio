package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.ResultatAprenentatgeCicle;
import com.codiblau.autoprogramacio.repository.ResultatAprenentatgeCicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatAprenentatgeCicleService {
    @Autowired
    ResultatAprenentatgeCicleRepository resultatAprenentatgeCicleRepository;


    public void save(ResultatAprenentatgeCicle r){
        resultatAprenentatgeCicleRepository.save(r);
    }

}

