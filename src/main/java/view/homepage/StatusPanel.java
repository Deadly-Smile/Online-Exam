package view.homepage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StatusPanel extends JPanel {
    public StatusPanel() {
        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Arial",Font.BOLD,14));

        JLabel dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial",Font.BOLD,14));

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
