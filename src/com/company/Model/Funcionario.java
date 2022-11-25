package com.company.Model;

import java.sql.Array;
import java.sql.Timestamp;

public class Funcionario {
private String apelido;
private String nome;
private Timestamp dataNascimento;
private String contacto;
private int idFuncionaro;
private String email;
private String password;
private String tabela = "funcionario";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getIdFuncionaro() {
        return idFuncionaro;
    }

    public void setIdFuncionaro(int idFuncionaro) {
        this.idFuncionaro = idFuncionaro;
    }

    @Override
    public String toString() {
        return  "'" + apelido +
                "', '" + nome +
                "', '" + dataNascimento +
                "', '" + contacto +
                "', '" + idFuncionaro +
                "', '" + email +"'";
    }


    public Funcionario(String apelido, String nome, Timestamp dataNascimento, String contacto, String email, String password) {
        this.apelido = apelido;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.contacto = contacto;
        this.email = email;
        this.password = password;
    }
    public String[][] toArray(){
        String [][]array = new String[7][2];
        array[0][0] = "id";
        array[1][0] = "nome";
        array[2][0] = "apelido";
        array[3][0] = "data de nascimento";
        array[4][0] = "email";
        array[5][0] = "contacto";
        array[6][0] = "password";

        array[0][1] = String.valueOf(this.idFuncionaro);
        array[1][1] = this.nome;
        array[2][1] = this.apelido;
        array[3][1] = String.valueOf(this.dataNascimento);
        array[4][1] = this.email;
        array[5][1] = this.contacto;
        array[6][1] = this.password;

        return array;
    }

    public Funcionario(String email, String password) {
        this.email = email;
        this.password = password;
    }
}



