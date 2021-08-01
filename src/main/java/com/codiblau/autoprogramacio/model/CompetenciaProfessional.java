package com.codiblau.autoprogramacio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "autoprogramacio_competenciaprofessional")
public @Data class CompetenciaProfessional {
    @Id
    @Column(name = "idcompetencia")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idcompetencia;

    @Column(name = "nom_es", nullable = false)
    private String nomES;

    @Column(name = "nom_ca", nullable = false)
    private String nomCA;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @ManyToOne
    @JoinColumn(
            name="modul_idmodul",
            nullable = false)
    @JsonBackReference
    private Modul modul;
}
