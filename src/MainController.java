import gui.ENVDialog;
import gui.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    public MainView theGUI;
    public ENVDialog dialog;

    public MainController(MainView theGUI, ENVDialog dialog) {

        this.theGUI = theGUI;
        this.dialog = dialog;

    }

    public void initialise() {
        //Detect Device Display Resolution and adjust GUI sizing
        double systemDisplaySize = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        if (systemDisplaySize > 2000) {
            theGUI.setDisplayResolution(0);
            dialog.setDisplayResolution(0);
            System.out.println("UHD Display Detected");
        } else {
            theGUI.setDisplayResolution(1);
            dialog.setDisplayResolution(1);
        }
        theGUI.setGUISize();
        dialog.setDialogueSize();
        dialog.setLoadingDialogueSize();

        //Display Loading Dialogue

        //Format Frame and Components
        theGUI.formatPanel1();
        theGUI.formatPanel2();
        theGUI.formatMenuBar();

        theGUI.formatFrame();

        //initalise action listeners for buttons
        theGUI.addBtnListener(new BtnListener());
        theGUI.addMenuListener(new MenuListener());
        dialog.addDlgBtnListener(new DlgBtnListener());


        //Close Loading Dialogue


        //set GUI to visible
        theGUI.pack();
        theGUI.resizeFrame();
        theGUI.setLocationRelativeTo(null);
        theGUI.setVisible(true);

    }

//determines which button in the main application was pressed and what action must be performed
    class BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String btn = ((JButton) e.getSource()).getName();

            switch (btn) {
                case "ecBtn":
                    System.out.println("EC Button Pressed");
                    theGUI.setJobList("EC");
                    theGUI.setDisplayCard("JOBS");
                break;

                case "ohBtn":
                    System.out.println("OH Button Pressed");
                    theGUI.setJobList("OH");
                    theGUI.setDisplayCard("JOBS");
                break;

                case "rsBtn":
                    System.out.println("RS Button Pressed");
                    theGUI.setJobList("RS");
                    theGUI.setDisplayCard("JOBS");
                break;

                case "returnHome":
                    System.out.println("Return Home Button Pressed");
                    theGUI.setDisplayCard("HOME");
                break;

                case "selectJobType":
                    System.out.println("Select Job Type Button Pressed");
                    if (theGUI.getSelectedJobType() != null) {
                        System.out.println("'"+theGUI.getSelectedJobType()+"' selected.");
                        jobSelectionManager(theGUI.getSelectedJobType());
                    }
                break;
            }

        }

    }

//determines which dialog button was pressed and what action must be performed
    class DlgBtnListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = ((JButton) e.getSource()).getName();

        switch (btn) {
            case "dismissBtn":
                System.out.println("Dismiss Dialogue Button Pressed");
                dialog.dispose();
            break;
        }
    }
}

//sets action to be performed when a job type is selected
    public void jobSelectionManager(String selectedJobType) {
        switch (selectedJobType) {
            case "Not Implemented Yet":
                System.out.println("Initiating '"+theGUI.getSelectedJobType()+"' template constructor.");
                dialog.noticeDialogue("This feature has not been implemented yet.");
            break;
        }
    }

class MenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());

        switch (source.getText()) {

            case "Exit":
                System.exit(0);
            break;

        }

    }

}

}
