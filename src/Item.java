/**
 * This class represents an item.
 */
public class Item {

    /** name of the item */
    private String name;

    /** id that updates everytime a new item is initialized */
    private static int itemIds = 1;

    /** id of the item */
    private final int id;

    /** price of the item */
    private int price;

    /** quantity of the item after restock */
    private int startingQuantity;

    /** quantity of the item */
    private int quantity;

    /** calories of the item */
    private int calories;

    /**
     * This constructor initializes a new item.
     *
     * @param name name of the item
     * @param price price of the item
     * @param calories calories of the item
     */
    public Item(String name, int price, int calories){
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.startingQuantity = 10;
        this.quantity = 10;
        id = itemIds;
        itemIds++;
    }

    /**
     * This method changes the name of the item.
     *
     * @param name new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets the name of the item.
     *
     * @return name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the id of the item.
     *
     * @return id of the item
     */
    public int getId() {
        return id;
    }

    /**
     * This method gets the price of the item.
     *
     * @return price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method changes the price of the item.
     *
     * @param price new price of the item
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This method gets the starting quantity of the item.
     *
     * @return starting quantity of the item
     */
    public int getStartingQuantity() {
        return startingQuantity;
    }

    /**
     * This method changes the value for startingQuantity.
     *
     * @param quantity quantity to be added
     */
    public void setStartingQuantity(int quantity) {
        this.startingQuantity = quantity;
    }

    /**
     * This method gets the quantity of the item.
     *
     * @return quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method changes the value for quantity.
     *
     * @param quantity quantity to be added
     */
    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    /**
     * This method changes the calories of the item.
     *
     * @param calories new calories of the item
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * This method gets the calories of the item.
     *
     * @return calories of the item
     */
    public int getCalories() {
        return calories;
    }

    /**
     * This method changes the item ID of the item.
     *
     * @param itemIds ID of the item
     */
    public static void setItemIds(int itemIds) {
        Item.itemIds = itemIds;
    }
}
