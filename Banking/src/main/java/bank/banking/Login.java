
package bank.banking;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login{
       
private JFrame log = new JFrame("Nyecash");
private JTextField txtaccnum = new JTextField();
private JPasswordField txtPin = new JPasswordField();
private JLabel lblaccnum, lblPin, welcome;
private JButton Confirm, Cancel;

public Login(){  
   log.setVisible(true);
   log.setSize(400,300);
   log.setLayout(null);
   log.setResizable(false);
   log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   
   welcome = new JLabel("Welcome to Nyecash");
   welcome.setBounds(100, 30, 200, 40);
   welcome.setFont(new Font("Helvetica", Font.BOLD, 15));

   
   lblaccnum = new JLabel("Account No.: ");
   lblaccnum.setBounds(30, 100, 120, 30);
   txtaccnum.setBounds(150,100, 120, 30);
   txtaccnum.setFont(new Font("Helvetica", Font.BOLD, 15));
   
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

   log.add(welcome);
   log.add(lblaccnum);
   log.add(txtaccnum);
   log.add(lblPin);
   log.add(txtPin);
   log.add(Confirm);
   log.add(Cancel);
   
}
}
