package com.company.Controller;

import com.company.Model.Conexao;
import com.company.Model.Funcionario;
import com.company.Model.Medicamento;
import com.company.Model.Fornecedor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class MedicamentoController {
    Medicamento medicamento;
    Conexao conexao = new Conexao();
    String [][]lista;
    String[][]fornecedores;
    String []classificacao = {"Renina-Angiotensina", "Bloqueadores beta", "Bloqueadores dos Canais de Cálcio",
            "Diuréticos", "Estatinas", "Outros Agentes de Dislipidemias", "Antiplaquetas", "anticoagulantes tradicionais",
            "Novos Anticoagulantes Orais", "Antiginosos", "Outros Agentes Cardiovasculares",
            "Corticosteróides inalatórios e Beta-agonistas de longa duração",
            "Agonistas beta de ação curta e Anticolinérgicos",
            "Outros Agentes Respiratórios",
            "Inibidores da bomba de protões",
            "Receptor de histamina (H2) Bloqueadores",
            "Laxantes", "Diarréia e colite ulcerativa", "Náusea"};
    public MedicamentoController() {
        Arrays.sort(classificacao);
        ArrayList<Medicamento> list = conexao.consultaMedicamento(null,null);
        fornecedores = new String[list.size()][2];

        for(int i = 0; i<list.size();i++){
            fornecedores[i][1] = list.get(i).toString();
        }


    }



    public String[] getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String[] classificacao) {
        this.classificacao = classificacao;
    }


    public boolean inserir(String batchNo, String nomeComercial, String nomeGenerico, Timestamp validade,
                           int precoCompra, int precoVenda, String classe, String fornecedorCnt, int quantidade){


        medicamento = new Medicamento(batchNo,nomeComercial,nomeGenerico,validade,precoCompra,precoVenda,classe,
                fornecedorCnt,quantidade);
        boolean sucesso = conexao.inserir(medicamento);

        return sucesso;
    }

    public String[][] lista(){


        ArrayList<Medicamento> lstMedicamentos = new ArrayList<>();
        lstMedicamentos = conexao.consultaMedicamento(null,null);
        lista = new String[lstMedicamentos.size()][6];
        for(int i = 0; i<lstMedicamentos.size();i++) {
                for (int j = 0; j < 6;i++) {
                    switch (j){
                        case 0:
                            lista[i+1][j] = String.valueOf(((Medicamento) lstMedicamentos.get(i)).getBatchNo());
                            break;
                        case 1:
                            lista[i+1][j] = String.valueOf(((Medicamento) lstMedicamentos.get(i)).getNome_comercial());
                            break;
                        case 2:
                            lista[i+1][j] = String.valueOf(((Medicamento) lstMedicamentos.get(i)).getNome_generico());

                            break;
                        case 3:
                            lista[i+1][j] = String.valueOf(((Medicamento) lstMedicamentos.get(i)).getPreco_compra());
                            break;
                        case 4:
                            lista[i+1][j] = String.valueOf(((Medicamento) lstMedicamentos.get(i)).getPreco_venda());
                            break;
                        case 5:
                            lista[i+1][j] = String.valueOf(((Medicamento) lstMedicamentos.get(i)).getClass());
                            break;

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

    public boolean actualizar(String batchNo, String nomeComercial,String nomeGenerico, Timestamp validade, int precoCompra,
                              int precoVenda, String classe, String fornecedorCnt, int quantidade, String []clnActualizadas){

        medicamento = new Medicamento(batchNo,nomeComercial,nomeGenerico,validade,precoCompra,precoVenda,classe,
                fornecedorCnt,quantidade);
        boolean sucesso = false;
        ArrayList<ArrayList<String>> lstParametros = new ArrayList<>();
        //ArrayList<String> parametrosQuery



        String []novosVlrs = new String[clnActualizadas.length];
        for(int i = 0;i<medicamento.toArray().length; i++) {
            boolean actualizado = false;
            for (int j = 0; j < clnActualizadas.length; j++) {
                if (medicamento.toArray()[i][0] == clnActualizadas[j]) {
                    novosVlrs[j] = medicamento.toArray()[i][1];


                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(medicamento.toArray()[i][0]);
                    arrayList.add(medicamento.toArray()[i][1]);
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
        if(conexao.actualizar(medicamento,clnActualizadas,novosVlrs,clnParametros,vlrParametros)){
            sucesso = true;
        }else {
            sucesso = false;
        }



        return sucesso;
    }


}
