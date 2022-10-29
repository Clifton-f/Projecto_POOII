package com.company.Model;

public class VendaMedicamento {
    private String batchNo;
    private String idVenda;
    private int quantidade;

    public VendaMedicamento(String batchNo, String idVenda, int quantidade) {
        this.batchNo = batchNo;
        this.idVenda = idVenda;
        this.quantidade = quantidade;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
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
}
