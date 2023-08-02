import javax.swing.*;

/**
 * The {@code Frame} class represents a custom JFrame for a Vending Machine Simulator.
 * It extends the JFrame class and sets up the initial configuration for the frame.
 */
public class Frame extends JFrame {
    /**
     * Constructs a new {@code Frame} object. It sets up the initial properties for the frame.
     * The frame title is set to "Vending Machine Simulator".
     * The default close operation is set to exit out of the application.
     * The frame is set to a fixed size and is not resizable.
     * The frame is made visible and centered on the screen.
     * The frame's icon is set to a custom image.
     * The background color of the content pane is set to a specific color.
     */
    Frame(){
        this.setTitle("Vending Machine Simulator"); // frame title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false); // prevent frame from being resized
        this.setSize(1000,700); // set x and y dimension of frame
        this.setVisible(true); //make frame visible
        this.setLocationRelativeTo(null); //center frame

        ImageIcon image = new ImageIcon("resources/logo.png"); //create ImageIcon
        this.setIconImage(image.getImage()); // change icon of frame
        // sets the background color of the content pane to a specific color defined in DesignKit
        this.getContentPane().setBackground(DesignKit.yellow); // background color
    }
}
