// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface BattleshipTemplate {
    void createGrid();
    void actionPerformed(ActionEvent e);
    void updateDisplay();
    void placeShip(int row, int col, boolean horizontal);
    void fireShot(int row, int col);
    void checkForShip(int row, int col);
    void checkForSunkShip(int row, int col);
    void checkForWin();
}
