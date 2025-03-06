package com.cdc.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PagamentoParte01Request {


    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @Valid
    private DocumentoRequest documentoRequest;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private String pais;

    private String estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public @NotBlank String getCep() {
        return cep;
    }

    public void setCep(@NotBlank String cep) {
        this.cep = cep;
    }

    public @NotBlank String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank String cidade) {
        this.cidade = cidade;
    }

    public @NotBlank String getComplemento() {
        return complemento;
    }

    public void setComplemento(@NotBlank String complemento) {
        this.complemento = complemento;
    }

    public DocumentoRequest getDocumento() {
        return documentoRequest;
    }

    public void setDocumento(@NotBlank DocumentoRequest documentoRequest) {
        this.documentoRequest = documentoRequest;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull String getPais() {
        return pais;
    }

    public void setPais(@NotNull String pais) {
        this.pais = pais;
    }


    public @NotBlank String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(@NotBlank String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank String telefone) {
        this.telefone = telefone;
    }

    public PagamentoParte01Request(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @Valid DocumentoRequest documentoRequest, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull String pais, String estado, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documentoRequest = documentoRequest;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "PagamentoParte01Request{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documentoRequest='" + documentoRequest + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais='" + pais + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

}
