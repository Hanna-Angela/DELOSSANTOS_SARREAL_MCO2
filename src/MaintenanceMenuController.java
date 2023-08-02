import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MaintenanceMenuController class controls the maintenance menu view of the application and handles user interactions.
 * It provides listeners for the buttons in the maintenance menu thus handling the navigation to other views accordingly.
 */
public class MaintenanceMenuController {

    /**
     * Constructs a new MaintenanceMenuController instance.
     *
     * @param mainView The MainView associated with the application.
     */
    public MaintenanceMenuController(MainView mainView){
        mainView.getMaintenanceMenuView().setButton1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getStockItemView().displayPanel();
                DesignKit.frame.revalidate();
            }
        });

        mainView.getMaintenanceMenuView().setButton2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getSetPriceView().displayPanel();
                DesignKit.frame.revalidate();
            }
        });

        mainView.getMaintenanceMenuView().setButton3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getReplenishDenominationsView().displayPanel();
                DesignKit.frame.revalidate();
            }
        });

        mainView.getMaintenanceMenuView().setButton5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getSummaryOfTransactionsView().getPanel());
                DesignKit.frame.revalidate();
            }
        });

        mainView.getMaintenanceMenuView().setButton6Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getTestMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });


    }

}
