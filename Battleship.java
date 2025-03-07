// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Battleship extends JPanel {
    private JFrame frame;
    private BattleshipGrid grid;

    public Battleship() {
        // Set the frame size
        frame = new JFrame("Battleship");
        frame.setSize(850, 600);
        // JButton Color Workaround for Mac - FINALLY FIGURED IT OUT!
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error setting native L&F: " + e.getMessage());
        }
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Battleship battleship = new Battleship();
    }
}