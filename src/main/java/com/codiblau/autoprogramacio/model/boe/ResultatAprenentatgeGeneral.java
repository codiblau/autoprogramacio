package com.codiblau.autoprogramacio.model.boe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "autoprogramacio_resultataprenentatgegeneral")
public @Data class ResultatAprenentatgeGeneral {
    @Id
    @Column(name = "idresultataprenentatge")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultatAprenentatge;

    @Column(name = "nom_es", nullable = false, length = 2048)
    private String nomES;

    @Column(name = "nom_ca", nullable = false, length = 2048)
    private String nomCA;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @ManyToOne
    @JoinColumn(name="resultataprenentatge_idresultataprenentatge", nullable = true)
    @JsonBackReference
    private ResultatAprenentatgeCicle resultatAprenentatgeCicle;
}