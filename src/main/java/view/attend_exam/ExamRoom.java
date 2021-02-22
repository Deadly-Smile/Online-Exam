package view.attend_exam;

import model.Exam;
import view.homepage.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExamRoom extends JDialog {
    private TimerPanel timerPanel;
    private QuestionFormPanel questionFormPanel;
    private Exam exam;

    public ExamRoom(HomePage home, String title, Exam exam, boolean model) throws HeadlessException {
        super(home,title,model);
        this.exam = exam;

        setSize(new Dimension(900,550));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Image logo = Toolkit.getDefaultToolkit().getImage("src/main/resources/Free Stolen Logo.png");
        setIconImage(logo);

        setLayout(new BorderLayout());
        timerPanel = new TimerPanel(this, exam.getExamName(), exam.getExamDuration());
        add(timerPanel,BorderLayout.NORTH);

        questionFormPanel = new QuestionFormPanel(exam);
        add(new JScrollPane(questionFormPanel),BorderLayout.CENTER);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                timerPanel.invokeClosingExam();
                submit();
                super.windowClosing(e);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void submit() {
        // submitting answer
    }
}
