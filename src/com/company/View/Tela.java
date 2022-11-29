package com.company.View;

import com.company.Controller.FuncionarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela implements ActionListener{
    JFrame tela = new JFrame("Tela");
    MedicamentoView pnlMedicamento = new MedicamentoView();
    Login pnlLogin = new Login();
    FornecedorView pnlFornecedor = new FornecedorView();
    FuncionarioView pnlFuncionario = new FuncionarioView();
    FuncionarioController funcionarioController = new FuncionarioController();



    JPanel pnlTela = new JPanel();
    CardLayout lyTela = new CardLayout();
    JPanel pnlCentro = new JPanel();
    CardLayout lyCentro = new CardLayout();
    BorderLayout lyWorkspc = new BorderLayout();
    JPanel pnlWorkspc = new JPanel();
    VendaView ViewVenda = new VendaView();
    MenuView pnlMenu = new MenuView();


    public Tela() {
        pnlLogin.btnLogin.addActionListener(this);
        pnlLogin.btnRegistar.addActionListener(this);


        /*Segunda tela*/
        //Centro
        pnlCentro.setLayout(lyCentro);
        pnlCentro.add("venda", ViewVenda.pnlVenda);
        pnlCentro.add("fornecedor",pnlFornecedor);
        pnlCentro.add("medicamento",pnlMedicamento);
        pnlCentro.add("funcionario",pnlFuncionario);

        //Oeste
        for(int i = 0; i<pnlMenu.buttons.length;i++){
            pnlMenu.buttons[i].addActionListener(this);
        }

        //adicoes
        pnlWorkspc.setLayout(lyWorkspc);
        pnlWorkspc.add(pnlMenu.sidemenu,BorderLayout.WEST);





        pnlWorkspc.add(pnlCentro, BorderLayout.CENTER);
        pnlWorkspc.add(pnlMenu.menuBar, BorderLayout.SOUTH);


        pnlTela.setLayout(lyTela);
        pnlTela.add("login",pnlLogin);
        pnlTela.add("workspace",pnlWorkspc);

        this.tela.add(pnlTela);

        pnlLogin.btnRegistar.addActionListener(this);





        this.tela.setSize(new Dimension(1280,720));
        this.tela.setVisible(true);
        this.tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }













    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pnlLogin.btnLogin){
            boolean login;

            if (funcionarioController.login(pnlLogin.txtEmail.getText(), String.valueOf(pnlLogin.password.getPassword()))){
                lyTela.show(pnlTela,"workspace");
            }else{
                System.out.println("erro");
            }


        }else if(e.getSource() == pnlLogin.btnRegistar){
            System.out.println("placeholder");


        }else if(e.getSource() == pnlMenu.buttons[0]){
            lyCentro.show(pnlCentro,"venda");


        }
        else if(e.getSource() == pnlMenu.buttons[1]){
            lyCentro.show(pnlCentro,"medicamento");



        }
        else if(e.getSource() == pnlMenu.buttons[2]){
            lyCentro.show(pnlCentro,"fornecedor");



        }
        else if(e.getSource() == pnlMenu.buttons[3]){
            lyCentro.show(pnlCentro,"funcionario");


        }


    }

}
