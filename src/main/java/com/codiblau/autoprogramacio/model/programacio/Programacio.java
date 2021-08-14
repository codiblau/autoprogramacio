package com.codiblau.autoprogramacio.model.programacio;

import com.codiblau.autoprogramacio.model.boe.CompetenciaProfessional;
import com.codiblau.autoprogramacio.model.boe.Contingut;
import com.codiblau.autoprogramacio.model.boe.Modul;
import com.codiblau.autoprogramacio.model.boe.ResultatAprenentatgeCicle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ap_programacio")
@EqualsAndHashCode(exclude="modul")
public @Data class Programacio {
    @Id
    @Column(name = "idprogramacio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprogramacio;

    @Column(name = "autor", nullable = false, length = 2048)
    private String autor;

    @Column(name = "curs", nullable = false, length = 255)
    private String curs;

    @ManyToOne
    @JoinColumn(name="modul_idmodul", nullable = false)
    @JsonManagedReference
    private Modul modul;

    @OneToMany(mappedBy="programacio")
    @JsonManagedReference
    private Set<UnitatFormativa> unitatsFormatives = new HashSet<>();

    @OneToMany(mappedBy="programacio")
    @JsonManagedReference
    private Set<Seccio> seccions = new HashSet<>();



}
