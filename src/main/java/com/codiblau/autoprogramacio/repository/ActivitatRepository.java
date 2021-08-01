package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.Activitat;
import com.codiblau.autoprogramacio.model.ResultatAprenentatgeCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitatRepository extends JpaRepository<Activitat, Long> {
}
