package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.Contingut;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContingutRepository extends JpaRepository<Contingut, Long> {
    List<Contingut> findAllByModul(Modul modul);
}
