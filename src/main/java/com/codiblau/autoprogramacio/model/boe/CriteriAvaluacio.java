package com.codiblau.autoprogramacio.model.boe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "ap_criteriavaluacio")
@EqualsAndHashCode(exclude="resultatAprenentatgeCicle")
public @Data class CriteriAvaluacio {
    @Id
    @Column(name = "idca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idca;

    @Column(name = "nom_es", nullable = false, length = 2048)
    private String nomES;

    @Column(name = "nom_ca", nullable = false, length = 2048)
    private String nomCA;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @Column(name = "excepcio", nullable = false)
    private Boolean excepcio;

    @ManyToOne
    @JoinColumn(name="resultataprenentatge_idresultataprenentatge", nullable = false)
    @JsonBackReference
    private ResultatAprenentatgeCicle resultatAprenentatgeCicle;
}
