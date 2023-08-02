import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The TestMenuController class is responsible for handling user interactions and actions related to the Test Menu View.
*/
public class TestMenuController {

    /**
     * Constructs a new TestMenuController.
     * Sets action listeners for the buttons in the Test Menu View and associates them with the corresponding actions.
     *
     * @param mainView The MainView instance to interact with the Test Menu View and other views.
     */
    public TestMenuController(MainView mainView){
        mainView.getTestMenuView().setButton1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getVendingMachineView().displayPanel();
                DesignKit.frame.revalidate();
            }
        });

        mainView.getTestMenuView().setButton2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getMaintenanceMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });

        mainView.getTestMenuView().setButton3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getMainMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });


    }

}
