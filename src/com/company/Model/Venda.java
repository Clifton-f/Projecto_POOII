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
        String [][]array = new String[2][5];

        array[0][0] = "idVenda";
        array[0][1] = "data";
        array[0][2] = "valor total";
        array[0][3] = "desconto";
        array[0][4] = "valor pago";



        array[1][0] = String.valueOf(this.idVenda);
        array[1][1] = String.valueOf(this.data);
        array[1][2] = String.valueOf(this.valor_total);
        array[1][3] = String.valueOf(this.desconto);
        array[1][4] = String.valueOf(this.valor_pago);

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
