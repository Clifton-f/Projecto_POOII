package com.company.Controller;

import java.util.ArrayList;
import java.util.Arrays;

public class MedicamentoController {

    public MedicamentoController() {
        Arrays.sort(classificacao);
    }

    String []classificacao = {"Renina-Angiotensina", "Bloqueadores beta", "Bloqueadores dos Canais de Cálcio",
            "Diuréticos", "Estatinas", "Outros Agentes de Dislipidemias", "Antiplaquetas", "anticoagulantes tradicionais",
            "Novos Anticoagulantes Orais", "Antiginosos", "Outros Agentes Cardiovasculares",
            "Corticosteróides inalatórios e Beta-agonistas de longa duração",
            "Agonistas beta de ação curta e Anticolinérgicos",
            "Outros Agentes Respiratórios",
            "Inibidores da bomba de protões",
            "Receptor de histamina (H2) Bloqueadores",
            "Laxantes", "Diarréia e colite ulcerativa", "Náusea"};

    public String[] getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String[] classificacao) {
        this.classificacao = classificacao;
    }

    public void inserir(){

    }


}
