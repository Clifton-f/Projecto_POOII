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
    public void consulta(Object tabela){

        if (tabela instanceof Venda){
            try {
                resultados = statement.executeQuery("select * FROM fornecedor" +
                        "WHERE ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public void insercao(Object tabela){
        String query;
        if (tabela instanceof Fornecedor){
            try {
                query ="INSERT INTO `fornecedor` (`contacto`, `nome`, `email`, `endereco`) VALUES ("+tabela.toString()+");";
                statement.executeUpdate(query);
                /*statement.executeUpdate("INSERT INTO fornecedor" +
                        " VALUES (" + tabela.toString() + ")");*/

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(tabela instanceof Medicamento){
            query ="INSERT INTO `medicamento`(`batchNo`, `nome_comercial`, `nome_genérico`, `validade`," +
                    " `preco_compra`, `preco_venda`, `classificacao`, `contacto`, `descricao`,`stock´) VALUES ("+tabela.toString()+");";
            try {
                statement.executeUpdate(query);

            }catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(tabela instanceof Venda) {
            query = "INSERT INTO `fornecedor` (`contacto`, `nome`, `email`, `endereco`) VALUES (" + tabela.toString() + ");";
            try {
                statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(tabela instanceof Funcionario) {
            query = "INSERT INTO `funcionario`(`apelido`, `pNome`, `data_nascimento`, `contacto`, `idFuncionario`, `email`)" +
                    " VALUES (" + tabela.toString() + ");";
            try {
                statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void main(String []args){
        Conexao conexao = new Conexao();
        Date data = new Date(2077,8,2);
        Funcionario funcionario = new Funcionario("Inculta","Vulpes",data,"856638515",001,"vulpesfumentari@legion.com");
        conexao.insercao(funcionario);
        String nome = "Da fonseca";
        String pn = "Clifton Fernandes";
        nome+=", "+pn;
        System.out.println(nome);
    }
}
