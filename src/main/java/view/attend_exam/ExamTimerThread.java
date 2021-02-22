package view.attend_exam;

import javax.swing.*;

public class ExamTimerThread extends Thread{
    private boolean isRunning;
    private final JLabel timeLabel;
    private long timeLeft;
    private final TimerPanel source;

    public ExamTimerThread(TimerPanel source, JLabel label, int duration) {
        timeLabel = label;
        isRunning = true;
        timeLeft = duration * 60L;
        this.source = source;
    }

    @Override
    public void run() {
        while (isRunning) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    int seconds = (int) (timeLeft % 60);
                    int minutes = (int) (timeLeft / 60);
                    timeLabel.setText(minutes + " : " + seconds);
                    if(timeLeft == 0) {
                        setRunning(false);
                        source.endExam();
                    }
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
