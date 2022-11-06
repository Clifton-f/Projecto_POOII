package com.company.View;

import com.company.View.CustomizarView;

import javax.swing.*;
import java.awt.*;

public class MenuView {

    Button []buttons;
    JLabel lblLogo = new JLabel();
    CustomizarView atributos = new CustomizarView();
    JPanel sidemenu = new JPanel();
    JPanel TopBar = new JPanel();

    public MenuView()
    {
        sidemenu.setPreferredSize(new Dimension(250,600));
        sidemenu.setBackground(Color.green);
        JFrame f = new JFrame();
        JPanel pnl = new JPanel();
        lblLogo.setIcon(new ImageIcon("logo.png"));
        sidemenu.setBackground(atributos.getSidemenuCor());
        lblLogo.setSize(new Dimension(150,200));
        buttons = new Button[5];
        buttons[0]=new Button("Venda");
        buttons[1]=new Button("Medicamento");
        buttons[2]=new Button("Fornecedor");
        buttons[3]=new Button("Funcionário");
        buttons[4]=new Button("Venda");


        sidemenu.add(lblLogo);
        for (int i = 0; i < 5; i++)
        {
            sidemenu.add(buttons[i]);
        }

        sidemenu.setLayout (new BoxLayout(sidemenu, BoxLayout.PAGE_AXIS));

    }
}
