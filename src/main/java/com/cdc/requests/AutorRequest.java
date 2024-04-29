package com.cdc.requests;

import com.cdc.model.AutorModel;
import com.cdc.validadores.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AutorRequest {

    private Long id;
    @NotBlank
    private String nome;


    @Email(message = "Email inválido")
    @Size(max = 50)
    @NotBlank
    @UniqueValue(domainClass = AutorModel.class, fieldName = "email")
    private String email;


    @NotBlank
    @Size(max = 400)
    private String descricao;

    private LocalDateTime instante = LocalDateTime.now();

    public AutorRequest(
        @NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao, LocalDateTime instante) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorRequest() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public AutorModel toModel() {
        return new AutorModel(this.id, this.nome, this.email, this.descricao, this.instante);
    }
}
