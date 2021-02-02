package view.register;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame {
    private final JLabel passwordLabel;
    private final JLabel handleLabel;
    private JTextField handleField;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JButton signInButton;
    private JCheckBox rememberMeCheck;
    private final JLabel noAccountLabel;

    public LogIn(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        handleLabel = new JLabel("Handle ");
        handleLabel.setBounds(100,60,60,30);
        add(handleLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100,95,60,30);
        add(passwordLabel);

        handleField = new JTextField();
        handleField.setBounds(180,65,120,20);
        add(handleField);

        passwordField = new JPasswordField();
        passwordField.setBounds(180,100,120,20);
        add(passwordField);

        rememberMeCheck = new JCheckBox("Remember me");
        rememberMeCheck.setBounds(95,135,120,20);
        add(rememberMeCheck);

        logInButton = new JButton("Login");
        logInButton.setBackground(new Color(0xa3ddcb));
        logInButton.setForeground(Color.BLACK);
        logInButton.setBounds(220,170,80,20);
        add(logInButton);

        noAccountLabel = new JLabel("No account ?");
        noAccountLabel.setForeground(new Color(0xeb5e0b));
        noAccountLabel.setBounds(120,220,100,30);
        add(noAccountLabel);

        signInButton = new JButton("Sign in");
        signInButton.setBackground(new Color(0x276678));
        signInButton.setForeground(Color.BLACK);
        signInButton.setBounds(200,225,80,20);
        add(signInButton);

        setLayout(null);
        setBounds(400,200,400,300);
        setVisible(true);
        setResizable(false);
    }
}
