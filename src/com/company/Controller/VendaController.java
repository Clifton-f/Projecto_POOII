package com.company.Controller;

import com.company.Model.Conexao;
import com.company.Model.Fornecedor;
import com.company.Model.Item;
import com.company.Model.Venda;

import java.sql.Timestamp;
import java.util.ArrayList;

public class VendaController {
    Conexao conexao = new Conexao();
    Venda venda;
    String [][]lista;

    public boolean addVenda(Timestamp data, int valorTotal, float desconto, int valorPago){
        Venda venda = new Venda(data, valorTotal,desconto,valorPago);
        if(conexao.inserir(venda)){
            return true;
        }else {
            return false;
        }

    }

    public boolean addItem(String batchNo, String idVenda, int quantidade){
        Item item = new Item(batchNo,idVenda,quantidade);


        return true;
    }

    public Object[] listarFornecedores(){


        ArrayList<Venda> vendas = new ArrayList<>();
        vendas = conexao.consultaVenda(null,null);
        lista = new String[vendas.size()][7];
        for(int i = 0; i<vendas.size();i++) {
            for (int j = 0; j < 4;i++) {

                switch (j){

                    case 0:
                        lista[i][j] = String.valueOf(vendas.get(i).getIdVenda());
                        break;
                    case 1:
                        lista[i][j] = String.valueOf(vendas.get(i).getValor_total());
                        break;
                    case 2:
                        lista[i][j] = String.valueOf(vendas.get(i).getDesconto());
                        break;
                    case 3:
                        lista[i][j] = String.valueOf(vendas.get(i).getValor_pago());
                        break;
                    case 4:
                        lista[i][j] = String.valueOf(vendas.get(i).getData());
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

    public boolean actualizar(Timestamp data, int valorTotal, float desconto, int valorPago, String []clnActualizadas){
        boolean sucesso = false;
        ArrayList<ArrayList<String>> lstParametros = new ArrayList<>();
        //ArrayList<String> parametrosQuery

        venda = new Venda(data,valorTotal,desconto,valorPago);
        String []novosVlrs = new String[clnActualizadas.length];
        for(int i = 0;i<venda.toArray().length; i++) {
            boolean actualizado = false;
            for (int j = 0; j < clnActualizadas.length; j++) {
                if (venda.toArray()[i][0] == clnActualizadas[j]) {
                    novosVlrs[j] = venda.toArray()[i][1];


                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(venda.toArray()[i][0]);
                    arrayList.add(venda.toArray()[i][1]);
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
        if(conexao.actualizar(venda,clnActualizadas,novosVlrs,clnParametros,vlrParametros)){
            sucesso = true;
        }else {
            sucesso = false;
        }



        return sucesso;
    }




}
