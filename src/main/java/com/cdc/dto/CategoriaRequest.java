package com.cdc.dto;

import com.cdc.model.AutorModel;
import com.cdc.model.CategoriaModel;
import com.cdc.validadores.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoriaRequest {

    private Long id;

    @NotBlank
    @UniqueValue(domainClass = CategoriaModel.class, fieldName = "nome")
    private String nome;


    // No-argument constructor
    public CategoriaRequest() {
    }

    public CategoriaRequest(@NotBlank String nome) {
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

    public CategoriaModel toModel() {
        return new CategoriaModel(this.nome);
    }
}
