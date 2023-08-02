import java.util.ArrayList;

public class RegularVendingMachineModel {
    /** list of items */
    private Item[] items;
    private ArrayList<Item> item1List;
    private ArrayList<Item> item2List;
    private ArrayList<Item> item3List;
    private ArrayList<Item> item4List;
    private ArrayList<Item> item5List;
    private ArrayList<Item> item6List;
    private ArrayList<Item> item7List;
    private ArrayList<Item> item8List;
    private ArrayList<ArrayList<Item>> listOfItemLists;

    private MoneyCompartment moneyCompartment;
    private String denominations;
    private int change;
    private int totalPayment;
    private int totalAmountDue;
    private int codeChoice;

    private int tempOne;
    private int tempFive;
    private int tempTen;
    private int tempTwenty;
    private int tempFifty;
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

    public Item getItem(int choice){
        return items[choice-1];
    }

    public Item[] getItems(){
        return items;
    }

    public ArrayList<ArrayList<Item>> getListOfItemLists(){
        return listOfItemLists;
    }

    public ArrayList<Item> getItemList(int choice){
        return listOfItemLists.get(choice-1);
    }

    public void removeItem(int choice){
        listOfItemLists.get(choice-1).remove(0);
        getItem(choice).setQuantity(-1);
    }


    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        if (totalPayment == 0)
            this.totalPayment = 0;
        else
            this.totalPayment += totalPayment;
    }

    public int getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(int totalAmountDue) {
        if (totalAmountDue == 0)
            this.totalAmountDue = 0;
        else
            this.totalAmountDue += totalAmountDue;
    }

    public MoneyCompartment getMoneyCompartment() {
        return moneyCompartment;
    }

    public String getDenominations() {
        return denominations;
    }

    public void setDenominations(String denominations) {
        this.denominations = denominations;
    }

    public int getCodeChoice() {
        return codeChoice;
    }

    public void setCodeChoice(int codeChoice) {
        this.codeChoice = codeChoice;
    }

    public void setTempOne(int tempOne) {
        this.tempOne += tempOne;
    }

    public void setTempFive(int tempFive) {
        this.tempFive += tempFive;
    }

    public void setTempTen(int tempTen) {
        this.tempTen += tempTen;
    }

    public void setTempTwenty(int tempTwenty) {
        this.tempTwenty += tempTwenty;
    }

    public void setTempFifty(int tempFifty) {
        this.tempFifty += tempFifty;
    }

    public void setTempHundred(int tempHundred) {
        this.tempHundred += tempHundred;
    }
}
