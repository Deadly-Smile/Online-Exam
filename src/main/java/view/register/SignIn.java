package view.register;

import javax.swing.*;
import java.awt.*;

public class SignIn extends JFrame {
    private JLabel nameLabel;
    private JLabel handleLabel;
    private JLabel passwordLabel;
    private JLabel accountLabel;
    private JTextField nameTextField;
    private JTextField handleField;
    private JTextField passwordField;
    private JButton signInButton;
    private JButton logInButton;
    public SignIn(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nameLabel =new JLabel("Name");
        nameLabel.setBounds(100,55,60,20);
        add(nameLabel);

        handleLabel =new JLabel("Handle");
        handleLabel.setBounds(100,85,60,20);
        add(handleLabel);

        passwordLabel =new JLabel("Password");
        passwordLabel.setBounds(100,115,60,20);
        add(passwordLabel);

        accountLabel =new JLabel("Already have an account?");
        accountLabel.setForeground(new Color(0xeb5e0b));
        accountLabel.setBounds(93,215,150,20);
        add(accountLabel);

        nameTextField =new JTextField();
        nameTextField.setBounds(190,55,120,20);
        add(nameTextField);

        handleField =new JTextField();
        handleField.setBounds(190,85,120,20);
        add(handleField);

        passwordField =new JTextField();
        passwordField.setBounds(190,115,120,20);
        add(passwordField);

        signInButton =new JButton("Sign In");
        signInButton.setBackground(new Color(0xa3ddcb));
        signInButton.setForeground(Color.BLACK);
        signInButton.setBounds(233,160,75,20);
        add(signInButton);

        logInButton =new JButton("Log In");
        logInButton.setBounds(243,215,70,20);
        logInButton.setBackground(new Color(0x276678));
        logInButton.setForeground(Color.BLACK);
        add(logInButton);

        setLayout(null);
        setBounds(400,200,400,300);
        setVisible(true);
        setResizable(false);
    }
}
