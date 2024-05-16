
package bank.banking;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class deposit{
       
private JFrame d = new JFrame("Deposit");
private JTextField txtAmount = new JTextField();
private JPasswordField txtPin = new JPasswordField();
private JLabel lblAmount, lblPin, dep;
private JButton Confirm, Cancel;

public deposit(){  
   d.setVisible(true);
   d.setSize(400,300);
   d.setLayout(null);
   d.setResizable(false);
   d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   
   dep = new JLabel("DEPOSIT");
   dep.setBounds(120, 30, 120, 40);
   dep.setFont(new Font("Helvetica", Font.BOLD, 15));

   
   lblAmount = new JLabel("Enter Amount: ");
   lblAmount.setBounds(30, 100, 120, 30);
   txtAmount.setBounds(150,100, 120, 30);
   txtAmount.setFont(new Font("Helvetica", Font.BOLD, 15));
   
   lblPin = new JLabel("Enter Pin: ");
   lblPin.setBounds(30, 150, 120, 30);
   txtPin.setBounds(150, 150, 120, 30);
   txtPin.setFont(new Font("Helvetica", Font.BOLD, 15));
   
   Confirm = new JButton("Confirm");
   Confirm.setBounds(20, 200, 100, 30);
   Confirm.setFont(new Font("Helvetica", Font.BOLD, 15));
   
   Cancel = new JButton("Cancel");
   Cancel.setBounds(150, 200, 100, 30);
   Cancel.setFont(new Font("Helvetica", Font.BOLD, 15));

   d.add(dep);
   d.add(txtAmount);
   d.add(lblAmount);
   d.add(lblPin);
   d.add(txtPin);
   d.add(Confirm);
   d.add(Cancel);
   
}
}
