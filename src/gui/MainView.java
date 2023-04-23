package gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionListener;

import static sun.swing.SwingUtilities2.drawRect;

public class MainView extends JFrame {
//Initalise Components
    String guiIconCache = "src/gui/Icons/";
    String activeCard;
    int displayResolution = 0; //0 = 4k+ and 1 is less than 4k.
    int frameWidth;
    int frameHeight;
    int textFontSize;
    int btnTextSize;
    int titleFontSize;
    int homeBtnTextSize;
    JPanel mainPanel = new JPanel(new CardLayout());
    Dimension mainPanelDimension;
    Dimension returnHomeBtnDimension;
    Insets returnHomeBtnInsets;
    Dimension jobListDimension;
    Dimension vScrollBarDimension;
    Dimension hScrollBarDimension;
    Insets jobPaneInsets;
    Dimension labelDimension;
    Insets labelInsets;
    String[] ecJoblist = {"Not Implemented Yet"/*"Preliminary Site Investigation (PSI)","Detailed Site Investigation (DSI)","Remediation Action Plan (RAP)","Validation Assessment","Waste Classification", "Acid Sulfate Soils Assessment (ASSA)", "Acid Sulfate Soils Management Plan (ASSMP)"*/};
    String[] ohJoblist = {"Asbestos Air Monitoring"/*"Asbestos Clearance Certificate (ACC)","Scope of Works","HAZMAT Assessment","Asbestos Management Plan (AMP)", "Mould", "Respirable Crystalline Silica (RCS)", "Exposure Air Monitoring"*/};
    String[] rsJoblist = {"Not Implemented Yet"/*"Dewatering Management Plan (DMP)"*/};

    //Panel 1 (Discipline Selector) Components
    JPanel panel1 = new JPanel(new GridBagLayout());
    Dimension panel1BtnDimension;
    Insets panel1BtnInsets;
    ENVBtn ecBtn = new ENVBtn();
    ImageIcon ecIcon;
    ENVBtn ohBtn = new ENVBtn();
    ImageIcon ohIcon;
    ENVBtn rsBtn = new ENVBtn();
    ImageIcon rsIcon;

    //Panel 2 (Job Selector) Components
    JPanel panel2 = new JPanel(new GridBagLayout());
    DefaultListModel<String> joblistListModel = new DefaultListModel<>();
    JList<String> jobList = new JList<>(joblistListModel);
    ENVBtn returnHomeBtn = new ENVBtn();
    ENVBtn selectJobTypeBtn = new ENVBtn();

    //Menu Bar Components
    JMenuBar menuBar = new JMenuBar();
    Dimension menuBarDimension;
    Dimension menuDimensionSml;
    Dimension menuDimensionLrg;
    ENVMenu menu1;

    //Menu 1 items
    ENVMenuItem m1i1;

    //Menu 2 items

    //Menu 3 items

    //Menu 4 items

    public MainView() {

    }

    public void setGUISize() {
        if (displayResolution == 0) {
            //Global Dimensions
            frameWidth = 1200;
            frameHeight = 1400;
            textFontSize = 30;
            btnTextSize = 40;
            homeBtnTextSize = 80;
            titleFontSize = 40;
            returnHomeBtnDimension = new Dimension(300,150);
            returnHomeBtnInsets = new Insets(20,50,50,50);
            jobListDimension = new Dimension(1000,800);
            vScrollBarDimension = new Dimension(40,0);
            hScrollBarDimension = new Dimension(0,40);
            jobPaneInsets = new Insets(20,100,20,100);
            labelDimension = new Dimension(1000,50);
            labelInsets = new Insets(40,50,20,50);

            //Panel 1 (Discipline Selector) Dimensions
            mainPanelDimension = new Dimension(1000,1000);
            panel1BtnDimension = new Dimension(600,250);
            panel1BtnInsets = new Insets(50,0,50,0);
            ecIcon = new ImageIcon(guiIconCache +"ECButtonUHD.png");
            ohIcon = new ImageIcon(guiIconCache +"OHButtonUHD.png");
            rsIcon = new ImageIcon(guiIconCache +"RSButtonUHD.png");

            //Menu Bar Dimensions
            menuBarDimension = new Dimension(500,50);
            menuDimensionSml = new Dimension(75,50);
            menuDimensionLrg = new Dimension(120,50);

        } else {
            //Global Dimensions
            frameWidth = 600;
            frameHeight = 700;
            textFontSize = 15;
            btnTextSize = 20;
            homeBtnTextSize = 40;
            titleFontSize = 20;
            returnHomeBtnDimension = new Dimension(150,75);
            returnHomeBtnInsets = new Insets(10,25,25,25);
            jobListDimension = new Dimension(500,400);
            vScrollBarDimension = new Dimension(20,0);
            hScrollBarDimension = new Dimension(0,20);
            jobPaneInsets = new Insets(10,50,10,50);
            labelDimension = new Dimension(500,25);
            labelInsets = new Insets(20,25,10,25);

            //Panel 1 (Discipline Selector) Dimensions
            mainPanelDimension = new Dimension(500,500);
            panel1BtnDimension = new Dimension(300,125);
            panel1BtnInsets = new Insets(25,0,25,0);
            ecIcon = new ImageIcon(guiIconCache +"ECButtonSD.png");
            ohIcon = new ImageIcon(guiIconCache +"OHButtonSD.png");
            rsIcon = new ImageIcon(guiIconCache +"RSButtonSD.png");

            //Menu Bar Dimensions
            menuBarDimension = new Dimension(250,25);
            menuDimensionSml = new Dimension(40,25);
            menuDimensionLrg = new Dimension(60,25);

        }
    }

