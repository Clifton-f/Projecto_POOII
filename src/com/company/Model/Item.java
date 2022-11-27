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
    public String[][] toArray(){
        String [][]array = new String[2][3];

        array[0][0] = "batchNo";
        array[0][1] = "idVenda";
        array[0][2] = "quantidade";



        array[1][0] = this.batchNo;
        array[1][1] = this.idVenda;
        array[1][2] = String.valueOf(this.quantidade);


        return array;
    }
}
