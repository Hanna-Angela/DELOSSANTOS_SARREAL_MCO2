import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The MenuView abstract class represents a base class for creating menu views in the vending machine simulator.
 * It provides common components like title label and buttons along with methods to set their properties and listeners.
 */
public abstract class MenuView {
    /** The title label displayed at the top of the menu view. */
    private final Title title;

    /** The first button displayed on the menu view. */
    private final Button button1;

    /** The second button displayed on the menu view. */
    private final Button button2;

    /** The third button displayed on the menu view. */
    private final Button button3;

    /** The main panel that contains the menu components. */
    private final JPanel panel;

    /** The constraints used for laying out components in the panel. */
    private final Constraints constraints;

    /**
     * Constructs a new MenuView instance.
     * Initializes the title label, buttons, panel, and constraints for the menu view.
     */
    public MenuView() {
        // Create title label
        title = new Title("", DesignKit.darkPink, DesignKit.titleFont);

        // Create buttons
        button1 = new Button("", DesignKit.white, DesignKit.darkPurple, DesignKit.buttonFont, 400, 50);
        button2 = new Button("", DesignKit.white, DesignKit.darkPurple, DesignKit.buttonFont, 400, 50);
        button3 = new Button("", DesignKit.white, DesignKit.darkPurple, DesignKit.buttonFont, 400, 50);

        // Create panel
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        // Create constraint
        constraints = new Constraints(0, GridBagConstraints.RELATIVE, 10, 0, 10, 0);

        // Add components to panel
        panel.add(title, constraints);
        panel.add(button1, constraints);
        panel.add(button2, constraints);
        panel.add(button3, constraints);
        panel.setBackground(DesignKit.yellow);
    }

    /**
     * Gets the title label of the menu view.
     *
     * @return The title label.
     */
    protected Title getTitle() {
        return title;
    }

    /**
     * Gets the first button of the menu view.
     *
     * @return The first button.
     */
    protected Button getButton1() {
        return button1;
    }

    /**
     * Gets the second button of the menu view.
     *
     * @return The second button.
     */
    protected Button getButton2() {
        return button2;
    }

    /**
     * Gets the third button of the menu view.
     *
     * @return The third button.
     */
    protected Button getButton3() {
        return button3;
    }

    /**
     * Gets the main panel containing the components of the menu view.
     *
     * @return The main panel.
     */
    protected JPanel getPanel() {
        return panel;
    }

    /**
     * Gets the constraints used for laying out components in the panel.
     *
     * @return The constraints.
     */
    protected Constraints getConstraints() {
        return constraints;
    }

    /**
     * Sets the ActionListener for the first button.
     *
     * @param actionListener The ActionListener to be set for the first button.
     */
    protected void setButton1Listener(ActionListener actionListener) {
        this.button1.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the second button.
     *
     * @param actionListener The ActionListener to be set for the second button.
     */
    protected void setButton2Listener(ActionListener actionListener) {
        this.button2.addActionListener(actionListener);
    }

    /**
     * Sets the ActionListener for the third button.
     *
     * @param actionListener The ActionListener to be set for the third button.
     */
    protected void setButton3Listener(ActionListener actionListener) {
        this.button3.addActionListener(actionListener);
    }
}
