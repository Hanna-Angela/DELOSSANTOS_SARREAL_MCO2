import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * A view class for replenishing denominations in a vending machine.
 * Extends the {@link VendingMachineView} class.
 */
public class ReplenishDenominationsView extends VendingMachineView{
    /** The MoneyCompartment object representing the money compartment in the vending machine. */
    private MoneyCompartment moneyCompartment;

    /** The label displaying the old quantity of denominations.*/
    private final Title oldQty;

    /** The label displaying the new quantity of denominations.*/
    private final Title newQty;

    /** Button for adding one peso denomination.*/
    private final JButton oneBill;

    /** Button for adding five pesos denomination.*/
    private final JButton fiveBill;

    /** Button for adding ten pesos denomination.*/
    private final JButton tenBill;

    /** Button for adding twenty pesos denomination.*/
    private final JButton twentyBill;

    /** Button for adding fifty pesos denomination.*/
    private final JButton fiftyBill;

    /** Button for adding hundred pesos denomination.*/
    private final JButton hundredBill;

    /**
     * Constructs a ReplenishDenominationsView.
     *
     * @param current             The current RegularVendingMachineModel.
     * @param backgroundImagePath The path to the background image for the view.
     */
    public ReplenishDenominationsView(RegularVendingMachineModel current, String backgroundImagePath) {
        super(current, backgroundImagePath);
        moneyCompartment = current.getMoneyCompartment();
        // create denomination buttons
        oneBill = new JButton();
        fiveBill = new JButton();
        tenBill = new JButton();
        twentyBill = new JButton();
        fiftyBill = new JButton();
        hundredBill = new JButton();

        createItem(oneBill, DesignKit.oneIcon);
        createItem(fiveBill, DesignKit.fiveIcon);
        createItem(tenBill, DesignKit.tenIcon);
        createItem(twentyBill, DesignKit.twentyIcon);
        createItem(fiftyBill, DesignKit.fiftyIcon);
        createItem(hundredBill,DesignKit.hundredIcon);

        // create labels for MAINTENANCE
        oldQty = new Title("OLD QTY.", Color.white, DesignKit.vendingFont);
        newQty = new Title("NEW QTY.", Color.white, DesignKit.vendingFont);

        mainPanel.setLayout(new GridBagLayout());

        getButtonConstraints().insets = new Insets(10, 0, 10, 0);
        getButtonPanel().add(oldQty, getButtonConstraints());//made changes

        getButtonConstraints().insets = new Insets(80, 0, 10, 0);
        getButtonPanel().add(newQty, getButtonConstraints()); //made changes

        getButtonConstraints().insets = new Insets(150, 0, 10, 0);
        getButtonPanel().add(getEnterCode(), getButtonConstraints());

        getButtonConstraints().insets = new Insets(170, 0, 10, 0);
        getButtonPanel().add(getEnterCodePanel(), getButtonConstraints());

        // BUTTONS (LEFT SIDE)
        getItemsConstraints().insets = new Insets(60, 140, 10, 0);
        getItemsPanel().add(getOneBill(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(60, 290, 10, 0);
        getItemsPanel().add(getFiveBill(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(60, 440, 10, 0);
        getItemsPanel().add(getTenBill(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(237, 129, 10, 0);
        getItemsPanel().add(getTwentyBill(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(237, 279, 10, 0);
        getItemsPanel().add(getFiftyBill(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(237, 450, 10, 0);
        getItemsPanel().add(getHundredBill(), getItemsConstraints());


        getButtonPanel().revalidate();
        getButtonPanel().repaint();

        displayPanel();
    }

    /**
     * A JPanel with custom painting to display a background image.
     * The image is obtained from the provided backgroundImagePath and drawn on the panel.
     */
    public JPanel mainPanel = new JPanel() {
        /**
         * Overrides the paintComponent method to draw the background image on the panel.
         *
         * @param g The Graphics object to paint on.
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon backgroundImage = new ImageIcon(getBackgroundImagePath());
            Image image = backgroundImage.getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };

    /**
     * Displays the description of the denomination at the specified index in a popup menu.
     *
     * @param index The index of the denomination (1 for One Peso, 2 for Five Pesos, etc.).
     */
    public void denominationDescription(int index) {
        switch (index) {
            case 1:
                JMenuItem one = new JMenuItem("<html><b>One Peso</b><br> Qty: " + moneyCompartment.getOne() + "</html>");
                getPopupMenu().removeAll();
                getPopupMenu().add(one);
                break;
            case 2:
                JMenuItem five = new JMenuItem("<html><b>Five Pesos</b><br> Qty: " + moneyCompartment.getFive() + "</html>");
                getPopupMenu().removeAll();
                getPopupMenu().add(five);
                break;
            case 3:
                JMenuItem ten = new JMenuItem("<html><b>Ten Pesos</b><br> Qty: " + moneyCompartment.getTen() + "</html>");
                getPopupMenu().removeAll();
                getPopupMenu().add(ten);
                break;
            case 4:
                JMenuItem twenty = new JMenuItem("<html><b>Twenty Pesos</b><br> Qty: " +moneyCompartment.getTwenty() + "</html>");
                getPopupMenu().removeAll();
                getPopupMenu().add(twenty);
                break;
            case 5:
                JMenuItem fifty = new JMenuItem("<html><b>Fifty Pesos</b><br> Qty: " + moneyCompartment.getFifty() + "</html>");
                getPopupMenu().removeAll();
                getPopupMenu().add(fifty);
                break;
            case 6:
                JMenuItem hundred = new JMenuItem("<html><b>Hundred Pesos</b><br> Qty: " + moneyCompartment.getHundred() + "</html>");
                getPopupMenu().removeAll();
                getPopupMenu().add(hundred);
                break;
        }
    }

    /**
     * Gets the button for adding one peso denomination.
     *
     * @return The JButton for one peso denomination.
     */
    public JButton getOneBill() {
        return oneBill;
    }

    /**
     * Gets the button for adding five peso denomination.
     *
     * @return The JButton for five peso denomination.
     */
    public JButton getFiveBill() {
        return fiveBill;
    }

    /**
     * Gets the button for adding ten peso denomination.
     *
     * @return The JButton for ten peso denomination.
     */
    public JButton getTenBill() {
        return tenBill;
    }

    /**
     * Gets the button for adding twenty peso denomination.
     *
     * @return The JButton for twenty peso denomination.
     */
    public JButton getTwentyBill() {
        return twentyBill;
    }

    /**
     * Gets the button for adding fifty peso denomination.
     *
     * @return The JButton for fifty peso denomination.
     */
    public JButton getFiftyBill() {
        return fiftyBill;
    }

    /**
     * Gets the button for adding hundred peso denomination.
     *
     * @return The JButton for hundred peso denomination.
     */
    public JButton getHundredBill() {
        return hundredBill;
    }

    /**
     * Sets the text for the old quantity label.
     *
     * @param text The text to be set as the old quantity.
     */
    public void setOldQty(String text) {
        oldQty.setText(text);
    }

    /**
     * Sets the text for the new quantity label.
     *
     * @param text The text to be set as the new quantity.
     */
    public void setNewQty(String text) {
        newQty.setText(text);
    }

    /**
     * Sets the MouseListener for the one peso denomination button.
     *
     * @param mouseListener The MouseListener to be set for the one peso denomination button.
     */
    public void setOneBillListener(MouseListener mouseListener) {
        this.oneBill.addMouseListener(mouseListener);
    }

    /**
     * Sets the MouseListener for the five peso denomination button.
     *
     * @param mouseListener The MouseListener to be set for the five peso denomination button.
     */
    public void setFiveBillListener(MouseListener mouseListener) {
        this.fiveBill.addMouseListener(mouseListener);
    }

    /**
     * Sets the MouseListener for the ten peso denomination button.
     *
     * @param mouseListener The MouseListener to be set for the ten peso denomination button.
     */
    public void setTenBillListener(MouseListener mouseListener) {
        this.tenBill.addMouseListener(mouseListener);
    }

    /**
     * Sets the MouseListener for the twenty peso denomination button.
     *
     * @param mouseListener The MouseListener to be set for the twenty peso denomination button.
     */
    public void setTwentyBillListener(MouseListener mouseListener) {
        this.twentyBill.addMouseListener(mouseListener);
    }

    /**
     * Sets the MouseListener for the fifty peso denomination button.
     *
     * @param mouseListener The MouseListener to be set for the fifty peso denomination button.
     */
    public void setFiftyBillListener(MouseListener mouseListener) {
        this.fiftyBill.addMouseListener(mouseListener);
    }

    /**
     * Sets the MouseListener for the hundred peso denomination button.
     *
     * @param mouseListener The MouseListener to be set for the hundred peso denomination button.
     */
    public void setHundredBillListener(MouseListener mouseListener) {
        this.hundredBill.addMouseListener(mouseListener);
    }
}
