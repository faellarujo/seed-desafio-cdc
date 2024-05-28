package com.cdc.requests;

import com.cdc.exception.ValorIncorretoException;
import com.cdc.service.PedidoService;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class PedidoRequest {

    @Autowired
    PedidoService pedidoService;

    @NotNull
    @Min(1)
    private BigDecimal total;

    @Valid
    @NotEmpty
    private List<ItensRequest> itens;


    public void setTotal(@NotNull @Min(1) BigDecimal total) {
        this.total = total;
    }

    public void setItens(@Valid @NotEmpty List<ItensRequest> itens) {
        this.itens = itens;
    }

    public PedidoRequest() {
    }

    public PedidoRequest(@NotNull @Min(1) BigDecimal total, @Valid @NotEmpty List<ItensRequest> itens, PedidoService pedidoService) {
        this.total = total;
        this.itens = itens;
        this.pedidoService = pedidoService;
    }
    public BigDecimal getTotal() {
        return total;
    }

    public List<ItensRequest> getItens() {
        return itens;
    }
    @Override
    public String toString() {
        return "PedidoRequest{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }

    public void ComparaValorDoPedidoComOvalorTotalDosItens() {
        if (getTotal().compareTo(pedidoService.valorTotalDosItensDoCarrinho(getItens())) != 0) {
            throw new ValorIncorretoException("O valor total da compra não confere com o valor total dos itens do pedido");
        }//1
    }


}
