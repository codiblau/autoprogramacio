package com.codiblau.autoprogramacio.model.boe;

import com.codiblau.autoprogramacio.model.programacio.Programacio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ap_cicleformatiu")
public @Data class CicleFormatiu {
    @Id
    @Column(name = "idcicleformatiu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcicleformatiu;

    @Column(name = "identificador", unique = true, nullable = false, length = 2048)
    private String identificador;

    @Column(name = "nom", nullable = false, length = 2048)
    private String nom;

    @OneToMany(mappedBy="cicleFormatiu")
    @JsonManagedReference
    private Set<ResultatAprenentatgeGeneral> resultatsAprenentatgeGeneral = new HashSet<>();

    @OneToMany(mappedBy="cicleFormatiu")
    @JsonManagedReference
    private Set<CompetenciaProfessional> competenciesProfessionals = new HashSet<>();

    @OneToMany(mappedBy="cicleFormatiu")
    @JsonManagedReference
    private Set<Modul> moduls = new HashSet<>();

}
