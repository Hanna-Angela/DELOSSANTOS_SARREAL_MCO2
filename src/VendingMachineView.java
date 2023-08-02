import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * An abstract class that the GUI for a Vending Machine.
 * This class provides the base layout and functionality for various Vending Machine views.
 */
public abstract class VendingMachineView {
    // labels
    /** Label for the total */
    private final Title total;

    /** Label for enter code */
    private final Title enterCode;

    // exit button
    /** Label for exit button */
    private final Button exitButton;

    // keypad buttons
    /** Button for enter code option 1*/
    private final Button num1;

    /** Button for enter code option 2*/
    private final Button num2;

    /** Button for enter code option 3*/
    private final Button num3;

    /** Button for enter code option 4*/
    private final Button num4;

    /** Button for enter code option 5*/
    private final Button num5;

    /** Button for enter code option 6*/
    private final Button num6;

    /** Button for enter code option 7*/
    private final Button num7;

    /** Button for enter code option 8*/
    private final Button num8;

    /** Button for enter code OK, for when done*/
    private final Button ok;

    // item buttons

    /** JButton that is for item 1*/
    private final JButton item1;

    /** JButton that is for item 2*/
    private final JButton item2;

    /** JButton that is for item 3*/
    private final JButton item3;

    /** JButton that is for item 4*/
    private final JButton item4;

    /** JButton that is for item 5*/
    private final JButton item5;

    /** JButton that is for item 6*/
    private final JButton item6;

    /** JButton that is for item 7*/
    private final JButton item7;

    /** JButton that is for item 8*/
    private final JButton item8;

    // payment buttons - used in payment
    /** Label for payment */
    private final Title paymentLabel;

    /** JButton that is used to represent one peso*/
    private final JButton button1;

    /** JButton that is used to represent five pesos*/
    private final JButton button5;

    /** JButton that is used to represent ten pesos*/
    private final JButton button10;

    /** JButton that is used to represent twenty pesos*/
    private final JButton button20;

    /** JButton that is used to represent fifty pesos*/
    private final JButton button50;

    /** JButton that is used to represent hundred pesos*/
    private final JButton button100;

    /** JButton that is used to represent DONE when user is done entering payment*/
    private final JButton buttonDone;

    // panels
    /** JPanel that is used to display the number buttons*/
    private final JPanel enterCodePanel;

    /** JPanel that  is used to display the buttons (payment, change, enter code)*/
    private final JPanel buttonPanel;

    /** JPanel that is used to display the items*/
    private final JPanel itemsPanel;

    /** JPanel that  is used to display the items dispensed*/
    private final JPanel dispenserPanel;

    // constraints
    /** Constraints for positioning and sizing the exit button in the main panel. */
    private Constraints exitConstraints;

    /** Constraints for positioning buttons in the button panel. */
    private Constraints buttonConstraints;

    /** Constraints for positioning the button panel. */
    private Constraints buttonPanelConstraints;

    /** Constraints for positioning items in the item panel. */
    private Constraints itemsConstraints;

    /** Constraints for positioning the item panel. */
    private Constraints itemsPanelConstraints;

    /** Constraints for positioning the dispense items panel. */
    private Constraints dispenserPanelConstraints;

    // pop up menu

    /** The pop-up menu used to display item information when an item button is clicked.*/
    private JPopupMenu popupMenu;

    // isDone
    /** A flag to indicate if the is done action*/
    private boolean isDone;

    // background image
    private String backgroundImagePath;
    private RegularVendingMachineModel currentModel;


