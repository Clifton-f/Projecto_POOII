package com.company.Model;

public class Fornecedor {
    private String contacto;
    private String nome;
    private String endereco;
    private String email;
    private String tabela = "fronecedor";

    public String getTabela() {
        return tabela;
    }

    public Fornecedor(String contacto, String nome, String endereco, String email) {
        this.contacto = contacto;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    @Override
    public String toString() {
        return " '"+contacto + "' " +
                ", '" + nome +
                "', '" + email+
                "', '" + endereco +"'";
    }

    public String getContacto() {
        return contacto;
    }


    public String getNome() {
        return nome;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String[][] toArray(){
        String [][]array = new String[7][2];

        array[0][0] = "contacto";
        array[1][0] = "nome";
        array[2][0] = "email";
        array[3][0] = "endereco";


        array[0][1] = this.contacto;
        array[1][1] = this.nome;
        array[2][1] = this.email;
        array[3][1] = this.endereco;

        return array;
    }
}
