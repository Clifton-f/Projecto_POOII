package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VendaView extends JPanel implements ActionListener {
    JLabel []cabecalho= new JLabel[2];
    JLabel [] lblProduto = new JLabel[7];
    JTextField []txtMedicamento = new JTextField[7];
    ArrayList<Object> elemento = new ArrayList<Object>();
    JLabel lblCompra;
    JLabel lblDadosPh[] = new JLabel[4];
    JLabel lblOrd;
    JLabel lblPym;
    JTextField []txtOrder = new JTextField[2];
    JButton btnAdd;
    JButton btnrmv;
    JButton Submeter;
    JTextField []txtRecibo;
    JLabel []lblRecibo;
    CustomizarView atributo = new CustomizarView();
    public VendaView(){

        /**
         * Inicializacao
         * */



        lblOrd = new JLabel("Ordem Número:");
        lblPym = new JLabel("Tipo de Pagamento:");
        txtOrder[0] = new JTextField();
        txtOrder[1] = new JTextField();

        btnAdd = new JButton("Adicionar");
        btnrmv = new JButton("Remover");
        Submeter = new JButton("Subeter compra");


        lblProduto[0] = new JLabel("#");
        lblProduto[1] = new JLabel("Nome do medicamento");
        lblProduto[2] = new JLabel("Quantidade");
        lblProduto[3] = new JLabel("Preço unitario");
        lblProduto[4] = new JLabel("Tipo de disconto");
        lblProduto[5] = new JLabel("Desconto");
        lblProduto[6] = new JLabel("Preço total");





        for (int i = 0; i<7;i++){
            lblProduto[i].setFont(atributo.getTextoCorpo());
            txtMedicamento[i] = new JTextField();
            txtMedicamento[i].setPreferredSize(new Dimension(200,31));
            txtMedicamento[i].setFont(atributo.getTextoCorpo());

        }
        //cabecalho
        for(int i = 0; i<4;i++){
            lblDadosPh[i] = new JLabel();
            lblDadosPh[i].setFont(atributo.getTextoCorpo());
        }
        lblCompra = new JLabel("Informações da compra");
        lblDadosPh[0].setText("San Francisco, California, USA");
        lblDadosPh[1].setText("+6399812765251");
        lblDadosPh[2].setText("cashier@gmail.com");
        lblDadosPh[3].setText("pharmacare.com.ph ");



        JLabel txtaddMed = new JLabel("Adicionar Medicamento");
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbl);

        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.ipady = 15;

        this.setBackground(atributo.getPainelCor());
        gbc.insets=new Insets(30,5,5,5);

        gbc.gridy=0;
        gbc.gridwidth = 3;
        gbc.gridheight=1;
        gbc.weightx = 1;
        gbc.gridx=0;

        /**
         * Add cabecalho
         * */
        cabecalho[1] = new JLabel("Nova Venda");
        cabecalho[0] = new JLabel("Informaçao da Venda");

        gbc.gridy = 0;
        gbc.insets=new Insets(10,15,0,10);
        this.add(cabecalho[1],gbc);
        cabecalho[1].setFont(atributo.getTextoH2());
        gbc.gridy = 1;
        gbc.gridx = 0;
        cabecalho[0].setFont(atributo.getTextoCorpo());

        gbc.insets=new Insets(0,15,0,10);
        this.add(cabecalho[0],gbc);

        //add(lblDadosPh,gbc);
        /**
         * Dados da ordem*/

        gbc.fill=GridBagConstraints.BOTH;
         gbc.gridheight=2;
        gbc.gridwidth = 1;
        gbc.gridy = 3;
        gbc.gridx = 4;
        add(lblOrd,gbc);

        gbc.gridwidth = 2;
        gbc.gridy = 5;
        add(lblPym,gbc);


        gbc.gridx =5;
        gbc.gridy =3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtOrder[0],gbc);
        gbc.gridy = 5;
        add(txtOrder[1],gbc);
        /**Compra*/
        gbc.gridwidth = 3;
        gbc.gridheight=1;
        for(int i=0; i<4;i++){
            gbc.gridy = 3+i;
            gbc.gridx =0;
            add(lblDadosPh[i],gbc);
        }
        gbc.insets=new Insets(5,5,5,5);
        gbc.gridwidth = 1;
        for(int i=0; i<6; i++){
            gbc.gridy = 9;
            gbc.gridx = i;

            this.add(lblProduto[i],gbc);
            gbc.gridy=10;
            gbc.gridx =i;
            this.add(txtMedicamento[i],gbc);
        }
        gbc.gridy =9;
        gbc.gridx = 6;
        this.add(lblProduto[6],gbc);
        gbc.gridy = 10;
        gbc.gridx = 6;
        gbc.weightx=1;
        this.add(txtMedicamento[6],gbc);

        /**Botões*/
        gbc.weighty = 1;
        gbc.gridx = 5;
        gbc.gridy = 11;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        this.add(btnAdd,gbc);

        gbc.gridx = 6;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.NONE;
        this.add(btnrmv,gbc);



    }
    public static void main(String[]args){
        JFrame tela = new JFrame("Compra");
        tela.add(new VendaView());
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1280,720));
        tela.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getSource().toString()){
            case "Adicionar":
                break;
            case"Remover":

                break;
        }
    }
}
