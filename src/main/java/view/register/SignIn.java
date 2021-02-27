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
    private JLabel imageLabel;

    private final Controller controller;
    private static final Font REGULAR_FONT = new Font("Arial",Font.PLAIN,15);
    private static final Font SMALL_FONT = new Font("FUTURA",Font.BOLD,12);

    public SignIn(LogIn logIn, String title, boolean b) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/main/resources/Free Stolen Logo.png");
        setIconImage(icon.getImage());

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

    //  all components are initialized in this method, all styling should be done here
    private void initialize(){
        nameLabel = new JLabel("Name :");
        nameLabel.setFont(REGULAR_FONT);

        handleLabel = new JLabel("Handle :");
        handleLabel.setFont(REGULAR_FONT);

        passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(REGULAR_FONT);

        accountLabel = new JLabel("Already have an account?");
        accountLabel.setFont(SMALL_FONT);

        tooShortLabel = new JLabel("Too short handle or password*");
        tooShortLabel.setForeground(Color.RED);
        tooShortLabel.setFont(SMALL_FONT);
        tooShortLabel.setVisible(false);

        alreadyLabel = new JLabel("Try another handle*");
        alreadyLabel.setForeground(Color.RED);
        alreadyLabel.setFont(SMALL_FONT);
        alreadyLabel.setVisible(false);

        imageLabel = new JLabel(new ImageIcon("src/main/resources/sign in .png"));

        successLabel = new JLabel("Sign in complete, now log in");
        successLabel.setForeground(new Color(0x21452B));
        successLabel.setFont(SMALL_FONT);
        successLabel.setVisible(false);

        nameTextField = new JTextField(12);
        nameTextField.setFont(REGULAR_FONT);

        handleField = new JTextField(12);
        handleField.setFont(REGULAR_FONT);

        passwordField = new JPasswordField(12);
        passwordField.setFont(REGULAR_FONT);

        signInButton = new JButton("Sign In");
        signInButton.setBackground(new Color(0x0f4c75));
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);

        logInButton = new JButton("Log In");
        logInButton.setBackground(Color.WHITE);
        logInButton.setForeground(Color.BLACK);
        logInButton.setFocusPainted(false);
    }

    // setting components in position is done in this method
    private void setComponents() {
        setSize(new Dimension(420,350));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel signInFormPanel = new JPanel();
        setSignInForm(signInFormPanel);

        JPanel imagePanel = new JPanel();
        imagePanel.setBorder(BorderFactory.createEmptyBorder(30,0,5,0));
        imagePanel.setLayout(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createEmptyBorder(15,0,10,0));
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.add(accountLabel);
        footerPanel.add(logInButton);

        add(imagePanel, BorderLayout.NORTH);
        add(signInFormPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
    }

    private void setSignInForm(JPanel signInFormPanel) {
        signInFormPanel.setLayout(new GridBagLayout());
        signInFormPanel.setBorder(BorderFactory.createEmptyBorder(5,50,5,50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 8;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

        // First Row
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        signInFormPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        signInFormPanel.add(nameTextField, gbc);

        // Next Row
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        gbc.gridx = 0;
        gbc.gridy++;
        signInFormPanel.add(handleLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        signInFormPanel.add(handleField, gbc);

        // Next Row
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        gbc.gridx = 0;
        gbc.gridy++;
        signInFormPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        signInFormPanel.add(passwordField, gbc);

        // Next Row
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = new Insets(0,0,0,-93);
        signInFormPanel.add(successLabel, gbc);

        // Next Row
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy++;
        signInFormPanel.add(tooShortLabel, gbc);

        // Next Row
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy++;
        signInFormPanel.add(alreadyLabel, gbc);

        // Next Row
        gbc.gridx = 1;
        gbc.insets = new Insets(0,0,0,33);
        gbc.anchor = GridBagConstraints.LINE_END;
        signInFormPanel.add(signInButton, gbc);
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