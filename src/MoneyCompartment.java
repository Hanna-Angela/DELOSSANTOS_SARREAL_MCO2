import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;
/**
 * This class stores the different denominations.
 */
public class MoneyCompartment {
    /** amount of one peso */
    private int one;

    /** amount of five pesos */
    private int five;

    /** amount of ten pesos */
    private int ten;

    /** amount of twenty peso bills */
    private int twenty;

    /** amount of fifty peso bills */
    private int fifty;

    /** amount of one hundred peso bills */
    private int hundred;

    /**
     * This constructor assigns each denomination to a starting quantity of 10 each.
     */
    public MoneyCompartment() {
        this.one = 100;
        this.five = 100;
        this.ten = 100;
        this.twenty = 100;
        this.fifty = 100;
        this.hundred = 100;
    }

    /**
     * This method gets the amount of one peso
     *
     * @return amount of one peso
     */
    public int getOne() {
        return one;
    }

    /**
     * This method changes the amount of one peso
     *
     * @param one amount of one peso
     */
    public void setOne(int one) {
        this.one = one;
    }

    /**
     * This method gets the amount of five pesos
     *
     * @return amount of five pesos
     */
    public int getFive() {
        return five;
    }

    /**
     * This method changes the amount of five pesos
     *
     * @param five amount of five pesos
     */
    public void setFive(int five) {
        this.five = five;
    }

    /**
     * This method gets the amount of ten pesos
     *
     * @return amount of ten pesos
     */
    public int getTen() {
        return ten;
    }

    /**
     * This method changes the amount of ten pesos
     *
     * @param ten amount of ten pesos
     */
    public void setTen(int ten) {
        this.ten = ten;
    }

    /**
     * This method gets the amount of twenty peso bills
     *
     * @return amount of twenty peso bills
     */
    public int getTwenty() {
        return twenty;
    }

    /**
     * This method changes the amount of twenty peso bills
     *
     * @param twenty amount of twenty peso bills
     */
    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    /**
     * This method gets the amount of fifty peso bills
     *
     * @return amount of fifty peso bills
     */
    public int getFifty() {
        return fifty;
    }

    /**
     * This method changes the amount of fifty peso bills
     *
     * @param fifty amount of fifty peso bills
     */
    public void setFifty(int fifty) {
        this.fifty = fifty;
    }

    /**
     * This method gets the amount of one hundred peso bills
     *
     * @return amount of one hundred peso bills
     */
    public int getHundred() {
        return hundred;
    }

    /**
     * This method changes the amount of one hundred peso bills
     *
     * @param hundred amount of one hundred peso bills
     */
    public void setHundred(int hundred) {
        this.hundred = hundred;
    }

