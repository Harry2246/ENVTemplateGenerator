package gui;

import javax.swing.*;
import java.awt.*;

public class ENVMenuItem extends JMenuItem {
    public ENVMenuItem(String menuItemName, int textSize) {
        this.setBackground(Color.decode("#232323"));
        this.setForeground(Color.decode("#F5F5F5"));
        this.setFont(new Font("Calibri",Font.PLAIN,textSize));
        this.setText(menuItemName);
        this.setBorder(null);
    }

}
