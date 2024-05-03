package com.cdc.requests;

import com.cdc.exception.DocumentoInvalido;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public abstract class DocumentoRequest {

    @CPF
    String cpf;

    @CNPJ
    String cnpj;

    public DocumentoRequest(String documento) {
        this.cpf = isValid(documento);
        this.cnpj = isValid(documento);

}
    public DocumentoRequest() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static String isValid(String documento) {

        if (documento.length() == 14 && documento.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$")) {
            return documento;
        } else if (documento.length() == 18 && documento.matches("^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}$")) {
            return documento;
        }
        throw new DocumentoInvalido("Documento inválido");
    }
}
