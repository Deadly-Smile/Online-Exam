package view.register;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

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
    private JLabel tooShortLabel;
    private JLabel alreadyLabel;
    private JLabel successLabel;

    private final Controller controller;

    public SignIn(LogIn logIn, String title, boolean b) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        logIn.setVisible(b);
        SignIn source = this;

        initialize();
        setComponents();

        controller = new Controller();

        signInButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String handle = handleField.getText();
            char[] pass = passwordField.getPassword();
            String password = new String(pass);

            controller.createUser(name,handle,password,source);
        });

        logInButton.addActionListener(e ->  {
            source.dispose();
            logIn.setVisible(true);
        });
    }
/*  all components are initialized in this method, all styling should be done here  */
    private void initialize(){
        nameLabel = new JLabel("Name");

        handleLabel = new JLabel("Handle");

        passwordLabel = new JLabel("Password");

        accountLabel = new JLabel("Already have an account?");
        accountLabel.setForeground(new Color(0xeb5e0b));

        tooShortLabel = new JLabel("Too short handle or password*");
        tooShortLabel.setForeground(Color.RED);
        tooShortLabel.setFont(new Font("FUTURA",Font.PLAIN,12));
        tooShortLabel.setVisible(false);

        alreadyLabel = new JLabel("Try another handle*");
        alreadyLabel.setForeground(Color.RED);
        alreadyLabel.setFont(new Font("FUTURA",Font.PLAIN,12));
        alreadyLabel.setVisible(false);

        successLabel = new JLabel("Account is successfully created, try logging in");
        successLabel.setForeground(new Color(0x21452B));
        successLabel.setFont(new Font("FUTURA",Font.PLAIN,12));
        successLabel.setVisible(false);

        nameTextField = new JTextField();

        handleField = new JTextField();

        passwordField =new JPasswordField();

        signInButton =new JButton("Sign In");
        signInButton.setBackground(new Color(0xa3ddcb));
        signInButton.setForeground(Color.BLACK);
        signInButton.setFocusPainted(false);

        logInButton =new JButton("Log In");
        logInButton.setBackground(new Color(0x276678));
        logInButton.setForeground(Color.BLACK);
        logInButton.setFocusPainted(false);
    }
/* setting components in position is done in this method */
    private void setComponents() {
        nameLabel.setBounds(100,55,60,20);
        add(nameLabel);

        handleLabel.setBounds(100,85,60,20);
        add(handleLabel);

        passwordLabel.setBounds(100,115,60,20);
        add(passwordLabel);

        accountLabel.setBounds(93,215,150,20);
        add(accountLabel);

        nameTextField.setBounds(190,55,130,20);
        add(nameTextField);

        handleField.setBounds(190,85,130,20);
        add(handleField);

        passwordField.setBounds(190,115,130,20);
        add(passwordField);

        tooShortLabel.setBounds(100,140,220,20);
        add(tooShortLabel);

        successLabel.setBounds(100,140,250,20);
        add(successLabel);

        alreadyLabel.setBounds(100,140,220,20);
        add(alreadyLabel);

        signInButton.setBounds(233,170,75,20);
        add(signInButton);

        logInButton.setBounds(243,215,70,20);
        add(logInButton);

        setLayout(null);
        setBounds(400,200,400,300);
        setVisible(true);
        setResizable(false);
    }

    public void setTooShortVisible(){
        tooShortLabel.setVisible(true);
        alreadyLabel.setVisible(false);
        successLabel.setVisible(false);
    }

    public void setAlreadyVisible(){
        tooShortLabel.setVisible(false);
        alreadyLabel.setVisible(true);
        successLabel.setVisible(false);
    }

    public void setSuccessVisible(){
        tooShortLabel.setVisible(false);
        alreadyLabel.setVisible(false);
        successLabel.setVisible(true);
    }
}