    /**
     * This method calculates the denominations to be given as change for the provided amount.
     *
     * @param change The amount of change to be given.
     * @return A list of ImageIcon objects representing the denominations to be given as change.
     */
    public List<ImageIcon> displayDenominations(int change) {
        List<ImageIcon> denominationIcons = new ArrayList<>();

        int one;
        int five;
        int ten;
        int twenty;
        int fifty;
        int hundred;
        int modHundred;

        hundred = change / 100; //gets the amount of 100 peso bills in the change
        modHundred = change % 100; //checks if there is excess change that can be further divided into smaller denominations
        if (hundred > 0) { // checks if the change to be given will contain 100pesos
            if (hundred <= this.hundred) { // checks if there is available denominations to give
                ImageIcon hundredIcon = new ImageIcon("resources/BILLS/100.PNG");
                denominationIcons.add(hundredIcon);
            } else {
                return denominationIcons;
            }
        }

        if (modHundred > 0) { // checks from the previous calculation if the excess change can be divided to the next smaller denomination
            fifty = modHundred / 50;
            modHundred %= 50;
            if (fifty > 0) {
                if (fifty <= this.fifty) {
                    ImageIcon hundredIcon = new ImageIcon("resources/BILLS/50.PNG");
                    denominationIcons.add(hundredIcon);
                } else {
                    return denominationIcons;
                }
            }
        }

        if (modHundred > 0) {
            twenty = modHundred / 20;
            modHundred %= 20;
            if (twenty > 0) {
                if (twenty <= this.twenty) {
                    ImageIcon hundredIcon = new ImageIcon("resources/BILLS/20.PNG");
                    denominationIcons.add(hundredIcon);
                } else {
                    return denominationIcons;
                }
            }
        }

        if (modHundred > 0) {
            ten = modHundred / 10;
            modHundred %= 10;
            if (ten > 0) {
                if (ten <= this.ten) {
                    ImageIcon hundredIcon = new ImageIcon("resources/BILLS/10.PNG");
                    denominationIcons.add(hundredIcon);
                } else {
                    return denominationIcons;
                }
            }
        }

        if (modHundred > 0) {
            five = modHundred / 5;
            modHundred %= 5;
            if (five > 0) {
                if (five <= this.five) {
                    ImageIcon hundredIcon = new ImageIcon("resources/BILLS/5.PNG");
                    denominationIcons.add(hundredIcon);
                } else {
                    return denominationIcons;
                }
            }
        }

        if (modHundred > 0) {
            one = modHundred;
            if (one <= this.one) {
                ImageIcon hundredIcon = new ImageIcon("resources/BILLS/1.PNG");
                denominationIcons.add(hundredIcon);
            } else {
                return denominationIcons;
            }
        }

        return denominationIcons;
    }


    /**
     * Deducts the denominations from the available denominations based on the given change amount.
     *
     * @param change The amount of change to be given.
     * @return A string representing the denominations that were deducted. Returns "-1" if the required denominations are not available.
     */
    public String denominations(int change) {
        String denominations = "";
        int one;
        int five;
        int ten;
        int twenty;
        int fifty;
        int hundred;
        int modHundred;

        hundred = change / 100; //gets the amount of 100 peso bills in the change
        modHundred = change % 100; //checks if there is excess change that can be further divided into smaller denominations
        if (hundred > 0) { // checks if the change to be given will contain 100pesos
            if (hundred <= this.hundred) { // checks if there is available denominations to give
                this.hundred -= hundred; // deducts 100 pesos from the stored denominations
                denominations += hundred + "\n"; // adds number of 100 peso bills to the string
            } else {
                return "-1"; // returns -1 if there is not 100 peso bills to be given as change
            }
        }

        if (modHundred > 0) { // checks from the previous calculation if the excess change can be divided to the next smaller denomination
            fifty = modHundred / 50;
            modHundred %= 50;
            if (fifty > 0) {
                if (fifty <= this.fifty) {
                    this.fifty -= fifty;
                    denominations += fifty + "\n";
                } else {
                    return "-1";
                }
            }
        }

        if (modHundred > 0) {
            twenty = modHundred / 20;
            modHundred %= 20;
            if (twenty > 0) {
                if (twenty <= this.twenty) {
                    this.twenty -= twenty;
                    denominations += twenty + "\n";
                } else {
                    return "-1";
                }
            }
        }

        if (modHundred > 0) {
            ten = modHundred / 10;
            modHundred %= 10;
            if (ten > 0) {
                if (ten <= this.ten) {
                    this.ten -= ten;
                    denominations += ten + "\n";
                } else {
                    return "-1";
                }
            }
        }

        if (modHundred > 0) {
            five = modHundred / 5;
            modHundred %= 5;
            if (five > 0) {
                if (five <= this.five) {
                    this.five -= five;
                    denominations += five + "\n";
                } else {
                    return "-1";
                }
            }
        }

        if (modHundred > 0) {
            one = modHundred;
            if (one <= this.one) {
                this.one -= one;
                denominations += one + "\n";
            } else {
                return "-1";
            }
        }

        if (change == 0) {
            return " "; // returns an empty string when there is no change to be given
        }

        return denominations;
    }

}




