package view.register;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JFrame {
    private JLabel nameLabel;
    private JLabel handleLabel;
    private JLabel passwordLabel;
    private JLabel accountLabel;
    private JTextField nameTextField;
    private JTextField handleField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton logInButton;

    private final Controller controller;

    public SignIn(LogIn logIn, String title, boolean b) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        logIn.setVisible(b);
        JFrame source = this;

        initialize();
        setComponents();

        controller = new Controller();

        signInButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String handle = handleField.getText();
            String password = passwordField.getText();
            controller.createUser(name,handle,password,logIn,source);
        });

        logInButton.addActionListener(e ->  {
            source.setVisible(false);
            logIn.setVisible(true);
        });
    }

    private void initialize(){
        nameLabel =new JLabel("Name");

        handleLabel =new JLabel("Handle");

        passwordLabel =new JLabel("Password");

        accountLabel =new JLabel("Already have an account?");
        accountLabel.setForeground(new Color(0xeb5e0b));

        nameTextField = new JTextField();

        handleField = new JTextField();

        passwordField =new JPasswordField();

        signInButton =new JButton("Sign In");
        signInButton.setBackground(new Color(0xa3ddcb));
        signInButton.setForeground(Color.BLACK);

        logInButton =new JButton("Log In");
        logInButton.setBackground(new Color(0x276678));
        logInButton.setForeground(Color.BLACK);
    }

    private void setComponents() {
        nameLabel.setBounds(100,55,60,20);
        add(nameLabel);

        handleLabel.setBounds(100,85,60,20);
        add(handleLabel);

        passwordLabel.setBounds(100,115,60,20);
        add(passwordLabel);

        accountLabel.setBounds(93,215,150,20);
        add(accountLabel);

        nameTextField.setBounds(190,55,120,20);
        add(nameTextField);

        handleField.setBounds(190,85,120,20);
        add(handleField);

        passwordField.setBounds(190,115,120,20);
        add(passwordField);

        signInButton.setBounds(233,160,75,20);
        add(signInButton);

        logInButton.setBounds(243,215,70,20);
        add(logInButton);

        setLayout(null);
        setBounds(400,200,400,300);
        setVisible(true);
        setResizable(false);
    }
}
