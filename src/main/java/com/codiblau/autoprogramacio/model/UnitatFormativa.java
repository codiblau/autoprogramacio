package com.codiblau.autoprogramacio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autoprogramacio_unitatformativa")
public @Data class UnitatFormativa {
    @Id
    @Column(name = "idunitatformativa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnitatFormativa;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "justificacio", nullable = true)
    @Type(type="text")
    private String justificacio;

    @Column(name = "ordre", nullable = false)
    private Integer ordre;

    @ManyToOne
    @JoinColumn(
            name="modul_idmodul",
            nullable = false)
    @JsonBackReference
    private Modul modul;

    @OneToMany(mappedBy="unitatFormativa")
    @JsonManagedReference
    private Set<Activitat> activitats = new HashSet<>();
}
