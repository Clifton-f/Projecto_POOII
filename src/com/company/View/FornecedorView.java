package com.company.View;

import com.company.Controller.FornecedorController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class FornecedorView extends JPanel implements ActionListener, ListSelectionListener {
    JLabel lblFornecedor = new JLabel("Adicionar fornecedor");
    JLabel []lblDados  = new JLabel[4];
    JLabel []cabecalho = new JLabel[2];
    JTextField []txtFornecedor = new JTextField[3];
    JTextField txtNome = new JTextField("Nome");
    JTextField txtEmail= new JTextField("Email");
    JTextField txtContacto = new JTextField("Contacto");
    JTextField txtPassword = new JTextField("password");
    JTextArea txaEndereco = new JTextArea("Enderesso");
    JButton btnSave = new JButton("Guardar");
    JButton btnCancel = new JButton("Cancelar");
    JButton btnAdionarFornecedor = new JButton("Adcionar Fornecedor");
    JButton btnSaveAlteracoes = new JButton("Guardar");
    CustomizarView customizarView = new CustomizarView();
    FornecedorController fornecedorController = new FornecedorController();
    JSpinner spnData = new JSpinner();
    JPanel pnlListaFornecedores = new JPanel();
    JPanel pnlAddFornecedores = new JPanel();
    JTable tblFornecedores;
    String [][]listaFornecedores;
    String []atributos;
    ListSelectionModel selecionar;
    CardLayout cl = new CardLayout();
    JPanel pnlBtn;


    public FornecedorView(){

        this.setBackground(customizarView.getPainelCor());
        this.setLayout(cl);
        construirPnlListaFornecedores();
        inicializarElementosPnlAdd();
        adicionarElementosAoPnlAdd();

        this.add("lista",pnlListaFornecedores);
        this.add("adicionar",pnlAddFornecedores);



    }

    public void construirPnlListaFornecedores(){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        inicializarElementosPnlListaFornecedores();


        gbc.ipady = 10;
        pnlListaFornecedores.setLayout(gbl);
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth=GridBagConstraints.REMAINDER;


        /**
         * Add cabecalho
         * */
        JLabel [] cabecalho = new JLabel[2];
        cabecalho[0] = new JLabel("Lista de fornecedores");
        cabecalho[1] = new JLabel("");

        gbc.gridy = 0;
        gbc.insets=new Insets(10,15,10,15);

        cabecalho[0].setFont(customizarView.getTextoH1());
        pnlListaFornecedores.add(cabecalho[0],gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        cabecalho[1].setFont(customizarView.getTextoH2());
        gbc.insets=new Insets(8,30,20,15);
        pnlListaFornecedores.add(cabecalho[1],gbc);

        gbc.gridy = 2;
        gbc.anchor= GridBagConstraints.FIRST_LINE_END;

        pnlListaFornecedores.add(btnAdionarFornecedor,gbc);

        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane sp = new JScrollPane(tblFornecedores);

        pnlListaFornecedores.add(sp, gbc);
    }

    public void inicializarElementosPnlListaFornecedores(){
        atributos = fornecedorController.atributos();
        listaFornecedores = fornecedorController.listarFornecedores();

        btnSaveAlteracoes = definirAtributosBtnPositivos(btnSaveAlteracoes);
        btnAdionarFornecedor = definirAtributosBtnPositivos(btnAdionarFornecedor);


        tblFornecedores = new JTable(listaFornecedores,atributos);
        selecionar = tblFornecedores.getSelectionModel();
        selecionar.addListSelectionListener(this);

    }


    public void mostrarTela(String tela){
        cl.show(this,tela);
    }

    public void inicializarElementosPnlAdd(){
        txaEndereco.setPreferredSize(customizarView.getTamanhoMedT());
        //txaEndereco.setFont(atributo.getTextoCorpo());

        lblDados[0] = new JLabel("Nome");
        lblDados[1] = new JLabel("Contacto");
        lblDados[2] = new JLabel("Email");
        lblDados[3] = new JLabel("Endereco");

        Date hj = new Date();
        spnData = new JSpinner(new SpinnerDateModel(hj,null,null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editor);
        spnData.setFont(customizarView.getTextoCorpo());


        btnSave = definirAtributosBtnPositivos(btnSave);
        btnCancel = definirAtributosBtnNegativos(btnCancel);



        for (int i = 0; i<txtFornecedor.length;i++){
            txtFornecedor[i] = new JTextField();
            txtFornecedor[i].setPreferredSize(new Dimension(560,36));


        }

        JLabel txtaddFornecedor = new JLabel("Adicionar Fornecedor");


    }



    public void adicionarElementosAoPnlAdd(){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.ipady =10;
        pnlAddFornecedores.setLayout(gbl);
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth=GridBagConstraints.REMAINDER;


        /**
         * Add cabecalho
         * */
        JLabel [] cabecalho = new JLabel[2];
        cabecalho[0] = new JLabel("Nova Compra");
        cabecalho[1] = new JLabel("Informaçao da compra");

        gbc.gridy = 0;
        gbc.insets=new Insets(10,15,0,10);
        cabecalho[0].setFont(customizarView.getTextoH1());
        pnlAddFornecedores.add(cabecalho[0],gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        cabecalho[1].setFont(customizarView.getTextoH2());

        gbc.insets=new Insets(0,20,0,10);
        pnlAddFornecedores.add(cabecalho[1],gbc);


        gbc.insets=new Insets(10,30,0,20);
        for(int i=0; i<3; i++){
            gbc.gridy = 2*i+3;

            pnlAddFornecedores.add(lblDados[i],gbc);
            gbc.gridy =2*i+4;
            pnlAddFornecedores.add(txtFornecedor[i],gbc);
        }
        gbc.gridy = 9;

        pnlAddFornecedores.add(lblDados[3],gbc);
        gbc.gridy =10;
        pnlAddFornecedores.add(txaEndereco,gbc);


        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.gridx = 1;
        gbc.weighty=1;
        gbc.gridy=14;

        pnlBtn = new JPanel();
        GridLayout gl = new GridLayout(1,2);
        gl.setHgap(10);
        pnlBtn.setLayout(gl);
        pnlBtn.setBackground(pnlAddFornecedores.getBackground());
        pnlBtn.add(btnSave);
        pnlBtn.add(btnCancel);

        pnlAddFornecedores.add(pnlBtn,gbc);


        gbc.gridx = 2;



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSave){
            //funcionarioController.addFuncionario();
            String nome = txtFornecedor[0].getText();
            String contacto = txtFornecedor[1].getText();
            String email = txtFornecedor[2].getText();
            String endereco = txaEndereco.getText();
            fornecedorController.inserirFornecedor(contacto,nome,email,endereco);
        }
        else if(e.getSource() == btnCancel){
            for(int i=0; i<txtFornecedor.length;i++){
                txtFornecedor[i].setText("");
            }
            txaEndereco.setText("");
        }else if(e.getSource() == btnAdionarFornecedor){
            inicializarElementosPnlAdd();
            cl.next(this);
        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        int linhaSelecionada = tblFornecedores.getSelectedRow();
        for (int i = 0; i<txtFornecedor.length;i++){
            txtFornecedor[i].setText(String.valueOf(tblFornecedores.getValueAt(linhaSelecionada,i)));

        }
        txaEndereco.setText(String.valueOf(tblFornecedores.getValueAt(linhaSelecionada,3)));
        pnlBtn.remove(btnSave);
        pnlBtn.remove(btnCancel);
        pnlBtn.add(btnSaveAlteracoes);


        pnlBtn.add(btnCancel);
        cl.show(this,"adicionar");
    }
    public JButton definirAtributosBtnPositivos(JButton btn){
        btn.setBackground(customizarView.getBotaoPCor());
        btn.setForeground(Color.white);
        btn.setFont(customizarView.getTextoCorpo());
        btn.addActionListener(this);

        return btn;
    }
    public JButton definirAtributosBtnNegativos(JButton btn){
        btn.setBackground(customizarView.getBotaoNCor());
        btn.setForeground(Color.white);
        btn.setFont(customizarView.getTextoCorpo());
        btn.addActionListener(this);

    return btn;
    }

    public static void main(String[]args){
        JFrame tela = new JFrame();
        tela.add(new FornecedorView());
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1280,720));
        tela.setVisible(true);
    }
}
