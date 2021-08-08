package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultatAprenentatgeCicleRepository extends JpaRepository<ResultatAprenentatgeCicle, Long> {
    ResultatAprenentatgeCicle findByOrdreAndModul(Integer ordre, Modul modul);
}
