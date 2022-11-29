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
    private String contactoFornecedor;
    private String descricao;
    private String tabela = "medicamento";

    public Medicamento(String batchNo, String nome_comercial, String nome_generico, Timestamp validade, int preco_compra,
                       int preco_venda, String classificacao, String contacto, int quantidade) {
        this.batchNo = batchNo;
        this.nome_comercial = nome_comercial;
        this.nome_generico = nome_generico;
        this.validade = validade;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.classificacao = classificacao;
        this.contactoFornecedor = contacto;
        this.quatidade = quantidade;
    }
    public Medicamento(String []medicamento){
        if(medicamento.length == 10){
            this.batchNo = medicamento[0];
            this.nome_comercial = medicamento[1];
            this.nome_generico = medicamento[2];
            this.contactoFornecedor = medicamento[3];
            this.quatidade = Integer.parseInt(medicamento[4]);
            this.preco_venda = Integer.parseInt(medicamento[5]);
            this.preco_compra = Integer.parseInt(medicamento[6]);
            this.descricao = medicamento[7];
            this.classificacao = medicamento[8];
            this.validade = Timestamp.valueOf(medicamento[9]);
        }
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

    public Timestamp getValidade() {
        return validade;
    }

    public void setValidade(Timestamp validade) {
        this.validade = validade;
    }

    public int getStock() {
        return quatidade;
    }

    public void setStock(int stock) {
        this.quatidade = stock;
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
        return contactoFornecedor;
    }

    public void setContacto(String contacto) {
        this.contactoFornecedor = contacto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String[][] toArray(){
        String [][]array = new String[2][10];

        array[0][0] = "batch No.";
        array[0][1] = "Nome comercial";
        array[0][2] = "Nome Genérico";
        array[0][3] = "contacto do fornecedor";
        array[0][4] = "quantidade";
        array[0][5] = "preco de venda";
        array[0][6] = "preco de compra";
        array[0][7] = "descricao";
        array[0][8] = "classificacao";
        array[0][9] = "validade";


        array[1][0] = this.batchNo;
        array[1][1] = this.nome_comercial;
        array[1][2] = this.nome_generico;
        array[1][3] = this.contactoFornecedor;
        array[1][4] = String.valueOf(this.quatidade);
        array[1][5] = String.valueOf(this.preco_venda);
        array[1][6] = String.valueOf(this.preco_compra);
        array[1][7] = this.descricao;
        array[1][8] = this.classificacao;
        array[1][9] = String.valueOf(this.validade);



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
                "', '" + contactoFornecedor +
                "', '" + descricao +
                "', '" + quatidade +"'";
    }

}
