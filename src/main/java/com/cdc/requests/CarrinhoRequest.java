package com.cdc.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public class CarrinhoRequest {

    @NotNull
    @Min(1)
    private BigDecimal total;

    @Valid
    private List<ItensRequest> itens;

    public CarrinhoRequest() {
    }

    public CarrinhoRequest(@NotNull @Min(1) BigDecimal total,  @Valid List<ItensRequest> itens) {
        this.total = total;
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItensRequest> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "CarrinhoRequest{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }

}
