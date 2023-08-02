import javax.swing.*;
import java.awt.event.*;

/**
 * Controller class for handling replenishing denominations in a vending machine.
 */
public class ReplenishDenominationsController {
    /** View for replenishing denominations. */
    private ReplenishDenominationsView replenishDenominationsView;

    /** The current vending machine model. */
    private RegularVendingMachineModel currentModel;

    /**  The current vending machine model. */
    private MoneyCompartment moneyCompartment;

    /**  The user's choice for which denomination to replenish*/
    private int choice;

    /** The updated quantity of denominations to be replenished. */
    private String updatedQuantity;

    /** A flag to indicate if the next action*/
    private boolean next;

    /**
     * Constructs a new ReplenishDenominationsController with the specified models and view.
     *
     * @param mainModel The main model containing the vending machine models.
     * @param mainView  The main view containing the replenish denominations view.
     */
    public ReplenishDenominationsController(MainModel mainModel, MainView mainView) {
        moneyCompartment = mainModel.getCurrent().getMoneyCompartment();
        replenishDenominationsView = mainView.getReplenishDenominationsView();
        currentModel = mainModel.getCurrent();

        choice = 0;
        updatedQuantity = "";
        next = false;

        replenishDenominationsView.enableKeypad();
        replenishDenominationsView.getNum7().setEnabled(false);
        replenishDenominationsView.getNum8().setEnabled(false);

        replenishDenominationsView.setExitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DesignKit.frame.setContentPane(mainView.getMaintenanceMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });

