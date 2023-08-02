import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SummaryOfTransactionsView extends MenuView{

    /** Label for the title */
    private Title titleLabel;

    /** Label for the NO */
    private Title noLabel;

    /** Label for the item name */
    private Title itemNameLabel;

    /** Label for the price */
    private Title priceLabel;

    /** Label for the calories */
    private Title caloriesLabel;

    /** Label for the quantity */
    private Title quantityLabel;

    /** Label for the units sold */
    private Title unitsSoldLabel;

    /** Label for the amount collected */
    private Title amountCollectedLabel;


    /** JPanel for the summary of transactions */
    private JPanel summaryPanel;

    /** JPanel for the inventory */
    private JPanel inventoryPanel;

    /** JPanel for the header */
    private JPanel headerPanel;


    /** The current model of the REGULAR vending machine. */
    private RegularVendingMachineModel currentRegular;

    /** The current model of the SPECIAL vending machine. */
    private SpecialVendingMachineModel currentSpecial;


    /** Constraints for the panel. */
    private GridBagConstraints constraints;

    /** Constraints for the buttons. */
    private GridBagConstraints buttonConstraints;


    /** Button for back (bigger font)*/
    private Button button4;

    /** Button for back (smaller font)*/
    private Button button5;


    /** A list of Swing Components that need to be removed from the inventoryPanel when displaying new content. */
    private java.util.List<Component> componentsToRemoveInventory;

    /**  A list of Swing Components that need to be removed from the summaryPanel when displaying new content. */
    private java.util.List<Component> componentsToRemoveSummary;

    /** Last index */
    private int endIndex;

    /**
     * Constructs a SummaryOfTransactionsView object with the given RegularVendingMachineModel.
     *
     * @param current The RegularVendingMachineModel representing the current vending machine.
     */
    public SummaryOfTransactionsView(RegularVendingMachineModel current){
        super();

        if (current instanceof SpecialVendingMachineModel){
            currentSpecial = (SpecialVendingMachineModel) current;
            currentRegular = null;
            endIndex = 10;
        }

        else{
            currentSpecial = null;
            currentRegular = current;
            endIndex = 9;
        }

        getTitle().setText("TRANSACTIONS SUMMARY");
        getButton1().setText("STARTING INVENTORY");
        getButton2().setText("ENDING INVENTORY");
        getButton3().setText("SUMMARY");

        // create exit button
        button4 = new Button("BACK", DesignKit.white, DesignKit.darkPurple, DesignKit.buttonFont, 400, 50);
        button5 = new Button("BACK", DesignKit.white, DesignKit.darkPurple, DesignKit.vendingFont, 90, 40);

        titleLabel = new Title("", DesignKit.darkPink, DesignKit.titleFont);
        noLabel = new Title("NO.", DesignKit.darkPink, DesignKit.summaryHeaderFont);
        itemNameLabel = new Title("ITEM NAME", DesignKit.darkPink, DesignKit.summaryHeaderFont);
        priceLabel = new Title("PRICE", DesignKit.darkPink, DesignKit.summaryHeaderFont);
        caloriesLabel = new Title("CALORIES", DesignKit.darkPink, DesignKit.summaryHeaderFont);
        quantityLabel = new Title("QUANTITY", DesignKit.darkPink, DesignKit.summaryHeaderFont);
        unitsSoldLabel = new Title("UNITS SOLD", DesignKit.darkPink, DesignKit.summaryHeaderFont);
        amountCollectedLabel = new Title("AMOUNT COLLECTED", DesignKit.darkPink, DesignKit.summaryHeaderFont);

        getPanel().add(button4, getConstraints());

        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridBagLayout());
        inventoryPanel.setBackground(DesignKit.yellow);

        summaryPanel = new JPanel();
        summaryPanel.setLayout(new GridBagLayout());
        summaryPanel.setBackground(DesignKit.yellow);

        headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setPreferredSize(new Dimension(1000, 75));
        headerPanel.setBackground(DesignKit.darkPurple);

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 15, 5, 15);

        buttonConstraints = new GridBagConstraints();
        buttonConstraints.insets = new Insets(0, 0, 0, 0);
        buttonConstraints.anchor = GridBagConstraints.CENTER;
        buttonConstraints.gridx = 0;
        buttonConstraints.gridwidth = 5;

        componentsToRemoveInventory = new ArrayList<>();
        componentsToRemoveSummary = new ArrayList<>();
    }

    public void Inventory(boolean isStarting){

        for (Component component : componentsToRemoveInventory) {
            inventoryPanel.remove(component);
        }

        componentsToRemoveInventory.clear();
        inventoryPanel.repaint();
        inventoryPanel.revalidate();

        // Add labels and button to the main panel with centered alignment
        if (isStarting == true)
            titleLabel.setText("STARTING INVENTORY");
        else
            titleLabel.setText("ENDING INVENTORY");

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        inventoryPanel.add(titleLabel, constraints);


        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER; // This makes the headerPanel span across all columns
        inventoryPanel.add(headerPanel, constraints);

        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        inventoryPanel.add(noLabel, constraints);

        constraints.gridx = 1;
        inventoryPanel.add(itemNameLabel, constraints);

        constraints.gridx = 2;
        inventoryPanel.add(priceLabel, constraints);

        constraints.gridx = 3;
        inventoryPanel.add(caloriesLabel, constraints);

        constraints.gridx = 4;
        inventoryPanel.add(quantityLabel, constraints);

        Title idLabel;
        Title nameLabel;
        Title priceLabel;
        Title caloriesLabel;
        Title quantityLabel;

        // Add inventory items to the main panel using a loop
        constraints.anchor = GridBagConstraints.WEST;
        int row = 2;

        for (int i = 1; i < endIndex; i++) {
            if (currentRegular == null){
                constraints.gridx = 0;
                constraints.gridy = row;
                constraints.gridwidth = 1;
                idLabel = new Title(Integer.toString(currentSpecial.getItem(i).getId()), DesignKit.darkPurple, DesignKit.summaryFont);
                inventoryPanel.add(idLabel, constraints);


                constraints.gridx = 1;
                nameLabel = new Title(currentSpecial.getItem(i).getName(), DesignKit.darkPurple, DesignKit.summaryFont);
                inventoryPanel.add(nameLabel, constraints);

                constraints.gridx = 2;
                priceLabel = new Title(Integer.toString(currentSpecial.getItem(i).getPrice()), DesignKit.darkPurple, DesignKit.summaryFont);
                inventoryPanel.add(priceLabel, constraints);

                constraints.gridx = 3;
                caloriesLabel = new Title(Integer.toString(currentSpecial.getItem(i).getCalories()), DesignKit.darkPurple, DesignKit.summaryFont);
                inventoryPanel.add(caloriesLabel, constraints);

                constraints.gridx = 4;

                if (isStarting == true)
                    quantityLabel = new Title(Integer.toString(currentSpecial.getItem(i).getStartingQuantity()), DesignKit.darkPurple, DesignKit.summaryFont);

                else
                    quantityLabel = new Title(Integer.toString(currentSpecial.getItem(i).getQuantity()), DesignKit.darkPurple, DesignKit.summaryFont);

                inventoryPanel.add(quantityLabel, constraints);

                row++;

                componentsToRemoveInventory.add(idLabel);
                componentsToRemoveInventory.add(nameLabel);
                componentsToRemoveInventory.add(priceLabel);
                componentsToRemoveInventory.add(caloriesLabel);
                componentsToRemoveInventory.add(quantityLabel);
            }

            else {
                constraints.gridx = 0;
                constraints.gridy = row;
                constraints.gridwidth = 1;
                idLabel = new Title(Integer.toString(currentRegular.getItem(i).getId()), DesignKit.darkPurple, DesignKit.summaryFont);
                inventoryPanel.add(idLabel, constraints);


                constraints.gridx = 1;
                nameLabel = new Title(currentRegular.getItem(i).getName(), DesignKit.darkPurple, DesignKit.summaryFont);
                inventoryPanel.add(nameLabel, constraints);

                constraints.gridx = 2;
                priceLabel = new Title(Integer.toString(currentRegular.getItem(i).getPrice()), DesignKit.darkPurple, DesignKit.summaryFont);
                inventoryPanel.add(priceLabel, constraints);

                constraints.gridx = 3;
                caloriesLabel = new Title(Integer.toString(currentRegular.getItem(i).getCalories()), DesignKit.darkPurple, DesignKit.summaryFont);
                inventoryPanel.add(caloriesLabel, constraints);

                constraints.gridx = 4;

                if (isStarting == true)
                    quantityLabel = new Title(Integer.toString(currentRegular.getItem(i).getStartingQuantity()), DesignKit.darkPurple, DesignKit.summaryFont);

                else
                    quantityLabel = new Title(Integer.toString(currentRegular.getItem(i).getQuantity()), DesignKit.darkPurple, DesignKit.summaryFont);

                inventoryPanel.add(quantityLabel, constraints);

                row++;

                componentsToRemoveInventory.add(idLabel);
                componentsToRemoveInventory.add(nameLabel);
                componentsToRemoveInventory.add(priceLabel);
                componentsToRemoveInventory.add(caloriesLabel);
                componentsToRemoveInventory.add(quantityLabel);
            }
        }

        buttonConstraints.gridy = row++;
        inventoryPanel.add(button5, buttonConstraints);

    }

    /**
     * Updates and displays the summary of transactions in the summaryPanel.
     */
    public void Summary(){
        for (Component component : componentsToRemoveSummary) {
            summaryPanel.remove(component);
        }
        summaryPanel.repaint();
        summaryPanel.revalidate();
        componentsToRemoveSummary.clear();

        titleLabel.setText("TRANSACTIONS SUMMARY");

        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        summaryPanel.add(titleLabel, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER; // This makes the headerPanel span across all columns
        summaryPanel.add(headerPanel, constraints);

        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        summaryPanel.add(noLabel, constraints);

        constraints.gridx = 1;
        summaryPanel.add(itemNameLabel, constraints);

        constraints.gridx = 2;
        summaryPanel.add(unitsSoldLabel, constraints);

        constraints.gridx = 3;
        summaryPanel.add(amountCollectedLabel, constraints);


        int unitsSold;
        int amountCollected;

        Title idLabel;
        Title nameLabel;
        Title unitsSoldLabel;
        Title amountCollectedLabel;

        // Add inventory items to the main panel using a loop
        constraints.anchor = GridBagConstraints.WEST;
        int row = 3;

        for (int i = 1; i < endIndex; i++) {
            if(currentRegular == null){
                unitsSold = currentSpecial.getItem(i).getStartingQuantity() - currentSpecial.getItem(i).getQuantity();
                amountCollected = currentSpecial.getItem(i).getPrice() * unitsSold;

                constraints.gridx = 0;
                constraints.gridy = row;
                constraints.gridwidth = 1;
                idLabel = new Title(Integer.toString(currentSpecial.getItem(i).getId()), DesignKit.darkPurple, DesignKit.summaryFont);
                summaryPanel.add(idLabel, constraints);


                constraints.gridx = 1;
                nameLabel = new Title(currentSpecial.getItem(i).getName(), DesignKit.darkPurple, DesignKit.summaryFont);
                summaryPanel.add(nameLabel, constraints);

                constraints.gridx = 2;
                unitsSoldLabel = new Title(Integer.toString(unitsSold), DesignKit.darkPurple, DesignKit.summaryFont);
                summaryPanel.add(unitsSoldLabel, constraints);

                constraints.gridx = 3;
                amountCollectedLabel = new Title(Integer.toString(amountCollected), DesignKit.darkPurple, DesignKit.summaryFont);
                summaryPanel.add(amountCollectedLabel, constraints);

                row++;

                componentsToRemoveSummary.add(idLabel);
                componentsToRemoveSummary.add(nameLabel);
                componentsToRemoveSummary.add(unitsSoldLabel);
                componentsToRemoveSummary.add(amountCollectedLabel);
            }

            else{
                unitsSold = currentRegular.getItem(i).getStartingQuantity() - currentRegular.getItem(i).getQuantity();
                amountCollected = currentRegular.getItem(i).getPrice() * unitsSold;

                constraints.gridx = 0;
                constraints.gridy = row;
                constraints.gridwidth = 1;
                idLabel = new Title(Integer.toString(currentRegular.getItem(i).getId()), DesignKit.darkPurple, DesignKit.summaryFont);
                summaryPanel.add(idLabel, constraints);


                constraints.gridx = 1;
                nameLabel = new Title(currentRegular.getItem(i).getName(), DesignKit.darkPurple, DesignKit.summaryFont);
                summaryPanel.add(nameLabel, constraints);

                constraints.gridx = 2;
                unitsSoldLabel = new Title(Integer.toString(unitsSold), DesignKit.darkPurple, DesignKit.summaryFont);
                summaryPanel.add(unitsSoldLabel, constraints);

                constraints.gridx = 3;
                amountCollectedLabel = new Title(Integer.toString(amountCollected), DesignKit.darkPurple, DesignKit.summaryFont);
                summaryPanel.add(amountCollectedLabel, constraints);

                row++;

                componentsToRemoveSummary.add(idLabel);
                componentsToRemoveSummary.add(nameLabel);
                componentsToRemoveSummary.add(unitsSoldLabel);
                componentsToRemoveSummary.add(amountCollectedLabel);
            }
        }

        buttonConstraints.gridy = row++;
        summaryPanel.add(button5, buttonConstraints);

    }


    /**
     * Sets an ActionListener for the "BACK" button (button4) in the SummaryOfTransactionsView.
     * Triggers the ActionListener when the user clicks the "BACK" button.
     *
     * @param actionListener The ActionListener to set for the "BACK" button.
     */
    public void setButton4Listener(ActionListener actionListener) {
        this.button4.addActionListener(actionListener);
    }

    /**
     * Sets an ActionListener for the "BACK" button (button5) in the SummaryOfTransactionsView.
     * Triggers the ActionListener when the user clicks the "BACK" button.
     *
     * @param actionListener The ActionListener to set for the "BACK" button.
     */
    public void setButton5Listener(ActionListener actionListener) {
        this.button5.addActionListener(actionListener);
    }

    /**
     * Returns the JPanel displaying the summary of transactions.
     *
     * @return The JPanel containing the summary of transactions.
     */
    public JPanel getSummaryPanel() {
        return summaryPanel;
    }

    /**
     * Returns the JPanel displaying the inventory items.
     *
     * @return The JPanel containing the inventory items.
     */
    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }

}