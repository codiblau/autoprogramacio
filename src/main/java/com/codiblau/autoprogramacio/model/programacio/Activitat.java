package com.codiblau.autoprogramacio.model.programacio;

import com.codiblau.autoprogramacio.model.boe.Contingut;
import com.codiblau.autoprogramacio.model.boe.CriteriAvaluacio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ap_activitat")
public @Data class Activitat {
    @Id
    @Column(name = "idactivitat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivitat;

    @Column(name = "nom", nullable = false, length = 2048)
    private String nom;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @Column(name = "temps", nullable = true)
    private Integer temps;

    @ManyToOne
    @JoinColumn(name="unitatformativa_idunitatformativa", nullable = false)
    @JsonBackReference
    private UnitatFormativa unitatFormativa;

    @ManyToMany
    private Set<Contingut> continguts = new HashSet<>();

    @ManyToMany
    private Set<CriteriAvaluacio> criterisAvaluacio = new HashSet<>();
}
