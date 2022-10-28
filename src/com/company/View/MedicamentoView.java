package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicamentoView extends JPanel implements ActionListener {

    JLabel []cabecalho= new JLabel[2];
    JLabel []lblMedicamento = new JLabel[9];
    JTextField []txtMedicamento = new JTextField[9];
    JButton btnAdicionar = new JButton("Adicionar");
    JButton btnCancelar = new JButton("Cancelar");
    JSeparator separator = new JSeparator();
    CustomizarView atributo = new CustomizarView();
    GridLayout gl;

    public MedicamentoView(){
        this.setBackground(atributo.getPainelCor());


        cabecalho[0] = new JLabel("Adicionar Medicamento");
        cabecalho[0].setFont(atributo.getTextoH1());
        cabecalho[0].setForeground(atributo.getTextoCor());

        cabecalho[1] = new JLabel("Informação do Medicamento");
        separator.setOrientation(JSeparator.HORIZONTAL);

        lblMedicamento[0] = new JLabel("BatchNo");
        lblMedicamento[1] = new JLabel("Nome do medicamento");
        lblMedicamento[2] = new JLabel("Nome genérico");
        lblMedicamento[3] = new JLabel("Fornecedor");
        lblMedicamento[4] = new JLabel("Validade");
        lblMedicamento[5] = new JLabel("Quantidade");
        lblMedicamento[6] = new JLabel("Preço");
        lblMedicamento[7] = new JLabel("Classificação");
        lblMedicamento[8] = new JLabel("Categoria");

        btnAdicionar.setForeground(atributo.getPainelCor());
        btnCancelar.setForeground(atributo.getPainelCor());


        btnAdicionar.setBackground(atributo.getBotaoPCor());
        btnCancelar.setBackground(atributo.getBotaoNCor());



        for (int i = 0; i<9;i++){
            txtMedicamento[i] = new JTextField();
            txtMedicamento[i].setFont(atributo.getTextoCorpo());

            txtMedicamento[i].setForeground(atributo.getTextoCor());
            lblMedicamento[i].setFont(atributo.getTextoCorpo());
            lblMedicamento[i].setForeground(atributo.getTextoCor());

        }

        JLabel txtaddMed = new JLabel("Adicionar Medicamento");
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.ipady = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;

        this.setLayout(gbl);
        /**
         * Add cabecalho
         * */
        gbc.gridy = 0;
        this.add(cabecalho[0],gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        cabecalho[1].setFont(atributo.getTextoH2());
        gbc.insets=new Insets(10,15,30,15);
        this.add(cabecalho[1],gbc);



        /**
         * Add Formulario
         * */

        gbc.insets=new Insets(10,30,0,10);
        for(int i=0; i<4; i++){

            gbc.ipady = 5;
            gbc.gridy = 3+2*i;

            this.add(lblMedicamento[i],gbc);
            gbc.gridy =2*i+4;
            gbc.ipady = 10;
            this.add(txtMedicamento[i],gbc);

            gbc.gridx = 1;
            gbc.ipady = 5;
            gbc.gridy = 3+2*i;

            this.add(lblMedicamento[i+4],gbc);
            gbc.gridy =2*i+4;
            gbc.ipady = 10;
            this.add(txtMedicamento[i+4],gbc);
            gbc.gridx=0;
        }
        gbc.gridy = 11;
        this.add(lblMedicamento[8],gbc);
        gbc.gridy = 12;

        this.add(txtMedicamento[8],gbc);

        /**
         * Add Botões*/
        JPanel pnlBotoes = new JPanel();
        gl = new GridLayout(1,2);
        gl.setHgap(15);
        pnlBotoes.setLayout(gl);
        pnlBotoes.add(btnAdicionar);
        pnlBotoes.add(btnCancelar);
        gbc.weighty=1;
        gbc.weightx=1;
        gbc.gridy=13;
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        //gbc.insets = new Insets(50,10,0,1050);
        pnlBotoes.setBackground(atributo.getPainelCor());
        this.add(pnlBotoes,gbc);





        //this.add(txtMedicamento[3],gbc);



    }
    public static void main(String[]args){
        JFrame tela = new JFrame();
        tela.add(new MedicamentoView());
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1280,720));
        tela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getSource().toString()){
            case"Adicionar":
                break;
            case "Cancelar":
                break;
        }

    }
}
