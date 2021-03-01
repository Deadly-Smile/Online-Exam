package view.attend_exam;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitingTimerThread extends Thread{
    private boolean isRunning;
    private final JLabel timeLabel;
    private long timeLeft;
    private final WaitingRoom waitingRoom;

    public WaitingTimerThread(WaitingRoom source, Date startingTime, JLabel timeLabel) {
        this.timeLabel = timeLabel;
        isRunning = true;
        waitingRoom = source;
        timeLeft = startingTime.getTime() - new Date().getTime();
        timeLeft /= 1000L;
    }

    @Override
    public void run() {
        while (isRunning){
            SwingUtilities.invokeLater(() -> {
                int hour = (int) (timeLeft / (60 * 60));
                int minute = (int) (timeLeft % (60 * 60));
                minute /= 60;
                int second = (int) (timeLeft % 60);
                timeLabel.setText(
                    hour + ": " + minute + ": " + second
                );
                if(timeLeft <= 60) {
                    timeLabel.setForeground(new Color(0xFFAA1455, true));
                }
                if (timeLeft == 0){
                    setRunning(false);
                    waitingRoom.waitingIsOver();
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

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
