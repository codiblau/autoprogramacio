package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.CompetenciaProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaProfessionalRepository extends JpaRepository<CompetenciaProfessional, Long> {
}
