package com.cdc.requests;

import com.cdc.model.PaisModel;
import com.cdc.validadores.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PaisRequest {

        @NotBlank
        @Size(max = 50)
        @UniqueValue(domainClass = PaisModel.class, fieldName = "nome")
        private String nome;

        public PaisRequest() {
        }

        public PaisRequest(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

         public void setNome(@NotBlank String nome) {
            this.nome = nome;
        }

    public PaisModel toModel() {
           return new PaisModel(this.nome);

    }
}
