package view.homepage;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class HeaderPanel extends JPanel {
    private JButton setAExamButton;
    private JLabel handleLabel;
    private JLabel searchLabel;
    private JTextField searchBarField;
    private JButton searchButton;

    public HeaderPanel() {
        initialiseComponent();
        setComponent();
    }

    private void setComponent() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addComponent(setAExamButton)
                .addComponent(searchLabel)
                .addComponent(searchBarField)
                .addComponent(searchButton)
                .addComponent(handleLabel)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(setAExamButton)
                                .addComponent(searchLabel)
                                .addComponent(searchBarField)
                                .addComponent(searchButton, GroupLayout.Alignment.CENTER)
                                .addComponent(handleLabel))
        );

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    private void initialiseComponent() {

        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

        setAExamButton = new JButton("Set a Exam");
        setAExamButton.setFont(new Font("Arial",Font.BOLD,18));

        handleLabel = new JLabel("Handle");
        handleLabel.setFont(new Font("Arial",Font.BOLD,18));

        searchLabel = new JLabel("Search exam by ID :");
        searchLabel.setFont(new Font("Arial",Font.PLAIN,17));

        searchBarField = new JTextField(15);
        searchBarField.setFont(new Font("Arial",Font.PLAIN,18));

        searchButton = new JButton();
        searchButton.setIcon(createIcon("src/main/resources/Search Icon resized.png"));
    }

/*  By GridBagConstraints layout
    private void setAnotherLayout() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gridBagConstraints.weightx = 10;
        gridBagConstraints.weighty = 5;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        //      First Column
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        add(setAExamButton,gridBagConstraints);
        //      Next Column
        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(5,10,5,-15);
        add(searchBarField,gridBagConstraints);
        //      Next Column
        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new Insets(5,-15,5,10);
        add(searchButton,gridBagConstraints);
        //      Next Column
        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        add(handleLabel,gridBagConstraints);
    }
*/

    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);
        if (url == null){
            System.err.println("Unable to lode " + path);
        }

        return new ImageIcon(path);
    }
}
