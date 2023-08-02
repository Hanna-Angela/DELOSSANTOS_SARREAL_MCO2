import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The StockItemView class represents the view for managing stock items in the vending machine.
 * It extends the VendingMachineView and provides additional functionality for editing stock item information.
 */
public class StockItemView extends VendingMachineView{
    /** Button for number 9 in the keypad. */
    private final Button num9;

    /** The main panel that is used in the stock item view */
    private JPanel panel;

    /**  The labels used in the stock item view */
    private Title label;

    /** Button used to restock stock item */
    private final Button restock;

    /** The button used to change the stock item's information. */
    private final Button change;

    /**  The text field for entering the name of a new stock item. */
    private JTextField newItemName;

    /** The text field for entering the calories of a new stock item. */
    private JTextField newCalories;

     /** The text field for entering the calories of a new stock item. */
    private JTextField newPrice;

     /** The title displaying the old quantity of a stock item. */
    private final Title oldQty;

     /** The title displaying the new quantity of a stock item. */
    private final Title newQty;

    /**
     * Constructs a new StockItemView with the given RegularVendingMachineModel and background image path.
     *
     * @param current The RegularVendingMachineModel instance associated with this view.
     * @param backgroundImagePath The file path for the background image of the view.
     */
    public StockItemView(RegularVendingMachineModel current, String backgroundImagePath) {
        super(current, backgroundImagePath);
        num9 = new Button("9", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);

        // for whenQty0
        restock = new Button("RESTOCK ITEM", Color.white, DesignKit.darkPurple, DesignKit.vendingFont, 170, 40);
        change = new Button("CHANGE ITEM", Color.white, DesignKit.darkPurple, DesignKit.vendingFont, 170, 40);

        // create labels for MAINTENANCE
        oldQty = new Title("OLD QTY.", Color.white, DesignKit.vendingFont);
        newQty = new Title("NEW QTY.", Color.white, DesignKit.vendingFont);

        mainPanel.setLayout(new GridBagLayout());
        getEnterCodePanel().setLayout(new GridLayout(4,3));
        getEnterCodePanel().remove(getOk());
        createKeypadButton(num9);
        createKeypadButton(getOk());

        getButtonConstraints().insets = new Insets(10, 0, 10, 0);
        getButtonPanel().add(oldQty, getButtonConstraints());//made changes

        getButtonConstraints().insets = new Insets(80, 0, 10, 0);
        getButtonPanel().add(newQty, getButtonConstraints()); //made changes

        getButtonConstraints().insets = new Insets(150, 0, 10, 0);
        getButtonPanel().add(getEnterCode(), getButtonConstraints());

        getButtonConstraints().insets = new Insets(170, 0, 10, 0);
        getButtonPanel().add(getEnterCodePanel(), getButtonConstraints());

        // BUTTONS (LEFT SIDE)
        getItemsPanel().add(getItem1(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(0, 274, 10, 0);
        getItemsPanel().add(getItem2(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(0, 452, 10, 0);
        getItemsPanel().add(getItem3(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(110, 200, 10, 0);
        getItemsPanel().add(getItem4(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(110, 350, 10, 0);
        getItemsPanel().add(getItem5(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(220, 128, 10, 0);
        getItemsPanel().add(getItem6(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(220, 274, 10, 0);
        getItemsPanel().add(getItem7(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(220, 452, 10, 0);
        getItemsPanel().add(getItem8(), getItemsConstraints());

        getButtonPanel().revalidate();
        getButtonPanel().repaint();

        displayPanel();
    }

    /**
     * Enables the keypad.
     * Overrides the enable method in the superclass.
     */
    /*
    @Override
    protected void enableKeypad() {
        super.enableKeypad();
        num9.setEnabled(true);
    }
*/
    /**
     * Disables the keypad to prevent user input.
     * Overrides the disableKeypad method in the superclass.
     */
    protected void disableKeypad() {
        super.disableKeypad();
        num9.setEnabled(false);
    }

    /**
     * JPanel with a custom paintComponent method to display the background image.
     *
     * JPanel with a custom paintComponent method to display the background image.
     */
    protected JPanel mainPanel = new JPanel() {
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
     * Method to create a new item when quantity is 0 and the user wants to change item
     */
    protected void createNewItem() {
        panel.removeAll();

        label.setText("ENTER NEW INFO");
        label.setFont(DesignKit.buttonFont);
        newItemName = new JTextField(15);
        newCalories = new JTextField(15);
        newPrice = new JTextField(15);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.insets = new Insets(5, 0, 10, 0);
        panel.add(label, constraints);
        panel.add(new Title("Name: ", DesignKit.darkPink, DesignKit.vendingFont), constraints);
        panel.add(newItemName, constraints);
        panel.add(new Title("Calories: ", DesignKit.darkPink, DesignKit.vendingFont), constraints);
        panel.add(newCalories, constraints);
        panel.add(new Title("Price: ", DesignKit.darkPink, DesignKit.vendingFont), constraints);
        panel.add(newPrice, constraints);

        constraints.insets = new Insets(0, 0, 0, 0);

        JButton buttonDone = getButtonDone();
        buttonDone.setBackground(Color.red);
        buttonDone.setForeground(Color.white);
        buttonDone.setFont(DesignKit.vendingFont);

        panel.add(buttonDone, constraints);

        panel.revalidate();
        panel.repaint();
    }

    /**
     * Displays two options: restock item & change item then directs the user to their desired option
     */
    protected void whenQty0() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("resources/change.PNG");
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setPreferredSize(new Dimension(300, 300));

        label = new Title(" DO YOU WANT TO ", DesignKit.darkPink, DesignKit.buttonFont);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(10, 0, 10, 0);

        panel.add(label, c);
        panel.add(restock, c);
        panel.add(change, c);

        JOptionPane.showOptionDialog(
                null, panel, "Quantity of the Item is 0", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null
        );
    }

    /**
     * Gets the text field for entering the name of a new stock item.
     *
     * @return The JTextField representing the new stock item's name input field.
     */
    public JTextField getNewItemName(){
        return newItemName;
    }

    /**
     * Gets the text field for entering the name of a new stock item.
     *
     * @return The JTextField representing the new stock item's name input field.
     */
    public JTextField getNewCalories(){
        return newCalories;
    }

    /**
     * Gets the text field for entering the price of a new stock item.
     *
     * @return The JTextField representing the new stock item's price input field.
     */
    public JTextField getNewPrice(){
        return newPrice;
    }

    /**
     * Gets the panel used for displaying and editing stock item information.
     *
     * @return The JPanel representing the stock item information panel.
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Sets the ActionListener for the restock button.
     * The ActionListener is triggered when the restock button is clicked.
     *
     * @param actionListener The ActionListener to set for the restock button.
     */
    public void setRestockListener(ActionListener actionListener) {
        this.restock.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the change button.
     * The ActionListener is triggered when the change button is clicked.
     *
     * @param actionListener The ActionListener to set for the change button.
     */
    public void setChangeListener(ActionListener actionListener) {
        this.change.addActionListener(actionListener);
    }

    /**
     * Gets the button representing the number 9 in the keypad for quantity input.
     * This button allows users to input the number 9 when updating the quantity of a stock item.
     *
     * @return The Button representing the number 9 in the keypad.
     */
    public Button getNum9() {
        return num9;
    }

    /**
     * Sets the ActionListener for the number 9 button in the keypad.
     * The ActionListener is triggered when the number 9 button is clicked.
     *
     * @param actionListener The ActionListener to set for the number 9 button.
     */
    public void setNum9Listener(ActionListener actionListener) {
        this.num9.addActionListener(actionListener);
    }

    /**
     * Sets the text of the OLD quantity label.
     * The old quantity label displays the current quantity of the stock item before any changes are made.
     *
     * @param text The text to set for the old quantity label.
     */
    public void setOldQty(String text) {
        oldQty.setText(text);
    }

    /**
     * Sets the text of the NEW quantity label.
     * The old quantity label displays the current quantity of the stock item before any changes are made.
     *
     * @param text The text to set for the old quantity label.
     */
    public void setNewQty(String text) {
        newQty.setText(text);
    }


}
