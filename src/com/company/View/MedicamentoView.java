package com.company.View;

import com.company.Controller.FornecedorController;
import com.company.Controller.IngredienteMedicamentoController;
import com.company.Controller.MedicamentoController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MedicamentoView extends JPanel implements ActionListener, TextListener {

    JLabel []cabecalho= new JLabel[2];
    JLabel []lblMedicamento = new JLabel[10];
    //JLabel []lblIng = new JLabel[2];
    //JTextField []txtIng = new JTextField[2];
    ArrayList<JLabel[]> listalblIng = new ArrayList<>();
    ArrayList<JTextField[]> listatxtIng = new ArrayList<>();
    JTextField []txtMedicamento = new JTextField[8];
    JTextField []txtDosagem = new JTextField[5];
    JLabel []lblDosagem = new JLabel[5];
    JSpinner spnData;
    JComboBox<String> cmbClassificacao;
    JComboBox<String> cmbFornecedor;
    JButton btnNext = new JButton("Póximo");
    JButton btnPrevious = new JButton("Anterior");
    JButton btnAddIngrediente = new JButton("Adicionar");
    JButton btnRmvIngrediente = new JButton("Remover");
    JButton btnSave = new JButton("Gravar");
    JSeparator separator = new JSeparator();
    CustomizarView atributo = new CustomizarView();
    GridLayout gl;
    private FornecedorController fornecedorC = new FornecedorController();
    //Variaveis de auxílio
    private int numIngrediente = 3;
    private CardLayout cl = new CardLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private final JPanel pnlPrimario = new JPanel();
    private final JPanel pnlSecundario = new JPanel();
    private final JPanel pnlListaMedicamento = new JPanel();
    private final JPanel pnlMedicamento[] = new JPanel[2];
    JLabel lblSubtituloPn2;
    JLabel lblTituloPn2;
    JLabel lblSubtituloPn1;
    JLabel lblTituloPn1;


    private int posicaoBtnAddIngredient = 3;


    MedicamentoController controllerMedicamento = new MedicamentoController();
    IngredienteMedicamentoController ingredienteController = new IngredienteMedicamentoController();


    public MedicamentoView(){

        incializarComponentes();
        pnlPrimario.setBackground(atributo.getPainelCor());

        setPnlPrimario();
        setPnlSecundario();
        setPnlListaMedicamento();
        this.setLayout(cl);
        this.add("1",pnlPrimario);
        this.add("2",pnlSecundario);



    }

    private void setPnlPrimario(){
        GridBagLayout gbl = new GridBagLayout();

        pnlPrimario.setLayout(gbl);


        gbc.weightx=1;
        gbc.weighty=0;
        gbc.ipady = 10;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;





        gbc.gridy = 1;
        gbc.insets=new Insets(10,15,10,15);
        pnlPrimario.add(lblTituloPn1,gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        //cabecalho[1].setFont(atributo.getTextoH2());
        gbc.insets=new Insets(8,30,20,15);


        pnlPrimario.add(lblSubtituloPn1,gbc);


        /**
         * Add Formulario
         * */

        gbc.insets=new Insets(10,30,0,30);
        gbc.gridx=0;
        gbc.gridwidth = 4;
        gbc.ipady = 10;
        gbc.gridy = 3;
        pnlPrimario.add(lblMedicamento[0],gbc);


        gbc.gridy =4;
        gbc.ipady = 10;
        pnlPrimario.add(txtMedicamento[0],gbc);


        gbc.gridwidth = 1;
        gbc.gridx = 4;
        gbc.ipady = 10;
        gbc.gridy = 3;

        pnlPrimario.add(lblMedicamento[4],gbc);
        gbc.gridy =4;
        gbc.ipady = 10;
        pnlPrimario.add(spnData,gbc);


        for(int i=1; i<4; i++){

            gbc.gridx=0;
            gbc.gridwidth = 4;
            gbc.ipady = 10;
            gbc.gridy = 3+2*i;

            pnlPrimario.add(lblMedicamento[i],gbc);
            gbc.gridy =2*i+4;
            gbc.ipady = 10;
            pnlPrimario.add(txtMedicamento[i],gbc);


            gbc.gridwidth = 1;
            gbc.gridx = 4;
            gbc.ipady = 10;
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





        gbc.gridy = 1;
        gbc.insets=new Insets(10,15,10,15);
        pnlSecundario.add(lblTituloPn2,gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        //cabecalho[1].setFont(atributo.getTextoH2());
        gbc.insets=new Insets(8,30,20,15);


        pnlSecundario.add(lblSubtituloPn2,gbc);

        gbc.gridwidth = 4;
        gbc.gridx=0;
        gbc.insets=new Insets(10,30,0,10);

        for(int i=0; i<4; i++){


            gbc.gridy = 3+2*i;
            gbc.ipady = 10;

            pnlSecundario.add(lblDosagem[i],gbc);
            gbc.gridy =2*i+4;
            gbc.ipady = 10;
            pnlSecundario.add(txtDosagem[i],gbc);



        }
        gbc.gridy = 11;
        gbc.ipady = 10;
        pnlSecundario.add(lblDosagem[4],gbc);
        gbc.ipady = 10;
        gbc.gridy = 12;
        pnlSecundario.add(txtDosagem[4],gbc);

        adicionarIngrediente();
        inicializarBotoes();

        gbc.weighty=1;
        gbc.weightx=1;
        gbc.gridy=GridBagConstraints.LAST_LINE_END;
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.ipady = 10;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        gbc.insets = new Insets(0,15,50,0);
        pnlSecundario.add(btnPrevious,gbc);
        gbc.gridx = 5;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        pnlSecundario.add(btnSave,gbc);



    }

    private void setPnlListaMedicamento(){

    }

    private void pnlUpdateMedicamento(String []textFields){
        try {
            for(int i=0; i>textFields.length;i++){

                    txtMedicamento[i].setText(textFields[i]);
                    txtMedicamento[i].setText(textFields[2*i+2]);
            }

        } catch (NullPointerException nu){
                nu.printStackTrace();
        }

    }

    public void updateMedicamento(){

    }

    public static void main(String[]args){
        JFrame tela = new JFrame();
        MedicamentoView mv = new MedicamentoView();
        tela.add(mv);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1280,720));
        tela.setVisible(true);


    }


    @Override
    public void textValueChanged(TextEvent e) {

    }

    private void adicionarIngrediente(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(10,30,0,30);

        incializarElementosDosIngredientes();
        pnlSecundario.remove(btnRmvIngrediente);
        pnlSecundario.remove(btnAddIngrediente);

        gbc.gridx = 5;
        gbc.gridy = posicaoBtnAddIngredient;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0;
        pnlSecundario.add(listalblIng.get(listalblIng.size()-1)[0],gbc);
        gbc.gridy = posicaoBtnAddIngredient+1;
        pnlSecundario.add(listatxtIng.get(listalblIng.size()-1)[0],gbc);


        gbc.gridx = 7;
        gbc.gridy = posicaoBtnAddIngredient;
        gbc.weightx = 1;
        gbc.gridwidth =1;
        pnlSecundario.add(listalblIng.get(listalblIng.size()-1)[1],gbc);
        gbc.gridy = posicaoBtnAddIngredient+1;
        gbc.fill = GridBagConstraints.BOTH;
        pnlSecundario.add(listatxtIng.get(listalblIng.size()-1)[1],gbc);
        gbc.gridy = posicaoBtnAddIngredient+2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        pnlSecundario.add(btnAddIngrediente,gbc);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        pnlSecundario.add(btnRmvIngrediente,gbc);


        posicaoBtnAddIngredient+=2;

    }

    private void removerIngrediente(){
        int indice = listatxtIng.size()-1;
        pnlSecundario.remove(listalblIng.get(indice)[0]);
        pnlSecundario.remove(listalblIng.get(indice)[1]);
        pnlSecundario.remove(listatxtIng.get(indice)[0]);
        pnlSecundario.remove(listatxtIng.get(indice)[1]);
        listatxtIng.remove(indice);
        listalblIng.remove(indice);

        pnlSecundario.remove(btnAddIngrediente);
        pnlSecundario.remove(btnRmvIngrediente);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(10,30,0,30);

        gbc.gridx = 7;
        gbc.weightx = 1;
        gbc.weighty = 0;
        posicaoBtnAddIngredient-=2;

        gbc.gridy = posicaoBtnAddIngredient;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        pnlSecundario.add(btnAddIngrediente,gbc);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        pnlSecundario.add(btnRmvIngrediente,gbc);
    }

    private void incializarComponentes(){
        inicializarCabecalho();
        incializarElementosDosIngredientes();

        lblTituloPn2 = new JLabel("Adicionar Medicamento");
        lblTituloPn2.setFont(atributo.getTextoH1());
        lblSubtituloPn2 = new JLabel("Informação do Medicamento");
        lblSubtituloPn2.setFont(atributo.getTextoH2());
        lblTituloPn1 = new JLabel("Adicionar Medicamento");
        lblTituloPn1.setFont(atributo.getTextoH1());
        lblSubtituloPn1 = new JLabel("Informação do Medicamento");
        lblSubtituloPn1.setFont(atributo.getTextoH2());

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

        String []classe = controllerMedicamento.getClassificacao();
        cmbClassificacao = new JComboBox<>(classe);




        //Dosagem

        lblDosagem[0] = new JLabel("Dosagem para bebês (0-2)");
        lblDosagem[1] = new JLabel("Dosagem para bebês (2-5)");
        lblDosagem[2] = new JLabel("Dosagem para crianças (6-12)");
        lblDosagem[3] = new JLabel("Dosagem para adolescentes (12-18)");
        lblDosagem[4] = new JLabel("Dosagem para adultos (18- )");



        for(int i = 0; i<txtDosagem.length;i++){
            txtDosagem[i] = new JTextField();
            txtDosagem[i].setForeground(atributo.getTextoCor());
            txtDosagem[i].setFont(atributo.getTextoCorpo());


        }
        //txtDosagem = definirAtributostextField(txtDosagem);
        //txtMedicamento = definirAtributostextField(txtMedicamento);

        JTextArea txaDescricao = new JTextArea(3,100);
        txaDescricao.setPreferredSize(atributo.getTamanhoMax());
        txaDescricao.setFont(atributo.getTextoCorpo());








        Date hj = new Date();
        spnData = new JSpinner(new SpinnerDateModel(hj,null,null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editor);
        spnData.setFont(atributo.getTextoCorpo());
    }

    private void actualizarPainel(JPanel pnl){

        pnl.revalidate();
        pnl.repaint();
    }

    private void incializarElementosDosIngredientes(){
        //Ingredientes
        JLabel []lblIng = new JLabel[2];
        lblIng[0] = new JLabel("Nome do Ingrediente");
        JTextField txtIng[] = new JTextField[2];
        txtIng[0] = new JTextField();
        lblIng[1] = new JLabel("quantidade");
        txtIng[1] = new JTextField();

        txtIng = definirAtributostextField(txtIng);
        lblIng = definirAtributoslblCorpo(lblIng);
        lblIng[0].setFont(atributo.getTextoCorpo());


        listalblIng.add(lblIng);
        listatxtIng.add(txtIng);



    }

    private void inicializarBotoes(){
        //botões
        btnNext.setForeground(atributo.getPainelCor());
        btnNext.setBackground(atributo.getBotaoPCor());
        btnNext.addActionListener(this);
        btnPrevious.setForeground(atributo.getPainelCor());
        btnPrevious.setBackground(atributo.getBotaoNCor());
        btnPrevious.addActionListener(this);

        btnRmvIngrediente.setBackground(atributo.getBotaoNCor());
        btnRmvIngrediente.setForeground(atributo.getPainelCor());
        btnRmvIngrediente.addActionListener(this);

        btnAddIngrediente.setForeground(atributo.getPainelCor());
        btnAddIngrediente.setBackground(atributo.getBotaoPCor());
        btnAddIngrediente.addActionListener(this);
    }


    public JTextField[] definirAtributostextField(JTextField[] txt){
        for (int i=0; i<txt.length;i++){
            txt[i] = atributo.atribuirPadroesTextFields(txt[i]);
        }
    return txt;
    }

    public JLabel[] definirAtributoslblCorpo(JLabel []lblTexto){
        for(int i= 0; i>lblTexto.length;i++){
            lblTexto[i] = atributo.atribuirPadroesLabel(lblTexto[i]);
        }
        return lblTexto;
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

            adicionarIngrediente();
            actualizarPainel(pnlSecundario);
            actualizarPainel(this);

        }else if (e.getSource() == btnRmvIngrediente){
            removerIngrediente();
            actualizarPainel(pnlSecundario);
            actualizarPainel(this);
        }
        else if(e.getSource() == btnSave){
            String []valoresDosagem = new String[txtDosagem.length];
            String []valoresMedicamento = new String[lblMedicamento.length];
            String fornecedor = cmbFornecedor.getSelectedItem().toString();
            String classe = cmbClassificacao.getSelectedItem().toString();


            controllerMedicamento.inserirMedicamento(txtMedicamento[0].getText(),txtMedicamento[1].getText(),txtMedicamento[2].getText(), Timestamp.valueOf(spnData.getValue().toString()),Integer.parseInt(txtMedicamento[5].getText()),Integer.parseInt(txtMedicamento[6].getText()),
                    cmbClassificacao.getSelectedItem().toString(),
                    cmbFornecedor.getSelectedItem().toString()
                    ,Integer.parseInt(txtMedicamento[4].getText()));

            for(int i=0;i<txtMedicamento.length;i++){
                valoresMedicamento[i] = txtMedicamento[i].getText();
            }

            for (int i=0; i<valoresDosagem.length;i++){
                valoresDosagem[i] = txtDosagem[i].getText();
            }

            valoresMedicamento[8] = cmbClassificacao.getSelectedItem().toString();
            valoresMedicamento[9] = spnData.toString();
            boolean sucesso;
            sucesso = controllerMedicamento.inserirMedicamento(valoresMedicamento);

            sucesso &= controllerMedicamento.inserirDosagem(valoresDosagem);

            for (int i =0;i<listatxtIng.size();i++){
                String []ingrediente = new String[3];
                ingrediente[0] = txtMedicamento[0].getText();
                ingrediente[1] = listatxtIng.get(i)[0].getText();
                ingrediente[2] = listatxtIng.get(i)[1].getText();
                sucesso &= ingredienteController.inserirIngrediente(ingrediente);
            }
            if(sucesso){

            }

        }

    }



    private void inicializarCabecalho(){

    }
}
