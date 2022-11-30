package com.company.View;

import javax.swing.*;
import java.awt.*;

public class MenuView {

    Button [] buttonsSideBar;
    JLabel lblLogo = new JLabel();
    CustomizarView atributos = new CustomizarView();
    JPanel sidemenu = new JPanel();
    JPanel topBar = new JPanel();
    JMenuBar menuBar;
    Button buttonsTopBar[];

    public MenuView()
    {
        sidemenu.setPreferredSize(new Dimension(250,600));

        JFrame f = new JFrame();
        JPanel pnl = new JPanel();
        lblLogo.setIcon(new ImageIcon("logo.png"));
        sidemenu.setBackground(atributos.getSidemenuCor());
        lblLogo.setSize(new Dimension(150,200));
        buttonsSideBar = new Button[4];
        buttonsSideBar[0]=new Button("Venda");
        buttonsSideBar[1]=new Button("Medicamento");
        buttonsSideBar[2]=new Button("Fornecedor");
        buttonsSideBar[3]=new Button("Funcionário");

        //buttons[4]=new Button("Venda");

        buttonsTopBar = new Button[4];
        buttonsTopBar[0] = new Button("Venda");
        buttonsTopBar[1] = new Button("Medicamento");
        buttonsTopBar[2] = new Button("Fornecedor");
        buttonsTopBar[3] = new Button("Funcionário");

        sidemenu.add(lblLogo);
        for (int i = 0; i < 4; i++)
        {
            buttonsSideBar[i].setBackground(atributos.getSidemenuCor());
            buttonsSideBar[i].setForeground(Color.lightGray);
            buttonsSideBar[i].setFont(atributos.getTextoCorpo());
            topBar.add(buttonsTopBar[i]);
            sidemenu.add(buttonsSideBar[i]);
        }

        sidemenu.setLayout (new BoxLayout(sidemenu, BoxLayout.PAGE_AXIS));
        topBar.setLayout(new GridLayout(1,4));


        GridBagConstraints gbc = new GridBagConstraints();
        /*Object[] listaTopbar = new Object[4];
        listaTopbar[1] = new JLabel();*/
        menuBar = new JMenuBar();
        JMenu linha = new JMenu();
        JMenuItem []menuItems = new JMenuItem[2];
        menuItems[0] = new JMenuItem("Perfil");
        menuItems[1] = new JMenuItem("Logout");
        linha.add(menuItems[0]);
        linha.add(menuItems[1]);
        menuBar.add(linha);
        topBar.add(menuBar);

    }
}
