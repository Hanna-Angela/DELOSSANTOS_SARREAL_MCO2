import java.awt.*;

/**
 * Custom GridBagConstraints with predefined properties.
 */
public class Constraints extends GridBagConstraints {

    /**
     * Constructor that creates a new Constraints instance with the specified properties.
     *
     * @param anchor      the anchor for the component within its display area
     * @param weightx     the horizontal weight
     * @param weighty     the vertical weight
     * @param gridx       the column position of the component in the layout grid
     * @param gridy       the row position of the component in the layout grid
     * @param gridwidth   the number of columns the component occupies
     * @param gridheight  the number of rows the component occupies
     * @param topInset    the inset from the top
     * @param leftInset   the inset from the left
     * @param bottomInset the inset from the bottom
     * @param rightInset  the inset from the right
     */
    Constraints(int anchor, double weightx, double weighty, int gridx, int gridy, int gridwidth, int gridheight,
                int topInset, int leftInset, int bottomInset, int rightInset){
        this.anchor = anchor;
        this.weightx = weightx;
        this.weighty = weighty;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
        this.gridx = gridx;
        this.gridy = gridy;

        this.insets = new Insets(topInset, leftInset, bottomInset, rightInset);
    }

    /**
     * Constructor that creates a new Constraints instance with the specified grid position and insets.
     *
     * @param gridx       the column position of the component in the layout grid
     * @param gridy       the row position of the component in the layout grid
     * @param topInset    the inset from the top
     * @param leftInset   the inset from the left
     * @param bottomInset the inset from the bottom
     * @param rightInset  the inset from the right
     */
    Constraints(int gridx, int gridy, int topInset, int leftInset, int bottomInset, int rightInset){

        this.gridx = gridx;
        this.gridy = gridy;

        this.insets = new Insets(topInset, leftInset, bottomInset, rightInset);
    }
}
