package bank.banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register implements ActionListener {

    private JFrame reg = new JFrame("Register");
    private JTextField txtfname = new JTextField();
    private JTextField txtlname = new JTextField();
    private JTextField txtmname = new JTextField();
    private JTextField txtcnum = new JTextField();
    private JTextField txtaccnum = new JTextField();
    private JTextField txtmpin = new JTextField();
    private JTextField txtaddress = new JTextField();
    private JTextField txtemail = new JTextField();
    private JLabel txtreg = new JLabel();
    private JLabel lblfname = new JLabel();
    private JLabel lbllname = new JLabel();
    private JLabel lblmname = new JLabel();
    private JLabel lblcnum = new JLabel();
    private JLabel lblaccnum = new JLabel();
    private JLabel lblmpin = new JLabel();
    private JLabel lbladdress = new JLabel();
    private JLabel lblemail = new JLabel();
    private JButton Submit, Cancel;

    public register() {
        reg.setVisible(true);
        reg.setResizable(false);
        reg.setSize(600, 500);
        reg.setLayout(null);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtreg = new JLabel("REGISTER");
        txtreg.setBounds(120, 30, 120, 40);
        txtreg.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblfname = new JLabel("First Name: ");
        lblfname.setBounds(30, 100, 120, 30);
        txtfname.setBounds(150, 100, 120, 30);
        txtfname.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblmname = new JLabel("Middle Name: ");
        lblmname.setBounds(30, 150, 120, 30);
        txtmname.setBounds(150, 150, 120, 30);
        txtmname.setFont(new Font("Helvetica", Font.BOLD, 15));

        lbllname = new JLabel("Last Name: ");
        lbllname.setBounds(30, 200, 120, 30);
        txtlname.setBounds(150, 200, 120, 30);
        txtlname.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblcnum = new JLabel("Contact Number: ");
        lblcnum.setBounds(30, 250, 120, 30);
        txtcnum.setBounds(150, 250, 120, 30);
        txtcnum.setFont(new Font("Helvetica", Font.BOLD, 15));

        lbladdress = new JLabel("Address: ");
        lbladdress.setBounds(330, 100, 120, 30);
        txtaddress.setBounds(450, 100, 120, 30);
        txtaddress.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblemail = new JLabel("Email: ");
        lblemail.setBounds(330, 150, 120, 30);
        txtemail.setBounds(450, 150, 120, 30);
        txtemail.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblaccnum = new JLabel("Account Number: ");
        lblaccnum.setBounds(330, 200, 120, 30);
        txtaccnum.setBounds(450, 200, 120, 30);
        txtaccnum.setFont(new Font("Helvetica", Font.BOLD, 15));

        lblmpin = new JLabel("MPIN: ");
        lblmpin.setBounds(330, 250, 120, 30);
        txtmpin.setBounds(450, 250, 120, 30);
        txtmpin.setFont(new Font("Helvetica", Font.BOLD, 15));

        Submit = new JButton("Confirm");
        Submit.setBounds(330, 350, 100, 30);
        Submit.setFont(new Font("Helvetica", Font.BOLD, 15));
        Submit.addActionListener(this);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(450, 350, 100, 30);
        Cancel.setFont(new Font("Helvetica", Font.BOLD, 15));
        Cancel.addActionListener(this);

        reg.add(txtreg);
        reg.add(lblfname);
        reg.add(txtfname);
        reg.add(lbllname);
        reg.add(txtlname);
        reg.add(lblmname);
        reg.add(txtmname);
        reg.add(lblcnum);
        reg.add(txtcnum);
        reg.add(lbladdress);
        reg.add(txtaddress);
        reg.add(lblaccnum);
        reg.add(txtaccnum);
        reg.add(lblemail);
        reg.add(txtemail);
        reg.add(lblmpin);
        reg.add(txtmpin);
        reg.add(Submit);
        reg.add(Cancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Submit) {
            reg.dispose();
            Login log =  new Login();
                    log.setVisible(true);
        } else if (e.getSource() == Cancel) {
            reg.dispose();
           Login log =  new Login();
                    log.setVisible(true);
        }
    }
}
