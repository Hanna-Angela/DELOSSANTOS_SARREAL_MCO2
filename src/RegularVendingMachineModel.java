import java.util.ArrayList;

/**
 * A model class representing the regular vending machine.
 * This class holds the items and the money compartment for the vending machine.
 */
public class RegularVendingMachineModel {
    /** list of items */
    private Item[] items;

    /** An ArrayList of Item objects representing a list of items for item1. */
    private ArrayList<Item> item1List;

    /** An ArrayList of Item objects representing a list of items for item2. */
    private ArrayList<Item> item2List;

    /** An ArrayList of Item objects representing a list of items for item3. */
    private ArrayList<Item> item3List;

    /** An ArrayList of Item objects representing a list of items for item4. */
    private ArrayList<Item> item4List;

    /** An ArrayList of Item objects representing a list of items for item5. */
    private ArrayList<Item> item5List;

    /** An ArrayList of Item objects representing a list of items for item6. */
    private ArrayList<Item> item6List;

    /** An ArrayList of Item objects representing a list of items for item7. */
    private ArrayList<Item> item7List;

    /** An ArrayList of Item objects representing a list of items for item8. */
    private ArrayList<Item> item8List;

    /** An ArrayList of all the item lists. */
    private ArrayList<ArrayList<Item>> listOfItemLists;


    /**The MoneyCompartment object representing the money in the application */
    private MoneyCompartment moneyCompartment;

    /** String representing the denominations to be given as change */
    private String denominations;

    /** Integer representing the change */
    private int change;

    /** Integer representing the totalPayment */
    private int totalPayment;

    /** Integer representing the totalAmountDue */
    private int totalAmountDue;

    /** User choice */
    private int codeChoice;


    /** Stores how many One peso coins the user inputted as payment */
    private int tempOne;

    /** Stores how many Five peso coins the user inputted as payment */
    private int tempFive;

    /** Stores how many Ten peso coins the user inputted as payment */
    private int tempTen;

    /** Stores how many Twenty peso bills the user inputted as payment */
    private int tempTwenty;

    /** Stores how many Fifty peso bills the user inputted as payment */
    private int tempFifty;

    /** Stores how many Hundred peso bills the user inputted as payment */
    private int tempHundred;

    /**
     * This constructor creates all the items for the vending machine.
     */
    public RegularVendingMachineModel(){
        Item.setItemIds(1);

        items = new Item[9];
        items[0] = new Item("Vanilla cake", 150,275); //1
        items[1] = new Item("Strawberry cake", 150, 275); //2
        items[2] = new Item("Chocolate cake", 150, 275); //3
        items[3] = new Item("Pocky", 45, 196); //4
        items[4] = new Item("Ferrero Rocher", 50, 220); //5
        items[5] = new Item("Macaron", 50, 275); //6
        items[6] = new Item("Oreo",20, 139); //7
        items[7] = new Item("Strawberry", 40, 100); //8

        item1List = new ArrayList<>();
        item2List = new ArrayList<>();
        item3List = new ArrayList<>();
        item4List = new ArrayList<>();
        item5List = new ArrayList<>();
        item6List = new ArrayList<>();
        item7List = new ArrayList<>();
        item8List = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            item1List.add(items[0]);
            item2List.add(items[1]);
            item3List.add(items[2]);
            item4List.add(items[3]);
            item5List.add(items[4]);
            item6List.add(items[5]);
            item7List.add(items[6]);
            item8List.add(items[7]);
        }

        listOfItemLists = new ArrayList<>();
        listOfItemLists.add(item1List);
        listOfItemLists.add(item2List);
        listOfItemLists.add(item3List);
        listOfItemLists.add(item4List);
        listOfItemLists.add(item5List);
        listOfItemLists.add(item6List);
        listOfItemLists.add(item7List);
        listOfItemLists.add(item8List);

        moneyCompartment = new MoneyCompartment();
        denominations = null;
        totalPayment = 0;
        totalAmountDue = 0;
        codeChoice = 0;
        change = 0;

