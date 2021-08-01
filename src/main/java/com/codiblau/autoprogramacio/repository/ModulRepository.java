package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.Modul;
import com.codiblau.autoprogramacio.model.ResultatAprenentatgeCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulRepository extends JpaRepository<Modul, Long> {
}
