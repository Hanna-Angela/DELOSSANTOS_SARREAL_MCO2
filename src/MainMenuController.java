import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MainMenuController class controls the main menu view of the application and handles user interactions.
 * It provides listeners for the buttons in the main menu and handles the navigation to other views accordingly.
 */
public class MainMenuController {
    /** The TimedPanelView used for displaying timed messages during specific actions. */
    private TimedPanelView timedPanelView;

    /** The current step during a timed action. */
    private int step;

    /** The Timer used for handling timed actions. */
    private Timer timer;

    /**
     * Constructs a new MainMenuController instance.
     *
     * @param mainModel The MainModel associated with the application.
     * @param mainView  The MainView associated with the application.
     */
    public MainMenuController(MainModel mainModel, MainView mainView){
        DesignKit.frame.setContentPane(mainView.getMainMenuView().getPanel());
        DesignKit.frame.revalidate();

        timedPanelView = new TimedPanelView();

        mainView.getMainMenuView().setButton1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getCreateMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });

        mainView.getMainMenuView().setButton2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainModel.getCurrent() == null){
                    step = 0;
                    timedPanelView.setText1("NO VENDING MACHINE");
                    timedPanelView.setText2("AVAILABLE FOR TESTING...");

                    DesignKit.frame.setContentPane(timedPanelView.getPanel());
                    DesignKit.frame.revalidate();

                    timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            switch (step) {
                                case 0:
                                    timedPanelView.setText1("GOING BACK");
                                    timedPanelView.setText2("TO MAIN MENU...");
                                    DesignKit.frame.revalidate();
                                    step++;
                                    break;
                                case 1:
                                    DesignKit.frame.setContentPane(mainView.getMainMenuView().getPanel());
                                    DesignKit.frame.revalidate();
                                    timer.stop();
                                    break;
                            }
                        }
                    });
                    timer.start();
                }
                else{
                    DesignKit.frame.setContentPane(mainView.getTestMenuView().getPanel());
                    DesignKit.frame.revalidate();
                }
            }
        });

        mainView.getMainMenuView().setButton3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.dispose();
            }
        });
    }
}
