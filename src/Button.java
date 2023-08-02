import javax.swing.*;
import java.awt.*;
/**
 * A custom JButton with predefined properties.
 */
public class Button extends JButton{

    /**
     * Creates a new Button instance with the specified properties.
     *
     * @param name           the text to be displayed on the button
     * @param textColor      the color of the text on the button
     * @param backgroundColor the background color of the button
     * @param buttonFont     the font to be used for the button text
     * @param width          the preferred width of the button
     * @param height         the preferred height of the button
     */
    Button(String name, Color textColor, Color backgroundColor, Font buttonFont, int width, int height){
        this.setPreferredSize(new Dimension(width, height));
        this.setText(name);
        this.setFont(buttonFont);
        this.setForeground(textColor);
        this.setBackground(backgroundColor);
    }

}
