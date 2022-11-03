package com.company.Model;

import java.sql.Date;

public class Funcionario {
private String apelido;
private String pNome;
private Date dataNascimento;
private String contacto;
private int idFuncionaro;
private String email;
private String password;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getpNome() {
        return pNome;
    }

    public void setpNome(String pNome) {
        this.pNome = pNome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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
                "', '" + pNome +
                "', '" + dataNascimento +
                "', '" + contacto +
                "', '" + idFuncionaro +
                "', '" + email +"'";
    }


    public Funcionario(String apelido, String pNome, Date dataNascimento, String contacto, int idFuncionaro, String email, String password) {
        this.apelido = apelido;
        this.pNome = pNome;
        this.dataNascimento = dataNascimento;
        this.contacto = contacto;
        this.idFuncionaro = idFuncionaro;
        this.email = email;
        this.password = password;
    }

    public Funcionario(String email, String password) {
        this.email = email;
        this.password = password;
    }
}



