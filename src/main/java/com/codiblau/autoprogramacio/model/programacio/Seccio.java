package com.codiblau.autoprogramacio.model.programacio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ap_seccio")
@EqualsAndHashCode(exclude="programacio")
public @Data class Seccio {
    @Id
    @Column(name = "idseccio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idseccio;

    @Column(name = "titol", nullable = false, length = 2048)
    private String titol;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @Column(name = "heading", nullable = false)
    private Integer heading;

    @Column(name = "continguts", nullable = false, length = 2048)
    private Boolean afegirContinguts;

    @Column(name = "criterisAvaluacio", nullable = false, length = 2048)
    private Boolean afegirCriterisAvaluacio;

    @OneToMany(mappedBy="seccio")
    @JsonManagedReference
    private Set<Paragraf> paragrafs = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="programacio_idprogramacio", nullable = false)
    @JsonBackReference
    private Programacio programacio;
}
