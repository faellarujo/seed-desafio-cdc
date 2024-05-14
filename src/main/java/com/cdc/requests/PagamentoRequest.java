package com.cdc.requests;

import com.cdc.exception.PaisExistException;
import com.cdc.model.PaisModel;
import com.cdc.service.VerificaPaisService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class PagamentoRequest {

    @PersistenceContext
    EntityManager entityManager;

    @PersistenceContext
    VerificaPaisService verificaPaisService;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;


    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    //@NotBlank
    private PaisRequest pais;


    @NotNull
    private EstadoRequest estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    // Criar constructor com todos os atributos e anotações

    public PagamentoRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, PaisRequest pais, @NotNull EstadoRequest estado, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = DocumentoRequest.isValid(documento);
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    // Criar getters e setters

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

    public PaisRequest getPais() {
        return pais;
    }

    public void setPais(PaisRequest pais) {
        this.pais = pais;
    }

    public EstadoRequest getEstado() {
        return estado;
    }

    public void setEstado(EstadoRequest estado) {
        this.estado = estado;
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

    // Criar método toString

    @Override
    public String toString() {
        return "PagamentoRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento=" + documento +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais='" + pais + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }


   public String verificaDocumento(String documento) {
       final String valid = DocumentoRequest.isValid(documento);
       return valid;

   }
}
