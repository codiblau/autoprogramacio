package com.codiblau.autoprogramacio.model.boe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autoprogramacio_resultataprenentatgecicle")
public @Data class ResultatAprenentatgeCicle {
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
    @JoinColumn(name="modul_idmodul", nullable = false)
    @JsonBackReference
    private Modul modul;

    @OneToMany(mappedBy="resultatAprenentatgeCicle")
    @JsonManagedReference
    private Set<CriteriAvaluacio> criterisAvaluacio = new HashSet<>();

    @ManyToMany
    private Set<ResultatAprenentatgeGeneral> resultatAprenentatgeGeneral = new HashSet<>();

    @ManyToMany
    private Set<CompetenciaProfessional> competencies = new HashSet<>();

    @ManyToMany
    private Set<Contingut> continguts = new HashSet<>();

}