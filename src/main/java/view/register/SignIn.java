package view.register;

import javax.swing.*;
import java.awt.*;

public class SignIn extends JFrame {
JLabel Signin,Name,Hindle,Password,Account;
JTextField Nametext,Hindletext,Passwordtext;
JButton SignInbutton,LogInbutton;
    public SignIn(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Signin=new JLabel("Sign In");
        Signin.setBounds(160,10,100,20);
        add(Signin);
        Name=new JLabel("Name");
        Name.setBounds(100,45,60,20);
        add(Name);
        Hindle=new JLabel("Hindle");
        Hindle.setBounds(100,75,60,20);
        add(Hindle);
        Password=new JLabel("Password");
        Password.setBounds(100,105,60,20);
        add(Password);
        Account=new JLabel("Already have an account?");
        Account.setBounds(60,185,150,20);
        add(Account);
        Nametext=new JTextField();
        Nametext.setBounds(190,45,100,20);
        add(Nametext);
        Hindletext=new JTextField();
        Hindletext.setBounds(190,75,100,20);
        add(Hindletext);
        Passwordtext=new JTextField();
        Passwordtext.setBounds(190,105,100,20);
        add(Passwordtext);
        SignInbutton=new JButton("Sign In");
        SignInbutton.setBounds(210,150,80,20);
        add(SignInbutton);
        LogInbutton=new JButton("Log In");
        LogInbutton.setBounds(210,185,80,20);
        add(LogInbutton);
        setLayout(null);
        setBounds(400,200,400,300);
        setVisible(true);
    }
}
