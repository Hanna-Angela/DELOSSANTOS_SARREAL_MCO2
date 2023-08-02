import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The StockItemController class controls the logic and interactions for the stock item view.
 * It manages the functionality to create, update, and display stock item information in the vending machine.
 */
public class StockItemController {
    /** View for setting item prices. */
    private StockItemView stockItemView;

    /** The current vending machine model. */
    private RegularVendingMachineModel currentModel;

    /**  The user's choice for which item to stock/restock price. */
    private int choice;

    /** The updated quantity of an item. */
    private String updatedQuantity;

    /** A flag to indicate the next action. */
    private boolean next;

    /**
     * Creates a new StockItemController instance.
     *
     * @param mainModel The main model containing the vending machine data.
     * @param mainView  The main view containing the stock item view.
     */
    public StockItemController(MainModel mainModel, MainView mainView){
        stockItemView = mainView.getStockItemView();
        currentModel = mainModel.getCurrent();

        stockItemView.enableKeypad();
        stockItemView.getNum9().setEnabled(false);

        choice = 0;
        updatedQuantity = "";
        next = false;

        stockItemView.setButtonDoneListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean inputValid = false;
                String itemName = stockItemView.getNewItemName().getText();
                int calories = 0;
                int price = 0;

                try {
                    calories = Integer.parseInt(stockItemView.getNewCalories().getText());
                    price = Integer.parseInt(stockItemView.getNewPrice().getText());
                    inputValid = true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid integer values for Calories/Price.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    inputValid = false;
                }

                if(inputValid) {
                    currentModel.getItem(choice).setName(itemName);
                    currentModel.getItem(choice).setCalories(calories);
                    currentModel.getItem(choice).setPrice(price);
                }
                else
                    stockItemView.createNewItem();

                Window popupWindow = SwingUtilities.getWindowAncestor(stockItemView.getButtonDone());
                popupWindow.dispose();
            }
        });

        stockItemView.setExitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockItemView.enableKeypad();
                stockItemView.getNum9().setEnabled(false);
                DesignKit.frame.setContentPane(mainView.getMaintenanceMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });

        stockItemView.setRestockListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window ancestor = SwingUtilities.getWindowAncestor(stockItemView.getPanel());
                if (ancestor instanceof JDialog) {
                    ((JDialog) ancestor).dispose();
                }
            }
        });

        stockItemView.setChangeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stockItemView.createNewItem();
            }
        });


        stockItemView.setNum1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(1);
                if (!next) {
                    stockItemView.disableKeypad();
                    choice = 1;
                    String getQuantity = Integer.toString(currentModel.getItem(choice).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(choice).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
                if (next) {
                    updatedQuantity += "1";
                    stockItemView.setNewQty(updatedQuantity);
                }
                stockItemView.getOk().setEnabled(true);
            }
        });


        stockItemView.setNum2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(2);

                if (!next) {
                    stockItemView.disableKeypad();
                    choice = 2;
                    String getQuantity = Integer.toString(currentModel.getItem(choice).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(choice).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
                if (next) {
                    updatedQuantity += "2";
                    stockItemView.setNewQty(updatedQuantity);

                }
                stockItemView.getOk().setEnabled(true);
            }
        });

        stockItemView.setNum3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(3);
                if (!next) {
                    stockItemView.disableKeypad();
                    choice = 3;
                    String getQuantity = Integer.toString(currentModel.getItem(choice).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(choice).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
                if (next) {
                    updatedQuantity += "3";
                    stockItemView.setNewQty(updatedQuantity);

                }
                stockItemView.getOk().setEnabled(true);
            }
        });

        stockItemView.setNum4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(4);
                if (!next) {
                    stockItemView.disableKeypad();
                    choice = 4;
                    String getQuantity = Integer.toString(currentModel.getItem(choice).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(choice).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
                if (next) {
                    updatedQuantity += "4";
                    stockItemView.setNewQty(updatedQuantity);

                }
                stockItemView.getOk().setEnabled(true);
            }
        });

        stockItemView.setNum5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(5);
                if (!next) {
                    stockItemView.disableKeypad();
                    choice = 5;
                    String getQuantity = Integer.toString(currentModel.getItem(choice).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(choice).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
                if (next) {
                    updatedQuantity += "5";
                    stockItemView.setNewQty(updatedQuantity);

                }
                stockItemView.getOk().setEnabled(true);
            }
        });

        stockItemView.setNum6Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(6);
                if (!next) {
                    stockItemView.disableKeypad();
                    choice = 6;
                    String getQuantity = Integer.toString(currentModel.getItem(choice).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(choice).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
                if (next) {
                    updatedQuantity += "6";
                    stockItemView.setNewQty(updatedQuantity);

                }
                stockItemView.getOk().setEnabled(true);
            }
        });

        stockItemView.setNum7Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(7);
                if (!next) {
                    stockItemView.disableKeypad();
                    choice = 7;
                    String getQuantity = Integer.toString(currentModel.getItem(choice).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(choice).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
                if (next) {
                    updatedQuantity += "7";
                    stockItemView.setNewQty(updatedQuantity);

                }
                stockItemView.getOk().setEnabled(true);
            }
        });

        stockItemView.setNum8Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(8);
                if (!next) {
                    stockItemView.disableKeypad();
                    choice = 8;
                    String getQuantity = Integer.toString(currentModel.getItem(choice).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(choice).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
                if (next) {
                    updatedQuantity += "8";
                    stockItemView.setNewQty(updatedQuantity);

                }
                stockItemView.getOk().setEnabled(true);
            }
        });

        stockItemView.setNum9Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(9);
                if(getNext()){
                    updatedQuantity += "9";
                    stockItemView.setNewQty(updatedQuantity);
                }
                stockItemView.getOk().setEnabled(true);
            }
        });

        stockItemView.setOkListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (next) {
                    int updatedQtyInt = Integer.parseInt(updatedQuantity);
                    currentModel.getItem(choice).setQuantity(updatedQtyInt);
                    currentModel.getItem(choice).setStartingQuantity(currentModel.getItem(choice).getQuantity());

                    for(int i = 0; i < updatedQtyInt; i++){
                        currentModel.getItemList(choice).add(currentModel.getItem(choice));
                    }

                    stockItemView.setOldQty("OLD QTY.");
                    stockItemView.setNewQty("NEW QTY.");
                    stockItemView.getEnterCode().setText("ENTER CODE:");
                    choice = 0;
                    updatedQuantity = "";

                    stockItemView.getNum9().setEnabled(false);
                }

                else{
                    stockItemView.getEnterCode().setText("ENTER QTY:");
                    stockItemView.getNum9().setEnabled(true);
                }


                next = !next;
                stockItemView.getOk().setEnabled(false);
                stockItemView.enableKeypad();
            }
        });

        // HOVER ACTIONS
        stockItemView.setItem1Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item1 = stockItemView.getItem1();
                stockItemView.itemDescription(1);
                stockItemView.getPopupMenu().show(item1, item1.getWidth(), item1.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });

        stockItemView.setItem2Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item2 = stockItemView.getItem2();
                stockItemView.itemDescription(2);
                stockItemView.getPopupMenu().show(item2, item2.getWidth(), item2.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });

        stockItemView.setItem3Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item3 = stockItemView.getItem3();
                stockItemView.itemDescription(3);
                stockItemView.getPopupMenu().show(item3, item3.getWidth(), item3.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });

        stockItemView.setItem4Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item4 = stockItemView.getItem4();
                stockItemView.itemDescription(4);
                stockItemView.getPopupMenu().show(item4, item4.getWidth(), item4.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });

        stockItemView.setItem5Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item5 = stockItemView.getItem5();
                stockItemView.itemDescription(5);
                stockItemView.getPopupMenu().show(item5, item5.getWidth(), item5.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });

        stockItemView.setItem6Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item6 = stockItemView.getItem6();
                stockItemView.itemDescription(6);
                stockItemView.getPopupMenu().show(item6, item6.getWidth(), item6.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });

        stockItemView.setItem7Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item7 = stockItemView.getItem7();
                stockItemView.itemDescription(7);
                stockItemView.getPopupMenu().show(item7, item7.getWidth(), item7.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });

        stockItemView.setItem8Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item8 = stockItemView.getItem8();
                stockItemView.itemDescription(8);
                stockItemView.getPopupMenu().show(item8, item8.getWidth(), item8.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });
    }

    /**
     * Get the associated StockItemView for this controller.
     *
     * @return The StockItemView associated with this controller.
     */
    public StockItemView getStockItemView() {
        return stockItemView;
    }

    /**
     * Get the current RegularVendingMachineModel instance associated with this controller.
     *
     * @return The current RegularVendingMachineModel instance.
     */
    public RegularVendingMachineModel getCurrentModel() {
        return currentModel;
    }

    /**
     * Set the current RegularVendingMachineModel instance associated with this controller.
     *
     * @param currentModel The RegularVendingMachineModel instance to set.
     */
    public void setCurrentModel(RegularVendingMachineModel currentModel) {
        this.currentModel = currentModel;
    }

    /**
     * Set the item choice for the stock item view.
     *
     * @param choice The item choice to set.
     */
    public void setChoice(int choice) {
        this.choice = choice;
    }

    /**
     * Get the updated quantity string for the stock item view.
     *
     * @return The updated quantity string.
     */
    public String getUpdatedQuantity() {
        return updatedQuantity;
    }

    /**
     * Set the updated quantity string for the stock item view.
     *
     * @param updatedQuantity The updated quantity string to set.
     */
    public void setUpdatedQuantity(String updatedQuantity) {
        this.updatedQuantity += updatedQuantity;
    }

    /**
     * Check if the stock item view is in "next" mode, where quantity input is expected.
     *
     * @return true if the stock item view is in "next" mode, false otherwise.
     */
    public boolean getNext() {
        return next;
    }

    /**
     * Set the "next" mode for the stock item view.
     *
     * @param next true to set the stock item view to "next" mode, false otherwise.
     */
    public void setNext(boolean next) {
        this.next = next;
    }

}
