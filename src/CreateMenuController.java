import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller responsible for handling the creation of vending machine types through the Create Menu view.
 */
public class CreateMenuController {
    /** The TimedPanelView instance is used for displaying timed messages. */
    private final TimedPanelView timedPanelView;

    /** The current step during vending machine creation. */
    private int step;

    /** The current step during vending machine creation. */
    private Timer timer;

    /**
     * Creates a new instance of the CreateMenuController with the specified mainModel, mainView, and mainController.
     *
     * @param mainModel     the main model representing the vending machine data
     * @param mainView      the main view containing the different views and panels
     * @param mainController the main controller managing the interactions between models and views
     */
    public CreateMenuController(MainModel mainModel, MainView mainView, MainController mainController){
        timedPanelView = new TimedPanelView();

        mainView.getCreateMenuView().setButton1Listener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainModel.setCurrent(new RegularVendingMachineModel());

                    mainView.setVendingMachineView(new RegularVendingMachineView(mainModel.getCurrent(), "resources/VendingMachine.png"));
                    mainController.setVendingMachineController(new RegularVendingMachineController(mainModel, mainView));

                    mainView.setStockItemView(new StockItemView(mainModel.getCurrent(), "resources/MAINTENANCE BG/StockItem.png"));
                    mainController.setStockItemController(new StockItemController(mainModel, mainView));

                    mainView.setSetPriceView(new SetPriceView(mainModel.getCurrent(), "resources/MAINTENANCE BG/SetPrice.png"));
                    mainController.setSetPriceController(new SetPriceController(mainModel, mainView));

                    mainView.setReplenishDenominationsView(new ReplenishDenominationsView(mainModel.getCurrent(), "resources/MAINTENANCE BG/ReplenishDenominations.png"));
                    mainController.setReplenishDenominationsController(new ReplenishDenominationsController(mainModel, mainView));

                    mainView.setSummaryOfTransactionsView(new SummaryOfTransactionsView(mainModel.getCurrent()));
                    mainController.setSummaryOfTransactionsController(new SummaryOfTransactionsController(mainView));

                    step = 0;
                    timedPanelView.setText1("CREATING REGULAR");
                    timedPanelView.setText2("VENDING MACHINE...");

                    DesignKit.frame.setContentPane(timedPanelView.getPanel());
                    DesignKit.frame.revalidate();

                    timer = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                switch (step) {
                                    case 0:
                                        timedPanelView.setText1("DONE! GOING BACK");
                                        timedPanelView.setText2("TO MAIN MENU...");
                                        DesignKit.frame.revalidate();
                                        step++;
                                        break;
                                    case 1:
                                        DesignKit.frame.setContentPane(mainView.getMainMenuView().getPanel());
                                        DesignKit.frame.revalidate();
                                        step++;
                                        timer.stop();
                                        break;
                                }
                            }
                        });
                        timer.start();
                    }
                });

        mainView.getCreateMenuView().setButton2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainModel.setCurrent(new SpecialVendingMachineModel());
                mainView.setVendingMachineView(new SpecialVendingMachineView(mainModel.getCurrent(), "resources/SpecialVendingMachine.png"));
                mainController.setVendingMachineController(new SpecialVendingMachineController(mainModel, mainView));

                mainView.setStockItemView(new SpecialStockItemView(mainModel.getCurrent(), "resources/MAINTENANCE BG/SpecialStockItem.png"));
                mainController.setSpecialStockItemController(new SpecialStockItemController(mainModel, mainView));

                mainView.setSetPriceView(new SpecialSetPriceView(mainModel.getCurrent(), "resources/MAINTENANCE BG/SpecialSetPrice.png"));
                mainController.setSpecialSetPriceController(new SpecialSetPriceController(mainModel, mainView));

                mainView.setReplenishDenominationsView(new ReplenishDenominationsView(mainModel.getCurrent(), "resources/MAINTENANCE BG/SpecialReplenishDenominations.png"));
                mainController.setReplenishDenominationsController(new ReplenishDenominationsController(mainModel, mainView));

                mainView.setSummaryOfTransactionsView(new SummaryOfTransactionsView(mainModel.getCurrent()));
                mainController.setSummaryOfTransactionsController(new SummaryOfTransactionsController(mainView));

                step = 0;
                timedPanelView.setText1("CREATING SPECIAL");
                timedPanelView.setText2("VENDING MACHINE...");

                DesignKit.frame.setContentPane(timedPanelView.getPanel());
                DesignKit.frame.revalidate();

                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch (step) {
                            case 0:
                                timedPanelView.setText1("DONE! GOING BACK");
                                timedPanelView.setText2("TO MAIN MENU...");
                                DesignKit.frame.revalidate();
                                step++;
                                break;
                            case 1:
                                DesignKit.frame.setContentPane(mainView.getMainMenuView().getPanel());
                                DesignKit.frame.revalidate();
                                step++;
                                timer.stop();
                                break;
                        }
                    }
                });
                timer.start();
            }
        });

        mainView.getCreateMenuView().setButton3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getMainMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });
    }

}
