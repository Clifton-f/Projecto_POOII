package com.company.Apoio;

import java.util.ArrayList;

public class ConversaoDS {
    private ArrayList<String> arrayList = new ArrayList<>();
    private String []array;

    public String[] converterArrayListToArray(ArrayList arrayList){
        array = new String[arrayList.size()];
        for(int i = 0; i<arrayList.size();i++){
            array[i] = arrayList.get(i).toString();
        }

        return array;
    }
    public String[][]converterArray2dListToArray(ArrayList<String[]> arrayList){


        return null;
    }
}
