package com.codiblau.autoprogramacio.model.programacio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "ap_paragraf")
@EqualsAndHashCode(exclude="seccio")
public @Data class Paragraf {
    @Id
    @Column(name = "idparagraf")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idparagraf;

    @Column(name = "descripcio")
    @Type(type="text")
    private String descripcio;

    @ManyToOne
    @JoinColumn(name="seccio_idseccio", nullable = false)
    @JsonBackReference
    private Seccio seccio;
}
