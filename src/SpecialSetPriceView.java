import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * View for setting prices for items in a special vending machine.
 * Extends the SetPriceView class.
 */
public class SpecialSetPriceView extends SetPriceView{
    /** Button representing the special item 9. */
    private final JButton item9;

    /**
     * Creates a new instance of SpecialSetPriceView.
     *
     * @param current            The current vending machine model.
     * @param backgroundImagePath The path to the background image for the view.
     */
    public SpecialSetPriceView(RegularVendingMachineModel current, String backgroundImagePath){
        super(current, backgroundImagePath);

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
    public JPanel mainPanel = new JPanel() {
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
     * Returns the button representing the special item 9.
     *
     * @return The button representing the special item 9.
     */
    public JButton getItem9() {
        return item9;
    }


    /**
     * Sets the mouse listener for the special item 9 button.
     *
     * @param mouseListener The mouse listener to be set.
     */
    public void setItem9Listener(MouseListener mouseListener) {
        this.item9.addMouseListener(mouseListener);
    }

}
