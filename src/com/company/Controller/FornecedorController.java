package com.company.Controller;

import com.company.Model.Conexao;
import com.company.Model.Fornecedor;
import com.company.Model.Funcionario;

import java.sql.*;
import java.util.ArrayList;

public class FornecedorController {
    private String[][] lista;
    private Fornecedor fornecedor;
    private Conexao conexao = new Conexao();

    public FornecedorController(){

    }
    public boolean addFornecedor(String contacto, String nome, String email, String endereco){
        Fornecedor novoFrnecedor = new Fornecedor(contacto,nome,endereco,email);
        if(conexao.inserir(novoFrnecedor)){
            return true;
        }else {
            return false;
        }

    }


    public Object[] listarFornecedores(){


        ArrayList<Object> fornecedores = new ArrayList<>();
        fornecedores = conexao.consultalista(fornecedor);
        lista = new String[fornecedores.size()][7];
        for(int i = 0; i<fornecedores.size();i++) {
            if(fornecedores.get(i) instanceof Fornecedor){
                for (int j = 0; j < 4;i++) {
                    switch (j){
                        case 0:

                            lista[i][j] = String.valueOf(((Fornecedor) fornecedores.get(i)).getNome());
                            break;
                        case 1:
                            lista[i][j] = String.valueOf(((Fornecedor) fornecedores.get(i)).getContacto());
                            break;
                        case 2:
                            lista[i][j] = String.valueOf(((Fornecedor) fornecedores.get(i)).getEmail());
                            break;
                        case 3:
                            lista[i][j] = String.valueOf(((Fornecedor) fornecedores.get(i)).getEndereco());
                            break;

                    }
                }

            }



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
