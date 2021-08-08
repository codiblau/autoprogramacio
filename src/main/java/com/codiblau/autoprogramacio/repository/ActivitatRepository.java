package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.programacio.Activitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitatRepository extends JpaRepository<Activitat, Long> {
}
