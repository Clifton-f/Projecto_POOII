package com.company.Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Venda {
    private int idVenda;
    private Timestamp data;
    private int valor_total;
    private int desconto;
    private int valor_pago;

    public Venda(int idVenda, Timestamp data, int valor_total, int desconto, int valor_pago) {
        this.idVenda = idVenda;
        this.data = data;
        this.valor_total = valor_total;
        this.desconto = desconto;
        this.valor_pago = valor_pago;

    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public int getValor_total() {
        return valor_total;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public int getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(int valor_pago) {
        this.valor_pago = valor_pago;
    }


}
