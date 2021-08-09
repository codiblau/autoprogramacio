package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.Contingut;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.repository.ContingutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContingutService {
    @Autowired
    ContingutRepository contingutRepository;

    public void save(Double index, String es, String ca,Boolean basic, Boolean excepcio, Modul m) {
        Contingut c = new Contingut();
        c.setNomES(es);
        c.setNomCA(ca);
        c.setOrdre(index);
        c.setExcepcio(excepcio);
        c.setBasic(basic);
        c.setModul(m);
        contingutRepository.save(c);
    }

}

