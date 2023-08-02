import javax.swing.*;
import java.awt.*;

/**
 * The Title class allows setting the title text, text color, and font during initialization
 * It extends the JLabel class to provide a convenient way to create and style title labels in Swing applications.
 */
public class Title extends JLabel {

    /**
     * Constructs a new Title label with the specified title text, color, and font.
     *
     * @param title The text to be displayed as the title.
     * @param color The color to be applied to the title text.
     * @param font  The font to be used for rendering the title text.
     */
    Title(String title, Color color, Font font){
        this.setText(title);
        this.setForeground(color);
        this.setFont(font);
    }
}