package com.cdc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_id")
    private Long id;
    private String nome;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    public Estado() {
    }

    public Estado(Long id, String nome, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public Estado(String nome, Long paisId) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado(Long idEstado) {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
