package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import com.codiblau.autoprogramacio.repository.ResultatAprenentatgeCicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultatAprenentatgeCicleService {
    @Autowired
    ResultatAprenentatgeCicleRepository resultatAprenentatgeCicleRepository;

    public void save(ResultatAprenentatgeCicle r){
        resultatAprenentatgeCicleRepository.save(r);
    }

    public void save(Integer index,String es, String ca, Modul m){
        ResultatAprenentatgeCicle r = new ResultatAprenentatgeCicle();
        r.setNomES(es);
        r.setNomCA(ca);
        r.setOrdre(index);
        r.setModul(m);

        resultatAprenentatgeCicleRepository.save(r);
    }

    public ResultatAprenentatgeCicle findByOrdreAndModul(Integer ordre, Modul m){
        return resultatAprenentatgeCicleRepository.findByOrdreAndModul(ordre, m);
    }

}

