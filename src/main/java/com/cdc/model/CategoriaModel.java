package com.cdc.model;


import com.cdc.validadores.NomeAlreadyExists;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @NomeAlreadyExists()
    private String nome;

    public CategoriaModel(){

    }

    public CategoriaModel(String nome) {
        this.nome = nome;
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
