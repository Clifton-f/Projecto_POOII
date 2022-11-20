package com.company.Model;

public class Item {
    private String batchNo;
    private String idVenda;
    private int quantidade;

    public Item(String batchNo, String idVenda, int quantidade) {
        this.batchNo = batchNo;
        this.idVenda = idVenda;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return " '"+batchNo + "' " +
                ", '" + idVenda +
                "', '" + quantidade+ "'";
    }
}
