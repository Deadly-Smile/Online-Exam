package view.add_exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarPanel extends JPanel implements ActionListener {
    private JButton backButton;
    private JButton addQuestionButton;
    private AddExam addExam;

    public ToolBarPanel() {
        initialiseComponent();
        setComponent();
        backButton.addActionListener(this);
        addQuestionButton.addActionListener(this);
    }

    private void initialiseComponent() {
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

        backButton = new JButton("Abort");
        backButton.setFocusPainted(false);
        backButton.setBackground(new Color(0xa4ebf3));
        backButton.setForeground(new Color(0x91091e));
        backButton.setFont(new Font("Arial",Font.BOLD,14));

        addQuestionButton = new JButton("Add Question");
        addQuestionButton.setFocusPainted(false);
        addQuestionButton.setBackground(new Color(0xa4ebf3));
        addQuestionButton.setFont(new Font("Arial",Font.BOLD,14));
    }

    private void setComponent() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(backButton);
        add(addQuestionButton);
    }

    public void setAddExam(AddExam addExam) {
        this.addExam = addExam;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            addExam.backOperationOfToolbar();
        }
        if(e.getSource() == addQuestionButton){
            addExam.addQuestionOfToolbar();
        }
    }
}
