package view.add_exam;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AddQuestionDialog extends JDialog {
    private JLabel questionLabel;
    private JTextArea questionTextArea;
    private JLabel choice1Label;
    private JTextField choice1Field;
    private JLabel choice2Label;
    private JTextField choice2Field;
    private JLabel choice3Label;
    private JTextField choice3Field;
    private JLabel choice4Label;
    private JTextField choice4Field;
    private JLabel rightAnswerLabel;
    private JSpinner rightAnswerSpinner;
    private JButton confirmButton;
    public AddQuestionDialog(JDialog owner, String title) {
        super(owner, title);
        setSize(new Dimension(500,350));

        initialization();
        setComponents();

        setVisible(true);
        setLocationRelativeTo(owner);
    }

    private void initialization() {
        questionLabel = new JLabel("Question :");

        questionTextArea = new JTextArea();
        questionTextArea.setColumns(20);
        questionTextArea.setRows(4);
        questionTextArea.setLineWrap(true);

        choice1Label = new JLabel("Choice A :");
        choice1Field = new JTextField(20);

        choice2Label = new JLabel("Choice B :");
        choice2Field = new JTextField(20);

        choice3Label = new JLabel("Choice C :");
        choice3Field = new JTextField(20);

        choice4Label = new JLabel("Choice D :");
        choice4Field = new JTextField(20);

        rightAnswerLabel = new JLabel("Right one :");

        List<String> options = Arrays.asList("A", "B", "C", "D");
        SpinnerModel spinnerModel = new SpinnerListModel(options);
        rightAnswerSpinner = new JSpinner(spinnerModel);
        rightAnswerSpinner.setEditor(new JSpinner.DefaultEditor(rightAnswerSpinner));

        confirmButton = new JButton("Confirm");
    }

    private void setComponents() {
        /*  Initialization  */
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 10;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

        /* First Row */
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(questionLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        add(new JScrollPane(questionTextArea), gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        add(choice1Label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(-10,0,-10,0);
        add(choice1Field, gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        add(choice2Label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        add(choice2Field, gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        add(choice3Label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        add(choice3Field, gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        add(choice4Label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        add(choice4Field, gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        add(rightAnswerLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        add(rightAnswerSpinner, gbc);

        /* Last Row */
        gbc.gridy++;
        gbc.weighty = 4;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(confirmButton,gbc);

    }
}
