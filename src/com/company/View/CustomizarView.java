package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Collections;

public class CustomizarView {

    private Color botaoPCor = new Color(0,123,255);
    private Color botaoNCor = new Color(231,76,60);
    private Color sidemenuCor = new Color(51,51,51);
    private Color painelCor = new Color(221,221,221);
    private Font textoH1 = new Font("Montserrat",Font.BOLD,20);
    private Font textoH2 = new Font("Montserrat", Font.BOLD,20);
    private  Font textoCorpo = new Font("Montserrat",Font.PLAIN, 12);
    private Color textoCor = new Color(51,51,51);
    private Dimension tamanhoMedT = new Dimension(560,24);
    private Dimension tamanhoMin = new Dimension();
    private Dimension tamanhoMax = new Dimension();
    JTextField textFieldPadrao = new JTextField();



    public Font getTextoH2() {
        return textoH2;
    }

    public Dimension getTamanhoMedT() {
        return tamanhoMedT;
    }

    public Dimension getTamanhoMin() {
        return tamanhoMin;
    }

    public Dimension getTamanhoMax() {
        return tamanhoMax;
    }


    public CustomizarView() {

        textoH2 = textoH2.deriveFont(
                Collections.singletonMap(
                        TextAttribute.WEIGHT, TextAttribute.WEIGHT_SEMIBOLD));



        this.textFieldPadrao.setFont(textoCorpo);

        this.textFieldPadrao.setPreferredSize(this.getTamanhoMedT());
        this.textFieldPadrao.setMinimumSize(this.tamanhoMin);
        this.textFieldPadrao.setMaximumSize(this.getTamanhoMedT());

    }


    public Color getPainelCor() {
        return painelCor;
    }

    public Font getTextoCorpo() {
        return textoCorpo;
    }

    public Color getTextoCor() {
        return textoCor;
    }



    public Font getTextoH1() {
        return textoH1;
    }





    public Color getBotaoPCor() {
        return botaoPCor;
    }

    public Color getBotaoNCor() {
        return botaoNCor;
    }

    public Color getSidemenuCor() {
        return sidemenuCor;
    }

    public static void main(String[]args){
        System.out.println();
    }
    public void definirAtributosPadraoTextFields(){


    }
    public JTextField atribuirPadroesTextFields(JTextField textField){
        textField.setFont(textFieldPadrao.getFont());
        textField.setPreferredSize(textFieldPadrao.getPreferredSize());
        textField.setMinimumSize(textFieldPadrao.getMinimumSize());
        textField.setMaximumSize(textFieldPadrao.getMaximumSize());

        return textField;
    }

    public JLabel atribuirPadroesLabel(JLabel label){

        label.setForeground(textoCor);
        label.setFont(textoCorpo);

        return label;
    }
    public void actualizarPainel(JPanel pnl){

        pnl.revalidate();
        pnl.repaint();
    }
}
