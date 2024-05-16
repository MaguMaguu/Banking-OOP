package bank.banking;


import java.awt.*;
import javax.swing.*;

public class Accounts  {

    private JFrame a = new JFrame("Home Page");
    private JButton bal, dep, wdraw, trans, exit;
    private JLabel txt1;

  public Accounts(){
       a.setSize(600, 400);
       a.setLayout(null);
       a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);

       txt1 = new JLabel("Choose Your Transaction");
       txt1.setBounds(200, 30, 400, 30);
       txt1.setFont(new Font("Helvatica", Font.BOLD, 15));

       bal = new JButton("Check Balance");
       bal.setBounds(20, 100, 150, 40);
       bal.setFont(new Font("Helvetica", Font.BOLD, 15));

       dep = new JButton("Deposit");
       dep.setBounds(220, 100, 150, 40);
       dep.setFont(new Font("Helvetica", Font.BOLD, 15));

       wdraw = new JButton("Withdraw");
       wdraw.setBounds(420, 100, 150, 40);
       wdraw.setFont(new Font("Helvetica", Font.BOLD, 15));

       trans = new JButton("Transactions");
       trans.setBounds(95, 200, 150, 40);
       trans.setFont(new Font("Helvetica", Font.BOLD, 15));

       exit = new JButton("Exit");
       exit.setBounds(295, 200, 150, 40);
       exit.setFont(new Font("Helvetica", Font.BOLD, 15));
       exit.addActionListener(e -> a.dispose());

       a.add(txt1);
       a.add(bal);
       a.add(dep);
       a.add(wdraw);
       a.add(trans);
       a.add(exit);

       a.setVisible(true);
       a.setResizable(false);

    }
}