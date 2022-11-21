package com.company.Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Venda {
    private int idVenda;
    private Timestamp data;
    private int valor_total;
    private float desconto;
    private int valor_pago;
    private ArrayList<Item> itens = new ArrayList<>();
    private String tabela = "venda";

    public Venda() {
        this.idVenda = 2;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Venda(Timestamp data, int valor_total, float desconto, int valor_pago) {
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

    public float getDesconto() {
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

    public String[][] toArray(){
        String [][]array = new String[5][2];

        array[0][0] = "idVenda";
        array[1][0] = "data";
        array[2][0] = "valor total";
        array[3][0] = "desconto";
        array[4][0] = "valor pago";



        array[0][1] = String.valueOf(this.idVenda);
        array[1][1] = String.valueOf(this.data);
        array[2][1] = String.valueOf(this.valor_total);
        array[3][1] = String.valueOf(this.desconto);
        array[4][1] = String.valueOf(this.valor_pago);

        return array;
    }

    @Override
    public String toString() {
        return " '"+ data + "' " +
                ", '" + valor_total +
                ", '" + desconto +
                "', '" + valor_pago + "'";
    }
}
