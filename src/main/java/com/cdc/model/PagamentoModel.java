package com.cdc.model;


import jakarta.persistence.*;

@Entity
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;

    @ManyToOne
    private PaisModel pais;

    @ManyToOne
    private EstadoModel estado;
    private String telefone;
    private String cep;

    public PagamentoModel() {
    }

    public PagamentoModel(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, PaisModel pais, EstadoModel estado, String telefone, String cep) {
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

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public PaisModel getPais() {
        return pais;
    }

    public EstadoModel getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }


}