        replenishDenominationsView.setNum1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(1);
                if (!next) {
                    replenishDenominationsView.disableKeypad();
                    choice = 1;
                    String getQuantity = Integer.toString(moneyCompartment.getOne());
                    replenishDenominationsView.setOldQty(getQuantity);
                }
                if (next) {
                    updatedQuantity += "1";
                    replenishDenominationsView.setNewQty(updatedQuantity);
                }
                replenishDenominationsView.getOk().setEnabled(true);
            }
        });

        replenishDenominationsView.setNum2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(2);

                if (!next) {
                    replenishDenominationsView.disableKeypad();
                    choice = 2;
                    String getQuantity = Integer.toString(moneyCompartment.getFive());
                    replenishDenominationsView.setOldQty(getQuantity);
                }
                if (next) {
                    updatedQuantity += "2";
                    replenishDenominationsView.setNewQty(updatedQuantity);

                }
                replenishDenominationsView.getOk().setEnabled(true);
            }
        });

        replenishDenominationsView.setNum3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(3);
                if (!next) {
                    replenishDenominationsView.disableKeypad();
                    choice = 3;
                    String getQuantity = Integer.toString(moneyCompartment.getTen());
                    replenishDenominationsView.setOldQty(getQuantity);
                }
                if (next) {
                    updatedQuantity += "3";
                    replenishDenominationsView.setNewQty(updatedQuantity);

                }
                replenishDenominationsView.getOk().setEnabled(true);
            }
        });

        replenishDenominationsView.setNum4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(4);
                if (!next) {
                    replenishDenominationsView.disableKeypad();
                    choice = 4;
                    String getQuantity = Integer.toString(moneyCompartment.getTwenty());
                    replenishDenominationsView.setOldQty(getQuantity);
                }
                if (next) {
                    updatedQuantity += "4";
                    replenishDenominationsView.setNewQty(updatedQuantity);

                }
                replenishDenominationsView.getOk().setEnabled(true);
            }
        });

        replenishDenominationsView.setNum5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(5);
                if (!next) {
                    replenishDenominationsView.disableKeypad();
                    choice = 5;
                    String getQuantity = Integer.toString(moneyCompartment.getFifty());
                    replenishDenominationsView.setOldQty(getQuantity);
                }
                if (next) {
                    updatedQuantity += "5";
                    replenishDenominationsView.setNewQty(updatedQuantity);

                }
                replenishDenominationsView.getOk().setEnabled(true);
            }
        });

        replenishDenominationsView.setNum6Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(6);
                if (!next) {
                    replenishDenominationsView.disableKeypad();
                    choice = 6;
                    String getQuantity = Integer.toString(moneyCompartment.getHundred());
                    replenishDenominationsView.setOldQty(getQuantity);
                }
                if (next) {
                    updatedQuantity += "6";
                    replenishDenominationsView.setNewQty(updatedQuantity);

                }
                replenishDenominationsView.getOk().setEnabled(true);
            }
        });

        replenishDenominationsView.setOkListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (next) {
                    int updatedQuantityInt = Integer.parseInt(updatedQuantity);
                    switch (choice) {
                        case 1:
                            moneyCompartment.setOne(moneyCompartment.getOne() + updatedQuantityInt);
                            break;
                        case 2:
                            moneyCompartment.setFive(moneyCompartment.getFive() + updatedQuantityInt);
                            break;
                        case 3:
                            moneyCompartment.setTen(moneyCompartment.getTen() + updatedQuantityInt);
                            break;
                        case 4:
                            moneyCompartment.setTwenty(moneyCompartment.getTwenty() + updatedQuantityInt);
                            break;
                        case 5:
                            moneyCompartment.setFifty(moneyCompartment.getFifty() + updatedQuantityInt);
                            break;
                        case 6:
                            moneyCompartment.setHundred(moneyCompartment.getHundred() + updatedQuantityInt);
                            break;
                    }
                    replenishDenominationsView.setOldQty("OLD QTY.");
                    replenishDenominationsView.setNewQty("NEW QTY.");
                    replenishDenominationsView.getEnterCode().setText("ENTER CODE:");

                    choice = 0;
                    updatedQuantity = "";
                }
                else
                    replenishDenominationsView.getEnterCode().setText("ENTER QTY:");
                next = !next;

                replenishDenominationsView.getOk().setEnabled(false);
                replenishDenominationsView.enableKeypad();
                replenishDenominationsView.getNum7().setEnabled(false);
                replenishDenominationsView.getNum8().setEnabled(false);

            }
        });

        // HOVER ACTIONS
        replenishDenominationsView.setOneBillListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton oneBill = replenishDenominationsView.getOneBill();
                replenishDenominationsView.denominationDescription(1);
                replenishDenominationsView.getPopupMenu().show(oneBill, oneBill.getWidth(), oneBill.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                replenishDenominationsView.getPopupMenu().setVisible(false);

            }
        });

        replenishDenominationsView.setFiveBillListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton fiveBill = replenishDenominationsView.getFiveBill();
                replenishDenominationsView.denominationDescription(2);
                replenishDenominationsView.getPopupMenu().show(fiveBill, fiveBill.getWidth(), fiveBill.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                replenishDenominationsView.getPopupMenu().setVisible(false);
            }
        });

        replenishDenominationsView.setTenBillListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton tenBill = replenishDenominationsView.getTenBill();
                replenishDenominationsView.denominationDescription(3);
                replenishDenominationsView.getPopupMenu().show(tenBill, tenBill.getWidth(), tenBill.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                replenishDenominationsView.getPopupMenu().setVisible(false);
            }
        });

        replenishDenominationsView.setTwentyBillListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton twentyBill = replenishDenominationsView.getTwentyBill();
                replenishDenominationsView.denominationDescription(4);
                replenishDenominationsView.getPopupMenu().show(twentyBill, twentyBill.getWidth(), twentyBill.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                replenishDenominationsView.getPopupMenu().setVisible(false);
            }
        });

        replenishDenominationsView.setFiftyBillListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton fiftyBill = replenishDenominationsView.getFiftyBill();
                replenishDenominationsView.denominationDescription(5);
                replenishDenominationsView.getPopupMenu().show(fiftyBill, fiftyBill.getWidth(), fiftyBill.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                replenishDenominationsView.getPopupMenu().setVisible(false);
            }
        });

        replenishDenominationsView.setHundredBillListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton hundredBill = replenishDenominationsView.getTwentyBill();
                replenishDenominationsView.denominationDescription(6);
                replenishDenominationsView.getPopupMenu().show(hundredBill, hundredBill.getWidth(), hundredBill.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                replenishDenominationsView.getPopupMenu().setVisible(false);
            }
        });
    }
}
