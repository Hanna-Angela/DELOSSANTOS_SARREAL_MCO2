import java.awt.event.ActionListener;

/**
 * The MaintenanceMenuView class represents the maintenance menu view of the vending machine simulator.
 * It extends the MenuView class and provides specific configurations for the maintenance menu.
 */
public class MaintenanceMenuView extends MenuView {

    /** The button for displaying the summary of transactions. */
    private final Button button5;

    /** The button for going back to the previous menu. */
    private final Button button6;

    /**
     * Constructs a new MaintenanceMenuView instance.
     * Initializes the maintenance menu view with appropriate title, button labels, and additional buttons.
     */
    public MaintenanceMenuView() {
        super(); // Call the constructor of the parent class (MenuView)

        // Set the title and button labels for the maintenance menu
        getTitle().setText("MAINTENANCE");
        getButton1().setText("RESTOCK/STOCK ITEM");
        getButton2().setText("SET PRICE");
        getButton3().setText("REPLENISH MONEY");

        // Create and add additional buttons to the panel
        button5 = new Button("SUMMARY OF TRANSACTIONS", DesignKit.white, DesignKit.darkPurple, DesignKit.buttonFont, 400, 50);
        button6 = new Button("BACK", DesignKit.white, DesignKit.darkPurple, DesignKit.buttonFont, 400, 50);

        getPanel().add(button5, getConstraints());
        getPanel().add(button6, getConstraints());
    }

    /**
     * Sets the ActionListener for the button that displays the summary of transactions.
     *
     * @param actionListener The ActionListener to be set for the button.
     */
    public void setButton5Listener(ActionListener actionListener) {
        this.button5.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the button that goes back to the previous menu.
     *
     * @param actionListener The ActionListener to be set for the button.
     */
    public void setButton6Listener(ActionListener actionListener) {
        this.button6.addActionListener(actionListener);
    }

}
