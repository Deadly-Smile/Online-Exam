package view.attend_exam;

import model.MultipleChoiceQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerPanel extends JPanel {
    private List<JRadioButton> choiceButtons;
    private ButtonGroup choiceGroup;
    private MultipleChoiceQuestion mcq;

    public AnswerPanel(MultipleChoiceQuestion mcq) {
        this.mcq = mcq;
        initialization();
        setComponents();
    }

    private void initialization() {
        choiceButtons = new ArrayList<>();
        choiceGroup = new ButtonGroup();

        for (int i = 0; i < mcq.getChoices().size(); i++) {
            JRadioButton tempButton = new JRadioButton(mcq.getChoices().get(i));
            tempButton.setFont(new Font("Arial",Font.PLAIN,16));
            choiceButtons.add(tempButton);
            choiceGroup.add(choiceButtons.get(i));
        }

    }

    private void setComponents() {
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 10;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.LINE_START;

        for (int i = 0; i < mcq.getChoices().size(); i++) {
            add(choiceButtons.get(i),gbc);
            gbc.gridy++;
        }
    }

    public List<JRadioButton> getChoiceButtons() {
        return choiceButtons;
    }

    public ButtonGroup getChoiceGroup() {
        return choiceGroup;
    }
}
