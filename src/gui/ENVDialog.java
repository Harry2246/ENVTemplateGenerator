package gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class ENVDialog extends JDialog{
    //initialise Components
    //Initiate Universal Components
    int textFontSize;
    int titleFontSize;
    int btnTextSize;
    Dimension btnDimension;
    Insets btn1Insets;
    Insets btn2Insets;
    ENVTextStyle txtStyle;
    JTextPane dlgText = new JTextPane();
    Dimension textDimension1L;
    Dimension textDimension2L;
    Insets dlgTextInsets;
    Dimension vScrollBarDimension;
    GridBagConstraints dGBC = new GridBagConstraints();
    ENVBtn cancelBtn = new ENVBtn();
    int displayResolution = 0; //0 = 4k+ and 1 is less than 4k.

    //Initiate notice dialogue components
    JPanel noticePanel = new JPanel(new GridBagLayout());
    Dimension noticePanelDimension;
    Insets noticeTextInsets;
    Insets noticeBtnInsets;

    //initialise loading dialogue components
    JPanel loadingPanel = new JPanel(new GridBagLayout());
    int loadingDialogueWidth;
    int loadingDialogueHeight;
    JProgressBar loadingBar = new JProgressBar();
    Dimension loadingBarDimension;
    Insets loadingBarInsets;
    String sbIcon;
    Dimension iconDimension;
    Insets iconInsets;
    Dimension sbTitleDimension;
    int sbTitleFontSize;
    Insets sbTitleInsets;
    JTextPane statusText = new JTextPane();
    Dimension statusTextDimension;
    int loadingDialogueTextSize;
    Insets statusTextInsets;

    public void setDialogueSize() {
        if (displayResolution == 0) {
            //Universal Components
            textFontSize = 30;
            titleFontSize = 40;
            txtStyle = new ENVTextStyle(textFontSize);
            textDimension1L = new Dimension(700,40);
            textDimension2L = new Dimension(700,80);
            dlgTextInsets = new Insets(10,20,10,20);
            btnTextSize = 36;
            btnDimension = new Dimension(200,80);
            btn1Insets = new Insets(20,50,10,25);
            btn2Insets = new Insets(20,25,10,50);
            vScrollBarDimension = new Dimension(40,0);

            //NoticeDialogue
            noticePanelDimension = new Dimension(750,250);
            noticeTextInsets = new Insets(10,10,10,10);
            noticeBtnInsets = new Insets(25,10,10,10);

        }else {
            //Universal Components
            textFontSize = 15;
            titleFontSize = 20;
            txtStyle = new ENVTextStyle(textFontSize);
            textDimension1L = new Dimension(350,20);
            textDimension2L = new Dimension(350,40);
            dlgTextInsets = new Insets(5,10,5,10);
            btnTextSize = 18;
            btnDimension = new Dimension(100,40);
            btn1Insets = new Insets(10,25,5,13);
            btn2Insets = new Insets(10,13,5,25);
            vScrollBarDimension = new Dimension(20,0);

            //NoticeDialogue
            noticePanelDimension = new Dimension(375,125);
            noticeTextInsets = new Insets(5,5,5,5);
            noticeBtnInsets = new Insets(13,5,5,5);
        }
    }

    //Dialogue for displaying messages
    public void noticeDialogue (String message) {
        //Set dialogue pane format
        noticePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder()));
        noticePanel.setBackground(Color.decode("#36383c"));

        //Set label format
        dlgText.setPreferredSize(textDimension2L);
        dlgText.setBackground(Color.decode("#36383c"));
        StyledDocument doc = dlgText.getStyledDocument();
        dlgText.setText(message);
        doc.setParagraphAttributes(0,doc.getLength(),txtStyle,true);
        dlgText.setEditable(false);

        //Set button format
        cancelBtn.setText("Ok");
        cancelBtn.setPreferredSize(btnDimension);
        cancelBtn.setFont(new Font("Calibri",Font.PLAIN, btnTextSize));
        cancelBtn.setName("dismissBtn");

        //Add components to panel

        dGBC.gridx = 0;
        dGBC.gridy = 0;
        dGBC.gridwidth = 1;
        dGBC.insets = noticeTextInsets;
        dGBC.anchor = GridBagConstraints.CENTER;
        noticePanel.add(dlgText, dGBC);

        dGBC.gridy = 1;
        dGBC.insets = noticeBtnInsets;
        noticePanel.add(cancelBtn, dGBC);

        //Add panel to dialogue pane, format and set to visible
        this.setContentPane(noticePanel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(noticePanelDimension);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.pack();
        this.setVisible(true);
    }

    //Loading Dialogue
    public void loadingDialogue () {
        loadingPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLoweredBevelBorder()));
        loadingPanel.setBackground(Color.decode("#36383c"));

        //Set icon format
        JLabel icon = new JLabel(new ImageIcon(sbIcon));
        icon.setPreferredSize(iconDimension);

        JTextPane sbTitle = new JTextPane();
        sbTitle.setPreferredSize(sbTitleDimension);
        sbTitle.setBackground(Color.decode("#36383c"));
        sbTitle.setEditable(false);
        StyledDocument sbTitleDoc = sbTitle.getStyledDocument();
        SimpleAttributeSet sbTitleAtr = new SimpleAttributeSet();
        StyleConstants.setBackground(sbTitleAtr, Color.decode("#36383c"));
        StyleConstants.setForeground(sbTitleAtr, Color.decode("#F5F5F5"));
        StyleConstants.setFontFamily(sbTitleAtr, "Arial");
        StyleConstants.setFontSize(sbTitleAtr, sbTitleFontSize);
        sbTitleDoc.setParagraphAttributes(0,sbTitleDoc.getLength(),sbTitleAtr,true);
        try {
            sbTitleDoc.insertString(0,"STOCK",sbTitleAtr);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        StyleConstants.setBold(sbTitleAtr,true);
        try {
            sbTitleDoc.insertString(sbTitleDoc.getLength(),"BOT",sbTitleAtr);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        //Set status text format
        statusText.setPreferredSize(statusTextDimension);
        statusText.setBackground(Color.decode("#36383c"));
        StyledDocument doc = statusText.getStyledDocument();
        ENVTextStyle statusStyle = new ENVTextStyle(loadingDialogueTextSize);
        StyleConstants.setAlignment(statusStyle,StyleConstants.ALIGN_LEFT);
        doc.setParagraphAttributes(0,doc.getLength(),statusStyle,true);
        statusText.setEditable(false);

        //Set loading bar format
        loadingBar.setMinimum(0);
        loadingBar.setMaximum(8);
        loadingBar.setBackground(Color.decode("#282a2d"));
        loadingBar.setForeground(Color.decode("#43464b"));
        loadingBar.setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() { return Color.decode("#F5F5F5"); }
            protected Color getSelectionForeground() { return Color.black; }
        });
        loadingBar.setFont(new Font("Calibri",Font.BOLD, loadingDialogueTextSize));
        loadingBar.setBorder(BorderFactory.createLineBorder(Color.black));
        loadingBar.setBorderPainted(false);
        loadingBar.setStringPainted(true);
        loadingBar.setPreferredSize(loadingBarDimension);

        //Add components to panel
        dGBC.gridx = 0;
        dGBC.gridy = 0;
        dGBC.gridwidth = 1;
        dGBC.insets = iconInsets;
        dGBC.weightx = 0;
        dGBC.weighty = 0.3;
        dGBC.anchor = GridBagConstraints.LINE_START;
        loadingPanel.add(icon, dGBC);

        dGBC.gridx = 1;
        dGBC.weightx = 1;
        dGBC.insets = sbTitleInsets;
        dGBC.anchor = GridBagConstraints.FIRST_LINE_START;
        loadingPanel.add(sbTitle, dGBC);

        dGBC.gridy = 1;
        dGBC.gridx = 0;
        dGBC.weighty = 0.3;
        dGBC.insets = loadingBarInsets;
        dGBC.gridwidth = 2;
        dGBC.anchor = GridBagConstraints.LINE_START;
        loadingPanel.add(loadingBar, dGBC);

        dGBC.gridy = 2;
        dGBC.weighty = 0.4;
        dGBC.insets = statusTextInsets;
        dGBC.anchor = GridBagConstraints.FIRST_LINE_START;
        loadingPanel.add(statusText, dGBC);

        //Add panel to dialogue pane, format and set to visible
        this.setContentPane(loadingPanel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(loadingDialogueWidth, loadingDialogueHeight);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    //Add dialogue button listener
    public void addDlgBtnListener(ActionListener listenForDlgBtn) {

        cancelBtn.addActionListener(listenForDlgBtn);

    }

    //Sets the app Display Size
    public void  setDisplayResolution(int displaySize) {
        this.displayResolution = displaySize;
    }

    //Sets the Loading Dialogue Size
    public void setLoadingDialogueSize() {
        if (displayResolution == 0) {
            sbIcon = "src/Data/GUI/Icons/SBIconMed.png";
            iconDimension = new Dimension(150,150);
            sbTitleDimension = new Dimension(570,100);
            sbTitleFontSize = 100;
            statusTextDimension = new Dimension(700,80);
            loadingDialogueTextSize = 30;
            loadingBarDimension = new Dimension(770,35);
            iconInsets = new Insets(10,10,10,5);
            sbTitleInsets = new Insets(10,5,10,10);
            loadingBarInsets = new Insets(10,25,10,25);
            statusTextInsets = new Insets(10,25,10,10);
            loadingDialogueWidth = 850;
            loadingDialogueHeight = 350;
        } else {
            sbIcon = "src/Data/GUI/Icons/SBIconSml.png";
            iconDimension = new Dimension(75,75);
            sbTitleDimension = new Dimension(285,55);
            sbTitleFontSize = 50;
            statusTextDimension = new Dimension(350,40);
            loadingDialogueTextSize = 15;
            loadingBarDimension = new Dimension(385,20);
            iconInsets = new Insets(5,5,5,3);
            sbTitleInsets = new Insets(5,3,5,5);
            loadingBarInsets = new Insets(5,13,5,13);
            statusTextInsets = new Insets(5,13,5,5);
            loadingDialogueWidth = 425;
            loadingDialogueHeight = 175;
        }
    }

    //Sets the status text
    public void setStatusText (String status) {
        statusText.setText(status);
    }

    //Sets the progress bar
    public void setProgress (int progress) {
        loadingBar.setValue(progress);
    }

}
