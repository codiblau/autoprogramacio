package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.CicleFormatiu;
import com.codiblau.autoprogramacio.model.boe.Modul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CicleFormatiuRepository extends JpaRepository<CicleFormatiu, Long> {
}
