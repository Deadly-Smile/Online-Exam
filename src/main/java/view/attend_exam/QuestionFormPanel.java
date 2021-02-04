package view.attend_exam;

import model.Exam;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class QuestionFormPanel extends JPanel {
    private Exam exam;
    private JTextArea questionArea;
    private JPanel answerPanel;
    private JLabel choseLabel;
    private JSpinner answerSpinner;
    private JButton submitButton;


    public QuestionFormPanel(Exam exam) {
        this.exam = exam;

        submitButton = new JButton("Submit");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;

        int j = 0;
        for(int i = 0; i < exam.getQuestions().size(); i++, j = i * 2){
            questionArea = new JTextArea();
            questionArea.setRows(7);
            questionArea.setLineWrap(true);
            questionArea.setEditable(false);
            questionArea.setText(        /* Pretty hard coded area :( */
                    exam.getQuestions().get(i).getId() + ". "
                    + exam.getQuestions().get(i).getQuestion()
                    + "\nA. " + exam.getQuestions().get(i).getChoices().get(0)
                    + "\nB. " + exam.getQuestions().get(i).getChoices().get(1)
                    + "\nC. " + exam.getQuestions().get(i).getChoices().get(2)
                    + "\nD. " + exam.getQuestions().get(i).getChoices().get(3)
            );

            answerPanel = new JPanel();
            setAnswerPanel();

            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.gridy = j;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(questionArea),gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridy = j+1;
            gbc.fill = GridBagConstraints.NONE;
            add(answerPanel,gbc);
        }
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridy = j+1;
        add(submitButton,gbc);
    }

    private void setAnswerPanel() {
        choseLabel = new JLabel("Choose your answer : ");
        List<String> options = Arrays.asList("A", "B", "C", "D");
        SpinnerModel spinnerModel = new SpinnerListModel(options);
        answerSpinner = new JSpinner(spinnerModel);
        answerSpinner.setSize(answerSpinner.getWidth() * 2, answerSpinner.getHeight());
        answerSpinner.setEditor(new JSpinner.DefaultEditor(answerSpinner));

        GroupLayout layout = new GroupLayout(answerPanel);
        answerPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(choseLabel)
                        .addComponent(answerSpinner)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(choseLabel)
                                .addComponent(answerSpinner))
        );
    }
}