    /**
     * Constructs a new VendingMachineView object with the specified RegularVendingMachineModel and background image path.
     *
     * @param currentModel        The RegularVendingMachineModel to associate with this view.
     * @param backgroundImagePath The file path to the background image used in the GUI.
     */
    public VendingMachineView(RegularVendingMachineModel currentModel, String backgroundImagePath) {
        this.currentModel = currentModel;

        // initialize isDone
        isDone = false;

        // assign image
        this.backgroundImagePath = backgroundImagePath;

        // create popupMenu
        popupMenu = new JPopupMenu();
        Color selectionBackgroundColor = Color.RED;
        UIManager.put("MenuItem.selectionBackground", selectionBackgroundColor);

        // create labels
        total = new Title("TOTAL", Color.white, DesignKit.vendingFont);
        enterCode = new Title("ENTER CODE:", Color.black, DesignKit.vendingFont);

        // create exit button
        exitButton = new Button("EXIT", DesignKit.white, Color.red, DesignKit.vendingFont, 90, 40);

        // create num pads for 1 to 8
        num1 = new Button("1", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        num2 = new Button("2", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        num3 = new Button("3", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        num4 = new Button("4", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        num5 = new Button("5", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        num6 = new Button("6", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        num7 = new Button("7", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        num8 = new Button("8", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);
        ok = new Button("OK", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 400, 50);

        // create item buttons
        item1 = new JButton();
        item2 = new JButton();
        item3 = new JButton();
        item4 = new JButton();
        item5 = new JButton();
        item6 = new JButton();
        item7 = new JButton();
        item8 = new JButton();

        // create payment buttons
        paymentLabel = new Title("PAYMENT", Color.white, DesignKit.buttonFont);

        button1 = new JButton("");
        button1.setIcon(DesignKit.oneIcon);
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);

        button5 = new JButton("");
        button5.setIcon(DesignKit.fiveIcon);
        button5.setBorderPainted(false);
        button5.setContentAreaFilled(false);

        button10 = new JButton("");
        button10.setIcon(DesignKit.tenIcon);
        button10.setBorderPainted(false);
        button10.setContentAreaFilled(false);

        button20 = new JButton("");
        button20.setIcon(DesignKit.twentyIcon);
        button20.setBorderPainted(false);
        button20.setContentAreaFilled(false);

        button50 = new JButton();
        button50.setIcon(DesignKit.fiftyIcon);
        button50.setBorderPainted(false);
        button50.setContentAreaFilled(false);

        button100 = new JButton("");
        button100.setIcon(DesignKit.hundredIcon);
        button100.setBorderPainted(false);
        button100.setContentAreaFilled(false);

        buttonDone = new JButton("Done");
        buttonDone.setBackground(Color.red);
        buttonDone.setForeground(Color.white);
        buttonDone.setFont(DesignKit.buttonFont);

        // create panels
        mainPanel.setLayout(new GridBagLayout());

        enterCodePanel = new JPanel(new GridLayout(3, 3));
        enterCodePanel.setBackground(DesignKit.darkPurple);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setPreferredSize(new Dimension(140, 500));
        buttonPanel.setOpaque(false);

        dispenserPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        dispenserPanel.setPreferredSize(new Dimension(455, 75));
        dispenserPanel.setOpaque(false);

        itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridBagLayout());
        itemsPanel.setPreferredSize(new Dimension(500, 500));
        itemsPanel.setOpaque(false);

        // create constraints
        exitConstraints = new Constraints(GridBagConstraints.NORTHWEST, 21, 1, 20, 0, 22, 2, 0, 0, 0, 0);
        buttonConstraints = new Constraints(GridBagConstraints.NORTH, 0.5, 0.5, 0, 0, 1, 1, 10, 0, 10, 0);
        buttonPanelConstraints = new Constraints(GridBagConstraints.NORTHEAST, 0.5, 0.5, 7, 1, 1, 2, 70, 10, 10, 181);
        itemsConstraints = new Constraints(GridBagConstraints.NORTHWEST, 0.5, 0.5, 0, 0, 1, 1, 0, 128, 10, 0);
        itemsPanelConstraints = new Constraints(GridBagConstraints.NORTHWEST, 0.5, 0.5, 7, 1, 1, 2, 70, 0, 10, 181);
        dispenserPanelConstraints = new Constraints(GridBagConstraints.SOUTHWEST, 0, 0, 0, 2, 0, 1, 0, 190, 120, 0);

        createKeypadButton(num1);
        createKeypadButton(num2);
        createKeypadButton(num3);
        createKeypadButton(num4);
        createKeypadButton(num5);
        createKeypadButton(num6);
        createKeypadButton(num7);
        createKeypadButton(num8);
        createKeypadButton(ok);

        createItem(item1, DesignKit.item1Icon);
        createItem(item2, DesignKit.item2Icon);
        createItem(item3, DesignKit.item3Icon);
        createItem(item4, DesignKit.item4Icon);
        createItem(item5, DesignKit.item5Icon);
        createItem(item6, DesignKit.item6Icon);
        createItem(item7, DesignKit.item7Icon);
        createItem(item8, DesignKit.item8Icon);
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
            ImageIcon backgroundImage = new ImageIcon(backgroundImagePath);
            Image image = backgroundImage.getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };

    /**
     * Displays the main panel of the Vending Machine GUI, including the exit button, button panel, items panel,
     * and dispenser panel.
     */
    protected void displayPanel() {
        mainPanel.add(exitButton);
        mainPanel.add(buttonPanel, buttonPanelConstraints);
        mainPanel.add(itemsPanel, itemsPanelConstraints);
        mainPanel.add(dispenserPanel, dispenserPanelConstraints);
        DesignKit.frame.setContentPane(mainPanel);
    }

    /**
     * Creates an item button with the given name and image and sets it up for display in the Vending Machine GUI.
     *
     * @param name  The button to be configured with the given image.
     * @param image The image to be set as the icon of the button.
     */
    protected void createItem(JButton name, ImageIcon image) {
        name.setIcon(image);
        name.setBorderPainted(false);
        name.setContentAreaFilled(false);
    }

    /**
     * Creates a keypad button with the given name.
     *
     * @param name The keypad button to be configured.
     */
    protected void createKeypadButton(JButton name) {
        name.setBorder(new LineBorder(DesignKit.darkPurple, 7));
        name.setContentAreaFilled(false);
        name.setEnabled(false);
        enterCodePanel.add(name);
    }

    /**
     * Disables the keypad buttons to prevent user input.
     */
    protected void disableKeypad() {
        num1.setEnabled(false);
        num2.setEnabled(false);
        num3.setEnabled(false);
        num4.setEnabled(false);
        num5.setEnabled(false);
        num6.setEnabled(false);
        num7.setEnabled(false);
        num8.setEnabled(false);
    }

    /**
     * Enables the keypad buttons for user input.
     */
    protected void enableKeypad() {
        num1.setEnabled(true);
        num2.setEnabled(true);
        num3.setEnabled(true);
        num4.setEnabled(true);
        num5.setEnabled(true);
        num6.setEnabled(true);
        num7.setEnabled(true);
        num8.setEnabled(true);
    }

    /**
     * Displays the description of the selected item in a pop-up menu.
     *
     * @param itemIndex The index of the item for which the description is to be displayed.
     */
    protected void itemDescription(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < 10) {
            Item item = currentModel.getItem(itemIndex);
            JMenuItem itemMenu = new JMenuItem("<html><b>" + item.getName() + "</b><br>"
                    + "Cal: " + item.getCalories() + "<br>"
                    + "Qty: " + item.getQuantity() + "<br>"
                    + "Price: " + item.getPrice() + "</html>");
            popupMenu.removeAll();
            popupMenu.add(itemMenu);
        }
    }

    /**
     * Displays the change amount in a pop-up window with images of denominations and their count
     * If the change is zero, it displays a message indicating that no change is given for the exact amount.
     * If there are insufficient funds to process the payment, it displays a message that money is refunded.
     */
    protected void displayChange() {
        int change = currentModel.change();

        // background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("resources/change.PNG");
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new GridBagLayout());

        // constraints for change panel
        GridBagConstraints constraints = new GridBagConstraints();
        Title changeLabel = new Title(" CHANGE ", DesignKit.darkPink, DesignKit.buttonFont);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 10, 5, 10);
        panel.add(changeLabel, constraints);


        if (change >= 0 && !currentModel.getDenominations().equals("-1")) {
            List<ImageIcon> denominationIcons = currentModel.getMoneyCompartment().displayDenominations(change);
            if (!denominationIcons.isEmpty()) {
                String denominations = currentModel.getDenominations();
                String[] denominationCount = denominations.split("\n");

                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.gridwidth = 1;
                constraints.insets = new Insets(0, 10, 20, 10);

                for (int i = 0; i < denominationCount.length; i++) {
                    JLabel denominationLabel = new JLabel(denominationCount[i]);
                    denominationLabel.setFont(DesignKit.buttonFont);
                    denominationLabel.setForeground(DesignKit.darkPink);

                    constraints.gridx = 0;
                    constraints.gridy = i + 1;
                    panel.add(denominationLabel, constraints);
                }

                for (int i = 0; i < denominationIcons.size(); i++) {
                    ImageIcon icon = denominationIcons.get(i);
                    JLabel denominationLabel = new JLabel(icon);
                    constraints.gridx = 1;
                    constraints.gridy = i + 1;
                    panel.add(denominationLabel, constraints);
                }
            } else if (change == 0) {
                JLabel noChange = new JLabel("Exact amount. No change given.");
                noChange.setFont(DesignKit.vendingFont);
                noChange.setForeground(DesignKit.darkPink);

                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.gridwidth = 2;
                panel.add(noChange, constraints);
            }
        }
        if (currentModel.getDenominations().equals("-1")) {
            JLabel insufficientFunds = new JLabel("Money Refunded.");
            insufficientFunds.setFont(DesignKit.vendingFont);
            insufficientFunds.setForeground(DesignKit.darkPink);

            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 2;
            panel.add(insufficientFunds, constraints);
        }

        JOptionPane.showOptionDialog(null, panel, "Change",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{},
                null);
    }

    /**
     * Displays the payment options panel with various buttons for different payment amounts.
     */
    protected void payment() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("resources/payment.PNG");
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(new GridBagLayout());
        while (!isDone) {
            GridBagConstraints constraints = new GridBagConstraints();

            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 2;
            constraints.insets = new Insets(20, 10, 10, 10); // Increase top insets
            panel.add(paymentLabel, constraints);

            constraints.gridwidth = 1;
            constraints.gridy = 1;
            constraints.insets = new Insets(10, 10, 10, 10);
            panel.add(button1, constraints);

            constraints.gridx = 1;
            panel.add(button20, constraints);

            constraints.gridx = 0;
            constraints.gridy = 2;
            panel.add(button5, constraints);

            constraints.gridx = 1;
            panel.add(button50, constraints);

            constraints.gridx = 0;
            constraints.gridy = 3;
            panel.add(button10, constraints);

            constraints.gridx = 1;
            panel.add(button100, constraints);

            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 2;
            panel.add(buttonDone, constraints);

            JOptionPane.showOptionDialog(null, panel, "Payment Options",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{},
                    null
            );
        }
    }

    /**
     * Sets an ActionListener for the exitButton in the Vending Machine GUI.
     *
     * @param actionListener The ActionListener to be set for the exitButton.
     */
    protected void setExitButtonListener(ActionListener actionListener) {
        this.exitButton.addActionListener(actionListener);
    }

    // ITEMS

    /**
     * Sets a MouseListener for the item1 button in the Vending Machine GUI.
     *
     * @param mouseListener The MouseListener to be set for the item1 button.
     */
    protected void setItem1Listener(MouseListener mouseListener) {
        this.item1.addMouseListener(mouseListener);
    }

    /**
     * Sets a MouseListener for the item2 button in the Vending Machine GUI.
     *
     * @param mouseListener The MouseListener to be set for the item2 button.
     */
    protected void setItem2Listener(MouseListener mouseListener) {
        this.item2.addMouseListener(mouseListener);
    }

    /**
     * Sets a MouseListener for the item3 button in the Vending Machine GUI.
     *
     * @param mouseListener The MouseListener to be set for the item3 button.
     */
    protected void setItem3Listener(MouseListener mouseListener) {
        this.item3.addMouseListener(mouseListener);
    }

    /**
     * Sets a MouseListener for the item4 button in the Vending Machine GUI.
     *
     * @param mouseListener The MouseListener to be set for the item4 button.
     */
    protected void setItem4Listener(MouseListener mouseListener) {
        this.item4.addMouseListener(mouseListener);
    }

    /**
     * Sets a MouseListener for the item5 button in the Vending Machine GUI.
     *
     * @param mouseListener The MouseListener to be set for the item5 button.
     */
    protected void setItem5Listener(MouseListener mouseListener) {
        this.item5.addMouseListener(mouseListener);
    }

    /**
     * Sets a MouseListener for the item6 button in the Vending Machine GUI.
     *
     * @param mouseListener The MouseListener to be set for the item6 button.
     */
    protected void setItem6Listener(MouseListener mouseListener) {
        this.item6.addMouseListener(mouseListener);
    }

    /**
     * Sets a MouseListener for the item7 button in the Vending Machine GUI.
     *
     * @param mouseListener The MouseListener to be set for the item7 button.
     */
    protected void setItem7Listener(MouseListener mouseListener) {
        this.item7.addMouseListener(mouseListener);
    }

    /**
     * Sets a MouseListener for the item8 button in the Vending Machine G
     *
     * @param mouseListener The MouseListener to be set for the item8 button.
     */
    protected void setItem8Listener(MouseListener mouseListener) {
        this.item8.addMouseListener(mouseListener);
    }


    // ENTER PANEL

    /**
     * Sets an ActionListener for the num1 button.
     *
     * @param actionListener The ActionListener to be set for the num1 button.
     */
    protected void setNum1Listener(ActionListener actionListener) {
        this.num1.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the num2 button.
     *
     * @param actionListener The ActionListener to be set for the num2 button.
     */
    protected void setNum2Listener(ActionListener actionListener) {
        this.num2.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the num3 button.
     *
     * @param actionListener The ActionListener to be set for the num3 button.
     */
    protected void setNum3Listener(ActionListener actionListener) {
        this.num3.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the num4 button in the Vending Machine GUI.
     *
     * @param actionListener The ActionListener to be set for the num4 button.
     */
    protected void setNum4Listener(ActionListener actionListener) {
        this.num4.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the num5 button in the Vending Machine GUI.
     *
     * @param actionListener The ActionListener to be set for the num5 button.
     */
    protected void setNum5Listener(ActionListener actionListener) {
        this.num5.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the num6 button in the Vending Machine GUI.
     *
     * @param actionListener The ActionListener to be set for the num6 button.
     */
    protected void setNum6Listener(ActionListener actionListener) {
        this.num6.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the num7 button in the Vending Machine GUI.
     *
     * @param actionListener The ActionListener to be set for the num7 button.
     */
    protected void setNum7Listener(ActionListener actionListener) {
        this.num7.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the num8 buttnN.
     *
     * @param actionListener The ActionListener to be set for the num8 button.
     */
    protected void setNum8Listener(ActionListener actionListener) {
        this.num8.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the ok button .
     *
     * @param actionListener The ActionListener to be set for the ok button.
     */
    protected void setOkListener(ActionListener actionListener) {
        this.ok.addActionListener(actionListener);
    }

    // BILLS - PAYMENT

    /**
     * Sets an ActionListener for the button1.
     *
     * @param actionListener The ActionListener to be set for the button1.
     */
    protected void setButton1Listener(ActionListener actionListener) {
        this.button1.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the button5.
     *
     * @param actionListener The ActionListener to be set for the button5.
     */
    protected void setButton5Listener(ActionListener actionListener) {
        this.button5.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the button10.
     *
     * @param actionListener The ActionListener to be set for the button10.
     */
    protected void setButton10Listener(ActionListener actionListener) {
        this.button10.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the button20.
     *
     * @param actionListener The ActionListener to be set for the button20.
     */
    protected void setButton20Listener(ActionListener actionListener) {
        this.button20.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the button50.
     *
     * @param actionListener The ActionListener to be set for the button50.
     */
    protected void setButton50Listener(ActionListener actionListener) {
        this.button50.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the button100.
     *
     * @param actionListener The ActionListener to be set for the button100.
     */
    protected void setButton100Listener(ActionListener actionListener) {
        this.button100.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the buttonDone.
     *
     * @param actionListener The ActionListener to be set for the buttonDone.
     */
    protected void setButtonDoneListener(ActionListener actionListener) {
        this.buttonDone.addActionListener(actionListener);
    }

    /**
     * Retrieves the JButton object representing the "Done" button.
     *
     * @return The JButton object representing the "Done" button.
     */
    protected JButton getButtonDone() {
        return buttonDone;
    }

    /**
     * Sets the flag indicating whether the payment process is completed or not.
     *
     * @param isDone A boolean value indicating whether the payment process is completed (true) or not (false).
     */
    protected void setisDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Sets the text for the payment label.
     *
     * @param text The text to be displayed on the payment label.
     */
    protected void setPaymentLabel(String text) {
        paymentLabel.setText(text);
    }


    /**
     * Retrieves the Title object representing the total label in the Vending Machine GUI.
     *
     * @return The Title object representing the total label.
     */
    protected Title getTotal() {
        return total;
    }

    /**
     * Sets the text for the total label in the Vending Machine GUI.
     *
     * @param text The text to be displayed on the total label.
     */
    protected void setTotal(String text) {
        total.setText(text);
    }

    /**
     * Retrieves the Title object representing the enter code label in the Vending Machine GUI.
     *
     * @return The Title object representing the enter code label.
     */
    protected Title getEnterCode() {
        return enterCode;
    }

    // GETTERS FOR ENTER PANEL NUMBER BUTTONS

    /**
     * Retrieves the Button object representing the "1" keypad button in the Vending Machine GUI.
     *
     * @return The Button object representing the "1" keypad button.
     */
    protected Button getNum1() {
        return num1;
    }

    /**
     * Retrieves the Button object representing the "2" keypad button
     *
     * @return The Button object representing the "2" keypad button.
     */
    protected Button getNum2() {
        return num2;
    }

    /**
     * Retrieves the Button object representing the "3" keypad button
     *
     * @return The Button object representing the "3" keypad button.
     */
    protected Button getNum3() {
        return num3;
    }

    /**
     * Retrieves the Button object representing the "4" keypad button
     *
     * @return The Button object representing the "4" keypad button.
     */
    protected Button getNum4() {
        return num4;
    }

    /**
     * Retrieves the Button object representing the "5" keypad button
     *
     * @return The Button object representing the "5" keypad button.
     */
    protected Button getNum5() {
        return num5;
    }

    /**
     * Retrieves the Button object representing the "6" keypad button
     *
     * @return The Button object representing the "6" keypad button.
     */
    protected Button getNum6() {
        return num6;
    }

    /**
     * Retrieves the Button object representing the "7" keypad button
     *
     * @return The Button object representing the "7" keypad button.
     */
    protected Button getNum7() {
        return num7;
    }

    /**
     * Retrieves the Button object representing the "8" keypad button
     *
     * @return The Button object representing the "8" keypad button.
     */
    protected Button getNum8() {
        return num8;
    }

    /**
     * Retrieves the Button object representing the "OK" keypad button.
     *
     * @return The Button object representing the "OK" keypad button.
     */
    protected Button getOk() {
        return ok;
    }

    // GETTERS FOR ITEMS

    /**
     * Retrieves the JButton object representing item 1
     *
     * @return The JButton object representing item 1.
     */
    protected JButton getItem1() {
        return item1;
    }

    /**
     * Retrieves the JButton object representing item 2
     *
     * @return The JButton object representing item 2.
     */
    protected JButton getItem2() {
        return item2;
    }

    /**
     * Retrieves the JButton object representing item 3
     *
     * @return The JButton object representing item 3.
     */
    protected JButton getItem3() {
        return item3;
    }

    /**
     * Retrieves the JButton object representing item 4
     *
     * @return The JButton object representing item 4.
     */
    protected JButton getItem4() {
        return item4;
    }

    /**
     * Retrieves the JButton object representing item 5
     *
     * @return The JButton object representing item 5.
     */
    protected JButton getItem5() {
        return item5;
    }

    /**
     * Retrieves the JButton object representing item 6
     *
     * @return The JButton object representing item 6.
     */
    protected JButton getItem6() {
        return item6;
    }

    /**
     * Retrieves the JButton object representing item 7.
     *
     * @return The JButton object representing item 7.
     */
    protected JButton getItem7() {
        return item7;
    }

    /**
     * Retrieves the JButton object representing item 8
     *
     * @return The JButton object representing item 8.
     */
    protected JButton getItem8() {
        return item8;
    }

    /**
     * Retrieves the JPanel representing the "Enter Code" panel
     *
     * @return The JPanel representing the "Enter Code" panel.
     */
    protected JPanel getEnterCodePanel() {
        return enterCodePanel;
    }

    /**
     * Retrieves the JPanel representing the button panel
     *
     * @return The JPanel representing the button panel.
     */
    protected JPanel getButtonPanel() {
        return buttonPanel;
    }

    /**
     * Retrieves the JPanel representing the items panel
     *
     * @return The JPanel representing the items panel.
     */
    protected JPanel getItemsPanel() {
        return itemsPanel;
    }

    /**
     * Retrieves the JPanel representing the dispenser panel
     *
     * @return The JPanel representing the dispenser panel.
     */
    protected JPanel getDispenserPanel() {
        return dispenserPanel;
    }


    /**
     * Retrieves the Constraints object representing the constraints used for positioning and layout of the buttons.
     *
     * @return The Constraints object for button positioning and layout.
     */
    protected Constraints getButtonConstraints() {
        return buttonConstraints;
    }

    /**
     * Retrieves the Constraints object representing the constraints used for positioning and layout of the button panel.
     *
     * @return The Constraints object for button panel positioning and layout.
     */
    protected Constraints getButtonPanelConstraints() {
        return buttonPanelConstraints;
    }

    /**
     * Retrieves the Constraints object representing the constraints used for positioning and layout of the items panel.
     *
     * @return The Constraints object for items panel positioning and layout.
     */
    protected Constraints getItemsPanelConstraints() {
        return itemsPanelConstraints;
    }

    /**
     * Retrieves the Constraints object representing the constraints used for positioning and layout of the items.
     *
     * @return The Constraints object for item buttons positioning and layout.
     */
    protected Constraints getItemsConstraints() {
        return itemsConstraints;
    }

    /**
     * Retrieves the Constraints object representing the constraints used for positioning and layout of the dispenser panel.
     *
     * @return The Constraints object for dispenser panel positioning and layout.
     */
    protected Constraints getDispenserPanelConstraints() {
        return dispenserPanelConstraints;
    }

    /**
     * Retrieves the JPopupMenu object used for displaying the pop-up menu
     *
     * @return The JPopupMenu used for the pop-up menu.
     */
    protected JPopupMenu getPopupMenu() {
        return popupMenu;
    }

    /**
     * Retrieves the path of the background image used in the Vending Machine GUI.
     *
     * @return The path of the background image.
     */
    protected String getBackgroundImagePath() {
        return backgroundImagePath;
    }
}