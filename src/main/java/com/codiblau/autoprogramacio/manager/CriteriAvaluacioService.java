package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.CompetenciaProfessional;
import com.codiblau.autoprogramacio.model.boe.CriteriAvaluacio;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import com.codiblau.autoprogramacio.repository.CriteriAvaluacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriteriAvaluacioService {
    @Autowired
    CriteriAvaluacioRepository criteriAvaluacioRepository;


    public void save(Integer index, String es, String ca, Boolean excepcio, Modul m, ResultatAprenentatgeCicle ra){
        CriteriAvaluacio cav = new CriteriAvaluacio();
        cav.setOrdre(index);
        cav.setNomES(es);
        cav.setNomCA(ca);
        cav.setExcepcio(excepcio);
        cav.setResultatAprenentatgeCicle(ra);

        criteriAvaluacioRepository.save(cav);
    }

}

