package com.codiblau.autoprogramacio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autoprogramacio_modul")
public @Data class Modul {
    @Id
    @Column(name = "idmodul")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmodul;

    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy="modul")
    @JsonManagedReference
    private Set<CompetenciaProfessional> competenciesProfessionals = new HashSet<>();

    @OneToMany(mappedBy="modul")
    @JsonManagedReference
    private Set<ResultatAprenentatgeCicle> resultatAprenentatgeCicle = new HashSet<>();

    @OneToMany(mappedBy="modul")
    @JsonManagedReference
    private Set<UnitatFormativa> unitatsFormatives = new HashSet<>();

}