    public void formatPanel1() {
        //Panel 1 (Discipline Selector) format
        //initialise Panel
        panel1.setPreferredSize(mainPanelDimension);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.setBackground(Color.decode("#161616"));

        ecBtn.setPreferredSize(panel1BtnDimension);
        ecBtn.setIcon(ecIcon);
        ecBtn.setText("EC");
        ecBtn.setFont(new Font("Calibri", Font.BOLD, homeBtnTextSize));
        ecBtn.setForeground(Color.decode("#F5F5F5"));
        ecBtn.setVerticalTextPosition(JButton.CENTER);
        ecBtn.setHorizontalTextPosition(JButton.CENTER);
        ecBtn.setName("ecBtn");

        ohBtn.setPreferredSize(panel1BtnDimension);
        ohBtn.setIcon(ohIcon);
        ohBtn.setText("OH");
        ohBtn.setFont(new Font("Calibri", Font.BOLD, homeBtnTextSize));
        ohBtn.setForeground(Color.decode("#F5F5F5"));
        ohBtn.setVerticalTextPosition(JButton.CENTER);
        ohBtn.setHorizontalTextPosition(JButton.CENTER);
        ohBtn.setName("ohBtn");

        rsBtn.setPreferredSize(panel1BtnDimension);
        rsBtn.setIcon(rsIcon);
        rsBtn.setText("RS");
        rsBtn.setFont(new Font("Calibri", Font.BOLD, homeBtnTextSize));
        rsBtn.setForeground(Color.decode("#F5F5F5"));
        rsBtn.setVerticalTextPosition(JButton.CENTER);
        rsBtn.setHorizontalTextPosition(JButton.CENTER);
        rsBtn.setName("rsBtn");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = panel1BtnInsets;
        gbc.anchor = GridBagConstraints.CENTER;
        panel1.add(ecBtn, gbc);

        gbc.gridy = 1;
        panel1.add(ohBtn, gbc);

        gbc.gridy = 2;
        panel1.add(rsBtn,gbc);

    }

