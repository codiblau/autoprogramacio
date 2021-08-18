package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.boe.CicleFormatiu;
import com.codiblau.autoprogramacio.model.boe.CompetenciaProfessional;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaProfessionalRepository extends JpaRepository<CompetenciaProfessional, Long> {
    List<CompetenciaProfessional> findAllByCicleFormatiu(CicleFormatiu cicleFormatiu);
}
