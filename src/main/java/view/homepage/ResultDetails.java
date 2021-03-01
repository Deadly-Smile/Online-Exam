package view.homepage;

import model.Result;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class ResultDetails extends JDialog {
    private JLabel examId;
    private JLabel setter;
    private JLabel startDate;
    private JLabel startTime;
    private JLabel duration;
    private JLabel totalQ;
    private JLabel isPassed;
    private JLabel totalMark;
    private JLabel achievedMark;
    private JLabel rightAnswered;
    private JLabel wrongAnswered;
    private JLabel notAnswered;
    private JLabel penalty;
    private JLabel examName;

    private static final Font font = new Font("Arial", Font.PLAIN, 15);
    private static final Color color = new Color(0x0B2341);

    public ResultDetails(JFrame owner, String title, boolean modal, Result result) {
        super(owner, title, modal);
        setSize(new Dimension(420, 360));
        setLocationRelativeTo(owner);

        initializer(result);
        setComponents();

        setVisible(true);
    }

    private void initializer(Result result) {
        examId = new JLabel("Exam Id : " + result.getExamId());
        examId.setForeground(color);
        examId.setFont(font);

        setter = new JLabel("Exam Setter : " + result.getExamSetter());
        setter.setForeground(color);
        setter.setFont(font);

        examName = new JLabel("Exam Name : " + result.getExamName());
        examName.setForeground(color);
        examName.setFont(font);

        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy");
        startDate = new JLabel("Start Date : " + format.format(result.getExamStartTime()));
        startDate.setFont(font);
        startDate.setForeground(color);

        format = new SimpleDateFormat("HH: mm");
        startTime = new JLabel("Start Time : " + format.format(result.getExamStartTime()));
        startTime.setFont(font);
        startTime.setForeground(color);

        duration = new JLabel("Duration : " + result.getExamDuration() + " Minute");
        duration.setFont(font);
        duration.setForeground(color);

        totalQ = new JLabel("Total question : " + result.getNumberOfQuestion());
        totalQ.setFont(font);
        totalQ.setForeground(color);

        if (result.isPassed()) {
            isPassed = new JLabel("Is passed : Passed");
        } else {
            isPassed = new JLabel("Is passed : Failed");
        }
        isPassed.setFont(font);
        isPassed.setForeground(color);

        totalMark = new JLabel("Total question : " + result.getMaximumMark());
        totalMark.setFont(font);
        totalMark.setForeground(color);

        achievedMark = new JLabel("Achieved Mark : " + result.getAchievedMark());
        achievedMark.setFont(font);
        achievedMark.setForeground(color);

        rightAnswered = new JLabel("Right Answered : " + result.getRightAnswered());
        rightAnswered.setFont(font);
        rightAnswered.setForeground(color);

        wrongAnswered = new JLabel("Wrong Answered : " + result.getWrongAnswered());
        wrongAnswered.setFont(font);
        wrongAnswered.setForeground(color);

        notAnswered = new JLabel("Not Answered : " + result.getNotAnswered());
        notAnswered.setFont(font);
        notAnswered.setForeground(color);

        penalty = new JLabel("Penalty : " + result.getPenalty());
        penalty.setFont(font);
        penalty.setForeground(color);
    }

    private void setComponents() {
        JPanel componentPanel = new JPanel();
        componentPanel.setLayout(new GridBagLayout());
        componentPanel.setBorder(BorderFactory.createEmptyBorder(10,50,10,10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 8;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = -1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_START;

        /* First Row */
        gbc.gridy++;
        componentPanel.add(examName, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(examId, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(setter, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(startDate, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(startTime, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(duration, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(isPassed, gbc);

        /* First Row */
        gbc.gridy++;
        componentPanel.add(totalQ, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(penalty, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(totalMark, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(achievedMark, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(rightAnswered, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(wrongAnswered, gbc);

        /* Next Row */
        gbc.gridy++;
        componentPanel.add(notAnswered, gbc);

        setLayout(new BorderLayout());
        add(new JScrollPane(componentPanel), BorderLayout.CENTER);
    }
}