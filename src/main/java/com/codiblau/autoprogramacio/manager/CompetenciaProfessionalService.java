package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.CompetenciaProfessional;
import com.codiblau.autoprogramacio.repository.CompetenciaProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenciaProfessionalService {
    @Autowired
    CompetenciaProfessionalRepository competenciaProfessionalRepository;


    public void save(CompetenciaProfessional r){
        competenciaProfessionalRepository.save(r);
    }

}

