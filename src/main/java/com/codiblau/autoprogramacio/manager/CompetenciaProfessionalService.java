package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.CompetenciaProfessional;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.repository.CompetenciaProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenciaProfessionalService {
    @Autowired
    CompetenciaProfessionalRepository competenciaProfessionalRepository;


    public void save(Integer index, String es, String ca, Modul m){
        CompetenciaProfessional cp = new CompetenciaProfessional();
        cp.setOrdre(index);
        cp.setNomES(es);
        cp.setNomCA(ca);
        cp.setModul(m);

        competenciaProfessionalRepository.save(cp);
    }

}

