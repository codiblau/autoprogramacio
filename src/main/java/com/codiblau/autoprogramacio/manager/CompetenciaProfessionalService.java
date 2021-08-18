package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.CicleFormatiu;
import com.codiblau.autoprogramacio.model.boe.CompetenciaProfessional;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import com.codiblau.autoprogramacio.repository.CompetenciaProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaProfessionalService {
    @Autowired
    CompetenciaProfessionalRepository competenciaProfessionalRepository;


    public void save(Integer index, String es, String ca, CicleFormatiu cf){
        CompetenciaProfessional cp = new CompetenciaProfessional();
        cp.setOrdre(index);
        cp.setNomES(es);
        cp.setNomCA(ca);
        cp.setCicleFormatiu(cf);

        competenciaProfessionalRepository.save(cp);
    }

    public List<CompetenciaProfessional> findByCicleFormatiu(CicleFormatiu cf){
        return competenciaProfessionalRepository.findAllByCicleFormatiu(cf);
    }

}

