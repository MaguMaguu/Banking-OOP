package bank.banking;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class withdraw{
       
private JFrame w = new JFrame("Withdraw");
private   JTextField txtAmount = new JTextField();
private   JPasswordField txtPin = new JPasswordField();
private   JLabel lblAmount, lblPin, wdraw;
private JButton Confirm, Cancel;

public withdraw() {  
   w.setVisible(true);
   w.setSize(400,300);
   w.setLayout(null);
   w.setResizable(false);
   w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   
   wdraw = new JLabel("WITHDRAW");
   wdraw.setBounds(120, 30, 120, 40);
   wdraw.setFont(new Font("Helvetica", Font.BOLD, 15));
           
   lblAmount = new JLabel("Enter Amount: ");
   lblAmount.setBounds(30, 100, 120, 30);
   txtAmount.setBounds(150,100, 120, 30);
   txtAmount.setFont(new Font("Helvetica", Font.BOLD, 15));
   
   lblPin = new JLabel("Enter MPin: ");
   lblPin.setBounds(30, 150, 120, 30);
   txtPin.setBounds(150, 150, 120, 30);
   txtPin.setFont(new Font("Helvetica", Font.BOLD, 15));
   
   Confirm = new JButton("Confirm");
   Confirm.setBounds(20, 200, 100, 30);
   Confirm.setFont(new Font("Helvetica", Font.BOLD, 15));
   
   Cancel = new JButton("Cancel");
   Cancel.setBounds(150, 200, 100, 30);
   Cancel.setFont(new Font("Helvetica", Font.BOLD, 15));

   w.add(wdraw);
   w.add(txtAmount);
   w.add(lblAmount);
   w.add(lblPin);
   w.add(txtPin);
   w.add(Confirm);
   w.add(Cancel);
   
}
}

