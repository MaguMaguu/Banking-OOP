package infomanagement;

import java.awt.Font;
import javax.swing.*;
import java.sql.*;

public class transac {

    private JFrame t = new JFrame("");
    private JLabel History;
    private JTable table;
    private JButton Exit = new JButton();

    public transac() {
        t.setSize(600, 500);
        t.setLayout(null);
        t.setResizable(false);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        History = new JLabel("Transaction History");
        History.setBounds(30, 20, 500, 100);
        History.setFont(new Font("Helvetica", Font.BOLD, 15));

        // Fetch data from database
        Object[][] trans = fetchDataFromDatabase();

        String[] columnNames = {"First Name", "Middle Name", "Last Name", "Username", "Address", "Contact Number", "Email"};

        table = new JTable(trans, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 80, 530, 100);

        Exit = new JButton("Exit");
        Exit.setBounds(50, 200, 100, 30);
        Exit.setFont(new Font("Helvetica", Font.BOLD, 15));
        Exit.addActionListener(e -> t.dispose());

        t.add(History);
        t.add(scrollPane);
        t.add(Exit);
        t.setVisible(true);
    }

    private Object[][] fetchDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/infomanagement";
        String user = "root";
        String pass = "";
        String query = "SELECT Firstname, Middlename, Lastname, username, address, contact_no, Email FROM users";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Get ResultSet metadata (number of columns)
            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();

            // Initialize data array based on ResultSet size
            rs.last(); // Move to last row to get row count
            int rows = rs.getRow();
            rs.beforeFirst(); // Move back to initial position

            Object[][] data = new Object[rows][columns];

            // Iterate through ResultSet and populate data array
            int row = 0;
            while (rs.next()) {
                for (int col = 0; col < columns; col++) {
                    data[row][col] = rs.getObject(col + 1);
                }
                row++;
            }

            return data;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(t, "Failed to fetch data from database.", "Error", JOptionPane.ERROR_MESSAGE);
            return new Object[0][0]; // Return empty array in case of error
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new table());
    }
}