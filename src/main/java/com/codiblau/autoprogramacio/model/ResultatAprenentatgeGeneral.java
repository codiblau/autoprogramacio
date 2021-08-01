package com.codiblau.autoprogramacio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autoprogramacio_resultataprenentatgegeneral")
public @Data class ResultatAprenentatgeGeneral {
    @Id
    @Column(name = "idresultataprenentatge")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultatAprenentatge;

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