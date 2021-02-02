package view.homepage;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Thread.sleep;

public class TimerThread extends Thread{
    private boolean isRunning;
    private JLabel timeLabel;

    private final SimpleDateFormat timeFormat =
            new SimpleDateFormat("h:mm:ss a");

    public TimerThread(JLabel timeLabel) {
        this.timeLabel = timeLabel;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Calendar currentCalendar = Calendar.getInstance();
                    Date currentTime = currentCalendar.getTime();
                    timeLabel.setText(timeFormat.format(currentTime));
                }
            });

            try {
                sleep(1000L);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}