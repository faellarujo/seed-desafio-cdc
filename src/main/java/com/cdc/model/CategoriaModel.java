package com.cdc.model;


import com.cdc.validadores.UniqueValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @UniqueValue(domainClass = CategoriaModel.class, fieldName = "nome")
    private String nome;

    public CategoriaModel(){

    }

    public CategoriaModel(String request) {
        this.nome = request;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
