package com.company.Model;

import java.sql.*;
import java.util.ArrayList;


public class Conexao {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    String query;


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



    /*public ArrayList<Funcionario> consultalista(Funcionario tabela){
        String query = "SELECT * FROM funcionario";

            try {

                resultSet = statement.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultados;

        }*/

    public ArrayList<Venda> consultarVenda(String[] atributos, String[] valores) {

        String query = "SELECT * FROM venda ";
        if (atributos != null){
            String parametros = buildQuery(atributos, valores);
            query += "\n" + parametros + ";";
        }
        ArrayList<Venda> lstvenda = new ArrayList<>();



        try {


            resultSet = statement.executeQuery(query);

            while (resultSet.next()!=false){
                Venda venda;
                venda = new Venda(resultSet.getTimestamp(2),
                        resultSet.getInt(3),resultSet.getFloat(4),resultSet.getInt(5));
                venda.setIdVenda(resultSet.getInt(1));
                lstvenda.add(venda);

            }
            return lstvenda;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Medicamento> consultarMedicamento(String[] atributos, String[] valores) {
        String query = "SELECT * FROM medicamento ";

        if (atributos != null){
            String parametros = buildQuery(atributos, valores);
            query += "\n" + parametros + ";";
        }
        ArrayList<Medicamento>lstMedicamento = new ArrayList<>();

        try {

            resultSet = statement.executeQuery(query);
            while (resultSet.next()!=false){
                Medicamento medicamento = new Medicamento(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getTimestamp(4),resultSet.getInt(5),
                        resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(10));

                lstMedicamento.add(medicamento);

            }



            return lstMedicamento;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Fornecedor> consultarFornecedor(String[] atributos, String[] valores) {
        String query = "SELECT * FROM fornecedor ";
        Fornecedor fornecedor = null;
        String parametros = buildQuery(atributos, valores);
        query += parametros + ";";
        ArrayList<Fornecedor> lstMedicamento = new ArrayList<>();



        try {

            resultSet = statement.executeQuery(query);
            while (resultSet.next()!=false){

                fornecedor = new Fornecedor(resultSet.getString(1),resultSet.getString(2),resultSet.getString(4),
                        resultSet.getString(3));
                lstMedicamento.add(fornecedor);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstMedicamento;
    }

    public ArrayList<Fornecedor> consultarFornecedor() {
        String query = "SELECT * FROM fornecedor ";
        Fornecedor fornecedor = null;

        ArrayList<Fornecedor> lstMedicamento = new ArrayList<>();

        try {

            resultSet = statement.executeQuery(query);
            while (resultSet.next()!=false){

                fornecedor = new Fornecedor(resultSet.getString(1),resultSet.getString(2),resultSet.getString(4),
                        resultSet.getString(3));
                lstMedicamento.add(fornecedor);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstMedicamento;
    }

    public ArrayList<Funcionario> consultarFuncionario(String[] atributos, String[] valores) {
        String query = "SELECT * FROM funcionario ";

        if (atributos!= null){
            String parametros = buildQuery(atributos, valores);
            query += "\n" + parametros + ";";
        }
        ArrayList<Funcionario> lstFuncionario = new ArrayList<>();

        try {

            resultSet = statement.executeQuery(query);
            //resultSet.next();


            while (resultSet.next() != false){


                Funcionario funcionario = new Funcionario(resultSet.getString(3)
                        , resultSet.getString(2),
                        resultSet.getTimestamp(4),
                        resultSet.getString(6)
                        , resultSet.getString(5),
                        resultSet.getString(7));
                funcionario.setIdFuncionaro(resultSet.getInt(1));
                lstFuncionario.add(funcionario);

            }

            return lstFuncionario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Ingrediente> consultarIngrediente(String[] atributos, String[] valores) {
        query = "SELECT * FROM ingrediente ";
        ArrayList <Ingrediente> lstIngredientes = new ArrayList<>();
        if(atributos != null){
            String parametros = buildQuery(atributos, valores);
            query += "\n" + parametros + ";";

        }


        try {

            resultSet = statement.executeQuery(query);

            while (resultSet.next() != false){

                Ingrediente ingrediente = new Ingrediente(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                lstIngredientes.add(ingrediente);

            }
            return lstIngredientes;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<String> consultarClassificacao(){
        query = "SELECT * FROM classificacao";
        try {
            ArrayList<String> classificacoes = new ArrayList<>();
            resultSet = statement.executeQuery(query);
            while (resultSet.next() != false){
                classificacoes.add(resultSet.getString(1));
            }
            return classificacoes;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
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

    public boolean inserirDosagem(Dosagem dosagem){
        String query = "";
        query = "INSERT INTO `dosagem`(`batchNo`,`baby`, `child`, `toddler`, `teen`, `adult`) VALUES (" +
                dosagem+")";

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


        usuario = conexao.consultarFuncionario(atributos,valores).get(0);
        System.out.println();
        //Funcionario funcionario = new Funcionario("Salow","Edward",Timestamp.valueOf("2226-01-01"),"875461243",);


        Timestamp data = Timestamp.valueOf("2024-10-01 00:00:00");
        System.out.println(usuario);






    }



}
