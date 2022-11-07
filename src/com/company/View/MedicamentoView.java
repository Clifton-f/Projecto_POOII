package com.company.View;

import com.company.Controller.MedicamentoController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MedicamentoView extends JPanel implements ActionListener, TextListener {

    JLabel []cabecalho= new JLabel[2];
    JLabel []lblMedicamento = new JLabel[10];
    JLabel []lblIng = new JLabel[2];
    JTextField []txtIng = new JTextField[2];
    ArrayList<JLabel[]> listalblIng = new ArrayList<>();
    ArrayList<JTextField[]> listatxtIng = new ArrayList<>();
    JTextField []txtMedicamento = new JTextField[8];
    JTextField []txtDosagem = new JTextField[6];
    JLabel []lblDosagem = new JLabel[6];
    JSpinner spnData;
    JComboBox<String> cmbClassificacao;
    JButton btnNext = new JButton("Póximo");
    JButton btnPrevious = new JButton("Anterior");
    JButton btnAddIngrediente = new JButton("Add");
    JButton btnSave = new JButton("Gravar");
    JSeparator separator = new JSeparator();
    CustomizarView atributo = new CustomizarView();
    GridLayout gl;
    MedicamentoController mc = new MedicamentoController();

    //Variaveis de auxílio
    private int numIngrediente = 3;
    private CardLayout cl = new CardLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private final JPanel pnlPrimario = new JPanel();
    private final JPanel pnlSecundario = new JPanel();


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


        for (int i = 0; i<8;i++){
            txtMedicamento[i] = new JTextField();
            txtMedicamento[i].setFont(atributo.getTextoCorpo());
            txtMedicamento[i].setText(String.valueOf(i));

            txtMedicamento[i].setForeground(atributo.getTextoCor());

            lblMedicamento[i].setFont(atributo.getTextoCorpo());
            lblMedicamento[i].setForeground(atributo.getTextoCor());

        }

        String []classe = controller.getClassificacao();
        cmbClassificacao = new JComboBox<>(classe);

        //Dosagem

        lblDosagem[0] = new JLabel("Dosagem para bebês (0-2)");
        lblDosagem[1] = new JLabel("Dosagem para bebês (2-5)");
        lblDosagem[2] = new JLabel("Dosagem para crianças (6-12)");
        lblDosagem[3] = new JLabel("Dosagem para adolescentes (12-18)");
        lblDosagem[4] = new JLabel("Dosagem para adultos (18- )");
        lblDosagem[5] = new JLabel("Número de vezes por dia");


        for(int i = 0; i<txtDosagem.length;i++){
            txtDosagem[i] = new JTextField();
            txtDosagem[i].setForeground(atributo.getTextoCor());
            txtDosagem[i].setFont(atributo.getTextoCorpo());


        }

        JTextArea txaDescricao = new JTextArea(3,100);
        txaDescricao.setPreferredSize(atributo.getTamanhoMax());
        txaDescricao.setFont(atributo.getTextoCorpo());

        //Ingredientes
        lblIng[0] = new JLabel("Nome do Ingrediente");
        txtIng[0] = new JTextField();
        lblIng[1] = new JLabel("quantidade");
        txtIng[1] = new JTextField();
        listalblIng.add(lblIng);
        listatxtIng.add(txtMedicamento);


        //botões
        btnNext.setForeground(atributo.getPainelCor());
        btnNext.setBackground(atributo.getBotaoPCor());
        btnNext.addActionListener(this);
        btnPrevious.setForeground(atributo.getPainelCor());
        btnPrevious.setBackground(atributo.getBotaoNCor());
        btnPrevious.addActionListener(this);
        btnAddIngrediente.setForeground(atributo.getPainelCor());
        btnAddIngrediente.setBackground(atributo.getBotaoPCor());
        btnAddIngrediente.addActionListener(this);


        Date hj = new Date();
        spnData = new JSpinner(new SpinnerDateModel(hj,null,null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editor);
        spnData.setFont(atributo.getTextoCorpo());



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
        lblTitulo.setFont(atributo.getTextoH1());
        JLabel lblSubtitulo = new JLabel("Informação do Medicamento");
        lblSubtitulo.setFont(atributo.getTextoH2());


        lblTitulo.setFont(atributo.getTextoH1());
        lblTitulo.setForeground(atributo.getTextoCor());
        gbc.gridy = 1;
        gbc.insets=new Insets(10,15,10,15);
        pnlPrimario.add(lblTitulo,gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        //cabecalho[1].setFont(atributo.getTextoH2());
        gbc.insets=new Insets(8,30,20,15);


        pnlPrimario.add(lblSubtitulo,gbc);


        /**
         * Add Formulario
         * */

        gbc.insets=new Insets(10,30,0,30);
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

        gbc.gridheight = 1;

        //pnlPrimario.add(txtMedicamento[0],gbc);

        gbc.gridy = 12;
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
        gbc.insets = new Insets(0,0,50,15);
        gbc.weightx=1;
        gbc.gridy=15;
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.ipady = 10;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;

        pnlPrimario.add(btnNext,gbc);


    }

    private void setPnlSecundario(){
        GridBagLayout gbl = new GridBagLayout();
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.ipady = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;

        pnlSecundario.setLayout(gbl);


        gbc.weightx=1;
        gbc.weighty=0;
        gbc.ipady = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;

        JLabel lblTitulo = new JLabel("Adicionar Medicamento");
        lblTitulo.setFont(atributo.getTextoH1());
        JLabel lblSubtitulo = new JLabel("Informação do Medicamento");
        lblSubtitulo.setFont(atributo.getTextoH2());


        lblTitulo.setFont(atributo.getTextoH1());
        lblTitulo.setForeground(atributo.getTextoCor());
        gbc.gridy = 1;
        gbc.insets=new Insets(10,15,10,15);
        pnlSecundario.add(lblTitulo,gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        //cabecalho[1].setFont(atributo.getTextoH2());
        gbc.insets=new Insets(8,30,20,15);


        pnlSecundario.add(lblSubtitulo,gbc);

        gbc.gridwidth = 4;
        gbc.gridx=0;
        gbc.insets=new Insets(10,30,0,10);

        for(int i=0; i<5; i++){


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

        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pnlSecundario.add(listalblIng.get(0)[0],gbc);
        gbc.gridy = 4;
        pnlSecundario.add(listatxtIng.get(0)[0],gbc);
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pnlSecundario.add(listalblIng.get(0)[1],gbc);
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        pnlSecundario.add(listatxtIng.get(0)[1],gbc);


        gbc.weighty=1;
        gbc.weightx=1;
        gbc.gridy=15;
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.ipady = 10;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        gbc.insets = new Insets(0,15,50,0);
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
        else if(e.getSource() == btnAddIngrediente){

        }
        else if(e.getSource() == btnSave){
            controller.inserir();
        }

    }

    @Override
    public void textValueChanged(TextEvent e) {

    }
}
