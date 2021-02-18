package view.homepage;

import model.User;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class HeaderPanel extends JPanel {
    private JButton setAnExamButton;
    private JLabel searchLabel;
    private JTextField searchBarField;
    private JButton searchButton;

    private JMenuBar handleBar;
    private JMenu handleMenu;
    private JMenuItem createdExamItem;
    private JMenuItem logOutItem;

    private final String handle;



    public HeaderPanel(User user, HomePage home) {
        handle = user.getHandle();
        initialiseComponent();
        setComponent();

        setAnExamButton.addActionListener(e -> home.startAddExam());
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
                .addComponent(handleBar)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(setAnExamButton)
                                .addComponent(searchLabel)
                                .addComponent(searchBarField)
                                .addComponent(searchButton, GroupLayout.Alignment.CENTER)
                                .addComponent(handleBar))
        );

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    private void initialiseComponent() {

        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

        setAnExamButton = new JButton("Set an Exam");
        setAnExamButton.setForeground(new Color(0x91091e));
        setAnExamButton.setBackground(new Color(0xa4ebf3));
        setAnExamButton.setFocusPainted(false);
        setAnExamButton.setFont(new Font("Arial",Font.BOLD,18));

//        handleLabel = new JLabel(handle);
//        handleLabel.setFont(new Font("Arial",Font.BOLD,18));
        handleMenu = new JMenu(handle);

        handleBar = new JMenuBar();

        createdExamItem = new JMenuItem("Created exam");
        logOutItem = new JMenuItem("Log out");

        handleMenu.add(createdExamItem);
        handleMenu.add(logOutItem);
        handleBar.add(handleMenu);

        searchLabel = new JLabel("Search exam by ID :");
        searchLabel.setFont(new Font("Arial",Font.PLAIN,17));

        searchBarField = new JTextField(15);
        searchBarField.setFont(new Font("Arial",Font.PLAIN,18));

        searchButton = new JButton();
        searchButton.setFocusPainted(false);
        searchButton.setBackground(new Color(0xfaf3e0));
        searchButton.setIcon(createIcon("src/main/resources/Search Icon resized.png"));
    }

    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);
        return new ImageIcon(path);
    }
}
