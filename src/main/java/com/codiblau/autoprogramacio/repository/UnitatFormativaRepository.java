package com.codiblau.autoprogramacio.repository;

import com.codiblau.autoprogramacio.model.programacio.UnitatFormativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitatFormativaRepository extends JpaRepository<UnitatFormativa, Long> {
}
