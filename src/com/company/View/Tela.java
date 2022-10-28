package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela implements ActionListener{
    JFrame tela = new JFrame("Tela");
    MedicamentoView pnlMedicamento = new MedicamentoView();
    Login pnlLogin = new Login();
    FornecedorView pnlFornecedor = new FornecedorView();

    JPanel painel = new JPanel();
    CardLayout lyTela = new CardLayout();
    JPanel pnlCentro = new JPanel();
    CardLayout lyCentro = new CardLayout();
    BorderLayout lyWorkspc = new BorderLayout();
    JPanel pnlWorkspc = new JPanel();
    VendaView pnlVendas = new VendaView();
    MenuView pnlMenu = new MenuView();


    public Tela() {
        /**window ou tela mesmo*/


        /**Segunda tela*/
        //Centro
        pnlCentro.setLayout(lyCentro);
        /**pnlCentro.add("Compra",pnl);
        pnlCentro.add(pnlFornecedor,"fornecedor");
        pnlCentro.add(pnlMedicamento,"medicamento");*/

        //Oeste
        for(int i = 0; i<pnlMenu.buttons.length;i++){
            pnlMenu.buttons[i].addActionListener(this);
        }

        //adicoes
        pnlWorkspc.setLayout(lyWorkspc);
        pnlWorkspc.add(pnlMenu.sidemenu,BorderLayout.WEST);
        //pnlWorkspc.add(pn, BorderLayout.CENTER);

        //pnlWorkspc.add(pnlCompra,BorderLayout.CENTER);

        //painel.add("Fornecedor",pnlFornecedor);
        //painel.add("Login",pnlLogin);
        pnlCentro.add("addvendas",pnlVendas);
        pnlCentro.add(pnlFornecedor,"addfornecedor");
        pnlCentro.add("addmedicamento", pnlMedicamento);
        pnlWorkspc.add(pnlCentro, BorderLayout.CENTER);
        //painel.add("Medicamentos",pnlMedicamentos);


        painel.setLayout(lyTela);
        painel.add("login",pnlLogin);
        painel.add("workspace",pnlWorkspc);
        this.tela.add(painel);
        pnlLogin.btnRegistar.addActionListener(this);





        this.tela.setSize(new Dimension(1280,720));
        this.tela.setVisible(true);
        this.tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }






    public void mostraWrkspc() {
       lyTela.show(painel,"workspace");

    }






    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pnlLogin.btnRegistar){
            mostraWrkspc();
        }
        if(e.getSource()==pnlMenu.buttons[0]){
            lyCentro.show(pnlCentro,"addvenda");
        }
        if(e.getSource()==pnlMenu.buttons[1]){
            lyCentro.show(pnlCentro,"addmedicamento");
        }
        if(e.getSource()==pnlMenu.buttons[2]){
            lyCentro.show(pnlCentro,"addfornecedor");
        }

    }

}
