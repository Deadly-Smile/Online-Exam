package view;

import javax.swing.*;
import java.awt.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StatusPanel extends JPanel {
    private JLabel timerLabel;
    private JLabel dateLabel;

    public StatusPanel() {
        Dimension dimension = getPreferredSize();
        dimension.height = 23;
        setPreferredSize(dimension);

        timerLabel = new JLabel();
        timerLabel.setFont(new Font("Arial",Font.PLAIN,12));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial",Font.PLAIN,12));

        setLayout(new BorderLayout());
        add(timerLabel,BorderLayout.EAST);
        add(dateLabel,BorderLayout.WEST);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

        LocalDateTime date = LocalDateTime.now();
        dateLabel.setText(date.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy")));

        TimerThread timerThread = new TimerThread(timerLabel);
        timerThread.start();
    }
}
