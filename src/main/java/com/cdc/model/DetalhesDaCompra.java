package com.cdc.model;

import com.cdc.requests.PedidoRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesDaCompra {

    String documento;
    String endereco;
    String complemento;
    Destinatario destinatario;
    String produto;
    int quantidade;
    BigDecimal total;
    PedidoRequest pedidoRequest;

    public DetalhesDaCompra() {
    }

    public DetalhesDaCompra(String documento, String endereco, String complemento, Destinatario destinatario, String produto, BigDecimal total , int quantidade, PedidoRequest pedidoRequest) {
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.destinatario = destinatario;
        this.produto = produto;
        this.total = total;
        this.quantidade = quantidade;
        this.pedidoRequest = pedidoRequest;

    }

    public PedidoRequest getPedidoRequest() {
        return pedidoRequest;
    }

    public void setPedidoRequest(PedidoRequest pedidoRequest) {
        this.pedidoRequest = pedidoRequest;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return total;
    }

    public void setPreco(BigDecimal preco) {
        this.total = preco;
    }




}
