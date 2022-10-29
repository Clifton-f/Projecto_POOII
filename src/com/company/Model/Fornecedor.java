package com.company.Model;

public class Fornecedor {
    private String contacto;
    private String nome;
    private String endereco;
    private String email;


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
}
