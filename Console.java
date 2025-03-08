// Imported Packages
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Console extends JFrame {
    private static Console instance;
    private JTextPane textPane;
    private static boolean isVisible;
    private static StyledDocument doc;
    private static Style defaultStyle, errorStyle;

    // Singleton to ensure one instance
    public static Console getInstance() {
        if (instance == null) {
            instance = new Console("Console");
        }
        return instance;
    }

    private Console(String title) {
        super(title);
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBackground(Color.BLACK);
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 14));

        doc = textPane.getStyledDocument();
        defaultStyle = textPane.addStyle("default", null);
        StyleConstants.setForeground(defaultStyle, Color.WHITE);

        errorStyle = textPane.addStyle("error", null);
        StyleConstants.setForeground(errorStyle, Color.decode("#D40000"));

        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);

        // Set the location of the frame to the upper right corner
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width - getWidth();
        int y = 0;
        setLocation(x, y);

        setVisible(true);
    }

    public static void print(Object text) {
        getInstance().appendText(String.valueOf(text), defaultStyle);
    }

    public static void errprint(Object text) {
        getInstance().appendText(String.valueOf(text), errorStyle);
    }
    
    public static void println(Object text) {
        getInstance().appendText(String.valueOf(text) + "\n", defaultStyle);
    }
    
    public static void errprintln(Object text) {
        getInstance().appendText(String.valueOf(text) + "\n", errorStyle);
    }

    public static void spacer() {
        getInstance().appendText("\n", defaultStyle);
    }

    private void appendText(String text, Style style) {
        SwingUtilities.invokeLater(() -> {
            try {
                doc.insertString(doc.getLength(), text, style);
                textPane.setCaretPosition(doc.getLength());
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        });
    }

    public static void toggleVisibility() {
        Console console = getInstance(); // Ensure the instance exists
        isVisible = !isVisible;
        console.setVisible(isVisible);
    }
}
