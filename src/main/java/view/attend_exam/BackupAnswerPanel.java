package view.attend_exam;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class BackupAnswerPanel extends JPanel {
    private JLabel choseLabel;
    private final List<String> options = Arrays.asList("A", "B", "C", "D");
    private JSpinner answerSpinner;
    private JCheckBox answeredCheckBox;

    public BackupAnswerPanel() {
        initialization();
        setComponents();
    }

    private void setComponents() {
        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        spinnerPanel.add(choseLabel);
        spinnerPanel.add(answerSpinner);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 10;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;

        // First Row
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,8,0,0);
        gbc.gridy = 0;
        this.add(answeredCheckBox, gbc);

        // Second Row
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,8,0,0);
        gbc.gridy = 1;
        this.add(spinnerPanel, gbc);
    }

    private void initialization() {
        choseLabel = new JLabel("Chose your answer : ");
        choseLabel.setForeground(new Color(0x413c69));
        choseLabel.setFont(new Font("FUTURA",Font.PLAIN,14));

        answerSpinner = new JSpinner(new SpinnerListModel(options));
        answerSpinner.setSize(answerSpinner.getWidth() * 2, answerSpinner.getHeight());
        answerSpinner.setEditor(new JSpinner.DefaultEditor(answerSpinner));

        answeredCheckBox = new JCheckBox("Mark as answered");
        answeredCheckBox.setForeground(new Color(0x6b011f));
        answeredCheckBox.setFont(new Font("FUTURA",Font.PLAIN,14));
    }
}
