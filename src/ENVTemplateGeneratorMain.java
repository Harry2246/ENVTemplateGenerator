import gui.ENVDialog;
import gui.MainView;

public class ENVTemplateGeneratorMain {
    public static void main(String[] args) {

        MainView theGUI = new MainView();
        ENVDialog dialog = new ENVDialog();

        MainController theController = new MainController(theGUI, dialog);

        theController.initialise();

    }

}
