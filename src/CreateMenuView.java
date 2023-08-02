/**
 * Represents the View for the Create Menu. It extends the MenuView class.
 * This screen allows the user to choose between creating a regular vending machine or a special vending machine.
 */
public class CreateMenuView extends MenuView {

    /**
     * Constructs a new CreateMenuView object. It initializes the view by setting the title and button labels.
     */
    public CreateMenuView() {
        super();

        // Set the title and button labels for the create vending machine menu
        getTitle().setText("CREATE");
        getButton1().setText("REGULAR VENDING MACHINE");
        getButton2().setText("SPECIAL VENDING MACHINE");
        getButton3().setText("BACK");
    }
}
