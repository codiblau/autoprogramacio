package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultatAprenentatgeGeneralRepository extends JpaRepository<ResultatAprenentatgeGeneral, Long> {
    List<ResultatAprenentatgeGeneral> findAllByModul(Modul modul);
}
