package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login  extends JPanel implements ActionListener {
    JButton btnLogin = new JButton("Entrar");
    JButton btnRegistar = new JButton("Registar");
    JTextField txtEmail = new JTextField("admin");
    
    JPasswordField password = new JPasswordField("admin");
    CustomizarView propriedades = new CustomizarView();

    public Login(){

        btnLogin.setBackground(propriedades.getBotaoPCor());
        btnLogin.setFont(propriedades.getTextoCorpo());
        btnLogin.setActionCommand("Login");
        btnLogin.addActionListener(this);
        btnRegistar.setBackground(propriedades.getBotaoPCor());
        btnRegistar.setFont(propriedades.getTextoCorpo());
        btnRegistar.setActionCommand("Registar");
        btnRegistar.addActionListener(this);
        txtEmail.setFont(propriedades.getTextoCorpo());
        password.setFont(propriedades.getTextoCorpo());

        this.setBackground(propriedades.getPainelCor());
        GridBagLayout gbl= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);




        gbc.gridy = 0;
        gbc.gridx=0;
        gbc.gridwidth=3;
        gbc.weightx=0.5;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,200,5,200);
        gbc.ipady = 10;
        add(txtEmail,gbc);

        gbc.gridy = 1;
        add(password,gbc);



        gbc.fill=GridBagConstraints.NONE;
        gbc.anchor=GridBagConstraints.LINE_END;

        gbc.gridwidth=1;
        gbc.insets = new Insets(5,0,5,5);
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.gridy = 2;
        gbc.gridx = 1;
        add(btnLogin,gbc);
        gbc.insets = new Insets(5,5,5,0);
        gbc.gridx = 2;
        gbc.anchor=GridBagConstraints.LINE_START;
        add(btnRegistar,gbc);


    }

    public static void main(String[]args){
        JFrame tela = new JFrame();
        tela.add(new Login());
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1280,720));
        tela.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
