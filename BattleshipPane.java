import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random; // Import the Random class

public class BattleshipPane extends JPanel {
    private JButton[][] buttons;
    private boolean[][] locatedCoords; // Stores ship locations
    private int gridSize;
    private int numShips;
    
    public BattleshipPane(int rows, int cols) {
        gridSize = rows;
        numShips = 5; // Example: number of ships to place
        locatedCoords = new boolean[gridSize][gridSize];
        buttons = new JButton[gridSize][gridSize];
        setLayout(new GridLayout(gridSize, gridSize)); // Grid layout for the buttons

        // Create grid with buttons
        createGrid();
        
        // Randomly place ships
        placeShipsRandomly();
    }

    private void createGrid() {
        // Initialize buttons and add action listeners
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setPreferredSize(new Dimension(50, 50)); // Button size
                buttons[row][col].setBackground(Color.CYAN); // Default color for water
                buttons[row][col].setActionCommand(row + "," + col); // Action command holds coordinates
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleTileClick(e); // Handle button click
                    }
                });
                add(buttons[row][col]); // Add button to panel
            }
        }
    }

    private void handleTileClick(ActionEvent e) {
        // Get the button that was clicked
        JButton clickedButton = (JButton) e.getSource();
        
        // Parse the coordinates from the action command
        String[] coordinates = clickedButton.getActionCommand().split(",");
        int row = Integer.parseInt(coordinates[0]);
        int col = Integer.parseInt(coordinates[1]);

        // Check if it's a hit or miss
        if (isHit(row, col)) {
            clickedButton.setBackground(Color.RED); // Hit
        } else {
            clickedButton.setBackground(Color.BLUE); // Miss
        }

        clickedButton.setEnabled(false); // Disable button after click
    }

    private boolean isHit(int row, int col) {
        // Returns true if the given location contains a ship
        return locatedCoords[row][col];
    }

    private void placeShipsRandomly() {
        // Randomly place ships on the grid
        Random random = new Random(); // Create an instance of Random
        for (int i = 0; i < numShips; i++) {
            int shipRow, shipCol;
            do {
                shipRow = random.nextInt(gridSize); // Random row
                shipCol = random.nextInt(gridSize); // Random column
            } while (locatedCoords[shipRow][shipCol]); // Ensure the location is empty

            locatedCoords[shipRow][shipCol] = true; // Mark this location as having a ship
        }
    }
}