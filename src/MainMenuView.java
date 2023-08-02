/**
 * The MainMenuView class represents the main menu view of the vending machine simulator.
 * It extends the MenuView class and provides specific configurations for the main menu.
 */
public class MainMenuView extends MenuView {

    /**
     * Constructs a new MainMenuView instance.
     * Initializes the main menu view with appropriate title and button labels.
     */
    public MainMenuView() {
        super(); // Call the constructor of the parent class (MenuView)

        // Set the title and button labels for the main menu
        getTitle().setText("VENDING SIMULATOR");
        getButton1().setText("CREATE A VENDING MACHINE");
        getButton2().setText("TEST A VENDING MACHINE");
        getButton3().setText("EXIT");
    }
}
