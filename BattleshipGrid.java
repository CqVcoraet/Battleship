// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BattleshipGrid extends JPanel {
    private JPanel panel;
    private JButton[][] tiles;
    private boolean[][] coords;
    private boolean[][] locatedCoords;
    private BattleshipPane grid;
    private int gridSize;
    private int numShips;
    private int numShots;
    private int numHits;
    private int numMisses;
    private int numShipsSunk;
    private boolean allSunk;

    public BattleshipGrid(int gridSize, int numShips) {
        this.gridSize = gridSize;
        this.numShips = numShips;
        this.numShots = 0;
        this.numHits = 0;
        this.numMisses = 0;
        this.numShipsSunk = 0;
        this.allSunk = false;
        this.grid = new BattleshipPane(gridSize, numShips);
        tiles = new JButton[gridSize][gridSize];
        coords = new boolean[gridSize][gridSize];
        locatedCoords = new boolean[gridSize][gridSize];
    }

    public boolean isHit(int row, int col) {
        // Example logic to check if the shot hits a ship
        return locatedCoords[row][col]; // Check if there is a ship at the specified location
    }

    public void placeShipsRandomly() {
    Random random = new Random();
    for (int i = 0; i < numShips; i++) {
        int shipRow, shipCol;
        do {
            shipRow = random.nextInt(gridSize); // Random row
            shipCol = random.nextInt(gridSize); // Random column
        } while (locatedCoords[shipRow][shipCol]); // Ensure it's not already occupied

        locatedCoords[shipRow][shipCol] = true; // Place the ship at the random location
    }
}
}
