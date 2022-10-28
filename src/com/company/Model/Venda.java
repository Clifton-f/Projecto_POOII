package com.company.Model;

import java.sql.Date;

public class Venda {
    private int idVenda;
    private Date data;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    private int valor_total;
    private int desconto;
    private int valor_pago;

}
