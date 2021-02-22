package view.attend_exam;

import model.Exam;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionFormPanel extends JPanel {
    private Exam exam;
    private JTextArea questionArea;
    private List<AnswerPanel> OMRList = new ArrayList<>();
    private JButton submitButton;


    public QuestionFormPanel(Exam exam) {
        this.exam = exam;

        Border outside = BorderFactory.createMatteBorder(1,1,1,1,new Color(0x28527a));
        Border inside = BorderFactory.createEmptyBorder(5,5,10,5);

        setBorder(BorderFactory.createCompoundBorder(outside, inside));

        submitButton = new JButton("Submit");
        submitButton.setFocusPainted(false);
        submitButton.setBackground(new Color(0xa7c5eb));
        submitButton.setForeground(new Color(0x413c69));

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
            questionArea.setFont(new Font("FUTURA",Font.PLAIN,14));
            questionArea.setText(        /* Pretty hard coded area :( */
                    "  " +
                    exam.getQuestions().get(i).getId() + ". "
                    + exam.getQuestions().get(i).getQuestion()
                    + "\n  A. " + exam.getQuestions().get(i).getChoices().get(0)
                    + "\n  B. " + exam.getQuestions().get(i).getChoices().get(1)
                    + "\n  C. " + exam.getQuestions().get(i).getChoices().get(2)
                    + "\n  D. " + exam.getQuestions().get(i).getChoices().get(3)
                    + "\n  Question mark : " + exam.getQuestions().get(i).getMark()
            );

            AnswerPanel answerPanel = new AnswerPanel();
            OMRList.add(answerPanel);

            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.gridy = j;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(questionArea),gbc);

            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.gridy = j+1;
            gbc.fill = GridBagConstraints.NONE;
            add(answerPanel,gbc);
        }
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridy = j+1;
        add(submitButton,gbc);
    }
}
