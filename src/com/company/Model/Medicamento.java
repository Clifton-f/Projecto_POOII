package com.company.Model;

import java.sql.*;

public class Medicamento {
    private String batchNo;
    private String nome_comercial;
    private String nome_genérico;
    private Date validade;
    private int quantidade;
    private int preco_compra;
    private int preco_venda;
    private String classe;
    private String Contacto;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getNome_comercial() {
        return nome_comercial;
    }

    public void setNome_comercial(String nome_comercial) {
        this.nome_comercial = nome_comercial;
    }

    public String getNome_genérico() {
        return nome_genérico;
    }

    public void setNome_genérico(String nome_genérico) {
        this.nome_genérico = nome_genérico;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(int preco_compra) {
        this.preco_compra = preco_compra;
    }

    public int getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(int preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }
}
