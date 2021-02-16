package view.attend_exam;

import model.Exam;

import javax.swing.*;
import java.awt.*;

public class ExamRoom extends JFrame {
    private TimerPanel timerPanel;
    private QuestionFormPanel questionFormPanel;
    private Exam exam;

    public ExamRoom(String title) throws HeadlessException {
        super(title);
        setSize(new Dimension(900,550));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Image logo = Toolkit.getDefaultToolkit().getImage("src/main/resources/Free Stolen Logo.png");
        setIconImage(logo);

        setLayout(new BorderLayout());
        timerPanel = new TimerPanel();
        add(timerPanel,BorderLayout.NORTH);
//        initializeExam();
        questionFormPanel = new QuestionFormPanel(exam);
        add(new JScrollPane(questionFormPanel),BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /* testing
    public void initializeExam(){
        ArrayList<MultipleChoiceQuestion> question = new ArrayList<>();
        List<String> c1 = Arrays.asList("1", "2", "3", "4");

        question.add(new MultipleChoiceQuestion(1,"What is 2 + 2 ?",c1,3));
        question.add(new MultipleChoiceQuestion(2,"What is 1 + 2 ?",c1,2));
        question.add(new MultipleChoiceQuestion(3,"What is 1 + 1 ?",c1,1));

        exam = new Exam(
                "13254684",
                "Test Exam",
                "Anik",
                "12345",
                Date.now(),
                question,
                5
        );
    }
     */
}
