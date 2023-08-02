import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A view class for setting prices for items in a vending machine.
 * Extends the VendingMachineView class.
 */
public class SetPriceView extends VendingMachineView{
    /** Button for number 9 in the keypad. */
    private final Button num9;

    /** Label to display the old price of an item during maintenance. */
    private final Title oldPrice;

    /** Label to display the new price of an item during maintenance. */
    private final Title newPrice;

    /**
     * Creates a new instance of SetPriceView.
     *
     * @param current The current vending machine model.
     * @param backgroundImagePath The path to the background image for the view.
     */
    public SetPriceView(RegularVendingMachineModel current, String backgroundImagePath) {
        super(current, backgroundImagePath);
        // create buttons
        num9 = new Button("9", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);

        // create labels for MAINTENANCE
        oldPrice = new Title("OLD PRICE", Color.white, DesignKit.vendingFont);
        newPrice = new Title("NEW PRICE", Color.white, DesignKit.vendingFont);

        mainPanel.setLayout(new GridBagLayout());
        getEnterCodePanel().setLayout(new GridLayout(4,3));
        getEnterCodePanel().remove(getOk());
        createKeypadButton(num9);
        createKeypadButton(getOk());

        getButtonConstraints().insets = new Insets(10, 0, 10, 0);
        getButtonPanel().add(oldPrice, getButtonConstraints());//made changes

        getButtonConstraints().insets = new Insets(80, 0, 10, 0);
        getButtonPanel().add(newPrice, getButtonConstraints()); //made changes

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

    }

    /**
     * Enables the keypad for accepting user input.
     * Overrides the enableKeypad method in the superclass.
     */
    /*
    @Override
    protected void enableKeypad() {
        super.enableKeypad();
        //num9.setEnabled(true);
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
     * Sets the text of the old price label during maintenance.
     *
     * @param text The text to be set on the old price label.
     */
    public void setOldPrice(String text) {
        oldPrice.setText(text);
    }

    /**
     * Sets the text of the new price label during maintenance.
     *
     * @param text The text to be set on the new price label.
     */
    public void setNewPrice(String text) {
        newPrice.setText(text);
    }

    /**
     * Gets the button for number 9 in the keypad.
     *
     * @return The Button instance for number 9.
     */
    public Button getNum9() {
        return num9;
    }

    /**
     * Sets the ActionListener for the number 9 button in the keypad.
     *
     * @param actionListener The ActionListener to be set.
     */
    public void setNum9Listener(ActionListener actionListener) {
        this.num9.addActionListener(actionListener);
    }

}
