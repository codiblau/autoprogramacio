package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.programacio.Seccio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccioRepository extends JpaRepository<Seccio, Long> {
}
