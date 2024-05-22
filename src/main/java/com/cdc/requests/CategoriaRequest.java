package com.cdc.requests;

import com.cdc.model.Categoria;
import com.cdc.validadores.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoriaRequest {

    private Long id;

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
