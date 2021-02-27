package view.register;

import controller.Controller;
import view.homepage.HomePage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LogIn extends JFrame {
    private JLabel passwordLabel;
    private JLabel handleLabel;
    private JTextField handleField;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JButton signInButton;
    private JCheckBox rememberMeCheck;
    private JLabel noAccountLabel;
    private JLabel massageLabel;
    private JLabel imageLabel;

    private final Controller controller;
    private static final Font REGULAR_FONT = new Font("Arial",Font.PLAIN,15);
    private static final Font SMALL_FONT = new Font("FUTURA",Font.BOLD,12);

    public LogIn(HomePage homePage, String title, boolean isStart) throws HeadlessException {
        super(title);
        controller = new Controller();
        ImageIcon icon = new ImageIcon("src/main/resources/Free Stolen Logo.png");
        setIconImage(icon.getImage());

        initializeComponents();
        setComponents();

        /* checking userinfo is in the file or not
        * if it is there then direct to homepage
        * if not then login to enter */
        if(isStart) {
            boolean isVisual = !controller.isLogInDefault();
            homePage.setVisible(!isVisual);
            if (!isVisual){
                homePage.setExams(controller.getExams());
                homePage.setUser(controller.getCurrentUser());
                homePage.lateSetting();
            }
            setVisible(isVisual);
        } else {
            controller.forgetLogInData();
            homePage.dispose();
            setVisible(true);
        }

        LogIn source = this;

        logInButton.addActionListener(e -> {
            try {
                String handle = handleField.getText();
                char[] pass = passwordField.getPassword();
                String password = new String(pass);

                boolean isRemembered = rememberMeCheck.isSelected();
                controller.setLogInDataUI(handle, password, isRemembered, homePage, source, isStart);
            } catch (NullPointerException | IOException ignored){}
        });

        signInButton.addActionListener(e -> new SignIn(this,"Sign In",false));

    }

    /* initializing part is here, all styling of components should be done in this method */
    private void initializeComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        handleLabel = new JLabel("  Handle :");
        handleLabel.setFont(REGULAR_FONT);

        passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(REGULAR_FONT);

        handleField = new JTextField(10);
        handleField.setFont(REGULAR_FONT);

        passwordField = new JPasswordField(10);
        passwordField.setFont(REGULAR_FONT);

        rememberMeCheck = new JCheckBox("Remember me");
        rememberMeCheck.setFocusPainted(false);
        rememberMeCheck.setFont(SMALL_FONT);

        massageLabel = new JLabel("Incorrect handle or password*");
        massageLabel.setForeground(Color.RED);
        massageLabel.setFont(SMALL_FONT);
        massageLabel.setVisible(false);

        logInButton = new JButton("Login");
        logInButton.setFont(SMALL_FONT);
        logInButton.setBackground(new Color(0x0f4c75));
        logInButton.setForeground(Color.WHITE);
        logInButton.setFocusPainted(false);

        imageLabel = new JLabel(new ImageIcon("src/main/resources/login_small.png"));

        noAccountLabel = new JLabel("No account ?");
        noAccountLabel.setFont(SMALL_FONT);

        signInButton = new JButton("Sign in");
        signInButton.setFont(SMALL_FONT);
        signInButton.setBackground(Color.WHITE);
        signInButton.setForeground(Color.BLACK);
        signInButton.setFocusPainted(false);
    }

    /* setting components in position is done in this method */
    private void setComponents() {
        setSize(new Dimension(420,350));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel logInFormPanel = new JPanel();
        setLogInForm(logInFormPanel);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createEmptyBorder(30,5,2,5));
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createEmptyBorder(15,5,5,5));
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.add(noAccountLabel);
        footerPanel.add(signInButton);

        add(logInFormPanel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.NORTH);
        add(footerPanel, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(false);
    }

    private void setLogInForm(JPanel logInFormPanel) {
        logInFormPanel.setBorder(BorderFactory.createEmptyBorder(5,50,5,50));

        //  Initialization  //
        logInFormPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 8;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

        // First Row
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        logInFormPanel.add(handleLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        logInFormPanel.add(handleField, gbc);

        // Next Row
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        logInFormPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        logInFormPanel.add(passwordField, gbc);

        // Next Row
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = new Insets(0,0,0,-25);
        gbc.anchor = GridBagConstraints.LINE_END;
        logInFormPanel.add(rememberMeCheck, gbc);

        // Next Row
        gbc.gridy++;
        gbc.insets = new Insets(0,0,0,-93);
        gbc.anchor = GridBagConstraints.LINE_END;
        logInFormPanel.add(massageLabel, gbc);

        // Next Row
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.weighty = 3;
        gbc.insets = new Insets(0,0,0,45);
        logInFormPanel.add(logInButton, gbc);
    }

    public void setMassage(boolean b) {
        massageLabel.setVisible(b);
    }
}
