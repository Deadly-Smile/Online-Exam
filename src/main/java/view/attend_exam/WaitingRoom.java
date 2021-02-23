package view.attend_exam;

import model.Exam;
import view.homepage.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WaitingRoom extends JDialog {
    private JLabel timerLabel;
    private JLabel setterLabel;
    private JLabel durationLabel;
    private JLabel fullMarkLabel;
    private JLabel penaltyLabel;
    private JLabel totalLabel;
    private JLabel noteLabel;
    private WaitingTimerThread waitingThread;
    private Exam exam;
    private HomePage home;

    public WaitingRoom(HomePage home, boolean model, Exam exam) {
        super(home, exam.getExamName(), model);
        setSize(new Dimension(400,320));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(home);

        this.exam = exam;
        this.home = home;

        initialization();
        setComponents();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                waitingThread.setRunning(false);
                super.windowClosing(e);
            }
        });

        setVisible(true);
    }

    public WaitingRoom() {

    }

    private void initialization() {
        timerLabel = new JLabel("hhh: mm: ss");
        timerLabel.setFont(new Font("Arial",Font.BOLD,24));

        setterLabel = new JLabel("Exam created by " + exam.getExamSetterHandle());
        setterLabel.setForeground(new Color(0x2c061f));
        setterLabel.setFont(new Font("Arial",Font.BOLD,15));

        durationLabel = new JLabel("Duration " + exam.getExamDuration() + " minutes");
        durationLabel.setForeground(new Color(0x0f3057));
        durationLabel.setFont(new Font("Arial",Font.PLAIN,15));

        fullMarkLabel = new JLabel("Maximum mark : " + exam.getMaxMark());
        fullMarkLabel.setForeground(new Color(0x0f3057));
        fullMarkLabel.setFont(new Font("Arial",Font.PLAIN,15));

        penaltyLabel = new JLabel("Wrong penalty " + exam.getPenalty() + " %");
        penaltyLabel.setForeground(new Color(0x0f3057));
        penaltyLabel.setFont(new Font("Arial",Font.PLAIN,15));

        totalLabel = new JLabel("Total " + exam.getQuestions().size() + " question");
        totalLabel.setForeground(new Color(0x0f3057));
        totalLabel.setFont(new Font("Arial",Font.PLAIN,15));

        noteLabel = new JLabel("Exam hasn't started yet, please wait");
        noteLabel.setFont(new Font("FUTURA", Font.BOLD, 20));
        noteLabel.setForeground(new Color(0x860909));
    }

    private void setComponents() {
        // initialization of layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = -1;
        gbc.insets = new Insets(2,0,2,0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;


        // Adding noteLabel
        gbc.gridy++;
        add(noteLabel,gbc);

        // Adding timerLabel
        gbc.gridy++;
        add(timerLabel,gbc);

        // Adding fullMarkLabel
        gbc.gridy++;
        add(fullMarkLabel,gbc);

        // Adding duration
        gbc.gridy++;
        add(durationLabel,gbc);

        // Adding totalQuestionLabel
        gbc.gridy++;
        add(totalLabel,gbc);

        // Adding penalty
        gbc.gridy++;
        add(penaltyLabel,gbc);

        // Adding setterLabel
        gbc.gridy++;
        gbc.weighty = 4;
        add(setterLabel,gbc);

        waitingThread = new WaitingTimerThread(this,exam.getExamStartingTime(),timerLabel);
        waitingThread.start();
    }

    public void waitingIsOver() {
        home.goToExamRoom(exam);
    }
}
