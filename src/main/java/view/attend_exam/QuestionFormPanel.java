package view.attend_exam;

import model.Exam;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuestionFormPanel extends JPanel {
    private JTextArea questionArea;
    private JButton submitButton;
    private List<AnswerPanel> omrList;
    private JLabel markLabel;
    private JLabel setterLabel;
    private JLabel noteLabel;
    private JLabel fullMarkLabel;
    private final Exam exam;


    public QuestionFormPanel(ExamRoom home, Exam exam) {
        this.exam = exam;
        initialization();
        setComponents();

        submitButton.addActionListener(e -> home.submit(false));
    }

    private void initialization() {
        omrList = new ArrayList<>();

        Border outside = BorderFactory.createMatteBorder(1,1,1,1,new Color(0x28527a));
        Border inside = BorderFactory.createEmptyBorder(8,8,14,8);
        setBorder(BorderFactory.createCompoundBorder(outside, inside));

        setterLabel = new JLabel("Exam created by " + exam.getExamSetterHandle());
        setterLabel.setForeground(new Color(0x0a043c));
        setterLabel.setFont(new Font("Arial",Font.PLAIN,18));

        fullMarkLabel = new JLabel("Full mark : " + exam.getMaxMark());
        fullMarkLabel.setForeground(new Color(0x0a043c));
        fullMarkLabel.setFont(new Font("FUTURA",Font.PLAIN,16));

        noteLabel = new JLabel("Note : There are " + exam.getPenalty() + "% mark penalty for each wrong answer.");
        noteLabel.setForeground(new Color(0x91091e));
        noteLabel.setFont(new Font("Arial",Font.PLAIN,16));

        submitButton = new JButton("Submit");
        submitButton.setFocusPainted(false);
        submitButton.setBackground(new Color(0xa7c5eb));
        submitButton.setForeground(new Color(0x413c69));
    }

    private void setComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = -1;

        // Adding setterLabel
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        add(setterLabel,gbc);

        // Adding fullMarkLabel
        gbc.insets = new Insets(2,0,2,0);
        gbc.gridy++;
        add(fullMarkLabel,gbc);

        // Adding setterLabel
        gbc.insets = new Insets(2,0,7,0);
        gbc.gridy++;
        add(noteLabel,gbc);

        for(int i = 0; i < exam.getQuestions().size(); i++){

            temporaryInitialization(i);
            AnswerPanel newAnswerPanel = new AnswerPanel(exam.getQuestions().get(i));
            omrList.add(newAnswerPanel);

            // Adding questionArea
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(questionArea),gbc);

            // Adding markLabel
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.gridy++;
            gbc.fill = GridBagConstraints.NONE;
            add(markLabel,gbc);

            // Adding answerPanel
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.gridy++;
            add(newAnswerPanel,gbc);
        }
        // Adding submitButton
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridy++;
        add(submitButton,gbc);
    }

    private void temporaryInitialization(int i) {
        markLabel = new JLabel("Question mark: " + exam.getQuestions().get(i).getMark());
        markLabel.setFont(new Font("FUTURA",Font.PLAIN,15));
        markLabel.setForeground(new Color(0x6b011f));

        questionArea = new JTextArea();
        questionArea.setRows(3);
        questionArea.setLineWrap(true);
        questionArea.setEditable(false);
        questionArea.setFont(new Font("FUTURA",Font.PLAIN,16));
        questionArea.setText(        // Pretty hard coded area
                "  " +
                        exam.getQuestions().get(i).getId() + ". "
                        + exam.getQuestions().get(i).getQuestion()
        );

    }

    public List<AnswerPanel> getOmrList() {
        return omrList;
    }
}
