package bank.banking;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class transac {

    private JFrame t = new JFrame("Transaction History");
    private JLabel transac;
    private JTable table;
    private JButton Back, Exit;

    public transac() {
        t.setSize(400, 300);
        t.setLayout(null);
        t.setResizable(false);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        transac = new JLabel("Transaction History");
        transac.setBounds(30, 30, 300, 40);
        transac.setFont(new Font("Helvetica", Font.BOLD, 15));
        

        // Set up the table data
        Object[][] trans = {
                {" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "}
        };
        String[] columnNames = {"Account No.", "Amount", "Date", "Time"};

        table = new JTable(trans, columnNames);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 80, 340, 100);
        

        Exit = new JButton("Exit");
        Exit.setBounds(50, 200, 100, 30);
        Exit.setFont(new Font("Helvetica", Font.BOLD, 15));
        Exit.addActionListener(e -> t.dispose());
        

        Back = new JButton("Back");
        Back.setBounds(175, 200, 100, 30);
        Back.setFont(new Font("Helvetica", Font.BOLD, 15));
        
        
        t.add(transac);
        t.add(scrollPane);
        t.add(Back);
        t.add(Exit);
        t.setVisible(true);
    }
}
