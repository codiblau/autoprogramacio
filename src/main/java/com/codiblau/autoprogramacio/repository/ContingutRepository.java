package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.Contingut;
import com.codiblau.autoprogramacio.model.ResultatAprenentatgeCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContingutRepository extends JpaRepository<Contingut, Long> {
    List<Contingut> findAllByResultatAprenentatgeCicle(ResultatAprenentatgeCicle resultatAprenentatgeCicle);
}
