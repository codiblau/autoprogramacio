package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.programacio.Programacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramacioRepository extends JpaRepository<Programacio, Long> {
}
