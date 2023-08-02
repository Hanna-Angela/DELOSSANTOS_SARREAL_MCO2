import javax.swing.*;
import java.awt.*;

/**
 * The TimedPanelView class represents the view for the timed panels used in the main menu and create vending machine menu.
 */
public class TimedPanelView {
    /** The Title component for displaying the first text. */
    private final Title text1;

    /** The Title component for displaying the second text.*/
    private final Title text2;

    /** The JPanel that contains the text components and serves as the view for TimedPanelView.*/
    private final JPanel panel;

    /** The Constraints object used for the placement of components within the panel. */
    private final Constraints constraints;

    /**
     * Constructs a new TimedPanelView.
     * Initializes the panel, text components, and the Constraints object.
     */
    public TimedPanelView(){
        constraints = new Constraints(0, GridBagConstraints.RELATIVE, 10,0,10,0);

        text1 = new Title("", DesignKit.darkPink, DesignKit.titleFont);
        text2 = new Title("", DesignKit.darkPink, DesignKit.titleFont);

        panel = new JPanel(new GridBagLayout());
        panel.setBackground(DesignKit.yellow);
        panel.add(text1, constraints);
        panel.add(text2, constraints);
    }

    /**
     * Get the JPanel that contains the text components and serves as the view for TimedPanelView.
     *
     * @return The JPanel containing the text components.
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Sets the text for the first text component (text1).
     *
     * @param text The text to be displayed in the first text component.
     */
    public void setText1(String text) {
        this.text1.setText(text);
    }

    /**
     * Sets the text for the second text component (text2).
     *
     * @param text The text to be displayed in the second text component.
     */
    public void setText2(String text) {
        this.text2.setText(text);
    }



}
