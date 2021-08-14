package com.codiblau.autoprogramacio.model.boe;

import com.codiblau.autoprogramacio.model.programacio.Programacio;
import com.codiblau.autoprogramacio.model.programacio.UnitatFormativa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ap_modul")
public @Data class Modul {
    @Id
    @Column(name = "idmodul")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmodul;

    @Column(name = "nom", nullable = false, length = 2048)
    private String nom;

    @OneToMany(mappedBy="modul")
    @JsonManagedReference
    private Set<ResultatAprenentatgeGeneral> resultatsAprenentatgeGeneral = new HashSet<>();

    @OneToMany(mappedBy="modul")
    @JsonManagedReference
    private Set<CompetenciaProfessional> competenciesProfessionals = new HashSet<>();

    @OneToMany(mappedBy="modul")
    @JsonManagedReference
    private Set<Contingut> continguts = new HashSet<>();

    @OneToMany(mappedBy="modul")
    @JsonManagedReference
    private Set<ResultatAprenentatgeCicle> resultatAprenentatgeCicle = new HashSet<>();

    @OneToMany(mappedBy="modul")
    @JsonBackReference
    private Set<Programacio> programacions = new HashSet<>();

}
