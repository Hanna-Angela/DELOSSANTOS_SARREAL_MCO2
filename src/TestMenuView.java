
/**
 * The TestMenuView class represents the view for the Test Menu in the vending machine application.
 * It extends the MenuView class, providing a menu-like display with buttons and a title.
 */
public class TestMenuView extends MenuView {

    /**
     * Constructs a new TestMenuView.
     * Initializes the view by setting the title and text for each button.
     */
    public TestMenuView(){
        super();
        getTitle().setText("TEST");
        getButton1().setText("VENDING FEATURES");
        getButton2().setText("MAINTENANCE FEATURES");
        getButton3().setText("BACK");
    }
}
