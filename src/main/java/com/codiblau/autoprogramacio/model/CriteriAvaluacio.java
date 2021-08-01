package com.codiblau.autoprogramacio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "autoprogramacio_criteriavaluacio")
public @Data class CriteriAvaluacio {
    @Id
    @Column(name = "idca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idca;

    @Column(name = "nom_es", nullable = false)
    private String nomES;

    @Column(name = "nom_ca", nullable = false)
    private String nomCA;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @ManyToOne
    @JoinColumn(
            name="resultataprenentatge_idresultataprenentatge",
            nullable = false)
    @JsonBackReference
    private ResultatAprenentatgeCicle resultatAprenentatgeCicle;
}
