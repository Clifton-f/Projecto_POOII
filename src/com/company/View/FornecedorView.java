package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FornecedorView extends JPanel implements ActionListener {
    JLabel lblFornecedor = new JLabel("Adicionar fornecedor");
    JLabel []lblDados  = new JLabel[4];
    JLabel []cabecalho = new JLabel[2];
    JTextField []txtFornecedor = new JTextField[4];
    JTextField txtNome = new JTextField("Nome");
    JTextField txtEmail= new JTextField("Email");
    JTextField txtContacto = new JTextField("Contacto");
    JTextArea txaEndereco = new JTextArea("Enderesso");
    JButton btnAdd = new JButton("Adicionar");
    JButton btnRmv = new JButton("Remover");
    CustomizarView atributo = new CustomizarView();


    public FornecedorView(){

        this.setBackground(Color.YELLOW);
        inicializarElementos();
        adicionarElementosAoPainel();



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd){
            System.out.println("Funciona");
        }
        else if(e.getSource() == btnRmv){
            System.out.println("Funciona");
        }
    }

    public void inicializarElementos(){
        JLabel[]lblDados = new JLabel[4];
        lblDados[0] = new JLabel("Nome");
        lblDados[1] = new JLabel("Contacto");
        lblDados[2] = new JLabel("Email");
        lblDados[3] = new JLabel("Endereco");



        btnAdd.addActionListener(this);
        btnRmv.addActionListener(this);



        for (int i = 0; i<4;i++){
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



        for(int i=0; i<3; i++){
            gbc.gridy = 2*i+3;
            gbc.insets=new Insets(10,30,0,20);
            this.add(lblDados[i],gbc);
            gbc.gridy =2*i+4;
            this.add(txtFornecedor[i],gbc);
        }
        gbc.gridy = 9;
        this.add(lblDados[3],gbc);
        gbc.gridy = 10;
        //gbc.gridheight=GridBagConstraints.REMAINDER;

        gbc.weighty=1;
        this.add(txtFornecedor[3],gbc);
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.gridx = 1;
        gbc.gridy=12;

        JPanel pnlBtn = new JPanel();
        GridLayout gl = new GridLayout(1,2);
        gl.setHgap(10);
        pnlBtn.setLayout(gl);
        pnlBtn.setBackground(this.getBackground());
        pnlBtn.add(btnAdd);
        pnlBtn.add(btnRmv);
        this.add(pnlBtn,gbc);


        gbc.gridx = 2;



        //this.add(txtMedicamento[3],gbc);

    }

    public static void main(String[]args){
        JFrame tela = new JFrame();
        tela.add(new FornecedorView());
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1280,720));
        tela.setVisible(true);
    }



}
