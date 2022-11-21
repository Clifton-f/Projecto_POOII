package com.company.Model;

import java.sql.*;
import java.util.ArrayList;


public class Conexao {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    ArrayList<Object> resultados;


    public Conexao() {
        try {
            connection = DriverManager.getConnection("JDBC:mysql://localhost:3306/farmacia", "root", "");

            statement = connection.createStatement();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String buildQuery(String []atributos, String []valores) {
        StringBuilder parametros;


        parametros = new StringBuilder(" WHERE " + atributos[0] + " = '" + valores[0] + "'");
        for (int i = 1; i < atributos.length; i++) {
            parametros.append("\n AND ").append(atributos[i]).append(" = '").append(valores[i]).append( "'");


        }
        return parametros.toString();
    }


    public ArrayList<Object> consultalista(Object tabela, String[] atributos, String[] valores) {

        StringBuilder parametros;
        String query = "SELECT * FROM ";
        parametros = new StringBuilder("WHERE " + atributos[0] + " = " + valores[0]);
        for (int i = 1; i < atributos.length; i++) {
            parametros.append("AND ").append(atributos[i]).append(" = ").append(valores[i]);


        }


        if (tabela instanceof Venda) {
            query += "venda " + parametros + ";";
        } else if (tabela instanceof Medicamento) {
            query += "medicamento " + parametros + ";";
        } else if (tabela instanceof Fornecedor) {
            query += "fornecedor " + parametros + ";";
        } else if (tabela instanceof Funcionario) {
            query += "funcionario " + parametros + ";";
        } else if (tabela instanceof Item) {
            query += "vendamedicamento " + parametros + ";";
        } else if (tabela instanceof Ingrediente) {
            query += "ingredientemedicamento " + parametros + ";";
        }

        try {

            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;


    }

    public ArrayList<Object> consultalista(Object tabela){
        String query = "SELECT * FROM ";
        if (tabela instanceof Venda) {
            query += "venda " + ";";
        } else if (tabela instanceof Medicamento) {
            query += "medicamento " + ";";
        } else if (tabela instanceof Fornecedor) {
            query += "fornecedor " + ";";
        } else if (tabela instanceof Funcionario) {
            query += "funcionario " + ";";
        } else if (tabela instanceof Item) {
            query += "vendamedicamento " + ";";
        } else if (tabela instanceof Ingrediente) {
            query += "ingredientemedicamento " + ";";
        }

        try {

            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;

    }

    /*public ArrayList<Funcionario> consultalista(Funcionario tabela){
        String query = "SELECT * FROM funcionario";

            try {

                resultSet = statement.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultados;

        }*/

    public Venda consultaVenda(String[] atributos, String[] valores) {
        String query = "SELECT * FROM venda ";
        Venda venda = new Venda();
        String parametros = buildQuery(atributos, valores);
        query += "\n" + parametros + ";";


        try {


            resultSet = statement.executeQuery(query);

            if (resultSet.next()==false){
                return null;
            }else {

                venda = new Venda(resultSet.getTimestamp(2),
                        resultSet.getInt(3),resultSet.getFloat(4),resultSet.getInt(5));
                venda.setIdVenda(resultSet.getInt(1));

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venda;
    }

    public Medicamento consultaMedicamento(String[] atributos, String[] valores) {
        String query = "SELECT * FROM medicamento ";
        Medicamento medicamento =null;
        String parametros = buildQuery(atributos, valores);
        query += "\n" + parametros + ";";


        try {


            resultSet = statement.executeQuery(query);
            if (resultSet.next()==false){
                return null;
            }else {

                medicamento = new Medicamento(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getTimestamp(4),
                        resultSet.getInt(5),resultSet.getInt(6),resultSet.getString(7),
                        resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10));
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicamento;
    }
    public Fornecedor consultaFornecedor(String[] atributos, String[] valores) {
        String query = "SELECT * FROM fornecedor ";
        Fornecedor fornecedor = null;
        String parametros = buildQuery(atributos, valores);
        query += "\n" + parametros + ";";


        try {

            resultSet = statement.executeQuery(query);
            if (resultSet.next()==false){
                return null;
            }else {
                fornecedor = new Fornecedor(resultSet.getString(1),resultSet.getString(2),resultSet.getString(4),
                        resultSet.getString(3));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    public Funcionario consultaFuncionario(String[] atributos, String[] valores) {
        String query = "SELECT * FROM funcionario ";
        Funcionario funcionario = null;
        String parametros = buildQuery(atributos, valores);
        query += "\n" + parametros + ";";

        try {

            resultSet = statement.executeQuery(query);
            //resultSet.next();

            if(resultSet.next() == false){
                return null;
            }else {


                funcionario = new Funcionario(resultSet.getString(3)
                        , resultSet.getString(2),
                        resultSet.getTimestamp(4),
                        resultSet.getString(6)
                        , resultSet.getString(5),
                        resultSet.getString(7));
                funcionario.setIdFuncionaro(resultSet.getInt(1));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public Ingrediente consultaIngrediente(String[] atributos, String[] valores) {
        String query = "SELECT * FROM ingrediente ";
        Ingrediente ingrediente = new Ingrediente("s", "s", 4);
        String parametros = buildQuery(atributos, valores);
        query += "\n" + parametros + ";";

        try {

            resultSet = statement.executeQuery(query);

            if(resultSet.next() == false){
                return null;
            }else {
                ingrediente = new Ingrediente(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));


            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingrediente;
    }




    /**public ArrayList<Object> consultaLike(Object tabela, String []atributos, String []valores){

        StringBuilder parametros;
        String query = "SELECT * FROM ";
        parametros = new StringBuilder("WHERE " + atributos[0] + " like " + valores[0]);
        for (int i=1;i<atributos.length;i++){
            parametros.append("AND ").append(atributos[i]).append(" = ").append(valores[i]);


        }



        if (tabela instanceof Venda){
            query += "venda "+parametros+";";
        } else if(tabela instanceof Medicamento){
            query += "medicamento "+parametros+";";
        }
        else if(tabela instanceof Fornecedor){
            query += "fornecedor "+parametros+";";
        }
        else if(tabela instanceof Funcionario) {
            query += "funcionario " + parametros + ";";
        }
        else if(tabela instanceof Item) {
            query += "vendamedicamento " + parametros + ";";
        }
        else if(tabela instanceof Ingrediente) {
            query += "ingredientemedicamento " + parametros + ";";
        }

        try {

            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;


    }*/
    /**public ArrayList<Object> consultaIn(Object tabela, String []atributos, String []valores){

        StringBuilder parametros;
        String query = "SELECT * FROM ";
        parametros = new StringBuilder("WHERE " + atributos[0] + " In " + valores[0]);
        for (int i=1;i<atributos.length;i++){
            parametros.append("AND ").append(atributos[i]).append(" = ").append(valores[i]);


        }



        if (tabela instanceof Venda){
            query += "venda "+parametros+";";
        } else if(tabela instanceof Medicamento){
            query += "medicamento "+parametros+";";
        }
        else if(tabela instanceof Fornecedor){
            query += "fornecedor "+parametros+";";
        }
        else if(tabela instanceof Funcionario) {
            query += "funcionario " + parametros + ";";
        }
        else if(tabela instanceof Item) {
            query += "vendamedicamento " + parametros + ";";
        }
        else if(tabela instanceof Ingrediente) {
            query += "ingredientemedicamento " + parametros + ";";
        }

        try {

            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;


    }*/
    public boolean inserir(Object tabela) {
        String query = "";
        if (tabela instanceof Fornecedor) {
            query = "INSERT INTO `fornecedor` (`contacto`, `nome`, `email`, `endereco`) VALUES (" + tabela + ");";

        }
        else if (tabela instanceof Medicamento) {
            query = "INSERT INTO `medicamento`(`batchNo`, `nome_comercial`, `nome_genérico`, `validade`," +
                    " `preco_compra`, `preco_venda`, `classificacao`, `contacto_fornecedor`, `descricao`,`quantidade`) VALUES (" + tabela + ");";


        }

        else if (tabela instanceof Venda) {
            query = "INSERT INTO `venda`(`idVenda`, `data`, `valor_total`, `desconto`, `valor_pago`) VALUES (" + tabela + ");";

        }

        else if (tabela instanceof Funcionario) {
            query = "INSERT INTO `funcionario`(`apelido`, `pNome`, `data_nascimento`, `contacto`, `idFuncionario`, `email`)" +
                    " VALUES (" + tabela + ");";



        }

        else if (tabela instanceof Ingrediente){
            query = "INSERT INTO `ingredientemedicamento`(`batchNo`, `nome`, `quantidade`) VALUES (" +
                    tabela+")";

        }

        else if (tabela instanceof Item){
            query = "INSERT INTO `vendamedicamento`(`batchNo`, `idVenda`, `quantidade`) VALUES ("+tabela+")";

        }

        else if(tabela instanceof Ingrediente){
            query = "INSERT INTO `ingredientemedicamento`(`batchNo`, `nome`, `quantidade`) VALUES ("+tabela+")";

        }
        try {
            statement.executeUpdate(query);

            connection.close();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }


    public boolean actualizar(Object tabela, String []clnAlteradas, String []novosVlrs,
                              String []clnIdetificacao, String []vlrIdentificacao) {
        boolean sucesso = false;
        StringBuilder query = new StringBuilder("UPDATE `");
        if (tabela instanceof Funcionario){
            query.append("funcionario");

        }else if(tabela instanceof Fornecedor){
            query.append("fornecedor");

        }else if(tabela instanceof Medicamento){
            query.append("medicamento");

        }
        else if(tabela instanceof VendaMedicamento){
            query.append("vendamedicamento");
        }
        else if(tabela instanceof Venda){
            query.append("venda");
        }
        else if(tabela instanceof Ingrediente){
            query.append("ingredientemedicamento");
        }
        query.append("` SET `"+clnAlteradas[0]+"` = "+novosVlrs[0]);
        for(int i = 1; i<clnAlteradas.length;i++){
            query.append(" , `"+clnAlteradas[i]+"` = "+ novosVlrs[i]);

        }
        query.append(buildQuery(clnIdetificacao,vlrIdentificacao));
        try{
            resultSet = statement.executeQuery(query.toString());
            connection.close();
        }catch (SQLException ee){
            ee.printStackTrace();
        }

        return sucesso;
    }


    private boolean eliminar(Object tabela,String []atributos, String []valores){
        String query = "DELETE FROM `";
        if(tabela instanceof Ingrediente){
            query+="ingredientemedicamento";

        }else if(tabela instanceof Fornecedor){
            query+="fornecedor";

        }else if(tabela instanceof Funcionario){
            query+="funcionario";

        }else if(tabela instanceof Medicamento){
            query+="medicamento";
        }else if(tabela instanceof Venda){
            query+="venda";
        }else if(tabela instanceof Item){
            query+="ingredientemedicamento";
        }

        query+= buildQuery(atributos,valores);
        try {

            resultSet = statement.executeQuery(query);

            connection.close();
        }catch (SQLException ee ){
            ee.printStackTrace();
        }

        return true;
    }


    public static void main(String []args){
        Conexao conexao = new Conexao();
        String email = "vulpesfumentari@legion.com",password = "caesarrules";
        Funcionario usuario = new Funcionario(email,password);
        String []valores = {email,password};
        String []atributos = {"email", "password"};


        usuario = conexao.consultaFuncionario(atributos,valores);
        System.out.println();
        //Funcionario funcionario = new Funcionario("Salow","Edward",Timestamp.valueOf("2226-01-01"),"875461243",);

        Venda venda = new Venda();
        Timestamp data = Timestamp.valueOf("2024-10-01 00:00:00");
        System.out.println(usuario);






    }



}
