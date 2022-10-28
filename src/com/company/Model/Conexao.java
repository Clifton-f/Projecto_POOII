package com.company.Model;

import java.sql.*;
import java.util.ArrayList;

public class Conexao {
    Connection connection;
    Statement statement;
    ResultSet resultados;
    ArrayList<Fornecedor> listafornecedores = new ArrayList<Fornecedor>();



    public Conexao(){
        try {
            connection = DriverManager.getConnection("JDBC:mysql://localhost:3306/farmacia","root","");

            statement = connection.createStatement();


            int i = 0;
            /*while (resultados.next()) {
                listafornecedores.add(new Fornecedor());

                listafornecedores.get(i).setContacto(resultados.getString("contacto"));
                listafornecedores.get(i).setEmail(resultados.getString("email"));
                listafornecedores.get(i).setNome(resultados.getString("nome"));
                listafornecedores.get(i).setEndereco(resultados.getString("endereco"));
                i += 1;


            }*/
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void consulta(){
        try {
            resultados = statement.executeQuery("select * from fornecedor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void fornecedorInsercao(Object tabela){
        if (tabela instanceof Fornecedor){
            try {
                resultados = statement.executeQuery("INSERT INTO `fornecedor` (`contacto`, `nome`, `email`, `endereco`) VALUES ("+tabela.toString()+")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    }

    public static void main(String []args){
        String nome = "Da fonseca";
        String pn = "Clifton Fernandes";
        nome+=", "+pn;
        System.out.println(nome);
    }
}
