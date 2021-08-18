package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.CicleFormatiu;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeGeneral;
import com.codiblau.autoprogramacio.repository.ResultatAprenentatgeCicleRepository;
import com.codiblau.autoprogramacio.repository.ResultatAprenentatgeGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ResultatAprenentatgeGeneralService {
    @Autowired
    ResultatAprenentatgeGeneralRepository resultatAprenentatgeGeneralRepository;

    public void save(Integer index, String es, String ca, CicleFormatiu cf, Set<ResultatAprenentatgeCicle> resultatsAprenentatgeCicle){
        ResultatAprenentatgeGeneral ra = new ResultatAprenentatgeGeneral();
        ra.setOrdre(index);
        ra.setNomES(es);
        ra.setNomCA(ca);
        ra.setCicleFormatiu(cf);
        if(resultatsAprenentatgeCicle != null) {
            ra.setResultatsAprenentatgeCicle(resultatsAprenentatgeCicle);
        }

        resultatAprenentatgeGeneralRepository.save(ra);
    }

    public List<ResultatAprenentatgeGeneral> findByModul(CicleFormatiu cf){
        return resultatAprenentatgeGeneralRepository.findAllByCicleFormatiu(cf);
    }

}

