package com.company.Model;

import java.sql.*;
import java.util.ArrayList;

public class Medicamento {
    private String batchNo;
    private String nome_comercial;
    private String nome_generico;
    private Timestamp validade;
    private int quatidade;
    private int preco_compra;
    private int preco_venda;
    private String classificacao;
    private String contacto;
    private String descricao;
    private String tabela = "medicamento";

    public Medicamento(String batchNo, String nome_comercial, String nome_generico, Timestamp validade, int preco_compra,
                       int preco_venda, String classificacao, String contacto, String descricao, int quantidade) {
        this.batchNo = batchNo;
        this.nome_comercial = nome_comercial;
        this.nome_generico = nome_generico;
        this.validade = validade;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.classificacao = classificacao;
        this.contacto = contacto;
        this.descricao = descricao;
        this.quatidade = quantidade;
    }

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

    /*public void setBatchNo(String batchNo) {
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

    public Timestamp getValidade() {
        return validade;
    }

    public void setValidade(Timestamp validade) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }*/

    public String[][] toArray(){
        String [][]array = new String[7][2];

        array[0][0] = "batch No.";
        array[1][0] = "Nome comercial";
        array[2][0] = "Nome Genérico";
        array[3][0] = "validade";
        array[4][0] = "fornecedor";


        array[0][1] = this.batchNo;
        array[1][1] = this.nome_comercial;
        array[2][1] = this.nome_generico;
        array[3][1] = String.valueOf(this.validade);

        return array;
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
                "', '" + quatidade +"'";
    }

}
