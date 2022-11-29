package com.company.Controller;

import com.company.Apoio.ConversaoDS;
import com.company.Model.Conexao;
import com.company.Model.Fornecedor;

import java.util.ArrayList;

public class FornecedorController {
    private String[][] lista;
    private Fornecedor fornecedor;
    private Conexao conexao = new Conexao();
    private ConversaoDS convertorDeED = new ConversaoDS();

    public FornecedorController(){

    }
    public boolean inserirFornecedor(String contacto, String nome, String email, String endereco){
        Fornecedor novoFrnecedor = new Fornecedor(contacto,nome,endereco,email);
        if(conexao.inserir(novoFrnecedor)){
            return true;
        }else {
            return false;
        }

    }

    public String[][]listarFornecedores(){


        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        fornecedores = conexao.consultarFornecedor();
        lista = new String[fornecedores.size()][7];
        lista[0] = (String[]) fornecedores.toArray()[0];
        for(int i = 0; i<fornecedores.size();i++) {
            String [][]array = fornecedores.get(i).toArray();
            lista[i+1] = array[1];



        }


        return lista;

    }





    public String[] pegarElemento(String id, int iterador) {
        if(lista[iterador][0] ==id){
            return lista[iterador];
        }
        else {
            return pegarElemento(id,iterador+1);
        }
    }

    public boolean actualizar( String contacto, String nome, String email, String endereco, String []clnActualizadas){
        boolean sucesso = false;
        ArrayList<ArrayList<String>> lstParametros = new ArrayList<>();
        //ArrayList<String> parametrosQuery

        fornecedor = new Fornecedor(contacto,nome,endereco,email);
        String []novosVlrs = new String[clnActualizadas.length];
        for(int i = 0;i<fornecedor.toArray().length; i++) {
            boolean actualizado = false;
            for (int j = 0; j < clnActualizadas.length; j++) {
                if (fornecedor.toArray()[i][0] == clnActualizadas[j]) {
                    novosVlrs[j] = fornecedor.toArray()[i][1];


                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(fornecedor.toArray()[i][0]);
                    arrayList.add(fornecedor.toArray()[i][1]);
                    lstParametros.add(arrayList);


                }

            }
        }
        String []clnParametros = new String[lstParametros.size()];
        String []vlrParametros = new String[lstParametros.size()];



        for(int i = 0; i<lstParametros.size();i++){
            clnParametros[i] = lstParametros.get(i).get(0);
            vlrParametros[i] = lstParametros.get(i).get(1);
        }
        if(conexao.actualizar(fornecedor,clnActualizadas,novosVlrs,clnParametros,vlrParametros)){
            sucesso = true;
        }else {
            sucesso = false;
        }



        return sucesso;
    }



    public static void main(String[] args){


    }
}
