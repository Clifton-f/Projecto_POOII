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
        String [][]array = new String[2][7];
        array[0][0] = "id";
        array[0][1] = "nome";
        array[0][2] = "apelido";
        array[0][3] = "data de nascimento";
        array[0][4] = "email";
        array[0][5] = "contacto";
        array[0][6] = "password";

        array[1][0] = String.valueOf(this.idFuncionaro);
        array[1][1] = this.nome;
        array[1][2] = this.apelido;
        array[1][3] = String.valueOf(this.dataNascimento);
        array[1][4] = this.email;
        array[1][5] = this.contacto;
        array[1][6] = this.password;

        return array;
    }

    public Funcionario(String email, String password) {
        this.email = email;
        this.password = password;
    }
}



