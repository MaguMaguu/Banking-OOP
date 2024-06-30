package bank.banking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class change extends JFrame implements ActionListener {

    private JTextField txtOldPin = new JTextField();
    private JPasswordField txtNewPin = new JPasswordField();
    private JLabel lblOldPin, lblNewPin, welcome;
    private JButton Confirm = new JButton();

    public change() {
        setVisible(true);
        setSize(400, 300);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        welcome = new JLabel("Change Pin");
        welcome.setBounds(100, 30, 200, 40);
        welcome.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblOldPin = new JLabel("Enter Old Pin: ");
        lblOldPin.setBounds(30, 100, 120, 30);
        txtOldPin.setBounds(150, 100, 120, 30);
        txtOldPin.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblNewPin = new JLabel("Enter New Pin: ");
        lblNewPin.setBounds(30, 150, 120, 30);
        txtNewPin.setBounds(150, 150, 120, 30);
        txtNewPin.setFont(new Font("Helvetica", Font.BOLD, 15));

        Confirm = new JButton("Confirm");
        Confirm.setBounds(20, 200, 100, 30);
        Confirm.setFont(new Font("Helvetica", Font.BOLD, 15));
        Confirm.addActionListener(this);

        add(welcome);
        add(lblOldPin);
        add(txtOldPin);
        add(lblNewPin);
        add(txtNewPin);
        add(Confirm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Confirm) {
            String oldPin = txtOldPin.getText();
            String newPin = new String(txtNewPin.getPassword());

            if (validateAndChangePin(oldPin, newPin)) {
                JOptionPane.showMessageDialog(this, "Pin changed successfully!");
                dispose();
                // Open another window or close the application
                // new SomeOtherClass().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid old pin or pin update failed.", "Change Pin Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateAndChangePin(String oldPin, String newPin) {
        String url = "jdbc:mysql://localhost:3306/infomanage";
        String user = "your_db_username";
        String pass = "your_db_password";
        String queryCheck = "SELECT * FROM users WHERE pin = ?";
        String queryUpdate = "UPDATE users SET pin = ? WHERE pin = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmtCheck = conn.prepareStatement(queryCheck);
             PreparedStatement stmtUpdate = conn.prepareStatement(queryUpdate)) {

            // Check if old pin is correct
            stmtCheck.setString(1, oldPin);
            ResultSet rs = stmtCheck.executeQuery();
            if (!rs.next()) {
                return false; // Old pin is incorrect
            }

            // Update with the new pin
            stmtUpdate.setString(1, newPin);
            stmtUpdate.setString(2, oldPin);
            int rowsUpdated = stmtUpdate.executeUpdate();

            return rowsUpdated > 0; // Return true if update was successful

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new change());
    }
}
