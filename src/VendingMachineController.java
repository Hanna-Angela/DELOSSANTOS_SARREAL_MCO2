import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The VendingMachineController class is responsible for handling user interactions and events in the Vending Machine view.
 * It listens for actions performed by the user, such as making payments, selecting items, and hovering over item buttons.
 */
public class VendingMachineController {
    /** The current view of the regular vending machine. */
    private VendingMachineView currentView;

    /** The current model of the regular vending machine. */
    private RegularVendingMachineModel currentModel;

    /** item chosen*/
    private Item itemChoice;

    /**
     * Constructs a new VendingMachineController with the given main model and main view.
     *
     * @param mainModel The main model containing the current vending machine model.
     * @param mainView  The main view containing the VendingMachineView for user interactions.
     */
    public VendingMachineController(MainModel mainModel, MainView mainView){
        currentView =  mainView.getVendingMachineView();
        currentModel = mainModel.getCurrent();

        // PAYMENT ACTIONS
        currentView.setButton1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setTotalPayment(1);
                currentModel.setTempOne(1);
                currentView.setPaymentLabel("" + currentModel.getTotalPayment());
            }
        });

        currentView.setButton5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setTotalPayment(5);
                currentModel.setTempFive(1);
                currentView.setPaymentLabel("" + currentModel.getTotalPayment());
            }
        });

        currentView.setButton10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setTotalPayment(10);
                currentModel.setTempTen(1);
                currentView.setPaymentLabel("" + currentModel.getTotalPayment());
            }
        });

        currentView.setButton20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setTotalPayment(20);
                currentModel.setTempTwenty(1);
                currentView.setPaymentLabel("" + currentModel.getTotalPayment());
            }
        });

        currentView.setButton50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setTotalPayment(50);
                currentModel.setTempFifty(1);
                currentView.setPaymentLabel("" + currentModel.getTotalPayment());
            }
        });

        currentView.setButton100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setTotalPayment(100);
                currentModel.setTempHundred(1);
                currentView.setPaymentLabel("" + currentModel.getTotalPayment());
            }
        });

        currentView.setButtonDoneListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentView.setPaymentLabel("PAYMENT");
                currentView.setisDone(true);
                Window popupWindow = SwingUtilities.getWindowAncestor(currentView.getButtonDone());
                popupWindow.dispose();
            }
        });

        //KEYPAD ACTIONS

        currentView.setNum1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(1);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        currentView.setNum2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(2);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        currentView.setNum3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(3);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        currentView.setNum4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(4);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        currentView.setNum5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(5);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        currentView.setNum6Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(6);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        currentView.setNum7Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(7);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        currentView.setNum8Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(8);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        // HOVER ACTIONS
        currentView.setItem1Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item1 = currentView.getItem1();
                currentView.itemDescription(1);
                currentView.getPopupMenu().show(item1, item1.getWidth(), item1.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });

        currentView.setItem2Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item2 = currentView.getItem2();
                currentView.itemDescription(2);
                currentView.getPopupMenu().show(item2, item2.getWidth(), item2.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });

        currentView.setItem3Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item3 = currentView.getItem3();
                currentView.itemDescription(3);
                currentView.getPopupMenu().show(item3, item3.getWidth(), item3.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });

        currentView.setItem4Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item4 = currentView.getItem4();
                currentView.itemDescription(4);
                currentView.getPopupMenu().show(item4, item4.getWidth(), item4.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });

        currentView.setItem5Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item5 = currentView.getItem5();
                currentView.itemDescription(5);
                currentView.getPopupMenu().show(item5, item5.getWidth(), item5.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });

        currentView.setItem6Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item6 = currentView.getItem6();
                currentView.itemDescription(6);
                currentView.getPopupMenu().show(item6, item6.getWidth(), item6.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });

        currentView.setItem7Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item7 = currentView.getItem7();
                currentView.itemDescription(7);
                currentView.getPopupMenu().show(item7, item7.getWidth(), item7.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });

        currentView.setItem8Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item8 = currentView.getItem8();
                currentView.itemDescription(8);
                currentView.getPopupMenu().show(item8, item8.getWidth(), item8.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });
    }

    /**
     * Buys the selected item and updates the total amount due and inventory in the model.
     * This method is called when the user clicks the "OK" button after entering the item code.
     */
    protected void buyItem(){
            itemChoice = currentModel.getItem(currentModel.getCodeChoice());

            // updates total amount due
            currentModel.setTotalAmountDue(itemChoice.getPrice());

            // removes 1 item
            currentModel.removeItem(currentModel.getCodeChoice());
    }

    /**
     * Dispenses the selected item in the dispenser panel on the view.
     * This method is called after the user successfully buys an item.
     */
    protected void dispenseItem(){
        JPanel dispenserPanel = currentView.getDispenserPanel();
            switch (currentModel.getCodeChoice()) {
                case 1:
                    dispenserPanel.add(new JLabel(DesignKit.item1Icon));
                    break;
                case 2:
                    dispenserPanel.add(new JLabel(DesignKit.item2Icon));
                    break;
                case 3:
                    dispenserPanel.add(new JLabel(DesignKit.item3Icon));
                    break;
                case 4:
                    dispenserPanel.add(new JLabel(DesignKit.item4Icon));
                    break;
                case 5:
                    dispenserPanel.add(new JLabel(DesignKit.item5Icon));
                    break;
                case 6:
                    dispenserPanel.add(new JLabel(DesignKit.item6Icon));
                    break;
                case 7:
                    dispenserPanel.add(new JLabel(DesignKit.item7Icon));
                    break;
                case 8:
                    dispenserPanel.add(new JLabel(DesignKit.item8Icon));
                    break;
            }
    }


    /**
     * Initiates the checkout process, updating the model and view accordingly.
     * This method is called when the user completes the purchase of one or more items.
     */
    protected void checkOut(){
        // do nothing
    }

    /**
     * Returns the current VendingMachineView associated with this VendingMachineController.
     *
     * @return The current VendingMachineView used for user interactions in the Vending Machine.
     */
    public VendingMachineView getCurrentView() {
        return currentView;
    }

    /**
     * Returns the current RegularVendingMachineModel associated with this VendingMachineController.
     *
     * @return The current RegularVendingMachineModel representing the vending machine's model.
     */
    public RegularVendingMachineModel getCurrentModel() {
        return currentModel;
    }

    /**
     * Returns the selected Item choice made by the user.
     *
     * @return The Item object representing the selected item choice made by the user.
     */
    public Item getItemChoice() {
        return itemChoice;
    }

}
