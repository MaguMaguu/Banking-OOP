package bank.banking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;
import javax.swing.*;

public class Login implements ActionListener {

    private JFrame log = new JFrame("Nyecash");
    private JTextField txtaccnum = new JTextField();
    private JPasswordField txtPin = new JPasswordField();
    private JLabel lblaccnum, lblPin, welcome;
    private JButton Confirm, Register;

    public Login(Accounts accountsFrame) {
        this.accountsFrame = accountsFrame;
        log.setVisible(true);
        log.setSize(400, 300);
        log.setLayout(null);
        log.setResizable(false);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        welcome = new JLabel("Welcome to Nyecash");
        welcome.setBounds(100, 30, 200, 40);
        welcome.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblaccnum = new JLabel("Account No.: ");
        lblaccnum.setBounds(30, 100, 120, 30);
        txtaccnum.setBounds(150, 100, 120, 30);
        txtaccnum.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblPin = new JLabel("Enter Pin: ");
        lblPin.setBounds(30, 150, 120, 30);
        txtPin.setBounds(150, 150, 120, 30);
        txtPin.setFont(new Font("Helvetica", Font.BOLD, 15));

        Confirm = new JButton("Confirm");
        Confirm.setBounds(20, 200, 100, 30);
        Confirm.setFont(new Font("Helvetica", Font.BOLD, 15));
        Confirm.addActionListener(this);

        Register = new JButton("Register");
        Register.setBounds(150, 200, 100, 30);
        Register.setFont(new Font("Helvetica", Font.BOLD, 15));
        Register.addActionListener(this);

        log.add(welcome);
        log.add(lblaccnum);
        log.add(txtaccnum);
        log.add(lblPin);
        log.add(txtPin);
        log.add(Confirm);
        log.add(Register);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Confirm) {
            String accnum = txtaccnum.getText();
            String pin = new String(txtPin.getPassword());

            if (ValidateLogin(accnum, pin)) {
                log.dispose();
                new Accounts().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(log, "Invalid account number or MPIN.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == Register) {
            log.dispose();
            new register().setVisible(true);
        }
    }
    public void showFrame() {
        log.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
