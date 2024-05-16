
package bank.banking;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class bal {
 private JFrame b = new JFrame("Balance Inquiry");
private JLabel balance;
private JButton Back, Exit;

 public bal(){
   
   b.setVisible(true);
   b.setSize(400,300);
   b.setLayout(null);
   b.setResizable(false);
   b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   
   balance = new JLabel("Your Total Balance is :");
   balance.setBounds(30, 30, 300, 40);
   balance.setFont(new Font("Helvetica", Font.BOLD, 15));

   Exit = new JButton("Exit");
   Exit.setBounds(50, 150, 100, 30);
   Exit.setFont(new Font("Helvetica", Font.BOLD, 15));
   
   
   Back = new JButton("Back");
   Back.setBounds(175, 150, 100, 30);
   Back.setFont(new Font("Helvetica", Font.BOLD, 15));
   
   b.add(balance);
   b.add(Exit);
   b.add(Back);
}
}
