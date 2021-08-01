package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.CriteriAvaluacio;
import com.codiblau.autoprogramacio.model.ResultatAprenentatgeCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriAvaluacioRepository extends JpaRepository<CriteriAvaluacio, Long> {
}