package bank.banking;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class withdraw implements ActionListener {

    private JFrame w = new JFrame("Withdraw");
    private JTextField txtAmount = new JTextField();
    private JPasswordField txtPin = new JPasswordField();
    private JLabel lblAmount, lblPin, wdraw;
    private JButton Confirm, Cancel;
    private double balance = 1000.0; // Assume initial balance is 1000.0 for demonstration purposes
    private Accounts accountsFrame;

    public withdraw(Accounts accountsFrame) {
        this.accountsFrame = accountsFrame;

        w.setSize(400, 300);
        w.setLayout(null);
        w.setResizable(false);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wdraw = new JLabel("WITHDRAW");
        wdraw.setBounds(120, 30, 120, 40);
        wdraw.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblAmount = new JLabel("Enter Amount: ");
        lblAmount.setBounds(30, 100, 120, 30);
        txtAmount.setBounds(150, 100, 120, 30);
        txtAmount.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblPin = new JLabel("Enter MPin: ");
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

        w.add(wdraw);
        w.add(txtAmount);
        w.add(lblAmount);
        w.add(lblPin);
        w.add(txtPin);
        w.add(Confirm);
        w.add(Cancel);

        w.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cancel) {
            w.dispose();
            accountsFrame.showFrame();
        }
        if (e.getSource() == Confirm) {
            String amountStr = txtAmount.getText();
            String pin = new String(txtPin.getPassword());

            if (validateWithdrawal(amountStr, pin)) {
                double amount = Double.parseDouble(amountStr);
                balance -= amount;
                JOptionPane.showMessageDialog(w, "Withdrawal successful! Remaining balance: " + balance);
            } else {
                JOptionPane.showMessageDialog(w, "Invalid amount or insufficient balance.", "Withdrawal Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == Cancel) {
            w.dispose();
            accountsFrame.showFrame(); // Show the Accounts frame again
        }
    }

    private boolean validateWithdrawal(String amountStr, String pin) {
        if (amountStr.isEmpty() || pin.isEmpty()) {
            return false;
        }

        try {
            double amount = Double.parseDouble(amountStr);
            if (amount <= 0 || amount > balance) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
