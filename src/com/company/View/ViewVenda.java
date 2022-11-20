package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewVenda extends JPanel implements ActionListener{
    ScrollPaneLayout sp = new ScrollPaneLayout();
    JLabel []cabecalho= new JLabel[2];
    JLabel [] lblProduto = new JLabel[7];
    JTextField [] txtProduto = new JTextField[7];
    ArrayList<Object> elemento = new ArrayList<Object>();
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
    JPanel pnlItens;
    int iterado =0;
    ArrayList<JLabel[]> listalblProduto = new ArrayList();
    ArrayList<JTextField[]> listatxtProduto = new ArrayList<>();
    JPanel pnlBtn  = new JPanel();
    GridLayout gl = new GridLayout(1,2);
    GridBagConstraints gbc = new GridBagConstraints();




    public ViewVenda(){
        /**
         * Inicializacao
         * */



        lblOrd = new JLabel("Ordem Número:");
        lblPym = new JLabel("Tipo de Pagamento:");
        txtOrder[0].setMinimumSize(new Dimension(200,31));
        txtOrder[1].setMinimumSize(new Dimension(200,31));
        txtOrder[0] = new JTextField();
        txtOrder[1] = new JTextField();

        btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(this);
        btnrmv = new JButton("Remover");
        Submeter = new JButton("Subeter compra");
        btnrmv.setMinimumSize(new Dimension(200,31));


        lblProduto[0] = new JLabel("#");
        lblProduto[1] = new JLabel("Nome do medicamento");
        lblProduto[2] = new JLabel("Quantidade");
        lblProduto[3] = new JLabel("Preço unitario");
        lblProduto[4] = new JLabel("Tipo de disconto");
        lblProduto[5] = new JLabel("Desconto");
        lblProduto[6] = new JLabel("Preço total");


        lblRecibo[0] = new JLabel("Sub Total");
        lblRecibo[1] = new JLabel("Desconto");
        lblRecibo[2] = new JLabel("Preço Total");
        for(int i = 0;i<3; i++){
            txtRecibo[i] = new JTextField();
            txtRecibo[i].setFont(atributo.getTextoCorpo());
        }




        for (int i = 0; i<7;i++){
            lblProduto[i].setFont(atributo.getTextoCorpo());
            txtProduto[i] = new JTextField();
            txtProduto[i].setPreferredSize(new Dimension(200,31));
            txtProduto[i].setFont(atributo.getTextoCorpo());
            txtProduto[i].setMinimumSize(new Dimension(200,31));
            try{

                txtRecibo[i] = new JTextField();
                txtRecibo[i].setPreferredSize(new Dimension(200,31));
                txtRecibo[i].setFont(atributo.getTextoCorpo());
                txtRecibo[i].setMinimumSize(new Dimension(200,31));

            }catch (NullPointerException ee){

            }


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

        listatxtProduto.add(txtProduto);
        listalblProduto.add(lblProduto);



        //sp.setVerticalScrollBarPolicy(ScrollPaneLayout.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setLayout(sp);

        teste();
        addProduto();
        this.add(pnlItens);



    }
    public void teste(){
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

            this.add(listalblProduto.get(0)[i],gbc);
            gbc.gridy=10;
            gbc.gridx =i;
            this.add(listatxtProduto.get(0)[i],gbc);
        }
        gbc.gridy =9;
        gbc.gridx = 6;
        this.add(listalblProduto.get(0)[6],gbc);
        gbc.gridy = 10;
        gbc.gridx = 6;
        gbc.weightx=1;
        this.add(listatxtProduto.get(0)[6],gbc);




        /**Botões*/
        gbc.weighty = 1;
        gbc.gridx = 6;
        gbc.gridy +=1;
        gbc.gridwidth = 1;

        pnlBtn.setLayout(gl);
        pnlBtn.setBackground(atributo.getPainelCor());
        gl.setHgap(15);
        pnlBtn.add(btnAdd);
        pnlBtn.add(btnrmv);
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        //gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        this.add(pnlBtn,gbc);


        gbc.weighty=0;

        gbc.fill = GridBagConstraints.BOTH;
        for(int i = 0; i<txtRecibo.length; i++){
            gbc.gridy=GridBagConstraints.LAST_LINE_END-i;
            gbc.gridx = 4;

            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1;
            this.add(txtRecibo[txtRecibo.length-i-1],gbc);
            gbc.gridwidth=1;
            gbc.gridx = 3;
            this.add(lblRecibo[lblRecibo.length-1-i],gbc);
        }


    }
    public void addProduto(){
        System.out.println("0");
        iterado+=1;
        listalblProduto.add(lblProduto);
        listatxtProduto.add(txtProduto);
        System.out.println("1");
        for (int i = 0; i<lblProduto.length; i++){
            gbc.gridx = i;
            this.add(listalblProduto.get(iterado)[i],gbc);
            gbc.gridy+=1;
            this.add(listatxtProduto.get(iterado)[i],gbc);
            gbc.gridy-=1;
        }
        System.out.println("2");
        gbc.gridy+=2;
        this.add(pnlItens,gbc);
        System.out.println("3");
    }
    public static void main(String[]args){
        JFrame tela = new JFrame("View Venda sp");
        tela.add(new VendaView());
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1280,720));
        tela.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAdd){
            addProduto();
        }
    }
}
