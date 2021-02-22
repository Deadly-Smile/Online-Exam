package view.attend_exam;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TimerPanel extends JPanel {
    private JButton submitButton;
    private JLabel timerLabel;
    private JLabel examNameLabel;
    private ExamRoom source;
    ExamTimerThread examTimerThread;
    public TimerPanel(ExamRoom source, String examName, int examDuration) {
        this.source = source;
        initializer(examName);
        setComponent(examDuration);
    }

    private void initializer(String examName) {
        submitButton = new JButton("Submit");
        submitButton.setFocusPainted(false);
        submitButton.setBackground(new Color(0xa7c5eb));
        submitButton.setForeground(new Color(0x413c69));
        submitButton.setFont(new Font("Arial",Font.PLAIN,16));

        timerLabel = new JLabel("Timer Label");
        timerLabel.setFont(new Font("Arial",Font.BOLD,18));

        examNameLabel = new JLabel(examName);
        examNameLabel.setFont(new Font("Arial",Font.BOLD,18));
        examNameLabel.setForeground(new Color(0x290149));
    }

    private void setComponent(int examDuration) {
        Border insideBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border outsideBorder = BorderFactory.createMatteBorder(1,1,1,1,
                new Color(0x0a043c));
        setBorder(BorderFactory.createCompoundBorder(outsideBorder,insideBorder));

        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        gbc.weightx = 10;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

        /* First Column */
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(submitButton, gbc);

        /* Next Column */

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(examNameLabel, gbc);

        /*  Last Column */
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(timerLabel, gbc);

        examTimerThread = new ExamTimerThread(this,timerLabel,examDuration);
        examTimerThread.start();
    }

    public void endExam() {
        source.submit();
    }

    public void invokeClosingExam() {
        examTimerThread.setRunning(false);
    }
}