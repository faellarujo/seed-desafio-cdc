package com.cdc.requests;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class DocumentoRequest {

    @CPF
    private String cpf;

    @CNPJ
    private String cnpj;

    // Default constructor
    public DocumentoRequest() {
    }


    public DocumentoRequest(String documento) {
        // preciso verificar se é cpf ou cnpj
        if (documento.length() == 11) {
            this.cpf = documento;
        } else if (documento.length() == 14) {
            this.cnpj = documento;
        } else {
            throw new IllegalArgumentException("DocumentoRequest inválido");
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

}
