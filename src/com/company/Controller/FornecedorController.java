package com.company.Controller;

import com.company.Model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;

public class FornecedorController {
    private ArrayList<Fornecedor> listafornecedores = new ArrayList<Fornecedor>();
    Connection connection;
    Statement statement;
    ResultSet resultados;

    public FornecedorController(){
        try {
            connection = DriverManager.getConnection("JDBC:mysql://localhost:3306/farmacia","root","");

            statement = connection.createStatement();

            resultados = statement.executeQuery("select * from fornecedor");
            int i = 0;
            /*while (resultados.next()){
                listafornecedores.add(new Fornecedor());

                listafornecedores.get(i).setContacto(resultados.getString("contacto"));
                listafornecedores.get(i).setEmail(resultados.getString("email"));
                listafornecedores.get(i).setNome(resultados.getString("nome"));
                listafornecedores.get(i).setEndereco(resultados.getString("endereco"));
                i+=1;


            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void introduzir(String contacto, String nome, String email,String endereco){


        try {
            resultados = statement.executeQuery("INSERT INTO `fornecedor` (`contacto`, `nome`, `email`, `endereco`) VALUES ('', '', 'info@robco.com', 'New Vegas ');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        FornecedorController fonecedores = new FornecedorController();
        for(int i = 0; i<fonecedores.listafornecedores.size();i++){
            System.out.println(fonecedores.listafornecedores.get(i).toString());
        }

    }
}
