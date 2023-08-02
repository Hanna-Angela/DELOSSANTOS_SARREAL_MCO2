/**
 * The MainModel class represents the model for the vending machine simulator.
 * It holds the current instance of the RegularVendingMachineModel and provides access to it.
 */
public class MainModel {

    /** The current RegularVendingMachineModel instance */
    private RegularVendingMachineModel current;

    /**
     * Constructs a new MainModel instance.
     * Initializes the current instance to null.
     */
    public MainModel() {
        current = null;
    }

    /**
     * Gets the current RegularVendingMachineModel instance.
     *
     * @return The current RegularVendingMachineModel instance.
     */
    public RegularVendingMachineModel getCurrent() {
        return current;
    }

    /**
     * Sets the current RegularVendingMachineModel instance.
     *
     * @param current The RegularVendingMachineModel instance to be set as current.
     */
    public void setCurrent(RegularVendingMachineModel current) {
        this.current = current;
    }
}
