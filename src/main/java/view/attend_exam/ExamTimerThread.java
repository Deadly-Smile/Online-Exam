package view.attend_exam;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ExamTimerThread extends Thread{
    private boolean isRunning;
    private final JLabel timeLabel;
    private long timeLeft;
    private final examRoomHeaderPanel source;

    public ExamTimerThread(examRoomHeaderPanel source, JLabel label, int duration, Date examStartingTime) {
        timeLabel = label;
        isRunning = true;
        timeLeft = new Date().getTime() - examStartingTime.getTime();
        timeLeft /= 1000L;
        timeLeft = ((60L * duration) - timeLeft);
        this.source = source;
    }

    @Override
    public void run() {
        while (isRunning) {
            SwingUtilities.invokeLater(() -> {
                int minute = (int) (timeLeft / 60);
                int second = (int) (timeLeft % 60);
                timeLabel.setText(
                        minute + ": " + second
                );
                if(timeLeft == 60) {
                    timeLabel.setForeground(Color.RED);
                }
                if(timeLeft <= 0) {
                    setRunning(false);
                    source.endExam();
                }
            });

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeLeft--;
        }
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
