package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultatAprenentatgeGeneralRepository extends JpaRepository<ResultatAprenentatgeGeneral, Long> {
}
