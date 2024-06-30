package bank.banking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Accounts implements ActionListener {

    private JFrame a;
    private JButton bal, dep, wdraw, trans, settings;
    private JLabel txt1;

    public Accounts() {
        initializeUI();
    }

    private void initializeUI() {
        a = new JFrame("Home Page");
        a.setSize(600, 400);
        a.setLayout(null);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txt1 = new JLabel("Choose Your Transaction");
        txt1.setBounds(200, 30, 400, 30);
        txt1.setFont(new Font("Helvetica", Font.BOLD, 15));

        bal = createButton("Check Balance", 20, 100, 150, 40);
        dep = createButton("Deposit", 220, 100, 150, 40);
        wdraw = createButton("Withdraw", 420, 100, 150, 40);
        trans = createButton("Transactions", 95, 200, 150, 40);
        settings = createButton("Settings", 295, 200, 150, 40);

        a.add(txt1);
        a.add(bal);
        a.add(dep);
        a.add(wdraw);
        a.add(trans);
        a.add(settings);

        a.setVisible(true);
        a.setResizable(false);
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Helvetica", Font.BOLD, 15));
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        a.setVisible(false);

        if (e.getSource() == dep) {
            new deposit(this);
        } else if (e.getSource() == wdraw) {
            new withdraw(this);
        } else if (e.getSource() == trans) {
            new transac(this);
        } else if (e.getSource() == bal) {
            new bal(this);
        } else if (e.getSource() == settings) {
            new setting(this);
        }
    }

    // Method to make the Accounts frame visible again
    public void showFrame() {
        a.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Accounts::new);
    }
}