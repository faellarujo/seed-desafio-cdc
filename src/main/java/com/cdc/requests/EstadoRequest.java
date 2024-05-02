package com.cdc.requests;

import com.cdc.model.EstadoModel;
import com.cdc.model.PaisModel;
import com.cdc.validadores.ExistId;
import com.cdc.validadores.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstadoRequest {


    @NotBlank
    @UniqueValue(domainClass = EstadoRequest.class, fieldName = "nome")
    private String nome;

    @NotNull(message = "É obrigatório informar o país ao qual o estado pertence.")
    @ExistId(domainClass = PaisModel.class, fieldName = "id")
    private Long paisId;

    public EstadoRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public EstadoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public EstadoModel toModel() {
        return new EstadoModel(this.nome, this.paisId);
    }


}

