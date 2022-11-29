package com.company.Controller;

import com.company.Apoio.ConversaoDS;
import com.company.Model.Conexao;
import com.company.Model.Ingrediente;

import java.util.ArrayList;

public class IngredienteMedicamentoController {
    private Ingrediente ingrediente;
    private Conexao conexao = new Conexao();
    boolean sucesso;
    private ConversaoDS conversor;

    public void criarIngrediente(String batchNo, String nome, int quatidade){

        ingrediente = new Ingrediente(batchNo,nome,quatidade);

    }

    public boolean inserirIngrediente(String []ingrediente){
        criarIngrediente(ingrediente[0],ingrediente[1],Integer.parseInt(ingrediente[2]));
        sucesso = conexao.inserir(ingrediente);
        return sucesso;
    }
    public boolean actualizar(String []clnActualizadas,String []novosValores, String [][]valoresVenda){
        ArrayList<String> valoresIdentificacao = new ArrayList<>();
        ArrayList<String> colunasIdentificaco = new ArrayList<>();
        for(int i = 0; i<clnActualizadas.length;i++) {
            if (clnActualizadas[i] == valoresVenda[i][0]) {
                colunasIdentificaco.add(valoresVenda[i][0]);
                valoresIdentificacao.add(valoresVenda[i][1]);
            }

        }
        String []clnIdentificacao;
        String []vlrIdentificacao;

        clnIdentificacao = conversor.converterArrayListToArray(colunasIdentificaco);
        vlrIdentificacao = conversor.converterArrayListToArray(valoresIdentificacao);
        sucesso = conexao.actualizar(ingrediente,clnActualizadas,novosValores,clnIdentificacao,vlrIdentificacao);
        return sucesso;
    }



}

