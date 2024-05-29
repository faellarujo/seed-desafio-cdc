package com.cdc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CupomDesconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private double percentualDesconto;
    private String validade;

    public CupomDesconto() {
    }

    public CupomDesconto(String codigo, double percentualDesconto, String validade) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public String getValidade() {
        return validade;
    }
}
