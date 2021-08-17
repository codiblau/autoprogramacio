package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.*;
import com.codiblau.autoprogramacio.repository.CriteriAvaluacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<CriteriAvaluacio> findAllByResultatAprenentatgeCicle(ResultatAprenentatgeCicle ra){
        return criteriAvaluacioRepository.findAllByResultatAprenentatgeCicle(ra);
    }

}

