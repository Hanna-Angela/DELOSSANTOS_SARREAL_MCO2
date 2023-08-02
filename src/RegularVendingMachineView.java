import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The RegularVendingMachineView class represents the view for a regular vending machine.
 * It extends the VendingMachineView and provides additional buttons and components specific to the regular vending machine.
 */
public class RegularVendingMachineView extends VendingMachineView {
    /** The button to exit the regular vending machine view. */
    private final Button exitButton;

    /** The button for payment in the regular vending machine view. */
    private final Button paymentButton;

    /** The button for providing change in the regular vending machine view. */
    private final Button changeButton;

    /**
     * Constructs a new RegularVendingMachineView instance.
     *
     * @param current            The current model of the regular vending machine.
     * @param backgroundImagePath The path to the background image for the view.
     */
    public RegularVendingMachineView(RegularVendingMachineModel current, String backgroundImagePath){
        super(current, backgroundImagePath);
        // create buttons
        exitButton = new Button("EXIT", DesignKit.white, Color.red, DesignKit.vendingFont, 90, 40);
        paymentButton = new Button("PAYMENT", DesignKit.white, DesignKit.slightPink, DesignKit.vendingFont, 400,50);
        changeButton = new Button("CHANGE", DesignKit.white, DesignKit.slightPink, DesignKit.vendingFont, 400,50);

        // BUTTONS (RIGHT SIDE)
        getButtonPanel().add(getTotal(), getButtonConstraints());

        getButtonConstraints().insets = new Insets(80, 0, 10, 0);
        getButtonPanel().add(paymentButton, getButtonConstraints());

        getButtonConstraints().insets = new Insets(150, 0, 10, 0);
        getButtonPanel().add(getEnterCode(), getButtonConstraints());

        getButtonConstraints().insets = new Insets(170, 0, 10, 0);
        getButtonPanel().add(getEnterCodePanel(), getButtonConstraints());

        getButtonConstraints().insets = new Insets(290, 0, 10, 0);
        getButtonPanel().add(changeButton, getButtonConstraints());

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
     * Sets the ActionListener for the paymentButton.
     *
     * @param actionListener The ActionListener to be set for the paymentButton.
     */
    public void setPaymentButtonListener(ActionListener actionListener) {
        this.paymentButton.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the changeButton.
     *
     * @param actionListener The ActionListener to be set for the changeButton.
     */
    public void setChangeButtonListener(ActionListener actionListener) {
        this.changeButton.addActionListener(actionListener);
    }

    /**
     * Gets the payment button of the regular vending machine view.
     *
     * @return The exit button.
     */
    public Button getPaymentButton() {
        return paymentButton;
    }

    /**
     * Gets the change button of the regular vending machine view.
     *
     * @return The change button.
     */
    public Button getChangeButton() {
        return changeButton;
    }
}
