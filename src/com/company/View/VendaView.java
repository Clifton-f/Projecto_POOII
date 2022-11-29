package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VendaView implements ActionListener {
    JLabel []cabecalho= new JLabel[2];

    JLabel lblCompra;
    JLabel lblDadosPh[] = new JLabel[4];
    JLabel lblOrd;
    JLabel lblPym;
    JTextField []txtOrder = new JTextField[2];
    JButton btnAdd;
    JButton btnrmv;
    JButton Submeter;
    JTextField []txtRecibo = new JTextField[3];
    JLabel []lblRecibo = new JLabel[3];
    CustomizarView atributo = new CustomizarView();
    ArrayList<JTextField[]> lstTxtProduto = new ArrayList<>();
    ArrayList<JLabel[]> lstLblProduto = new ArrayList<>();
    int posicao = 9;
    JPanel pnlBtn  = new JPanel();
    GridLayout gl = new GridLayout(1,2);


    JScrollPane jsc;

    JPanel pnlVenda = new JPanel();
    JButton btnConcluir = new JButton("Concluir");

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

        lblRecibo[0] = new JLabel("Sub Total");
        lblRecibo[1] = new JLabel("Desconto");
        lblRecibo[2] = new JLabel("Preço Total");

        for(int i = 0;i<3; i++){
            txtRecibo[i] = new JTextField();
            //txtRecibo[i].setFont(atributo.getTextoCorpo());
        }




        JLabel txtaddMed = new JLabel("Adicionar Medicamento");
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        pnlVenda.setLayout(gbl);

        gbc.anchor=GridBagConstraints.FIRST_LINE_START;
        gbc.ipady = 10;

        pnlVenda.setBackground(atributo.getPainelCor());
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
        pnlVenda.add(cabecalho[1],gbc);
        cabecalho[1].setFont(atributo.getTextoH1());
        gbc.gridy = 1;
        gbc.gridx = 0;
        cabecalho[0].setFont(atributo.getTextoH2());

        gbc.insets=new Insets(0,15,0,15);
        pnlVenda.add(cabecalho[0],gbc);

        //add(lblDadosPh,gbc);
        /**Dados da ordem*/

        gbc.fill=GridBagConstraints.BOTH;
        gbc.gridheight=2;
        gbc.gridwidth = 1;
        gbc.gridy = 3;
        gbc.gridx = 4;
        pnlVenda.add(lblOrd,gbc);

        gbc.gridwidth = 2;
        gbc.gridy = 5;
        pnlVenda.add(lblPym,gbc);


        gbc.gridx =5;
        gbc.gridy =3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlVenda.add(txtOrder[0],gbc);
        gbc.gridy = 5;
        pnlVenda.add(txtOrder[1],gbc);
        /**Compra*/
        gbc.gridwidth = 3;
        gbc.gridheight=1;
        for(int i=0; i<4;i++){
            gbc.gridy = 3+i;
            gbc.gridx =0;
            pnlVenda.add(lblDadosPh[i],gbc);
        }

        prepararBotoes();
        adicionarProduto();
        adicionarProduto();









        jsc = new JScrollPane(pnlVenda);

        jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);



    }

    public void inicializarProduto(){

        JLabel []lblProduto = new JLabel[7];
        lblProduto[0] = new JLabel("#");
        lblProduto[1] = new JLabel("Nome do medicamento");
        lblProduto[2] = new JLabel("Quantidade");
        lblProduto[3] = new JLabel("Preço unitario");
        lblProduto[4] = new JLabel("Tipo de disconto");
        lblProduto[5] = new JLabel("Desconto");
        lblProduto[6] = new JLabel("Preço total");

        JTextField []txtProduto = new JTextField[7];
        for (int i = 0; i<7;i++){
            lblProduto[i].setFont(atributo.getTextoCorpo());
            txtProduto[i] = new JTextField();
            txtProduto[i].setPreferredSize(new Dimension(200,31));
            txtProduto[i].setFont(atributo.getTextoCorpo());

        }

        lstTxtProduto.add(txtProduto);
        lstLblProduto.add(lblProduto);
    }


    public void adicionarRecibo(GridBagConstraints gbc){
        txtRecibo = definirAtributostextField(txtRecibo);
        //gbc = new GridBagConstraints();
        lblRecibo = definirAtributoslblCorpo(lblRecibo);
        removerRecibo();

        gbc.ipady = 10;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        for(int i = 0; i<txtRecibo.length; i++){
            gbc.gridy=posicao+i+3;
            gbc.gridx = 2;
            pnlVenda.add(lblRecibo[lblRecibo.length-1-i],gbc);
            gbc.gridx = 3;


            pnlVenda.add(txtRecibo[txtRecibo.length-i-1],gbc);

        }




        gbc.fill=GridBagConstraints.NONE;
        gbc.gridy = posicao+6;
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.weighty = 1;
        pnlVenda.add(btnConcluir,gbc);

    }

    public void removerRecibo(){
        for (int i=0; i<txtRecibo.length;i++){
            pnlVenda.remove(txtRecibo[i]);
            pnlVenda.remove(lblRecibo[i]);
        }
    }

    private void adicionarProduto(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(10,10,0,10);

        inicializarProduto();
        int indice = lstTxtProduto.size()-1;

        pnlVenda.remove(pnlBtn);

        gbc.ipady =10;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0;

        for(int i=0; i<lstTxtProduto.get(indice).length; i++){
            gbc.gridy = posicao;
            gbc.gridx = i;

            pnlVenda.add(lstLblProduto.get(indice)[i],gbc);
            gbc.gridy=posicao+1;
            gbc.gridx =i;
            pnlVenda.add(lstTxtProduto.get(indice)[i],gbc);
        }

        //gbc.weighty = 1;
        gbc.gridx = 5;
        gbc.gridy = posicao+2;
        gbc.gridwidth = 2;

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        //gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        pnlVenda.add(pnlBtn,gbc);


        adicionarRecibo(gbc);

        posicao+=2;

        atributo.actualizarPainel(pnlVenda);


    }

    public void removerProduto(){

        int indice = lstTxtProduto.size()-1;
        for (int i=0;i<lstTxtProduto.size();i++){
            pnlVenda.remove(lstTxtProduto.get(indice)[i]);
            pnlVenda.remove(lstLblProduto.get(indice)[i]);
        }


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

    public float precoTotal(int precoUnitario, float desconto){
        int precoTotal = 0;

        return precoTotal;
    }

    private void prepararBotoes(){
        btnAdd.addActionListener(this);
        btnrmv.addActionListener(this);
        pnlBtn.setLayout(gl);
        gl.setHgap(15);
        pnlBtn.add(btnAdd);
        pnlBtn.add(btnrmv);
    }

    public static void main(String[]args){
        JFrame tela = new JFrame("Compra");
        VendaView vendaView = new VendaView();
        tela.add(vendaView.pnlVenda);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1280,720));
        tela.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd){
            adicionarProduto();
            System.out.println("btnAdd");
        }else if (e.getSource() == btnrmv){
            removerProduto();
            System.out.println("btnrmv");
        }
        for(int i=0; i<lstTxtProduto.size();i++){
            if (e.getSource() == lstTxtProduto.get(i)[2]){
                //lstTxtProduto.get(i)
            }

        }
    }

}
