import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A controller class for managing the special vending machine.
 * Extends the VendingMachineController class.
 */
public class SpecialVendingMachineController extends VendingMachineController {
    /** The current view of the special vending machine. */
    private SpecialVendingMachineView currentView;

    /** The current model of the special vending machine. */
    private SpecialVendingMachineModel currentModel;

    /**
     * Creates a new instance of SpecialVendingMachineController.
     *
     * @param mainModel The main model of the application.
     * @param mainView  The main view of the application.
     */
    public SpecialVendingMachineController(MainModel mainModel, MainView mainView){
        super(mainModel, mainView);
        currentView = (SpecialVendingMachineView) getCurrentView();
        currentModel = (SpecialVendingMachineModel) getCurrentModel();

        currentView.getChangeButton().setEnabled(false);
        currentView.getCreateButton().setEnabled(false);

        // resets everything
        currentView.setExitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentModel.setCreateCake(false);
                currentModel.setBoughtCake(false);
                currentModel.setBoughtIcing(false);

                currentModel.getItemChoices().clear();

                currentView.setisDone(false);
                currentView.getChangeButton().setEnabled(false);
                currentView.getCreateButton().setEnabled(false);
                currentView.getPaymentButton().setEnabled(true);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(false);
                currentView.setTotal("TOTAL");
                currentModel.setCodeChoice(0);

                currentView.setCreateCakeText("");
                currentModel.getToppings().clear();

                currentView.getButtonPanel().revalidate();
                currentView.getButtonPanel().repaint();

                currentView.getDispenserPanel().removeAll();
                currentView.getDispenserPanel().revalidate();
                currentView.getDispenserPanel().repaint();

                currentModel.setTotalAmountDue(0);
                currentModel.setTotalPayment(0);

                DesignKit.frame.setContentPane(mainView.getTestMenuView().getPanel());
                DesignKit.frame.revalidate();
            }
        });

        // opens payment popup menu and updates button visibility based on payment
        currentView.setPaymentButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentView.payment();

                if (currentModel.getTotalPayment() != 0)
                    currentView.getPaymentButton().setEnabled(false);

                checkOut();

                currentView.getChangeButton().setEnabled(true);
            }
        });

        // resets everything
        currentView.setChangeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentView.displayChange();

                currentModel.setCreateCake(false);
                currentModel.setBoughtCake(false);
                currentModel.setBoughtIcing(false);

                currentModel.getItemChoices().clear();

                currentView.setisDone(false);
                currentView.getChangeButton().setEnabled(false);
                currentView.getCreateButton().setEnabled(false);
                currentView.getPaymentButton().setEnabled(true);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(false);
                currentView.setTotal("TOTAL");
                currentModel.setCodeChoice(0);

                currentView.setCreateCakeText("");
                currentModel.getToppings().clear();

                currentView.getButtonPanel().revalidate();
                currentView.getButtonPanel().repaint();

                currentView.getDispenserPanel().removeAll();
                currentView.getDispenserPanel().revalidate();
                currentView.getDispenserPanel().repaint();

                currentModel.setTotalAmountDue(0);
                currentModel.setTotalPayment(0);
            }
        });

        // create a cake
        currentView.setCreateButtonListener(new ActionListener() {
            private String cake = null;
            private int step = 0;
            private Timer timer;
            private int currentToppingIndex = 0;
            private int newPrice = 0;
            private int newCalories = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                currentView.getChangeButton().setEnabled(false);
                currentView.disableKeypad();
                step = 0;
                currentToppingIndex = 0;
                newPrice = 0;
                newCalories = 0;

                // create the price and calories for the created item
                for (Item item: currentModel.getItemChoices()) {
                    newPrice += item.getPrice();
                    newCalories += item.getCalories();

                    if (item.getId() > 0 && item.getId() < 4)
                        cake = item.getName();
                    else if(item.getId() > 3 && item.getId() != 9)
                        currentModel.getToppings().add(item.getName());
                }

                currentView.setCreateCakeText("CREATING CAKE...");

                // timed text for the creation of the cake
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch (step) {
                            case 0:
                                currentView.setCreateCakeText("ICING THE...");
                                step++;
                                break;
                            case 1:
                                currentView.setCreateCakeText(cake + "...");
                                step++;
                                break;
                            case 2:
                                currentView.setCreateCakeText("TOPPING WITH...");
                                step++;
                                break;
                            case 3:
                                if (currentToppingIndex < currentModel.getToppings().size()) {
                                    currentView.setCreateCakeText(currentModel.getToppings().get(currentToppingIndex) + "...");
                                    currentToppingIndex++;
                                } else {
                                    // If all toppings are displayed, move to the next step
                                    step++;
                                }
                                break;
                            case 4:
                                currentView.setCreateCakeText("CAKE DONE!");
                                step++;
                                break;
                            case 5:
                                currentView.setCreateCakeText("PRICE: " + newPrice);
                                step++;
                                break;
                            case 6:
                                currentView.setCreateCakeText("CALORIES: " + newCalories);
                                step++;
                                currentView.getChangeButton().setEnabled(true);
                                timer.stop();
                                break;
                        }
                    }
                });

                // Start the timer when the createButton is clicked
                timer.start();

            }
        });

        // KEYPAD ACTIONS
        currentView.setNum9Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(9);
                currentView.disableKeypad();
                currentView.getOk().setEnabled(true);
            }
        });

        currentView.setOkListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // buy item
                buyItem();

                if (currentModel.getCreateCake() == true){
                    currentView.getCreateButton().setEnabled(true);
                }

                if (currentModel.getBoughtIcing() == true || currentModel.getBoughtCake() == true)
                    currentView.getChangeButton().setEnabled(false);
                else
                    currentView.getChangeButton().setEnabled(true);

                // add to dispenser
                dispenseItem();

                // update total text
                String totalAmountText = Integer.toString(currentModel.getTotalAmountDue());
                currentView.setTotal(totalAmountText);

                // update buttons visibility
                checkOut();
                currentView.getOk().setEnabled(false);
            }
        });

        // ITEM HOVER
        currentView.setItem9Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item9 = currentView.getItem9();
                currentView.itemDescription(9);
                currentView.getPopupMenu().show(item9, item9.getWidth(), item9.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentView.getPopupMenu().setVisible(false);

            }
        });
    }

    /**
     * Overrides the buyItem method in the parent class to handle additional logic for special vending machine purchases.
     * Updates the current model's item choices list and sets flags for purchased items (cake, icing, and toppings).
     * If the user has purchased all required items for creating a cake, it sets the 'createCake' flag in the model.
     */
    protected void buyItem(){
        boolean isCake = false, isIcing = false, isTopping = false;
        super.buyItem();

        // adds to the list of items bought
        currentModel.getItemChoices().add(getItemChoice());

        if (currentModel.getCodeChoice() == 9){
            currentModel.setBoughtIcing(true);
        }

        else if (currentModel.getCodeChoice() < 4 && currentModel.getCodeChoice() > 0 ){
            currentModel.setBoughtCake(true);
        }

        // updates the values for the attributes involved in cake creation
        for (Item item: currentModel.getItemChoices()) {
            if (item.getId() > 0 && item.getId() < 4 )
                isCake = true;

            if (item.getId() == 9)
                isIcing = true;

            if (item.getId() > 3 && item.getId() < 9)
                isTopping = true;
        }
        if (isCake == true && isIcing == true && isTopping == true)
            currentModel.setCreateCake(true);
    }

    /**
     * Overrides the dispenseItem method in the parent class to handle additional logic for dispensing items.
     * If the current item choice is for icing (codeChoice = 9), adds the icing icon to the dispenser panel in the view.
     */
    protected void dispenseItem(){
        super.dispenseItem();
        if (currentModel.getCodeChoice() == 9)
            currentView.getDispenserPanel().add(new JLabel(DesignKit.item9Icon));
    }

    /**
     * Overrides the checkOut method in the parent class to handle additional logic for the checkout process in the special vending machine.
     * Updates the visibility of specific items in the view based on the user's payment and purchases.
     * Enables or disables numeric keypad buttons based on the remaining payment required for certain items.
     */
    protected void checkOut() {
        int minToppingPrice = currentModel.getItem(4).getPrice();
        int minCakePrice = currentModel.getItem(1).getPrice();

        // finds minimum cake price
        for (int i = 2; i < 4; i++) {
            if (minCakePrice > currentModel.getItem(i).getPrice())
                minCakePrice = currentModel.getItem(i).getPrice();
        }

        // finds minimum topping price
        for (int i = 5; i < 10; i++) {
            if (minToppingPrice > currentModel.getItem(i).getPrice())
                minToppingPrice = currentModel.getItem(i).getPrice();
        }

        // if payment is valid for cake creation
        if (currentModel.getTotalPayment() >= (currentModel.getItem(9).getPrice() + minCakePrice + minToppingPrice)) {
            if (currentModel.getCodeChoice() == 9 || (currentModel.getCodeChoice() < 4 && currentModel.getCodeChoice() >= 0)) {
                if (currentModel.getBoughtCake() == false) {
                    if (!currentModel.getItemList(1).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(1).getPrice()))
                        currentView.getNum1().setEnabled(true);

                    if (!currentModel.getItemList(2).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(2).getPrice()))
                        currentView.getNum2().setEnabled(true);

                    if (!currentModel.getItemList(3).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(3).getPrice()))
                        currentView.getNum3().setEnabled(true);
                }

                if (!currentModel.getItemList(9).isEmpty() && currentModel.getBoughtIcing() == false && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(9).getPrice()))
                    currentView.getNum9().setEnabled(true);
            }
        }

        // if they haven't picked anything or cake and icing have already been bought
            if (currentModel.getCodeChoice() == 0 || (currentModel.getBoughtIcing() == currentModel.getBoughtCake())) {
                if (!currentModel.getItemList(5).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(5).getPrice()))
                    currentView.getNum5().setEnabled(true);

                if (!currentModel.getItemList(6).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(6).getPrice()))
                    currentView.getNum6().setEnabled(true);


                if (!currentModel.getItemList(4).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(4).getPrice()))
                    currentView.getNum4().setEnabled(true);


                if (!currentModel.getItemList(8).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(8).getPrice()))
                    currentView.getNum8().setEnabled(true);

                if (!currentModel.getItemList(7).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(7).getPrice()))
                    currentView.getNum7().setEnabled(true);
            }
        }
}