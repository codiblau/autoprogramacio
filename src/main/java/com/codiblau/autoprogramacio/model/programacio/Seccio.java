package com.codiblau.autoprogramacio.model.programacio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "autoprogramacio_seccio")
public @Data class Seccio {
    @Id
    @Column(name = "idseccio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idseccio;

    @Column(name = "titol", nullable = false, length = 2048)
    private String titol;

    @Column(name = "descripcio")
    @Type(type="text")
    private String descripcio;

    @ManyToOne
    @JoinColumn(name="programacio_idprogramacio", nullable = false)
    @JsonBackReference
    private Programacio programacio;
}
