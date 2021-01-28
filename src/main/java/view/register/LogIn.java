package view.register;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1;

    public LogIn(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1=new JLabel("Username");
        l1.setBounds(100,55,60,30);
        add(l1);
        l2=new JLabel("Password");
        l2.setBounds(100,100,60,30);
        add(l2);
        t1=new JTextField();
        t1.setBounds(180,60,80,20);
        add(t1);
        t2=new JPasswordField();
        t2.setBounds(180,105,80,20);
        add(t2);
        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150,150,70,20);
        add(b1);
        setLayout(null);
        setBounds(400,200,400,300);
        setVisible(true);
    }
}
