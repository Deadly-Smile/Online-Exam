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
    private JLabel markLabel;
    private JSpinner markSpinner;
    private JLabel noteLabel;
    private JButton confirmButton;
    private QuestionFormListener questionFormListener;
    public AddQuestionDialog(JDialog owner, String title, boolean model) {
        super(owner, title, model);
        setSize(new Dimension(500,380));
        setResizable(false);
        setLocationRelativeTo(owner);

        initialization();
        setComponents();

        confirmButton.addActionListener(e -> {
            String question = questionTextArea.getText();
            String choice1 = choice1Field.getText();
            String choice2 = choice2Field.getText();
            String choice3 = choice3Field.getText();
            String choice4 = choice4Field.getText();
            double mark = (double) markSpinner.getValue();
            String rightChoice = (String) rightAnswerSpinner.getValue();
            if(question.length() <= 1){
                noteLabel.setVisible(true);
            }else{
                noteLabel.setVisible(false);
                QuestionFormEvent event = new QuestionFormEvent(
                        this, question, choice1, choice2, choice3,
                        choice4, mark, rightChoice
                );
                if (questionFormListener != null){
                    questionFormListener.questionFormEventOccurred(event);
                }
            }
        });

        setVisible(true);
    }

    public void setQuestionFormListener(QuestionFormListener questionFormListener) {
        this.questionFormListener = questionFormListener;
    }

    private void initialization() {
        questionLabel = new JLabel("Question :");

        questionTextArea = new JTextArea();
        questionTextArea.setColumns(25);
        questionTextArea.setRows(4);
        questionTextArea.setLineWrap(true);

        choice1Label = new JLabel("Choice A :");
        choice1Field = new JTextField(25);

        choice2Label = new JLabel("Choice B :");
        choice2Field = new JTextField(25);

        choice3Label = new JLabel("Choice C :");
        choice3Field = new JTextField(25);

        choice4Label = new JLabel("Choice D :");
        choice4Field = new JTextField(25);

        markLabel =  new JLabel("Q. Mark :");

        SpinnerModel markSpinnerModel = new SpinnerNumberModel(1.00,0.25,10.00,.25);
        markSpinner = new JSpinner(markSpinnerModel);
        // disabling editable mod
        JFormattedTextField spin = ((JSpinner.DefaultEditor)markSpinner.getEditor()).getTextField();
        spin.setEditable(false);

        rightAnswerLabel = new JLabel("Right one :");

        List<String> options = Arrays.asList("A", "B", "C", "D");
        SpinnerModel spinnerModel = new SpinnerListModel(options);
        rightAnswerSpinner = new JSpinner(spinnerModel);
        rightAnswerSpinner.setEditor(new JSpinner.DefaultEditor(rightAnswerSpinner));

        noteLabel = new JLabel("Question can't be blank");
        noteLabel.setForeground(Color.red);
        noteLabel.setVisible(false);

        confirmButton = new JButton("Confirm");
        confirmButton.setFocusPainted(false);
        confirmButton.setBackground(new Color(0xd3e0ea));
        confirmButton.setForeground(new Color(0x276678));
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
        add(markLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        add(markSpinner, gbc);

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

        /*  Next Row */
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(noteLabel, gbc);

        /* Last Row */
        gbc.gridy++;
        gbc.weighty = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(confirmButton,gbc);

    }
}
