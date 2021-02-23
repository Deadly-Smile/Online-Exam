package view.attend_exam;

import model.Exam;
import view.homepage.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class ExamRoom extends JDialog {
    private examRoomHeaderPanel examRoomHeaderPanel;
    private QuestionFormPanel questionFormPanel;
    private Exam exam;
    private ExamRoom examRoom;
    private HomePage home;
    private List<AnswerPanel> omrList = new ArrayList<>();

    public ExamRoom() {}

    public ExamRoom(HomePage home, String title, Exam exam, boolean model) throws HeadlessException {
        super(home,title,model);
        this.exam = exam;
        this.home = home;

        setSize(new Dimension(900,550));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Image logo = Toolkit.getDefaultToolkit().getImage("src/main/resources/Free Stolen Logo.png");
        setIconImage(logo);

        setLayout(new BorderLayout());
        examRoomHeaderPanel = new examRoomHeaderPanel(this,
                exam.getExamName(),
                exam.getExamDuration(),
                exam.getExamStartingTime());
        add(examRoomHeaderPanel,BorderLayout.NORTH);

        questionFormPanel = new QuestionFormPanel(this,exam);

        JScrollPane jScrollPane = new JScrollPane(questionFormPanel);
        // This will increase scrolling speed
        jScrollPane.getVerticalScrollBar().setUnitIncrement(28);

        add(jScrollPane,BorderLayout.CENTER);

        examRoom = this;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JLabel label = new JLabel("If you quit, it will not submit. Do you still want to proceed ?");
                label.setForeground(new Color(0x1a508b));
                label.setFont(new Font("Arial",Font.PLAIN,16));
                int userChoice = JOptionPane.showConfirmDialog(
                        examRoom,
                        label,"Confirm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if(userChoice == JOptionPane.YES_OPTION) {
                    examRoomHeaderPanel.invokeClosingExam();
                    examRoom.dispose();
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void submit(boolean isForceful) {
        if(!isForceful){
            JLabel label = new JLabel("Are you sure, you want to submit ?");
            label.setForeground(new Color(0x1a508b));
            label.setFont(new Font("Arial",Font.PLAIN,16));
            int userChoice = JOptionPane.showConfirmDialog(
                    examRoom,
                    label,"Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if(userChoice == JOptionPane.YES_OPTION) {
                submit(true);
            }
        } else {
            home.submitOMRList(questionFormPanel.getOmrList(),exam);
            examRoom.dispose();
        }
    }
}
