package com.cdc.model;

import com.cdc.requests.ItensRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;




@Entity
public class CarrinhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal total;

    @OneToMany(mappedBy = "carrinhoModel")
    private List<ItenDoCarrinhoModel> itens;

    public CarrinhoModel() {
    }

    public CarrinhoModel(BigDecimal total, List<ItensRequest> itens) {
        this.total = total;
        this.itens = new ArrayList<>();
        itens.forEach(itensRequest -> {
            this.itens.add(new ItenDoCarrinhoModel(itensRequest.getIdLivro(), itensRequest.getQuantidade()));
        });
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItenDoCarrinhoModel> getItens() {
        return itens;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setItens(ArrayList<ItenDoCarrinhoModel> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "CarrinhoModel{" +
                "total=" + total +
                ", itens=" + itens +
                '}';
    }
}
