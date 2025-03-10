// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface BattleshipInterface {
    // Static Constants - CANNOT BE CHANGED
    public static final int INIT_WIDTH = 800;
    public static final int INIT_HEIGHT = 600;

    // Interface Methods - MUST BE IMPLEMENTED BY SUBCLASSES
    void createGrid();
    void actionPerformed(ActionEvent e);
    void updateDisplay();
    void placeShip(int row, int col, boolean horizontal);
    void fireShot(int row, int col);
    void checkForShip(int row, int col);
    void checkForSunkShip(int row, int col);
}
