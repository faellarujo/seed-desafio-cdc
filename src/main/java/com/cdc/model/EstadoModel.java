package com.cdc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class EstadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_id")
    private Long id;
    private String nome;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private PaisModel pais;


    public EstadoModel() {
    }

    public EstadoModel(Long id, String nome, PaisModel pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public EstadoModel(String nome, Long paisId) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisModel getPais() {
        return pais;
    }

    public void setPais(PaisModel pais) {
        this.pais = pais;
    }
}