    public void formatPanel2() {
        //Job Selector
        //initialise Panel

        panel2.setPreferredSize(mainPanelDimension);
        panel2.setBorder(BorderFactory.createLineBorder(Color.black));
        panel2.setBackground(Color.decode("#161616"));

        JLabel jobLabel = new JLabel("Select your job type from the list below.");
        jobLabel.setForeground(Color.decode("#F5F5F5"));
        jobLabel.setFont(new Font("Calibri", Font.PLAIN, textFontSize));
        jobLabel.setPreferredSize(labelDimension);

        jobList.setBackground(Color.decode("#232323"));
        jobList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jobList.setLayoutOrientation(JList.VERTICAL);
        jobList.setFont(new Font("Calibri",Font.PLAIN, btnTextSize));
        jobList.setForeground(Color.decode("#F5F5F5"));
        jobList.setSelectionBackground(Color.decode("#454444"));
        jobList.setSelectionForeground(Color.decode("#F5F5F5"));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) jobList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        JScrollPane jobListPane = new JScrollPane(jobList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jobListPane.setPreferredSize(jobListDimension);
        jobListPane.setBorder(BorderFactory.createLineBorder(Color.black));
        JScrollBar jobListBar = jobListPane.getVerticalScrollBar();
        jobListBar.setPreferredSize(vScrollBarDimension);
        jobListBar.setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.black));
        jobListBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.decode("#43464b");
                this.thumbLightShadowColor = Color.BLACK;
                this.trackColor = Color.decode("#282a2d");
                this.trackHighlightColor = Color.BLACK;
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.decode("#43464b"));
                button.setForeground(Color.decode("#F5F5F5"));
                button.setBorder(BorderFactory.createLineBorder(Color.black));
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createIncreaseButton(orientation);
                button.setBackground(Color.decode("#43464b"));
                button.setForeground(Color.decode("#F5F5F5"));
                button.setBorder(BorderFactory.createLineBorder(Color.black));
                return button;
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
                    return;
                }

                int w = thumbBounds.width;
                int h = thumbBounds.height;

                g.translate(thumbBounds.x, thumbBounds.y);

                g.setColor(thumbLightShadowColor);
                drawRect(g, 0, 0, w - 1, h - 1);
                g.setColor(thumbColor);
                g.fillRect(1, 1, w - 2, h - 2);

                g.translate(-thumbBounds.x, -thumbBounds.y);
            }
        });

        returnHomeBtn.setPreferredSize(returnHomeBtnDimension);
        returnHomeBtn.setMinimumSize(returnHomeBtnDimension);
        returnHomeBtn.setText("Return Home");
        returnHomeBtn.setFont(new Font("Calibri", Font.BOLD, btnTextSize));
        returnHomeBtn.setForeground(Color.decode("#F5F5F5"));
        returnHomeBtn.setName("returnHome");

        selectJobTypeBtn.setPreferredSize(returnHomeBtnDimension);
        selectJobTypeBtn.setMinimumSize(returnHomeBtnDimension);
        selectJobTypeBtn.setText("Select");
        selectJobTypeBtn.setFont(new Font("Calibri", Font.BOLD, btnTextSize));
        selectJobTypeBtn.setForeground(Color.decode("#F5F5F5"));
        selectJobTypeBtn.setName("selectJobType");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.insets = labelInsets;
        gbc.anchor = GridBagConstraints.CENTER;
        panel2.add(jobLabel,gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = jobPaneInsets;
        panel2.add(jobListPane, gbc);

        gbc.gridy = 2;
        gbc.weightx = 0.5;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = returnHomeBtnInsets;
        panel2.add(returnHomeBtn, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel2.add(selectJobTypeBtn, gbc);

    }

    public void formatMenuBar() {
        //Menu Bar format
        //Menus
        menu1 = new ENVMenu("File", textFontSize);

        //Menu 1 items
        m1i1 = new ENVMenuItem("Exit", textFontSize);

        //Menu 2 items

        //Menu 3 items

        //Menu 4 items

        menu1.setPreferredSize(menuDimensionSml);
        menu1.add(m1i1);

        menuBar.add(menu1);

        menuBar.setPreferredSize(menuBarDimension);
        menuBar.setBackground(Color.decode("#232323"));
        menuBar.setBorder(BorderFactory.createLineBorder(Color.black,1));
        menu1.updateUI();
    }
    public void formatFrame() {
        //Frame format
        this.setTitle("ENV Template Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setResizable(false);

        mainPanel.setPreferredSize(mainPanelDimension);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.setBackground(Color.decode("#161616"));

        //Set App icon
        String appIcon = guiIconCache +"ENVAppIcon.png";
        ImageIcon appImage = new ImageIcon(appIcon);
        this.setIconImage(appImage.getImage());

        //add cards to main panel
        mainPanel.add(panel1, "HOME");
        mainPanel.add(panel2,"JOBS");

        //add components to frame
        this.add(mainPanel);
        this.setJMenuBar(menuBar);
    }

    public void resizeFrame() {
        this.setSize(frameWidth, frameHeight);
    }

//Sets the app Display Size
    public void  setDisplayResolution(int displaySize) {
        this.displayResolution = displaySize;
    }

//Adds action listeners to buttons
    public void addBtnListener(ActionListener listenForBtn) {

        ecBtn.addActionListener(listenForBtn);
        ohBtn.addActionListener(listenForBtn);
        rsBtn.addActionListener(listenForBtn);
        returnHomeBtn.addActionListener(listenForBtn);
        selectJobTypeBtn.addActionListener(listenForBtn);

    }

    public void setJobList(String Discipline) {

        joblistListModel.clear();
        int i = 0;

        switch (Discipline) {
            case "EC":
                for(String list : ecJoblist) {
                    if (!list.isEmpty()) {
                        joblistListModel.add(i, list);
                        i++;
                    }
                }
            break;

            case "OH":
                for(String list : ohJoblist) {
                    if (!list.isEmpty()) {
                        joblistListModel.add(i, list);
                        i++;
                    }
                }
            break;

            case "RS":
                for(String list : rsJoblist) {
                    if (!list.isEmpty()) {
                        joblistListModel.add(i, list);
                        i++;
                    }
                }
            break;
        }
        jobList.setSelectedIndex(0);
    }

    public String getSelectedJobType() {
        return jobList.getSelectedValue();
    }

    public void setDisplayCard(String displayCard) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel,displayCard);
        activeCard = displayCard;
    }

//Add menu listener
    public void addMenuListener (ActionListener menuListener) {

        m1i1.addActionListener(menuListener);

    }

}
