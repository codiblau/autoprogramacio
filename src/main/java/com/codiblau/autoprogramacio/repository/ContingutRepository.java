package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.Contingut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContingutRepository extends JpaRepository<Contingut, Long> {
}
