package com.company.View;

import com.company.View.CustomizarView;

import javax.swing.*;
import java.awt.*;

public class MenuView {

    Button []buttons;
    JLabel lblLogo = new JLabel();
    CustomizarView atributos = new CustomizarView();
    JPanel sidemenu = new JPanel();
    JPanel topBar = new JPanel();
    JMenuBar menuBar;

    public MenuView()
    {
        sidemenu.setPreferredSize(new Dimension(250,600));
        sidemenu.setBackground(Color.green);
        JFrame f = new JFrame();
        JPanel pnl = new JPanel();
        lblLogo.setIcon(new ImageIcon("logo.png"));
        sidemenu.setBackground(atributos.getSidemenuCor());
        lblLogo.setSize(new Dimension(150,200));
        buttons = new Button[4];
        buttons[0]=new Button("Venda");
        buttons[1]=new Button("Medicamento");
        buttons[2]=new Button("Fornecedor");
        buttons[3]=new Button("Funcionário");
        //buttons[4]=new Button("Venda");


        sidemenu.add(lblLogo);
        for (int i = 0; i < 4; i++)
        {
            sidemenu.add(buttons[i]);
        }

        sidemenu.setLayout (new BoxLayout(sidemenu, BoxLayout.PAGE_AXIS));

        topBar.setLayout(new GridBagLayout());

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
