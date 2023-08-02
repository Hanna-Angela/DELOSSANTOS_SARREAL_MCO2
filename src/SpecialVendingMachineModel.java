import java.util.ArrayList;

/**
 * A model class representing the special vending machine.
 * This class extends the RegularVendingMachineModel and adds additional functionalities
 * specific to the special vending machine, such as tracking purchases of cakes, icing, and toppings
 * and enabling cake creation based on specific item choices.
 */
public class SpecialVendingMachineModel extends RegularVendingMachineModel{
    /** Flag to track whether a cake has been bought */
    private boolean boughtCake;

    /** Flag to track whether icing has been bought */
    private boolean boughtIcing;

    /** Flag to indicate whether all required items are bought to create a cake */
    private boolean createCake;

    /** List to store items representing icing (codeChoice = 9) */
    private ArrayList<Item> item9List;

    /** List to store the user's selected item choices */
    private final ArrayList<Item> itemChoices;

     /** List to store the names of selected toppings */
    private ArrayList<String> toppings;

    /**
     * Constructor for the SpecialVendingMachineModel class.
     * Initializes the special vending machine model with specific items and flags.
     */
    public SpecialVendingMachineModel(){
        super();

        getItems()[8] = new Item("Icing", 20, 50);
        item9List = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            item9List.add(getItems()[8]);
        getListOfItemLists().add(item9List);

        boughtIcing = false;
        boughtCake = false;
        createCake = false;
        toppings = new ArrayList<>();
        itemChoices = new ArrayList<>();
    }

    /**
     * Get the flag indicating whether a cake has been bought.
     *
     * @return true if a cake has been bought; otherwise, false.
     */
    public boolean getBoughtCake() {
        return boughtCake;
    }

    /**
     * Get the flag indicating whether icing has been bought.
     *
     * @return true if icing has been bought; otherwise, false.
     */
    public boolean getBoughtIcing() {
        return boughtIcing;
    }

    /**
     * Get the flag indicating whether all required items are bought to create a cake.
     *
     * @return true if all required items are bought to create a cake; otherwise, false.
     */
    public boolean getCreateCake() {
        return createCake;
    }

    /**
     * Get the list of names of selected toppings for cake creation.
     *
     * @return the list of selected toppings.
     */
    public ArrayList<String> getToppings() {
        return toppings;
    }

    /**
     * Get the list of selected item choices by the user.
     *
     * @return the list of selected item choices.
     */
    public ArrayList<Item> getItemChoices() {
        return itemChoices;
    }

    /**
     * Set the flag indicating whether a cake has been bought.
     *
     * @param boughtCake true if a cake has been bought; otherwise, false.
     */
    public void setBoughtCake(boolean boughtCake) {
        this.boughtCake = boughtCake;
    }

    /**
     * Set the flag indicating whether icing has been bought.
     *
     * @param boughtIcing true if icing has been bought; otherwise, false.
     */
    public void setBoughtIcing(boolean boughtIcing) {
        this.boughtIcing = boughtIcing;
    }

    /**
     * Set the flag indicating whether all required items are bought to create a cake.
     *
     * @param createCake true if all required items are bought to create a cake; otherwise, false.
     */
    public void setCreateCake(boolean createCake) {
        this.createCake = createCake;
    }
}


