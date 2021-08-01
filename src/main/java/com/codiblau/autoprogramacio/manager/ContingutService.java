package com.codiblau.autoprogramacio.manager;

import com.codiblau.autoprogramacio.model.Contingut;
import com.codiblau.autoprogramacio.model.Modul;
import com.codiblau.autoprogramacio.repository.ContingutRepository;
import com.codiblau.autoprogramacio.repository.ModulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContingutService {
    @Autowired
    ContingutRepository contingutRepository;

    public void save(Contingut c){
        contingutRepository.save(c);
    }

}

