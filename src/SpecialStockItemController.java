import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A controller class for managing stock items in a special vending machine.
 * Extends the StockItemController class.
 */
public class SpecialStockItemController extends StockItemController{
    /** The view for managing stock items. */
    private SpecialStockItemView stockItemView;

    /** The current vending machine model. */
    private SpecialVendingMachineModel currentModel;

    /**
     * Creates a new instance of SpecialStockItemController.
     *
     * @param mainModel The main model containing the vending machine models.
     * @param mainView  The main view containing the stock item view.
     */
    public SpecialStockItemController(MainModel mainModel, MainView mainView){
        super(mainModel, mainView);
        stockItemView = (SpecialStockItemView) getStockItemView();
        currentModel = (SpecialVendingMachineModel) getCurrentModel();
        setNext(false);

        stockItemView.getNum9().setEnabled(true);

        stockItemView.setNum9Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentModel.setCodeChoice(9);
                if(!getNext()){
                    stockItemView.disableKeypad();
                    setChoice(9);
                    String getQuantity = Integer.toString(currentModel.getItem(currentModel.getCodeChoice()).getQuantity());
                    stockItemView.setOldQty(getQuantity);
                    if (currentModel.getItem(currentModel.getCodeChoice()).getQuantity() == 0) {
                        stockItemView.whenQty0();
                    }
                }
            }
        });

        stockItemView.setItem9Listener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton item9 = stockItemView.getItem9();
                stockItemView.itemDescription(9);
                stockItemView.getPopupMenu().show(item9, item9.getWidth(), item9.getInsets().right);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stockItemView.getPopupMenu().setVisible(false);

            }
        });
    }
}
