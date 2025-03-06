package com.cdc.requests;

import com.cdc.exception.DocumentoInvalido;
import com.cdc.exception.DocumentoObrigatorio;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class DocumentoRequest {

    @CPF
    private String cpf;

    @CNPJ
    private String cnpj;

    // Construtor padrão
    public DocumentoRequest() {
    }

    @JsonCreator
    public DocumentoRequest(@JsonProperty("cpf") String cpf, @JsonProperty("cnpj") String cnpj) {
        if (cpf != null && !cpf.isEmpty()) {
            this.cpf = cpf;
        } else if (cnpj != null && !cnpj.isEmpty()) {
            this.cnpj = cnpj;
        } else {
            throw new DocumentoInvalido("Documento inválido");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public boolean isCPF() {
        return cpf != null;
    }

    public boolean isCNPJ() {
        return cnpj != null;
    }

    @Override
    public String toString() {
        return "DocumentoRequest [cpf=" + cpf + ", cnpj=" + cnpj + "]";
    }

    public String existeDocumento(String documento) {
        if (documento == null) {
            throw new DocumentoObrigatorio("Documento Obrigatorio");
        }
        return documento;
    }
}