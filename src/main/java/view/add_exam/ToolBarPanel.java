package view.add_exam;

import javax.swing.*;
import java.awt.*;

public class ToolBarPanel extends JPanel {
    private JButton backButton;
    private JButton addQuestionButton;

    public ToolBarPanel() {
        initialiseComponent();
        setComponent();
    }

    private void initialiseComponent() {
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

        backButton = new JButton("Abort");
        backButton.setFont(new Font("Arial",Font.BOLD,14));

        addQuestionButton = new JButton("Add Question");
        addQuestionButton.setFont(new Font("Arial",Font.BOLD,14));
    }

    private void setComponent() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(backButton);
        add(addQuestionButton);
    }
}
