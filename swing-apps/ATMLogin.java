
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMLogin extends JFrame implements ActionListener {

    private JTextField userField;
    private JPasswordField pinField;
    private JButton loginButton;

    public ATMLogin() {
        setTitle("ATM Login System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

       
        setLayout(new GridLayout(3, 2, 10, 10));

      
        JLabel userLabel = new JLabel("Username:");
        userField = new JTextField();

        JLabel pinLabel = new JLabel("PIN:");
        pinField = new JPasswordField();

        loginButton = new JButton("Login");

        
        add(userLabel);
        add(userField);
        add(pinLabel);
        add(pinField);
        add(new JLabel()); 
        add(loginButton);

        
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String pin = new String(pinField.getPassword());

        if(username.equals("admin") && pin.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or PIN!");
        }
    }

    public static void main(String[] args) {
        ATMLogin atm = new ATMLogin();
        atm.setVisible(true);
    }
}
