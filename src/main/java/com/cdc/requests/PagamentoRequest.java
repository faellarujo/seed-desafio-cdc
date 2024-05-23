package com.cdc.requests;


import com.cdc.model.Pagamento;
import com.cdc.service.VerificaPaisService;
import com.cdc.validadores.Documento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class    PagamentoRequest {

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
    @Documento(domainClass = PagamentoRequest.class, fieldName = "documento")
    private String documento;


    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;


    @NotBlank
    private String pais;

    private String estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public PagamentoRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotBlank String pais,  String estado, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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

//    public Pagamento toModel() {
//        return new Pagamento(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, this.pais, this.estado, this.telefone, this.cep);
//    }
}
