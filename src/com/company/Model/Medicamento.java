package com.company.Model;

import java.sql.*;
import java.util.ArrayList;

public class Medicamento {
    private String batchNo;
    private String nome_comercial;
    private String nome_generico;
    private Date validade;
    private int stock;
    private int preco_compra;
    private int preco_venda;
    private String classificacao;
    private String contacto;
    private String descricao;
    ArrayList<Ingrediente> ingredientes = new ArrayList<>();

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

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

    public String getNome_generico() {
        return nome_generico;
    }

    public void setNome_generico(String nome_generico) {
        this.nome_generico = nome_generico;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Medicamento(String batchNo, String nome_comercial, Date validade, int quantidade, int preco_compra, int preco_venda) {
        this.batchNo = batchNo;
        this.nome_comercial = nome_comercial;
        this.validade = validade;
        this.stock = quantidade;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "'" + batchNo +
                "', '" + nome_comercial +
                "', '" + nome_generico +
                "', '" + validade +
                "', '" + preco_compra +
                "', '" + preco_venda +
                "', '" + classificacao +
                "', '" + contacto +
                "', '" + descricao +
                "', '" + stock +"'";
    }
}