        tempOne = 0;
        tempFive = 0;
        tempTen = 0;
        tempTwenty = 0;
        tempFifty = 0;
        tempHundred = 0;
    }

    /**
     * Calculates the change to be returned to the customer after a transaction.
     * Updates the denominations of the money compartment if the input is valid.
     *
     * @return The calculated change, or -1 if the input is invalid.
     */
    protected int change() {
        change = totalPayment - totalAmountDue;
        denominations = moneyCompartment.denominations(change);

        // if given amount is exact
        if (totalPayment == totalAmountDue && totalAmountDue != 0 )
            change = 0;

            // if input is invalid
        else if (denominations.equals("-1"))
            change = -1;

            // adds the payment to the money compartment if input is valid
        else {
            if (tempOne > 0) {
                moneyCompartment.setOne(moneyCompartment.getOne() + tempOne);
                tempOne = 0;
            }
            if (tempFive > 0) {
                moneyCompartment.setFive(moneyCompartment.getFive() + tempFive);
                tempFive = 0;
            }
            if (tempTen > 0) {
                moneyCompartment.setTen(moneyCompartment.getTen() + tempTen);
                tempTen = 0;
            }
            if (tempTwenty > 0) {
                moneyCompartment.setTwenty(moneyCompartment.getTwenty() + tempTwenty);
                tempTwenty = 0;
            }
            if (tempFifty > 0) {
                moneyCompartment.setFifty(moneyCompartment.getFifty() + tempFifty);
                tempFifty = 0;
            }
            if (tempHundred > 0) {
                moneyCompartment.setHundred(moneyCompartment.getHundred() + tempHundred);
                tempHundred = 0;
            }
        }
        return change;
    }


    /**
     * Retrieves the Item object from the specified choice in the items array.
     *
     * @param choice The choice representing the item index (1-based).
     * @return The selected Item object.
     */
    public Item getItem(int choice){
        return items[choice-1];
    }

    /**
     * Retrieves the array of Item objects containing available items.
     *
     * @return The array of Item objects.
     */
    public Item[] getItems(){
        return items;
    }

    /**
     * Retrieves the list of lists of Item objects containing items for various groups.
     *
     * @return The list of lists of Item objects.
     */
    public ArrayList<ArrayList<Item>> getListOfItemLists(){
        return listOfItemLists;
    }

    /**
     * Retrieves the list of Item objects from the specified group choice.
     *
     * @param choice The choice representing the group index (1-based).
     * @return The list of Item objects corresponding to the group.
     */
    public ArrayList<Item> getItemList(int choice){
        return listOfItemLists.get(choice-1);
    }

    /**
     * Removes the first item from the list corresponding to the specified choice.
     * Also updates the quantity of the item to -1, indicating its removal.
     *
     * @param choice The choice representing the group index (1-based).
     */
    public void removeItem(int choice){
        listOfItemLists.get(choice-1).remove(0);
        getItem(choice).setQuantity(-1);
    }

    /**
     * Retrieves the total payment amount made in the transaction.
     *
     * @return The total payment amount.
     */
    public int getTotalPayment() {
        return totalPayment;
    }

    /**
     * Sets the total payment amount for the current transaction.
     * If the input is 0, it sets the total payment to 0; otherwise, it adds to the existing total.
     *
     * @param totalPayment The additional payment amount to be added to the total.
     */
    public void setTotalPayment(int totalPayment) {
        if (totalPayment == 0)
            this.totalPayment = 0;
        else
            this.totalPayment += totalPayment;
    }

    /**
     * Retrieves the total amount due for the current transaction.
     *
     * @return The total amount due.
     */
    public int getTotalAmountDue() {
        return totalAmountDue;
    }

    /**
     * Sets the total amount due for the current transaction.
     * If the input is 0, it sets the total amount due to 0; otherwise, it adds to the existing total.
     *
     * @param totalAmountDue The additional amount due to be added to the total.
     */
    public void setTotalAmountDue(int totalAmountDue) {
        if (totalAmountDue == 0)
            this.totalAmountDue = 0;
        else
            this.totalAmountDue += totalAmountDue;
    }

    /**
     * Retrieves the MoneyCompartment object representing the available money in the system.
     *
     * @return The MoneyCompartment object.
     */
    public MoneyCompartment getMoneyCompartment() {
        return moneyCompartment;
    }

    /**
     * Retrieves the string representing the denominations of the available money in the system.
     *
     * @return The denominations as a string.
     */
    public String getDenominations() {
        return denominations;
    }

    /**
     * Sets the denominations of the available money in the system.
     *
     * @param denominations The string representing the new denominations to set.
     */
    public void setDenominations(String denominations) {
        this.denominations = denominations;
    }

    /**
     * Retrieves the code choice made during a transaction.
     *
     * @return The code choice.
     */
    public int getCodeChoice() {
        return codeChoice;
    }

    /**
     * Sets the code choice made during a transaction.
     *
     * @param codeChoice The new code choice to set.
     */
    public void setCodeChoice(int codeChoice) {
        this.codeChoice = codeChoice;
    }

    /**
     * Increments the temporary variable for the one peso denomination by the specified amount.
     *
     * @param tempOne The amount to increment the one peso denomination by.
     */
    public void setTempOne(int tempOne) {
        this.tempOne += tempOne;
    }

    /**
     * Increments the temporary variable for the five peso denomination by the specified amount.
     *
     * @param tempFive The amount to increment the five peso denomination by.
     */
    public void setTempFive(int tempFive) {
        this.tempFive += tempFive;
    }

    /**
     * Increments the temporary variable for the ten peso denomination by the specified amount.
     *
     * @param tempTen The amount to increment the  ten peso denomination by.
     */
    public void setTempTen(int tempTen) {
        this.tempTen += tempTen;
    }

    /**
     * Increments the temporary variable for the twenty peso denomination by the specified amount.
     *
     * @param tempTwenty The amount to increment the twenty peso denomination by.
     */
    public void setTempTwenty(int tempTwenty) {
        this.tempTwenty += tempTwenty;
    }

    /**
     * Increments the temporary variable for the fifty peso denomination by the specified amount.
     *
     * @param tempFifty The amount to increment the  fifty peso denomination by.
     */
    public void setTempFifty(int tempFifty) {
        this.tempFifty += tempFifty;
    }

    /**
     * Increments the temporary variable for the hundred peso denomination by the specified amount.
     *
     * @param tempHundred The amount to increment the hundred peso denomination by.
     */
    public void setTempHundred(int tempHundred) {
        this.tempHundred += tempHundred;
    }
}
