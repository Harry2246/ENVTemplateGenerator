package gui;

import javax.swing.*;
import java.awt.*;

public class ENVMenu extends JMenu {
    public ENVMenu(String menuName, int textSize) {
        this.setOpaque(true);
        this.setBorder(null);
        this.setBackground(Color.decode("#232323"));
        this.setForeground(Color.decode("#F5F5F5"));
        this.setFont(new Font("Calibri",Font.PLAIN,textSize));
        this.setText(menuName);
        this.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.black));
        UIManager.put("MenuItem.selectionBackground", Color.decode("#43464b"));
        UIManager.put("MenuItem.selectionForeground",Color.decode("#F5F5F5"));
        UIManager.put("Menu.selectionBackground",Color.decode("#43464b"));
        UIManager.put("Menu.selectionForeground",Color.decode("#F5F5F5"));

    }
}
