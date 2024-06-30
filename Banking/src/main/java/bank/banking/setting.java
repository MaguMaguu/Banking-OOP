package bank.banking;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class setting extends JFrame implements ActionListener {

    private JButton btndelete, btnchange;

    public setting() {
        setTitle("Settings");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnchange = new JButton("Change Password");
        btnchange.setBounds(95, 200, 150, 40);
        btnchange.setFont(new Font("Helvetica", Font.BOLD, 15));
        btnchange.addActionListener(this);

        btndelete = new JButton("Delete Account");
        btndelete.setBounds(295, 200, 150, 40);
        btndelete.setFont(new Font("Helvetica", Font.BOLD, 15));
        btndelete.addActionListener(this);

        add(btnchange);
        add(btndelete);

        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnchange) {
            new change().setVisible(true);
        } else if (e.getSource() == btndelete) {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                deleteAccount();
            }
        }
    }

    private void deleteAccount() {
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_db_username";
        String pass = "your_db_password";
        String query = "DELETE FROM users WHERE user_id = ?";  // Adjust this query to match your database schema

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the user ID parameter, adjust as needed based on how you track the current user
            stmt.setInt(1, getCurrentUserId());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Account deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();  // Close the settings window
            } else {
                JOptionPane.showMessageDialog(this, "Account deletion failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getCurrentUserId() {
        // Implement this method to return the current user's ID
        // This is just a placeholder, adjust it based on your application logic
        return 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new setting());
    }
}
