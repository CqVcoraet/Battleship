// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Battleship extends JPanel {
    private JFrame frame;
    private BattleshipGrid grid;
    public static boolean hasError = false;

    public Battleship() {
        // Set the frame size
        frame = new JFrame("Battleship");
        // JButton Color Workaround for Mac - FINALLY FIGURED IT OUT!
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            Console.errprintln("Error setting native L&F: " + e.getMessage());
            hasError = true;
        }

        int gridSize = 0;
        int numberOfShips = 0;

        while (gridSize <= 0) {
            String gridSizeInput = JOptionPane.showInputDialog(null, "Enter the grid size (Integers Only): ");
            if (gridSizeInput == null) {
                Console.errprintln("Input cancelled. Exiting.");
                hasError = true;
                return;
            }
            try {
                gridSize = Integer.parseInt(gridSizeInput);
                if (gridSize <= 0) {
                    Console.errprintln("Grid size must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                Console.errprintln("Invalid input. Please enter a valid integer for grid size.");
            }
        }

        while (numberOfShips <= 0) {
            String numberOfShipsInput = JOptionPane.showInputDialog(null, "Enter the number of ships (Integers Only): ");
            if (numberOfShipsInput == null) {
                Console.errprintln("Input cancelled. Exiting.");
                hasError = true;
                return;
            }
            try {
                numberOfShips = Integer.parseInt(numberOfShipsInput);
                if (numberOfShips <= 0) {
                    Console.errprintln("Number of ships must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                Console.errprintln("Invalid input. Please enter a valid integer for number of ships.");
            }
        }

        try {
            grid = new BattleshipGrid(gridSize, numberOfShips);
        } catch (Exception e) {
            e.printStackTrace();
            Console.errprintln("Error creating grid: " + e.getMessage());
            hasError = true;
        }

        if (grid != null) {
            frame.add(grid, BorderLayout.CENTER);  // Correct use of BorderLayout.CENTER
        } else {
            Console.errprintln("Error: grid initialization failed because this.grid is null.");
            hasError = true;
        }
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Console.toggleVisibility();
        Console.println(1.0 / 0.0);
        Console.println("INIT_WIDTH: " + BattleshipInterface.INIT_WIDTH);
        Console.println("INIT_HEIGHT: " + BattleshipInterface.INIT_HEIGHT);

        // Time Stuff
        Date now = new Date();

        // Format date and time
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String formattedDateTime = formatter.format(now);

        Battleship battleship = new Battleship();
        if (hasError) {
            Console.errprintln("Failed to start the game due to an error.");
            
            // Show a yes/no confirmation dialog
            int response = JOptionPane.showConfirmDialog(
                null, 
                "Failed to start the game due to an error. Do you want to exit in 5 seconds?", 
                "Error", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.ERROR_MESSAGE
            );
        
            if (response == JOptionPane.YES_OPTION) {
                Console.errprintln("Exiting in");
                try {
                    for (int i = 5; i > -1; i--) {
                        Thread.sleep(1000);
                        Console.errprintln(i);
                    }
                    System.exit(1);
                } catch (InterruptedException e) {
                    Console.errprintln("Error: " + e.getMessage());
                }
            } else {
                Console.println("Exiting canceled. The program will continue running.");
            }
        } else {
            Console.println("Game Started: " + formattedDateTime);
        }
    }
}