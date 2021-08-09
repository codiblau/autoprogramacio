package com.codiblau.autoprogramacio.model.boe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ap_competenciaprofessional")
public @Data class CompetenciaProfessional {
    @Id
    @Column(name = "idcompetencia")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idcompetencia;

    @Column(name = "nom_es", nullable = false)
    private String nomES;

    @Column(name = "nom_ca", nullable = false, length = 2048)
    private String nomCA;

    @Column(name = "ordre", nullable = false, length = 2048)
    private Integer ordre;

    @ManyToOne
    @JoinColumn(name="modul_idmodul", nullable = false)
    @JsonBackReference
    private Modul modul;
}
