package com.codiblau.autoprogramacio.model.boe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@Table(name = "ap_contingut")
@EqualsAndHashCode(exclude="modul")
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
    private Double ordre;

    @Column(name = "basic", nullable = false)
    private Boolean basic;

    @Column(name = "excepcio", nullable = false)
    private Boolean excepcio;

    @ManyToOne
    @JoinColumn(name="modul_idmodul", nullable = false)
    @JsonBackReference
    private Modul modul;

}
