package com.cdc.requests;

import com.cdc.model.Estado;
import com.cdc.model.Pais;
import com.cdc.validation.UniqueValue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;


public class PaisRequest {

    @PersistenceContext
    EntityManager entityManager;

    private List<Estado> estados;

    @NotBlank
    @Size(max = 50)
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String pais;

    public PaisRequest() {
    }

    public PaisRequest(String nome) {
        this.pais = nome;
    }

    public String getNome() {
        return pais;
    }

    public void setNome(@NotBlank String nome) {
        this.pais = nome;
    }

    public Pais toModel() {
        return new Pais(this.pais);
    }

}
