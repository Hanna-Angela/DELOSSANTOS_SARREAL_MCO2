/**
 * It is the entry point of the vending machine application.
 * Initializes the main view, main model, and main controller to start the application.
 */
public class Main {

    /**
     * The main method to start the vending machine application.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        MainView mainView = new MainView();
        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(mainModel, mainView);
    }
}
