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
        int input[] = new int[2];
        try {
            input[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the grid size (Integers Only): "));
            input[1] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of ships (Integers Only): "));
            grid = new BattleshipGrid(input[0], input[1]);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            Console.errprintln("Error creating grid: " + e.getMessage());
            hasError = true;
        }
        if (grid != null) {
            frame.add(grid, BorderLayout.CENTER);  // Correct use of BorderLayout.CENTER
        } else {
            Console.errprintln("Error: grid initialization failed.");
        }
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Console.toggleVisibility();
        Console.errprintln(1.0 / 0.0);
        Console.println(BattleshipInterface.INIT_WIDTH);
        Console.println(BattleshipInterface.INIT_HEIGHT);

        // Time Stuff
        Date now = new Date();

        // Format date and time
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String formattedDateTime = formatter.format(now);

        Battleship battleship = new Battleship();
        if (hasError) {
            Console.errprintln("Failed to start the game due to an error. The game will now exit in");
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
            Console.println("Game Started: " + formattedDateTime);
        }
    }
}