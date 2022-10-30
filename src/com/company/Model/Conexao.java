package com.company.Model;

import java.sql.*;


public class Conexao {
    Connection connection;
    Statement statement;
    ResultSet resultados;




    public Conexao(){
        try {
            connection = DriverManager.getConnection("JDBC:mysql://localhost:3306/farmacia","root","");

            statement = connection.createStatement();




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
                query ="INSERT INTO `fornecedor` (`contacto`, `nome`, `email`, `endereco`) VALUES ("+tabela+");";
                statement.executeUpdate(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(tabela instanceof Medicamento){
            query ="INSERT INTO `medicamento`(`batchNo`, `nome_comercial`, `nome_genérico`, `validade`," +
                    " `preco_compra`, `preco_venda`, `classificacao`, `contacto`, `descricao`,`stock´) VALUES ("+tabela+");";
            try {
                statement.executeUpdate(query);

                for(int i = 0; i<((Medicamento) tabela).getIngredientes().size();i++){

                    query = "INSERT INTO `ingredientemedicamento`(`batchNo`, `nome`, `quantidade`) VALUES ('"+((Medicamento) tabela).getBatchNo()+"',"+((Medicamento) tabela).getIngredientes().get(i)+")";
                    statement.executeUpdate(query);

                }


            }catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(tabela instanceof Venda) {
            query = "INSERT INTO `venda`(`idVenda`, `data`, `valor_total`, `desconto`, `valor_pago`) VALUES (" + tabela + ");";
            try {
                statement.executeUpdate(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(tabela instanceof Funcionario) {
            query = "INSERT INTO `funcionario`(`apelido`, `pNome`, `data_nascimento`, `contacto`, `idFuncionario`, `email`)" +
                    " VALUES (" + tabela + ");";
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
        Funcionario funcionario = new Funcionario("Inculta","Vulpes",data,"856638515",1,"vulpesfumentari@legion.com");
        conexao.insercao(funcionario);
        System.out.println(funcionario);
        String nome = "Da fonseca";
        String pn = "Clifton Fernandes";
        nome+=", "+pn;
        System.out.println(nome);
    }
}
