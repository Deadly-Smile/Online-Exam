package view.attend_exam;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TimerPanel extends JPanel {
    private JButton submitButton;
    private JLabel timerLabel;
    private JLabel examName;
    public TimerPanel() {
        initializer();
        setComponent();
    }

    private void initializer() {
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial",Font.PLAIN,16));

        timerLabel = new JLabel("Timer Label");
        timerLabel.setFont(new Font("Arial",Font.BOLD,18));

        examName = new JLabel("Exam Name");
        examName.setFont(new Font("Arial",Font.BOLD,18));
    }

    private void setComponent() {
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
        add(examName, gbc);

        /*  Last Column */
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(timerLabel, gbc);
    }
}