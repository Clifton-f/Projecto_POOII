package com.company.View;

import com.company.Controller.FornecedorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class FuncionarioView extends JPanel implements ActionListener {
    JLabel lblFornecedor = new JLabel("Adicionar fornecedor");
    JLabel []lblDados  = new JLabel[4];
    JLabel []cabecalho = new JLabel[2];
    JTextField []txtFornecedor = new JTextField[3];
    JTextField txtNome = new JTextField("Nome");
    JTextField txtEmail= new JTextField("Email");
    JTextField txtContacto = new JTextField("Contacto");
    JTextField txtPassword = new JTextField("password");
    JTextArea txaEndereco = new JTextArea("Enderesso");
    JButton btnAdd = new JButton("Adicionar");
    JButton btnRmv = new JButton("Remover");
    CustomizarView atributo = new CustomizarView();
    FornecedorController fornecedorController = new FornecedorController();
    JSpinner spnData = new JSpinner();

    public FuncionarioView(){

        this.setBackground(atributo.getPainelCor());
        inicializarElementos();
        System.out.println("passou");
        adicionarElementosAoPainel();



    }



    public void inicializarElementos(){
        txaEndereco.setPreferredSize(atributo.getTamanhoMedT());
        //txaEndereco.setFont(atributo.getTextoCorpo());

        lblDados[0] = new JLabel("Nome");
        lblDados[1] = new JLabel("Contacto");
        lblDados[2] = new JLabel("Email");
        lblDados[3] = new JLabel("Endereco");

        Date hj = new Date();
        spnData = new JSpinner(new SpinnerDateModel(hj,null,null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editor);
        spnData.setFont(atributo.getTextoCorpo());


        btnAdd.addActionListener(this);
        btnRmv.addActionListener(this);



        for (int i = 0; i<txtFornecedor.length;i++){
            txtFornecedor[i] = new JTextField();
            txtFornecedor[i].setPreferredSize(new Dimension(560,36));


        }

        JLabel txtaddFornecedor = new JLabel("Adicionar Fornecedr");


    }

    public void adicionarElementosAoPainel(){
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbl);
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth=GridBagConstraints.REMAINDER;


        /**
         * Add cabecalho
         * */
        cabecalho[0] = new JLabel("Nova Compra");
        cabecalho[1] = new JLabel("Informaçao da compra");

        gbc.gridy = 0;
        gbc.insets=new Insets(10,15,0,10);
        this.add(cabecalho[0],gbc);
        cabecalho[0].setFont(atributo.getTextoH1());
        gbc.gridy = 1;
        gbc.gridx = 0;
        cabecalho[1].setFont(atributo.getTextoH2());

        gbc.insets=new Insets(0,20,0,10);
        this.add(cabecalho[1],gbc);


        gbc.insets=new Insets(10,30,0,20);
        for(int i=0; i<3; i++){
            gbc.gridy = 2*i+3;

            this.add(lblDados[i],gbc);
            gbc.gridy =2*i+4;
            this.add(txtFornecedor[i],gbc);
        }
        gbc.gridy = 9;

        this.add(lblDados[3],gbc);
        gbc.gridy =10;
        this.add(txaEndereco,gbc);


        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.gridx = 1;
        gbc.weighty=1;
        gbc.gridy=14;

        JPanel pnlBtn = new JPanel();
        GridLayout gl = new GridLayout(1,2);
        gl.setHgap(10);
        pnlBtn.setLayout(gl);
        pnlBtn.setBackground(this.getBackground());
        pnlBtn.add(btnAdd);
        pnlBtn.add(btnRmv);
        this.add(pnlBtn,gbc);


        gbc.gridx = 2;



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd){

        }
        else if(e.getSource() == btnRmv){
            System.out.println("Funciona");
        }
    }

}
