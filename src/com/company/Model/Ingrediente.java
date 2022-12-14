package com.company.Model;

public class Ingrediente {
    private String batchNo;
    private String nome;
    private int quantidade;
    private String tabela = "ingrediente";

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Ingrediente(String batchNo, String nome, int quantidade) {
        this.batchNo = batchNo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return " '"+batchNo + "' " +
                ", '" + nome +
                "', '" + quantidade+ "'";
    }

}