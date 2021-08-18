package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.boe.CicleFormatiu;
import com.codiblau.autoprogramacio.model.boe.Contingut;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.repository.CicleFormatiuRepository;
import com.codiblau.autoprogramacio.repository.ContingutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CicleFormatiuService {
    @Autowired
    CicleFormatiuRepository cicleFormatiuRepository;

    public CicleFormatiu save(String identificador, String nom) {
        CicleFormatiu cf = new CicleFormatiu();
        cf.setNom(nom);
        cf.setIdentificador(identificador);
        return cicleFormatiuRepository.save(cf);
    }

}

