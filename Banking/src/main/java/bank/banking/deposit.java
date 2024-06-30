package bank.banking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class deposit implements ActionListener {

    private JFrame d = new JFrame("Deposit");
    private JTextField txtAmount = new JTextField();
    private JPasswordField txtPin = new JPasswordField();
    private JLabel lblAmount, lblPin, dep;
    private JButton Confirm, Cancel;
    private double balance = 1000.0; // Assume initial balance is 1000.0 for demonstration purposes
    private Accounts accountsFrame;

    public deposit(Accounts accountsFrame) {
        this.accountsFrame = accountsFrame;

        d.setSize(400, 300);
        d.setLayout(null);
        d.setResizable(false);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dep = new JLabel("DEPOSIT");
        dep.setBounds(120, 30, 120, 40);
        dep.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblAmount = new JLabel("Enter Amount: ");
        lblAmount.setBounds(30, 100, 120, 30);
        txtAmount.setBounds(150, 100, 120, 30);
        txtAmount.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblPin = new JLabel("Enter Pin: ");
        lblPin.setBounds(30, 150, 120, 30);
        txtPin.setBounds(150, 150, 120, 30);
        txtPin.setFont(new Font("Helvetica", Font.BOLD, 15));

        Confirm = new JButton("Confirm");
        Confirm.setBounds(20, 200, 100, 30);
        Confirm.setFont(new Font("Helvetica", Font.BOLD, 15));
        Confirm.addActionListener(this);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(150, 200, 100, 30);
        Cancel.setFont(new Font("Helvetica", Font.BOLD, 15));
        Cancel.addActionListener(this);

        d.add(dep);
        d.add(txtAmount);
        d.add(lblAmount);
        d.add(lblPin);
        d.add(txtPin);
        d.add(Confirm);
        d.add(Cancel);

        d.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Confirm) {
            String amountStr = txtAmount.getText();
            String pin = new String(txtPin.getPassword());

            if (validateDeposit(amountStr, pin)) {
                double amount = Double.parseDouble(amountStr);
                balance += amount; // Add the amount to balance
                JOptionPane.showMessageDialog(d, "Deposit successful! New balance: " + balance);
            } else {
                JOptionPane.showMessageDialog(d, "Invalid amount or MPIN.", "Deposit Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == Cancel) {
            d.dispose();
            accountsFrame.showFrame(); // Show the Accounts frame again
        }
    }

    private boolean validateDeposit(String amountStr, String pin) {
        if (amountStr.isEmpty() || pin.isEmpty()) {
            return false;
        }

        try {
            double amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                return false; // Invalid amount
            }
        } catch (NumberFormatException e) {
            return false; // Invalid amount format
        }

        // Here, you should add your actual MPIN validation logic
        // For demonstration purposes, let's assume any non-empty pin is valid
        return true;
    }
}
