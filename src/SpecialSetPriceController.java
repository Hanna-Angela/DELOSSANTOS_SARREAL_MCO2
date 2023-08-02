import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A specialized controller class for setting prices for items in a special vending machine.
 * Extends the SetPriceController class.
 */
public class SpecialSetPriceController extends SetPriceController{
    /** View for setting special item prices. */
    private SpecialSetPriceView setPriceView;

    /** The current special vending machine model. */
    private SpecialVendingMachineModel currentModel;

    /**
     * Creates a new instance of SpecialSetPriceController.
     *
     * @param mainModel The main model containing the vending machine models.
     * @param mainView  The main view containing the special set price view.
     */
    public SpecialSetPriceController(MainModel mainModel, MainView mainView){
        super(mainModel, mainView);
        setPriceView = (SpecialSetPriceView) getSetPriceView();
        currentModel = (SpecialVendingMachineModel) getCurrentModel();
        setNext(false);

        setPriceView.getNum9().setEnabled(true);

        setPriceView.setNum9Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(9);
                if(!getNext()){
                    setPriceView.disableKeypad();
                    setChoice(9);
                    String getPrice = Integer.toString(currentModel.getItem(currentModel.getCodeChoice()).getPrice());
                    setPriceView.setOldPrice(getPrice);
                }
            }
        });

        setPriceView.setItem9Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item9 = setPriceView.getItem9();
                setPriceView.itemDescription(9);
                setPriceView.getPopupMenu().show(item9, item9.getWidth(), item9.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setPriceView.getPopupMenu().setVisible(false);
            }
        });
    }

}
