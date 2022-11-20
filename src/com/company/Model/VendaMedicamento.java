package com.company.Model;

public class VendaMedicamento {
    private String idVenda;
    private int quantidade;
    private String tabela = "vendaMedicamento";

    public VendaMedicamento(String batchNo, String idVenda, int quantidade) {
        this.idVenda = idVenda;
        this.quantidade = quantidade;
    }


    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return
                "'" + idVenda +
                "','" + quantidade +
                "'";
    }
}
