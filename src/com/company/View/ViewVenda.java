package com.company.View;

import javax.swing.*;
import java.awt.*;

public class ViewVenda extends JPanel {
    ScrollPaneLayout sp = new ScrollPaneLayout();



    public ViewVenda(){
        this.setLayout(sp);
        JPanel pnl = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        pnl.setLayout(gbl);

    }
}
