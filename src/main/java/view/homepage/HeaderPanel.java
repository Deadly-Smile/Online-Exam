package view.homepage;

import model.User;
import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    private JButton setAnExamButton;
    private JLabel searchLabel;
    private JTextField searchBarField;
    private JButton searchButton;
    private JButton refreshButton;

    private JMenuBar handleBar;
    private JMenuItem createdExamItem;
    private JMenuItem logOutItem;

    User user;

    public HeaderPanel(User user, HomePage home) {
        this.user = user;
        initialiseComponent();
        setComponent();

        setAnExamButton.addActionListener(e -> home.startSettingExam());
        createdExamItem.addActionListener(e -> home.callCreatedExamDialog());
        logOutItem.addActionListener(e -> home.logOut());
        refreshButton.addActionListener(e -> home.examTableRefresh());
        searchButton.addActionListener(e -> {
            String searchValue = searchBarField.getText();
            if(searchValue.length() != 0){
                home.searchExam(searchValue);
            }
        });
    }

    private void setComponent() {

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addComponent(setAnExamButton)
                .addComponent(searchLabel)
                .addComponent(searchBarField)
                .addComponent(searchButton)
                .addComponent(refreshButton)
                .addComponent(handleBar)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(setAnExamButton)
                                .addComponent(searchLabel)
                                .addComponent(searchBarField)
                                .addComponent(searchButton)
                                .addComponent(refreshButton)
                                .addComponent(handleBar))
        );

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    private void initialiseComponent() {

        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

        setAnExamButton = new JButton("Set an Exam");
        setAnExamButton.setForeground(Color.WHITE);
        setAnExamButton.setBackground(new Color(0x276678));
        setAnExamButton.setFocusPainted(false);
        setAnExamButton.setFont(new Font("Arial",Font.BOLD,18));

        JMenu handleMenu = new JMenu(user.getHandle());
        handleBar = new JMenuBar();

        createdExamItem = new JMenuItem("Created exam");
        logOutItem = new JMenuItem("Log out");

        handleMenu.add(createdExamItem);
        handleMenu.add(logOutItem);
        handleBar.add(handleMenu);

        searchLabel = new JLabel("Search exam :");
        searchLabel.setFont(new Font("Arial",Font.BOLD,16));

        searchBarField = new JTextField(15);
        searchBarField.setFont(new Font("FUTURA",Font.PLAIN,18));

        searchButton = new JButton("Go");
        searchButton.setFont(new Font("Arial",Font.BOLD,16));
        searchButton.setFocusPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setBackground(new Color(0x276678));
        searchButton.setIcon(new ImageIcon("src/main/resources/Search Icon resized.png"));

        refreshButton = new JButton("Refresh");
        refreshButton.setFont(new Font("Arial",Font.BOLD,16));
        refreshButton.setFocusPainted(false);
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setBackground(new Color(0x276678));
        refreshButton.setIcon(new ImageIcon("src/main/resources/refresh_small.png"));
    }
}
