package com.codiblau.autoprogramacio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "autoprogramacio_contingut")
public @Data class Contingut {

    @Id
    @Column(name = "idcontingut")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcontingut;

    @Column(name = "nom_es", nullable = false, length = 2048)
    private String nomES;

    @Column(name = "nom_ca", nullable = false, length = 2048)
    private String nomCA;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @Column(name = "basic", nullable = false)
    private Boolean basic;

    @Column(name = "excepcio", nullable = false)
    private Boolean excepcio;

    @ManyToOne
    @JoinColumn(
            name="resultataprenentatge_idresultataprenentatge",
            nullable = false)
    @JsonBackReference
    private ResultatAprenentatgeCicle resultatAprenentatgeCicle;
}
