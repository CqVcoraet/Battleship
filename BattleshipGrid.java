// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        grid.createGrid();
        tiles = new JButton[gridSize][gridSize];
        coords = new boolean[gridSize][gridSize];
        locatedCoords = new boolean[gridSize][gridSize];
        // tiles.setBounds(BattleshipInterface.INIT_WIDTH / gridSize);

    }
}
