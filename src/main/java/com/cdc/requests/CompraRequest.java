package com.cdc.requests;


import com.cdc.exception.ValorIncorretoException;
import com.cdc.model.Estado;
import com.cdc.model.Pais;
import com.cdc.service.VerificaPaisService;
import com.cdc.validadores.Documento;
import com.cdc.validadores.ExistId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class  CompraRequest {

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

    public CompraRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotBlank Long id_pais,  Long id_estado, @NotBlank String telefone, @NotBlank String cep, @Valid PedidoRequest pedido) {
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


    // Criar método toString

    @Override
    public String toString() {
        return "CompraRequest{" +
                "entityManager=" + entityManager +
                ", verificaPaisService=" + verificaPaisService +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", id_pais=" + id_pais +
                ", id_estado=" + id_estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", pedidoRequest=" + pedido +
                '}';
    }




//    public Compra toModel() {
//        return new Compra(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, this.pais, this.estado, this.telefone, this.cep);
//    }
}
