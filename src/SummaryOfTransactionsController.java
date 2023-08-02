import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SummaryOfTransactionsController class is responsible for managing the interactions between the MainView
 * and the SummaryOfTransactionsView. It sets up ActionListeners for the buttons in the SummaryOfTransactionsView
 * and handles the actions when these buttons are clicked.
 */
public class SummaryOfTransactionsController {

    /**
     * Constructs a SummaryOfTransactionsController and sets up ActionListeners for the buttons in the SummaryOfTransactionsView.
     * The action listeners handle the actions to be taken when the corresponding buttons are clicked.
     *
     * @param mainView The MainView containing the SummaryOfTransactionsView to be controlled.
     */
    public SummaryOfTransactionsController(MainView mainView){
        mainView.getSummaryOfTransactionsView().setButton1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getSummaryOfTransactionsView().Inventory(true);
                DesignKit.frame.setContentPane(mainView.getSummaryOfTransactionsView().getInventoryPanel());
                DesignKit.frame.revalidate();

            }
        });

        mainView.getSummaryOfTransactionsView().setButton2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getSummaryOfTransactionsView().Inventory(false);
                DesignKit.frame.setContentPane(mainView.getSummaryOfTransactionsView().getInventoryPanel());
                DesignKit.frame.revalidate();
                DesignKit.frame.repaint();
            }
        });

        mainView.getSummaryOfTransactionsView().setButton3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getSummaryOfTransactionsView().Summary();
                DesignKit.frame.setContentPane(mainView.getSummaryOfTransactionsView().getSummaryPanel());
                DesignKit.frame.revalidate();
            }
        });

        mainView.getSummaryOfTransactionsView().setButton4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getMaintenanceMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });

        mainView.getSummaryOfTransactionsView().setButton5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getSummaryOfTransactionsView().getPanel());
                DesignKit.frame.revalidate();
            }
        });
    }

}
