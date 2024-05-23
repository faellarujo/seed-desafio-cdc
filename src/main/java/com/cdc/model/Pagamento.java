package com.cdc.model;


import jakarta.persistence.*;

@Entity
public class Pagamento {

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
    private Long  id_pais;
    private Long  id_estado;
    private String telefone;
    private String cep;

    public Pagamento() {
    }

    public Pagamento(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long id_pais, Long id_estado, String telefone, String cep) {
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

    public Long getPais() {
        return id_pais;
    }

    public Long getEstado() {
        return id_estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }


}
