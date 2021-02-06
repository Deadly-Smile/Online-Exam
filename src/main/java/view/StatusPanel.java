package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StatusPanel extends JPanel {
    private JLabel timerLabel;
    private JLabel dateLabel;

    public StatusPanel() {
        timerLabel = new JLabel();
        timerLabel.setFont(new Font("Arial",Font.PLAIN,12));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial",Font.PLAIN,12));

        setLayout(new BorderLayout());
        add(timerLabel,BorderLayout.EAST);
        add(dateLabel,BorderLayout.WEST);
        Border inSideBorder = BorderFactory.createEmptyBorder(3,3,3,3);
        Border outSideBorder = BorderFactory.createMatteBorder(
                1,1,1,1,new Color(0x726a95));
        setBorder(BorderFactory.createCompoundBorder(outSideBorder,inSideBorder));

        LocalDateTime date = LocalDateTime.now();
        dateLabel.setText(date.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy")));

        TimerThread timerThread = new TimerThread(timerLabel);
        timerThread.start();
    }
}
