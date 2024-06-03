package com.cdc.requests;

import com.cdc.model.CupomDesconto;
import com.cdc.model.EstatusCupom;
import com.cdc.validadores.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomDescontoRequest {

        @NotBlank
        @UniqueValue(domainClass = CupomDesconto.class, fieldName = "codigo")
        private String codigo;

        @NotNull
        @Positive
        private BigDecimal percentualDesconto;

        @Future
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonSerialize(using = LocalDateSerializer.class)
        private LocalDate validade;

        private EstatusCupom estatusCupom;



        public CupomDescontoRequest() {
        }

        public CupomDescontoRequest(@NotBlank String codigo, @NotNull @Positive BigDecimal percentualDesconto, @Future LocalDate validade, EstatusCupom estatusCupom) {
                this.codigo = codigo;
                this.percentualDesconto = percentualDesconto;
                this.validade = validade;
                this.estatusCupom = estatusCupom;
        }
        public EstatusCupom getEstatusCupom() {
                return estatusCupom;
        }

        public void setEstatusCupom(EstatusCupom estatusCupom) {
                this.estatusCupom = estatusCupom;
        }

        public @NotBlank String getCodigo() {
                return codigo;
        }

        public void setCodigo(@NotBlank String codigo) {
                this.codigo = codigo;
        }

        public @NotNull @Positive BigDecimal getPercentualDesconto() {
                return percentualDesconto;
        }

        public void setPercentualDesconto(@NotNull @Positive BigDecimal percentualDesconto) {
                this.percentualDesconto = percentualDesconto;
        }

        public @Future LocalDate getValidade() {
                return validade;
        }

        public void setValidade(@Future LocalDate validade) {
                this.validade = validade;
        }


        @Override
        public String toString() {
                return "CupomDescontoRequest{" +
                        "codigo='" + codigo + '\'' +
                        ", percentualDesconto=" + percentualDesconto +
                        ", validade=" + validade +
                        ", estatusCupom=" + estatusCupom +
                        '}';

        }

        public CupomDesconto toModel(){
                return new CupomDesconto(this.codigo, this.percentualDesconto.doubleValue(), this.validade.toString(), EstatusCupom.ATIVO);
        }
}
