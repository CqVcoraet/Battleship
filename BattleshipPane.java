// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BattleshipPane extends JPanel implements BattleshipInterface, ActionListener{

    // Constants - CANNOT BE CHANGED
    private static final int INIT_WIDTH = 850;
    private static final int INIT_HEIGHT = 600;
    
    // Instance Variables
    private int a;
    private int gridSize;
    private int numShips;
    private int numShots;
    private int numHits;
    private int numMisses;
    private int numShipsSunk;
    private boolean allSunk;
    private BattleshipGrid grid;

    public BattleshipPane(int gridSize, int numShips) {
        // Set the size of the panel
        setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
        // Set the background color of the panel
        setBackground(Color.WHITE);
        // Set the layout of the panel
        setLayout(new BorderLayout());
        // Set the grid size
        this.gridSize = gridSize;
        // Set the number of ships
        this.numShips = numShips;
        // Set the number of shots
        this.numShots = 0;
        // Set the number of hits
        this.numHits = 0;
        // Set the number of misses
        this.numMisses = 0;
        // Set the number of ships sunk
        this.numShipsSunk = 0;
        // Set the boolean value of allSunk
        this.allSunk = false;
        grid = new BattleshipGrid(gridSize, numShips);
        setLayout(new BorderLayout());
        add(grid,BorderLayout.CENTER);
        // Create a new grid
        createGrid();
    }

    @Override
    public void createGrid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createGrid'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public void updateDisplay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDisplay'");
    }

    @Override
    public void placeShip(int row, int col, boolean horizontal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'placeShip'");
    }

    @Override
    public void fireShot(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fireShot'");
    }

    @Override
    public void checkForShip(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkForShip'");
    }

    @Override
    public void checkForSunkShip(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkForSunkShip'");
    }

    @Override
    public void checkForWin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkForWin'");
    }
}