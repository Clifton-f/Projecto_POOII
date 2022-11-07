package com.company.View;

import com.company.Controller.MedicamentoController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class MedicamentoView extends JPanel implements ActionListener {

    JLabel []cabecalho= new JLabel[2];
    JLabel []lblMedicamento = new JLabel[10];
    JTextField []txtMedicamento = new JTextField[8];
    JTextField []txtDosagem = new JTextField[6];
    JLabel []lblDosagem = new JLabel[6];
    JSpinner spnData;
    JComboBox<String> cmbClassificacao;
    JButton btnNext = new JButton("Póximo");
    JButton btnPrevious = new JButton("Anterior");
    JButton btnSave = new JButton("Gravar");
    JSeparator separator = new JSeparator();
    CustomizarView atributo = new CustomizarView();
    GridLayout gl;
    MedicamentoController mc = new MedicamentoController();
    private CardLayout cl = new CardLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private JPanel pnlPrimario = new JPanel();
    private JPanel pnlSecundario = new JPanel();


    MedicamentoController controller = new MedicamentoController();
    public MedicamentoView(){

        pnlPrimario.setBackground(atributo.getPainelCor());


        cabecalho[0] = new JLabel("Adicionar Medicamento");
        cabecalho[0].setFont(atributo.getTextoH1());
        cabecalho[0].setForeground(atributo.getTextoCor());
        cabecalho[1] = new JLabel("Informação do Medicamento");
        separator.setOrientation(JSeparator.HORIZONTAL);

        lblMedicamento[0] = new JLabel("BatchNo");
        lblMedicamento[1] = new JLabel("Nome comercial");
        lblMedicamento[2] = new JLabel("Nome genérico");
        lblMedicamento[3] = new JLabel("Fornecedor");
        lblMedicamento[4] = new JLabel("Validade");
        lblMedicamento[5] = new JLabel("Quantidade");
        lblMedicamento[6] = new JLabel("Preço de venda");
        lblMedicamento[7] = new JLabel("preço de compra");
        lblMedicamento[8] = new JLabel("Classificação");
        lblMedicamento[9] = new JLabel("Descrição");

        String []classe = controller.getClassificacao();
        cmbClassificacao = new JComboBox<>(classe);

        //Dosagem

        lblDosagem[0] = new JLabel("Dosagem para bebês (0-2)");
        lblDosagem[1] = new JLabel("Dosagem para bebês (2-5)");
        lblDosagem[2] = new JLabel("Dosagem para crianças (6-12)");
        lblDosagem[3] = new JLabel("Dosagem para adolescentes (12-18)");
        lblDosagem[4] = new JLabel("Dosagem para adultos (18- )");
        lblDosagem[5] = new JLabel("Número de vezes por dia");

        JTextArea txaDescricao = new JTextArea(3,100);
        txaDescricao.setPreferredSize(atributo.getTamanhoMax());
        txaDescricao.setFont(atributo.getTextoCorpo());

        btnNext.setForeground(atributo.getPainelCor());
        btnNext.setBackground(atributo.getBotaoPCor());
        btnNext.addActionListener(this);
        btnPrevious.setForeground(atributo.getPainelCor());
        btnPrevious.setBackground(atributo.getBotaoNCor());
        btnPrevious.addActionListener(this);

        Date hj = new Date();
        spnData = new JSpinner(new SpinnerDateModel(hj,null,null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editor);
        spnData.setFont(atributo.getTextoCorpo());

        for (int i = 0; i<8;i++){
            txtMedicamento[i] = new JTextField();
            txtMedicamento[i].setFont(atributo.getTextoCorpo());

            txtMedicamento[i].setForeground(atributo.getTextoCor());

            lblMedicamento[i].setFont(atributo.getTextoCorpo());
            lblMedicamento[i].setForeground(atributo.getTextoCor());

        }
        for(int i = 0; i<txtDosagem.length;i++){
            txtDosagem[i] = new JTextField();
            txtDosagem[i].setForeground(atributo.getTextoCor());
            txtDosagem[i].setFont(atributo.getTextoCorpo());


        }
        setPnlPrimario();
        setPnlSecundario();
        this.setLayout(cl);
        this.add("1",pnlPrimario);
        this.add("2",pnlSecundario);

    }

    private void setPnlPrimario(){
        GridBagLayout gbl = new GridBagLayout();

        pnlPrimario.setLayout(gbl);


        gbc.weightx=1;
        gbc.weighty=0;
        gbc.ipady = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;

        JLabel lblTitulo = new JLabel("Adicionar Medicamento");
        JLabel lblSubtitulo = new JLabel("Informação do Medicamento");


        lblTitulo.setFont(atributo.getTextoH1());
        lblTitulo.setForeground(atributo.getTextoCor());
        gbc.gridy = 1;
        pnlPrimario.add(lblTitulo,gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        //cabecalho[1].setFont(atributo.getTextoH2());
        gbc.insets=new Insets(10,15,30,15);


        pnlPrimario.add(lblSubtitulo,gbc);

        /**
         * Add Formulario
         * */

        gbc.insets=new Insets(10,30,0,10);
        gbc.gridx=0;
        gbc.gridwidth = 4;
        gbc.ipady = 5;
        gbc.gridy = 3;
        pnlPrimario.add(lblMedicamento[0],gbc);


        gbc.gridy =4;
        gbc.ipady = 10;
        pnlPrimario.add(txtMedicamento[0],gbc);


        gbc.gridwidth = 1;
        gbc.gridx = 4;
        gbc.ipady = 5;
        gbc.gridy = 3;

        pnlPrimario.add(lblMedicamento[4],gbc);
        gbc.gridy =4;
        gbc.ipady = 10;
        pnlPrimario.add(spnData,gbc);


        for(int i=1; i<4; i++){

            gbc.gridx=0;
            gbc.gridwidth = 4;
            gbc.ipady = 5;
            gbc.gridy = 3+2*i;

            pnlPrimario.add(lblMedicamento[i],gbc);
            gbc.gridy =2*i+4;
            gbc.ipady = 10;
            pnlPrimario.add(txtMedicamento[i],gbc);


            gbc.gridwidth = 1;
            gbc.gridx = 4;
            gbc.ipady = 5;
            gbc.gridy = 3+2*i;

            pnlPrimario.add(lblMedicamento[i+4],gbc);
            gbc.gridy =2*i+4;
            gbc.ipady = 10;
            pnlPrimario.add(txtMedicamento[i+3],gbc);




        }
        gbc.gridx = 4;
        gbc.gridy = 11;
        lblMedicamento[9].setFont(atributo.getTextoCorpo());
        lblMedicamento[9].setForeground(atributo.getTextoCor());
        pnlPrimario.add(lblMedicamento[9],gbc);
        gbc.gridy = 12;
        gbc.gridheight = 1;
        pnlPrimario.add(txtMedicamento[7],gbc);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 11;
        pnlPrimario.add(lblMedicamento[8], gbc);
        lblMedicamento[8].setFont(atributo.getTextoCorpo());
        lblMedicamento[8].setForeground(atributo.getTextoCor());
        gbc.gridy = 12;


        pnlPrimario.add(cmbClassificacao,gbc);
        /**
         * Add Botões*/


        gbc.weighty=1;
        gbc.weightx=1;
        gbc.gridy=15;
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        pnlPrimario.add(btnNext,gbc);


    }

    private void setPnlSecundario(){
        GridBagLayout gbl = new GridBagLayout();
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.ipady = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;

        pnlSecundario.setLayout(gbl);


        gbc.weightx=1;
        gbc.weighty=0;
        gbc.ipady = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;

        gbc.gridy = 0;
        pnlSecundario.add(cabecalho[0],gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        cabecalho[1].setFont(atributo.getTextoH2());
        gbc.insets=new Insets(10,15,30,15);
        pnlSecundario.add(cabecalho[1],gbc);
        gbc.gridwidth = 4;

        gbc.gridx=0;
        gbc.insets=new Insets(10,30,0,10);

        for(int i=1; i<5; i++){


            gbc.gridy = 3+2*i;
            gbc.ipady = 5;

            pnlSecundario.add(lblDosagem[i],gbc);
            gbc.gridy =2*i+4;
            gbc.ipady = 10;
            pnlSecundario.add(txtDosagem[i],gbc);



        }
        gbc.gridy = 13;
        gbc.ipady = 5;
        pnlSecundario.add(lblDosagem[5],gbc);
        gbc.ipady = 10;
        gbc.gridy = 14;
        pnlSecundario.add(txtDosagem[5],gbc);
        gbc.weighty=1;
        gbc.weightx=1;
        gbc.gridy=15;
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;

        pnlSecundario.add(btnPrevious,gbc);






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
        if(e.getSource() == btnNext){
                cl.next(this);

        }
        else if(e.getSource()==btnPrevious){
            cl.previous(this);
        }

    }
}
