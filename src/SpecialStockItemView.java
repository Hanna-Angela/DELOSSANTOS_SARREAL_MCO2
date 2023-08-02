import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * A view class for stocking/restocking items in a special vending machine.
 * Extends the StockItemView class.
 */
public class SpecialStockItemView extends StockItemView{

    /** Button for item 9 in the vending machine. */
    private final JButton item9;

    /**
     * Creates a new instance of SpecialStockItemView.
     *
     * @param current            The current vending machine model.
     * @param backgroundImagePath The file path of the background image for the view.
     */
    public SpecialStockItemView(RegularVendingMachineModel current, String backgroundImagePath){
        super(current, backgroundImagePath);

        // create buttons
        item9 = new JButton();
        createItem(item9, DesignKit.item9Icon);

        // BUTTONS (LEFT SIDE)
        getItemsConstraints().insets = new Insets(0, 127, 10, 0);
        getItemsPanel().add(getItem1(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(0, 273, 10, 0);
        getItemsPanel().add(getItem2(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(0, 447, 10, 0);
        getItemsPanel().add(getItem3(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(110, 127, 10, 0);
        getItemsPanel().add(getItem4(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(110, 273, 10, 0);
        getItemsPanel().add(getItem5(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(110, 447, 10, 0);
        getItemsPanel().add(getItem6(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(220, 127, 10, 0);
        getItemsPanel().add(getItem7(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(220, 273, 10, 0);
        getItemsPanel().add(getItem8(), getItemsConstraints());

        getItemsConstraints().insets = new Insets(220, 447, 10, 0);
        getItemsPanel().add(item9, getItemsConstraints());

        getButtonPanel().revalidate();
        getButtonPanel().repaint();
    }


    /**
     * JPanel with a custom paintComponent method to display the background image.
     */
    protected JPanel mainPanel = new JPanel() {
        /**
         * Overrides the paintComponent method to draw the background image on the panel.
         *
         * @param g The Graphics object to paint on.
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon backgroundImage = new ImageIcon(getBackgroundImagePath());
            Image image = backgroundImage.getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };


    /**
     * Gets the button for item 9 in the vending machine.
     *
     * @return The button for item 9.
     */
    public JButton getItem9() {
        return item9;
    }

    /**
     * Sets the MouseListener for item 9 in the vending machine.
     *
     * @param mouseListener The MouseListener to set for item 9.
     */
    public void setItem9Listener(MouseListener mouseListener) {
        this.item9.addMouseListener(mouseListener);
    }

}