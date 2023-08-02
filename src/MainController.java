
/**
 * The MainController class represents the main controller of the vending machine simulator.
 * It holds references to various controllers in the application and provides methods to access and set them.
 */
public class MainController {

    /**
     * The controller for the main menu view.
     */
    private MainMenuController mainMenuController;

    /**
     * The controller for the create menu view
     */
    private CreateMenuController createMenuController;

    /**
     * The controller for the test menu view.
     */
    private TestMenuController testMenuController;

    /**
     * The controller for the maintenance menu view.
     */
    private MaintenanceMenuController maintenanceMenuController;

    /**
     * The currently active vending machine controller (either RegularVendingMachineController or SpecialVendingMachineController)
     */
    private VendingMachineController currentController;


    // RegularVendingMachine - maintenance
    /**
     * The controller for the stock item view in RegularVendingMachine maintenance mode.
     */
    private StockItemController stockItemController;

    /**
     * The controller for the set price view in RegularVendingMachine maintenance mode.
     */
    private SetPriceController setPriceController;

    // BOTH - maintenance
    /**
     * The controller for the replenish denominations view.
     */
    private ReplenishDenominationsController replenishDenominationsController;

    /**
     * The controller for the summary of transactions view.
     */
    private SummaryOfTransactionsController summaryOfTransactionsController;

    // SpecialVendingMachine - maintenance
    /**
     * The controller for the special stock item view in SpecialVendingMachine maintenance mode.
     */
    private SpecialStockItemController specialStockItemController;

    /**
     * The controller for the special set price view in SpecialVendingMachine maintenance mode.
     */
    private SpecialSetPriceController specialSetPriceController;


    /**
     * Creates a new instance of MainController with the specified mainModel and mainView.
     *
     * @param mainModel The main model representing the vending machine data.
     * @param mainView  The main view containing the different views and panels.
     */
    public MainController(MainModel mainModel, MainView mainView) {

        mainMenuController = new MainMenuController(mainModel, mainView);
        testMenuController = new TestMenuController(mainView);
        createMenuController = new CreateMenuController(mainModel, mainView, this);
        maintenanceMenuController = new MaintenanceMenuController(mainView);

        currentController = null;
        setPriceController = null;
        stockItemController = null;

        replenishDenominationsController = null;
        summaryOfTransactionsController = null;

        specialSetPriceController = null;
        specialStockItemController = null;
    }

    /**
     * Sets the vending machine controller.
     *
     * @param currentController The VendingMachineController to be set.
     */
    public void setVendingMachineController(VendingMachineController currentController) {
        this.currentController = currentController;
    }

    /**
     * Sets the stock item controller for regular items.
     *
     * @param stockItemController The StockItemController to be set.
     */
    public void setStockItemController(StockItemController stockItemController) {
        this.stockItemController = stockItemController;
    }

    /**
     * Sets the set price controller for regular items.
     *
     * @param setPriceController The SetPriceController to be set.
     */
    public void setSetPriceController(SetPriceController setPriceController) {
        this.setPriceController = setPriceController;
    }

    /**
     * Sets the replenish denominations controller for both regular and special items.
     *
     * @param replenishDenominationsController The ReplenishDenominationsController to be set.
     */
    public void setReplenishDenominationsController(ReplenishDenominationsController replenishDenominationsController) {
        this.replenishDenominationsController = replenishDenominationsController;
    }

    /**
     * Sets the summary of transactions controller for both regular and special items.
     *
     * @param summaryOfTransactionsController The SummaryOfTransactionsController to be set.
     */
    public void setSummaryOfTransactionsController(SummaryOfTransactionsController summaryOfTransactionsController) {
        this.summaryOfTransactionsController = summaryOfTransactionsController;
    }

    /**
     * Sets the special stock item controller for special items.
     *
     * @param specialStockItemController The SpecialStockItemController to be set.
     */
    public void setSpecialStockItemController(SpecialStockItemController specialStockItemController) {
        this.specialStockItemController = specialStockItemController;
    }

    /**
     * Sets the special set price controller for special items.
     *
     * @param specialSetPriceController The SpecialSetPriceController to be set.
     */
    public void setSpecialSetPriceController(SpecialSetPriceController specialSetPriceController) {
        this.specialSetPriceController = specialSetPriceController;
    }
}