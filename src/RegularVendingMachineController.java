import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The RegularVendingMachineController class controls the regular vending machine view and handles user interactions.
 * It extends the VendingMachineController class and provides listeners for the buttons in the regular vending machine view.
 */
public class RegularVendingMachineController extends VendingMachineController{
    /** The current view of the regular vending machine. */
    private RegularVendingMachineView currentView;

    /** The current model of the regular vending machine. */
    private RegularVendingMachineModel currentModel;

    /**
    * Constructs a new RegularVendingMachineController instance.
    *
    * @param mainModel The main model of the application.
    * @param mainView  The main view of the application.
    */
    public RegularVendingMachineController(MainModel mainModel, MainView mainView){
            super(mainModel, mainView);
            currentView = (RegularVendingMachineView) getCurrentView();
            currentModel = getCurrentModel();

            currentView.getChangeButton().setEnabled(false); // Set initial state of buttons and views

            currentView.setExitButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    currentView.setisDone(false);
                    currentView.getChangeButton().setEnabled(false);
                    currentView.getPaymentButton().setEnabled(true);
                    currentView.getOk().setEnabled(false);
                    currentView.getTotal().setText("TOTAL");

                    currentView.disableKeypad();

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

            currentView.setChangeButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentView.displayChange();

                    currentView.setisDone(false);
                    currentView.getChangeButton().setEnabled(false);
                    currentView.getPaymentButton().setEnabled(true);
                    currentView.getOk().setEnabled(false);
                    currentView.getTotal().setText("TOTAL");

                    currentView.disableKeypad();

                    currentView.getButtonPanel().revalidate();
                    currentView.getButtonPanel().repaint();

                    currentView.getDispenserPanel().removeAll();
                    currentView.getDispenserPanel().revalidate();
                    currentView.getDispenserPanel().repaint();

                    currentModel.setTotalAmountDue(0);
                    currentModel.setTotalPayment(0);

                }
            });

            currentView.setOkListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // buy item
                    buyItem();

                    // add to dispenser
                    dispenseItem();

                    // update total text
                    String totalAmountText = Integer.toString(currentModel.getTotalAmountDue());
                    currentView.getTotal().setText(totalAmountText);

                    // update buttons visibility
                    checkOut();
                    currentView.getOk().setEnabled(false);
                    currentView.getChangeButton().setEnabled(true);

                    DesignKit.frame.revalidate();
                }
            });


        }

    /**
    * Checks the available denominations and enables/disables the buttons based on the change amount and item availability.
    */
    protected void checkOut(){
                if (!currentModel.getItemList(1).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(1).getPrice()))
                    currentView.getNum1().setEnabled(true);

                if (!currentModel.getItemList(2).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(2).getPrice()))
                    currentView.getNum2().setEnabled(true);

                if (!currentModel.getItemList(3).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(3).getPrice()))
                    currentView.getNum3().setEnabled(true);


                if (!currentModel.getItemList(5).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(5).getPrice()))
                    currentView.getNum5().setEnabled(true);

                if (!currentModel.getItemList(6).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(6).getPrice()))
                    currentView.getNum6().setEnabled(true);


                if (!currentModel.getItemList(4).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(4).getPrice()))
                    currentView.getNum4().setEnabled(true);

                if (!currentModel.getItemList(7).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(7).getPrice()))
                    currentView.getNum7().setEnabled(true);

                if (!currentModel.getItemList(8).isEmpty() && (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() >= currentModel.getItem(8).getPrice()))
                    currentView.getNum8().setEnabled(true);
                /*
                for (int i = 1; i < 10; i++){
                    if (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() < currentModel.getItem(i).getPrice()) {
                        currentView.disableKeypad();
                        currentView.getOk().setEnabled(false);
                    }
                }

                for (Item item: currentModel.getItems()) {
                    if (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() < item.getPrice()) {
                        currentView.disableKeypad();
                        currentView.getOk().setEnabled(false);
                }

                if (currentModel.getTotalPayment() - currentModel.getTotalAmountDue() < 20) {
                    currentView.disableKeypad();
                    currentView.getOk().setEnabled(false);


            }

                 */
        }
}
