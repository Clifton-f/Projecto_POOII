package com.company.Model;

public class Ingrediente {
    private String nome;
    private int conceracao;

    @Override
    public String toString() {
        return  "'" + nome  +
                "', '" + conceracao +"'";
    }

    public Ingrediente(String nome, int conceracao) {
        this.nome = nome;
        this.conceracao = conceracao;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getConceracao() {
        return conceracao;
    }

    public void setConceracao(int conceracao) {
        this.conceracao = conceracao;
    }


}
