package com.codiblau.autoprogramacio.model.boe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ap_resultataprenentatgegeneral")
@EqualsAndHashCode(exclude="modul")
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
    @JoinColumn(name="cicleformatiu_idcicleformatiu", nullable = false)
    @JsonBackReference
    private CicleFormatiu cicleFormatiu;

    @ManyToMany
    private Set<ResultatAprenentatgeCicle> resultatsAprenentatgeCicle = new HashSet<>();
}