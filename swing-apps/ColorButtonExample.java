import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButtonExample {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Color Button Example");

        // Create buttons
        JButton redButton = new JButton("RED");
        JButton greenButton = new JButton("GREEN");
            // Set layout
        frame.setLayout(new GridLayout());

        // Add buttons to frame
        frame.add(redButton);
        frame.add(greenButton);

        // RED button action
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                greenButton.setBackground(Color.RED);
                System.out.println("RED button clicked");
            }
        });

        // GREEN button action
        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redButton.setBackground(Color.GREEN);
                System.out.println("GREEN button clicked");
            }
        });

        // Frame settings
        frame.setSize(300, 150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
