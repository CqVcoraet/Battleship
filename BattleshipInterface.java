// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface BattleshipInterface {
    // Static Constants - CANNOT BE CHANGED
    static int INIT_WIDTH = 800;
    static int INIT_HEIGHT = 600;

    // Interface Methods - MUST BE IMPLEMENTED BY SUBCLASSES
    void createGrid();
    void actionPerformed(ActionEvent e);
    void updateDisplay();
    void placeShip(int row, int col, boolean horizontal);
    void fireShot(int row, int col);
    void checkForShip(int row, int col);
    void checkForSunkShip(int row, int col);
    void checkForWin();
}
