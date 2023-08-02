import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * A class representing a special vending machine GUI.
 * This class extends the VendingMachineView and adds additional functionalities
 * specific to the special vending machine, such as displaying buttons for creating cakes,
 * handling specific item choices (e.g., codeChoice = 9 for icing), and providing timed cake creation feedback.
 */
public class SpecialVendingMachineView extends VendingMachineView{
    /** The button to exit the special vending machine view. */
    private final Button exitButton;

    /** The button to pay in the special vending machine view. */
    private final Button paymentButton;

    /** The button to get change in the special vending machine view. */
    private final Button changeButton;

    /** The button to create custom cake in the special vending machine view. */
    private final Button createButton;

    /** Button for the number 9 in the keypad. */
    private final Button num9;

    /** Button for item 9 in the vending machine. */
    private final JButton item9;

    /** Label for create cake */
    private final Title createCakeText;

    /** Used for displaying timed messages. */
    private final JPanel timedPanel;

    /** Constraints for the timed messages. */
    private final Constraints timedPanelConstraints;

    /**
     * Constructor for the SpecialVendingMachineView class.
     * Initializes the special vending machine view with specific GUI components and constraints.
     *
     * @param current            The RegularVendingMachineModel representing the current vending machine model.
     * @param backgroundImagePath The file path to the background image for the vending machine GUI.
     */
    public SpecialVendingMachineView(RegularVendingMachineModel current, String backgroundImagePath){
        super(current, backgroundImagePath);

        exitButton = new Button("EXIT", DesignKit.white, Color.red, DesignKit.vendingFont, 90, 40);
        createButton = new Button("CREATE", DesignKit.white, DesignKit.blue, DesignKit.vendingFont, 400, 50);
        paymentButton = new Button("PAYMENT", DesignKit.white, DesignKit.blue, DesignKit.vendingFont, 400,50);
        changeButton = new Button("CHANGE", DesignKit.white, DesignKit.blue, DesignKit.vendingFont, 400,50);

        num9 = new Button("9", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        item9 = new JButton();

        getButtonPanelConstraints().insets = new Insets(30, 0, 10, 200);
        getDispenserPanelConstraints().insets = new Insets(0, 190, 65, 0);
        timedPanelConstraints = new Constraints(GridBagConstraints.NORTHWEST, 0,0, 0, 1, 0, 1, 15, 170, 0, 0);

        getEnterCodePanel().setLayout(new GridLayout(4,3));
        createItem(item9, DesignKit.item9Icon);

        getEnterCodePanel().remove(getOk());
        createKeypadButton(num9);
        createKeypadButton(getOk());

        createCakeText = new Title("", Color.white, DesignKit.createFont);
        timedPanel = new JPanel(new GridBagLayout());
        timedPanel.add(createCakeText);
        timedPanel.setPreferredSize(new Dimension(455, 75));
        timedPanel.setOpaque(false);

        mainPanel.setLayout(new GridBagLayout());

        // BUTTONS (RIGHT SIDE)
        getButtonConstraints().gridy = 1;
        getButtonPanel().add(createButton, getButtonConstraints());

        getButtonConstraints().insets = new Insets(105, 0, 10, 0);
        getButtonPanel().add(getTotal(), getButtonConstraints());

        getButtonConstraints().insets = new Insets(165, 0, 10, 0);
        getButtonPanel().add(paymentButton, getButtonConstraints());

        getButtonConstraints().insets = new Insets(240, 0, 10, 0);
        getButtonPanel().add(getEnterCode(), getButtonConstraints());

        getButtonConstraints().insets = new Insets(270, 0, 10, 0);
        getButtonPanel().add(getEnterCodePanel(), getButtonConstraints());

        getButtonConstraints().insets = new Insets(430, 0, 10, 0);
        getButtonPanel().add(changeButton, getButtonConstraints());

        // BUTTONS (LEFT SIDE)
        getItemsConstraints().insets = new Insets(50, 102, 10, 200);
        getItemsPanel().add(getItem1(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(50, 250, 10, 0);
        getItemsPanel().add(getItem2(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(50, 400, 10, 0);
        getItemsPanel().add(getItem3(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(162, 102, 10, 0);
        getItemsPanel().add(getItem4(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(162, 250, 10, 0);
        getItemsPanel().add(getItem5(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(162, 400, 10, 0);
        getItemsPanel().add(getItem6(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(272, 102, 10, 0);
        getItemsPanel().add(getItem7(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(272, 250, 10, 0);
        getItemsPanel().add(getItem8(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(272, 400, 10, 0);
        getItemsPanel().add(item9, getItemsConstraints());

        getButtonPanel().revalidate();
        getButtonPanel().repaint();
    }

    /**
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
     * Display the mainPanel with all the GUI components for the special vending machine.
     * Adds buttons, items, dispenser, and timedPanel to the mainPanel and sets it as the content pane.
     */
    protected void displayPanel(){
        mainPanel.add(exitButton);
        mainPanel.add(getButtonPanel(), getButtonPanelConstraints());
        mainPanel.add(getItemsPanel(), getItemsPanelConstraints());
        mainPanel.add(getDispenserPanel(), getDispenserPanelConstraints());
        mainPanel.add(timedPanel, timedPanelConstraints);
        DesignKit.frame.setContentPane(mainPanel);

        DesignKit.frame.revalidate();
    }

    /**
     * Disable the keypad for the special vending machine view.
     */
    protected void disableKeypad() {
        super.disableKeypad();
        num9.setEnabled(false);
    }

    /**
     * Get the JButton representing item 9 in the special vending machine view.
     *
     * @return The JButton for item 9.
     */
    public JButton getItem9() {
        return item9;
    }

    /**
     * Get the Button representing the numeric button 9 in the special vending machine view.
     *
     * @return The Button for numeric button 9.
     */
    public Button getNum9() {
        return num9;
    }

    /**
     * Set the ActionListener for the numeric button 9 in the special vending machine view.
     *
     * @param actionListener The ActionListener to be set for the numeric button 9.
     */
    public void setNum9Listener(ActionListener actionListener) {
        this.num9.addActionListener(actionListener);
    }

    /**
     * Set the MouseListener for item 9 in the special vending machine view.
     *
     * @param mouseListener The MouseListener to be set for item 9.
     */
    public void setItem9Listener(MouseListener mouseListener) {
        this.item9.addMouseListener(mouseListener);
    }

    /**
     * Set the ActionListener for the exitButton in the special vending machine view.
     *
     * @param actionListener The ActionListener to be set for the exitButton.
     */
    public void setExitButtonListener(ActionListener actionListener) {
        this.exitButton.addActionListener(actionListener);
    }

    /**
     * Set the ActionListener for the paymentButton in the special vending machine view.
     *
     * @param actionListener The ActionListener to be set for the paymentButton.
     */
    public void setPaymentButtonListener(ActionListener actionListener) {
        this.paymentButton.addActionListener(actionListener);
    }

    /**
     * Set the ActionListener for the changeButton in the special vending machine view.
     *
     * @param actionListener The ActionListener to be set for the changeButton.
     */
    public void setChangeButtonListener(ActionListener actionListener) {
        this.changeButton.addActionListener(actionListener);
    }

    /**
     * Set the ActionListener for the createButton in the special vending machine view.
     *
     * @param actionListener The ActionListener to be set for the createButton.
     */
    public void setCreateButtonListener(ActionListener actionListener) {
        this.createButton.addActionListener(actionListener);
    }

    /**
     * Get the exitButton of the special vending machine view.
     *
     * @return The exitButton, a Button component representing the "EXIT" button.
     */
    public Button getExitButton() {
        return exitButton;
    }

    /**
     * Get the paymentButton of the special vending machine view.
     *
     * @return The paymentButton, a Button component representing the "PAYMENT" button.
     */
    public Button getPaymentButton() {
        return paymentButton;
    }

    /**
     * Get the changeButton of the special vending machine view.
     *
     * @return The changeButton, a Button component representing the "CHANGE" button.
     */
    public Button getChangeButton() {
        return changeButton;
    }

    /**
     * Get the createButton of the special vending machine view.
     *
     * @return The createButton, a Button component representing the "CREATE" button.
     */
    public Button getCreateButton() {
        return createButton;
    }

    /**
     * Set the text for the createCakeText component in the special vending machine view.
     * This method updates the text displayed for the timed cake creation feedback.
     *
     * @param text The text to be set for the createCakeText component.
     */
    public void setCreateCakeText(String text) {
        createCakeText.setText(text);
    }

}
