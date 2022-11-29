package com.company.Model;

public class Dosagem {
    private String batchNo;
    private String baby;
    private String toddler;
    private String child;
    private String teen;
    private String adult;
    public Dosagem(String[] dosagem){

        if (dosagem.length==6){
            this.batchNo=dosagem[0];
            this.baby=dosagem[1];
            this.toddler=dosagem[2];
            this.child =dosagem[3];
            this.teen=dosagem[4];
            this.adult=dosagem[5];
        }

    }
    public String[][] toArray(){
        String [][]array = new String[2][6];
        array[0][0] = "batchNo";
        array[0][1] = "baby";
        array[0][2] = "toddler";
        array[0][3] = "child";
        array[0][4] = "teen";
        array[0][5] = "adult";

        array[1][0] = this.batchNo;
        array[1][1] = this.baby;
        array[1][2] = this.toddler;
        array[1][3] = this.child;
        array[1][4] = this.teen;
        array[1][5] = this.adult;

        return array;
    }

    @Override
    public String toString() {
        return
                "'" + batchNo + '\'' +
                "', '" + child  +
                "', '" + teen +
                "', '" + toddler+
                "', '" + baby  + "'";
    }
}
