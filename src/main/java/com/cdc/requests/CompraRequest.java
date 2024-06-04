package com.cdc.requests;


import com.cdc.exception.CupomExisteException;
import com.cdc.exception.EstadoExistsException;
import com.cdc.model.*;
import com.cdc.service.CupomService;
import com.cdc.service.VerificaPaisService;
import com.cdc.validadores.Documento;
import com.cdc.validadores.ExistId;
import com.cdc.validadores.UniqueValue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class CompraRequest {

    @Autowired
    EntityManager entityManager;

    @PersistenceContext
    VerificaPaisService verificaPaisService;

    @Autowired
    CupomService cupomService;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Documento(domainClass = CompraRequest.class, fieldName = "documento")
    private String documento;


    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistId(domainClass = Pais.class, fieldName = "id")
    private Long id_pais;

    @ExistId(domainClass = Estado.class, fieldName = "id")
    private Long id_estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Valid
    private PedidoRequest pedido;

    private String codigoCupom;


    public CompraRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotBlank Long id_pais, Long id_estado, @NotBlank String telefone, @NotBlank String cep, @Valid PedidoRequest pedido, String cupomDesconto) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.id_pais = id_pais;
        this.id_estado = id_estado;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
        this.codigoCupom = cupomDesconto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documentoRequest) {
        this.documento = documentoRequest;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getPais() {
        return id_pais;
    }

    public void setPais(Long pais) {
        this.id_pais = pais;
    }

    public Long getEstado() {
        return id_estado;
    }

    public void setEstado(Long estado) {
        this.id_estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public PedidoRequest getPedidoRequest() {
        return pedido;
    }

    public void setPedidoRequest(PedidoRequest pedido) {
        this.pedido = pedido;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public void setCodigoCupom(String codigoCupom) {
        this.codigoCupom = codigoCupom;
    }


    public Compra toModel() {
        final Pais pais = new Pais(this.id_pais);
        final Estado estado = new Estado(this.id_estado);
        return new Compra(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, pais, estado, this.telefone, this.cep);
    }

    public Compra toModelComCupom(Long idCupom){
        return new Compra(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, new Pais(this.id_pais), new Estado(this.id_estado), this.telefone, this.cep, new CupomDesconto());
    }
}

