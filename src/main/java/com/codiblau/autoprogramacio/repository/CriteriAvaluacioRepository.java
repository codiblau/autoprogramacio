package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.Contingut;
import com.codiblau.autoprogramacio.model.boe.CriteriAvaluacio;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriAvaluacioRepository extends JpaRepository<CriteriAvaluacio, Long> {
    List<CriteriAvaluacio> findAllByResultatAprenentatgeCicle(ResultatAprenentatgeCicle resultatAprenentatgeCicle);
}
