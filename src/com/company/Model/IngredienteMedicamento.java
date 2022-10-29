package com.company.Model;

public class IngredienteMedicamento {
    private String batchNo;
    private String nome;
    private int quantidade;

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

    public IngredienteMedicamento(String batchNo, String nome, int quantidade) {
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
}
