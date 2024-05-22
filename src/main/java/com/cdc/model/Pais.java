package com.cdc.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pais {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Long id;
    private String nome;

    @JsonBackReference
    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    private List<Estado> estados;

    public Pais() {
    }

    public Pais(Long id, String nome, List<Estado> estado) {
        this.id = id;
        this.nome = nome;
        this.estados = estado;
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais(Long paisId) {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Estado> getEstado() {
        return estados;
    }

    public void setEstado(List<Estado> estado) {
        this.estados = estado;
    }

    public Pais(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
