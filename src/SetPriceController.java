import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A controller class for setting prices for items in a vending machine.
 */
public class SetPriceController {
    /** View for setting item prices. */
    private SetPriceView setPriceView;

    /** The current vending machine model. */
    private RegularVendingMachineModel currentModel;

    /**  The user's choice for which item to set new price*/
    private int choice;

    /** The updated price of an item. */
    private String updatedPrice;

    /** A flag to indicate the next action*/
    private boolean next;

    /**
     * Creates a new instance of SetPriceController.
     *
     * @param mainModel The main model containing the vending machine models.
     * @param mainView  The main view containing the set price view.
     */
    public SetPriceController(MainModel mainModel, MainView mainView){
        setPriceView = mainView.getSetPriceView();
        currentModel = mainModel.getCurrent();

        setPriceView.enableKeypad();
        setPriceView.getNum9().setEnabled(false);

        updatedPrice = "";
        choice = 0;
        next = false;

        setPriceView.setExitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPriceView.enableKeypad();
                setPriceView.getNum9().setEnabled(false);
                DesignKit.frame.setContentPane(mainView.getMaintenanceMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });

        setPriceView.setNum1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(1);

                if(!next){
                    setPriceView.disableKeypad();
                    choice = 1;
                    String getPrice = Integer.toString(currentModel.getItem(choice).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }

                if(next){
                    updatedPrice += "1";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setNum2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(2);

                if(!next){
                    setPriceView.disableKeypad();
                    choice = 2;
                    String getPrice = Integer.toString(currentModel.getItem(choice).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }
                if(next){
                    updatedPrice += "2";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setNum3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(3);
                if(!next){
                    setPriceView.disableKeypad();
                    choice = 3;
                    String getPrice = Integer.toString(currentModel.getItem(choice).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }
                if(next){
                    updatedPrice += "3";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setNum4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(4);
                if(!next){
                    setPriceView.disableKeypad();
                    choice = 4;
                    String getPrice = Integer.toString(currentModel.getItem(choice).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }
                if(next){
                    updatedPrice += "4";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setNum5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(5);
                if(!next){
                    setPriceView.disableKeypad();
                    choice = 5;
                    String getPrice = Integer.toString(currentModel.getItem(choice).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }
                if(next){
                    updatedPrice += "5";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setNum6Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(6);
                if(!next){
                    setPriceView.disableKeypad();
                    choice = 6;
                    String getPrice = Integer.toString(currentModel.getItem(choice).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }
                if(next){
                    updatedPrice += "6";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setNum7Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(7);
                if(!next){
                    setPriceView.disableKeypad();
                    choice = 7;
                    String getPrice = Integer.toString(currentModel.getItem(choice).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }
                if(next){
                    updatedPrice += "7";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setNum8Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(8);

                if(!next){
                    setPriceView.disableKeypad();
                    choice = 8;
                    String getPrice = Integer.toString(currentModel.getItem(choice).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }
                if(next){
                    updatedPrice += "8";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setNum9Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(9);

                if(getNext()){
                    updatedPrice += "9";
                    setPriceView.setNewPrice(updatedPrice);
                }
                setPriceView.getOk().setEnabled(true);
            }
        });

        setPriceView.setOkListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (next) {
                    int updatedPriceInt = Integer.parseInt(updatedPrice);
                    currentModel.getItem(choice).setPrice(updatedPriceInt);
                    setPriceView.setOldPrice("OLD PRICE");
                    setPriceView.setNewPrice("NEW PRICE");
                    setPriceView.getEnterCode().setText("ENTER CODE:");
                    choice = 0;
                    updatedPrice = "";
                    setPriceView.getNum9().setEnabled(false);
                }

                else{
                    setPriceView.getEnterCode().setText("ENTER PRICE:");
                    setPriceView.getNum9().setEnabled(true);
                }


                next = !next;
                setPriceView.getOk().setEnabled(false);
                setPriceView.enableKeypad();
            }
        });

        // HOVER ACTIONS
        setPriceView.setItem1Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item1 = setPriceView.getItem1();
                setPriceView.itemDescription(1);
                setPriceView.getPopupMenu().show(item1, item1.getWidth(), item1.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);

            }
        });

        setPriceView.setItem2Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item2 = setPriceView.getItem2();
                setPriceView.itemDescription(2);
                setPriceView.getPopupMenu().show(item2, item2.getWidth(), item2.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);

            }
        });

        setPriceView.setItem3Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item3 = setPriceView.getItem3();
                setPriceView.itemDescription(3);
                setPriceView.getPopupMenu().show(item3, item3.getWidth(), item3.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);

            }
        });

        setPriceView.setItem4Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item4 = setPriceView.getItem4();
                setPriceView.itemDescription(4);
                setPriceView.getPopupMenu().show(item4, item4.getWidth(), item4.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);

            }
        });

        setPriceView.setItem5Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item5 = setPriceView.getItem5();
                setPriceView.itemDescription(5);
                setPriceView.getPopupMenu().show(item5, item5.getWidth(), item5.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);

            }
        });

        setPriceView.setItem6Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item6 = setPriceView.getItem6();
                setPriceView.itemDescription(6);
                setPriceView.getPopupMenu().show(item6, item6.getWidth(), item6.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);

            }
        });

        setPriceView.setItem7Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item7 = setPriceView.getItem7();
                setPriceView.itemDescription(7);
                setPriceView.getPopupMenu().show(item7, item7.getWidth(), item7.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);

            }
        });

        setPriceView.setItem8Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item8 = setPriceView.getItem8();
                setPriceView.itemDescription(8);
                setPriceView.getPopupMenu().show(item8, item8.getWidth(), item8.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);

            }
        });
    }

    /**
     * Gets the view for setting item prices.
     *
     * @return The SetPriceView instance.
     */
    public SetPriceView getSetPriceView() {
        return setPriceView;
    }

    /**
     * Gets the current vending machine model.
     *
     * @return The RegularVendingMachineModel instance.
     */
    public RegularVendingMachineModel getCurrentModel() {
        return currentModel;
    }

    /**
     * Sets the current vending machine model.
     *
     * @param currentModel The RegularVendingMachineModel instance to set.
     */
    public void setCurrentModel(RegularVendingMachineModel currentModel) {
        this.currentModel = currentModel;
    }

    /**
     * Gets the updated price value.
     *
     * @return The updated price as a String.
     */
    public String getUpdatedPrice() {
        return updatedPrice;
    }

    /**
     * Sets the updated price value.
     *
     * @param updatedPrice The new updated price to set.
     */
    public void setUpdatedPrice(String updatedPrice) {
        this.updatedPrice += updatedPrice;
    }

    /**
     * Gets the state of the "next" flag.
     *
     * @return True if next is enabled, false otherwise.
     */
    public boolean getNext() {
        return next;
    }

    /**
     * Sets the state of the "next" flag.
     *
     * @param next The new value of the "next" flag.
     */
    public void setNext(boolean next) {
        this.next = next;
    }

    /**
     * Set the item choice for the stock item view.
     *
     * @param choice The item choice to set.
     */
    public void setChoice(int choice) {
        this.choice = choice;
    }
}
