package com.codiblau.autoprogramacio.model.boe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "ap_competenciaprofessional")
@EqualsAndHashCode(exclude="modul")
public @Data class CompetenciaProfessional {
    @Id
    @Column(name = "idcompetencia")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idcompetencia;

    @Column(name = "nom_es", nullable = false)
    private String nomES;

    @Column(name = "nom_ca", nullable = false, length = 2048)
    private String nomCA;

    @Column(name = "ordre", nullable = false, length = 2048)
    private Integer ordre;

    @ManyToOne
    @JoinColumn(name="cicleformatiu_idcicleformatiu", nullable = false)
    @JsonBackReference
    private CicleFormatiu cicleFormatiu;
}
