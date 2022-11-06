package com.company.Controller;

import com.company.Model.Conexao;
import com.company.Model.Funcionario;

public class FuncionarioController {
    Funcionario usuario;
    Conexao conexao = new Conexao();


    public boolean login(String email, String password){
        String []valores = {email,password};
        String []atributos = {"email", "password"};
        if(true){
            return true;
        }
        else {
            return false;
        }

    //return true;
    }
    public static void main(String []args){
        FuncionarioController fc = new FuncionarioController();
        fc.login("vulpesfumentari@legion.com","caesarrules");



    }
}
