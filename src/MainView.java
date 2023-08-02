/**
 * The MainView class represents the main view of the vending machine simulator.
 * It holds references to various views in the application and provides methods to access and set them.
 */
public class MainView {
    /** The main menu view of the application. */
    private final MainMenuView mainMenuView;

    /** The create menu view of the application. */
    private final CreateMenuView createMenuView;

    /** The test menu view of the application. */
    private final TestMenuView testMenuView;

    /** The maintenance menu view of the application. */
    private final MaintenanceMenuView maintenanceMenuView;

    /** The currently displayed vending machine view. */
    private VendingMachineView currentView;

    // REGULAR VIEWS
    /** The stock item view used for managing stock items of the vending machine. */
    private StockItemView stockItemView;

    /** The set price view used for setting prices of items in the vending machine. */
    private SetPriceView setPriceView;

    /** The replenish denominations view used for managing money that is inside the vending machine. */
    private ReplenishDenominationsView replenishDenominationsView;

    /** The summary of transactions view that is used for displaying transaction histories. */
    private SummaryOfTransactionsView summaryOfTransactionsView;

    /**
     * Constructs a new MainView instance.
     * Initializes all views to null.
     */
    public MainView() {
        mainMenuView = new MainMenuView();
        createMenuView = new CreateMenuView();
        testMenuView = new TestMenuView();
        maintenanceMenuView = new MaintenanceMenuView();

        currentView = null;

        stockItemView = null;
        setPriceView = null;
        replenishDenominationsView = null;
        summaryOfTransactionsView = null;
    }

    /**
     * Gets the main menu view of the application.
     *
     * @return The main menu view.
     */
    public MainMenuView getMainMenuView() {
        return mainMenuView;
    }

    /**
     * Gets the create menu view of the application.
     *
     * @return The create menu view.
     */
    public CreateMenuView getCreateMenuView() {
        return createMenuView;
    }

    /**
     * Gets the test menu view of the application.
     *
     * @return The test menu view.
     */
    public TestMenuView getTestMenuView() {
        return testMenuView;
    }

    /**
     * Gets the maintenance menu view of the application.
     *
     * @return The maintenance menu view.
     */
    public MaintenanceMenuView getMaintenanceMenuView() {
        return maintenanceMenuView;
    }

    /**
     * Gets the currently displayed vending machine view.
     *
     * @return The currently displayed vending machine view.
     */
    public VendingMachineView getVendingMachineView() {
        return currentView;
    }

    /**
     * Sets the currently displayed vending machine view.
     *
     * @param currentView The vending machine view to be set as the current view.
     */
    public void setVendingMachineView(VendingMachineView currentView) {
        this.currentView = currentView;
    }

    // MAINTENANCE VIEWS

    /**
     * Gets the stock item view used for managing stock items of the vending machine.
     *
     * @return The stock item view.
     */
    public StockItemView getStockItemView() {
        return stockItemView;
    }

    /**
     * Sets the stock item view used for managing stock items of the vending machine.
     *
     * @param stockItemView The stock item view to be set.
     */
    public void setStockItemView(StockItemView stockItemView) {
        this.stockItemView = stockItemView;
    }

    /**
     * Gets the set price view used for setting prices of items in the vending machine.
     *
     * @return The set price view.
     */
    public SetPriceView getSetPriceView() {
        return setPriceView;
    }

    /**
     * Sets the set price view used for setting prices of items in the vending machine.
     *
     * @param setPriceView The set price view to be set.
     */
    public void setSetPriceView(SetPriceView setPriceView) {
        this.setPriceView = setPriceView;
    }

    /**
     * Gets the replenish denominations view used for managing money in the vending machine.
     *
     * @return The replenish denominations view.
     */
    public ReplenishDenominationsView getReplenishDenominationsView() {
        return replenishDenominationsView;
    }

    /**
     * Sets the replenish denominations view used for managing money in the vending machine.
     *
     * @param replenishDenominationsView The replenish denominations view to be set.
     */
    public void setReplenishDenominationsView(ReplenishDenominationsView replenishDenominationsView) {
        this.replenishDenominationsView = replenishDenominationsView;
    }

    /**
     * Gets the summary of transactions view used for displaying transaction history.
     *
     * @return The summary of transactions view.
     */
    public SummaryOfTransactionsView getSummaryOfTransactionsView() {
        return summaryOfTransactionsView;
    }

    /**
     * Sets the summary of transactions view used for displaying transaction history.
     *
     * @param summaryOfTransactionsView The summary of transactions view to be set.
     */
    public void setSummaryOfTransactionsView(SummaryOfTransactionsView summaryOfTransactionsView) {
        this.summaryOfTransactionsView = summaryOfTransactionsView;
    }
}
