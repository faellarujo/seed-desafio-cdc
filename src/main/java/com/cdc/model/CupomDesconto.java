package com.cdc.model;

import jakarta.persistence.*;

@Entity
public class CupomDesconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String codigo;

    private double percentualDesconto;

    private String validade;


    @Enumerated(EnumType.STRING)
    private EstatusCupom estatusCupom;

    public EstatusCupom getEstatusCupom() {
        return estatusCupom;
    }

    @OneToOne(mappedBy = "cupomDesconto")
    private Compra compra;

    public void setEstatusCupom(EstatusCupom estatusCupom) {
        this.estatusCupom = estatusCupom;
    }

    public CupomDesconto() {
    }

    public CupomDesconto(String codigo, double percentualDesconto, String validade, EstatusCupom estatusCupom) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
        this.estatusCupom = EstatusCupom.ATIVO;
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
