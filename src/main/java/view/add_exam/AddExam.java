package view.add_exam;

import model.Exam;
import model.MultipleChoiceQuestion;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddExam extends JDialog {
    private ToolBarPanel toolBarPanel;
    private FromPanel fromPanel;
    private QuestionTablePanel questionTablePanel;
    private AddQuestionDialog addQuestionDialog;
    private Exam newExam;
    private ArrayList<MultipleChoiceQuestion> questionSet = new ArrayList<>();
    private int questionID = 0;

    public AddExam(JFrame home ,String title, boolean model, String handle) {
        super(home,title,model);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(750,450));
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(home);

        setLayout(new BorderLayout());
        toolBarPanel = new ToolBarPanel();
        toolBarPanel.setAddExam(this);
        add(toolBarPanel,BorderLayout.NORTH);
        fromPanel = new FromPanel();
        add(fromPanel,BorderLayout.WEST);
        questionTablePanel = new QuestionTablePanel();
        add(questionTablePanel,BorderLayout.CENTER);

        fromPanel.setExamFormListener(event -> {
            String examName = event.getExamName();
            String examPass = event.getExamPass();
            int penalty = event.getPenalty();
            int examDuration = event.getExamDuration();
            Date startsDate = event.getStartDate();
            newExam = new Exam(new ObjectId(), examName, handle,
                    examPass, startsDate, questionSet, examDuration, penalty);
            dispose();
        });

        setVisible(true);
    }

    public void backOperationOfToolbar(){
        this.dispose();
    }

    public void addQuestionOfToolbar(){
        addQuestionDialog = new AddQuestionDialog(this,"Add Question",false);
        addQuestionDialog.setQuestionFormListener(questionFormEvent -> {
            String question = questionFormEvent.getQuestion();
            List<String> choices = new ArrayList<>();
            choices.add(questionFormEvent.getChoice1());
            choices.add(questionFormEvent.getChoice2());
            choices.add(questionFormEvent.getChoice3());
            choices.add(questionFormEvent.getChoice4());
            double mark = questionFormEvent.getMark();
            String rightChoice = questionFormEvent.getRightChoice();
            int index = 0;
            switch (rightChoice){
                case "A":
                    index = 0;
                    break;
                case "B":
                    index = 1;
                    break;
                case "C":
                    index = 2;
                    break;
                case "D":
                    index = 3;
                    break;
                default:
                    System.err.println("Couldn't get right input from rightChoice spinner");
            }
            questionID++;
            MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(questionID, question, choices, index, mark);
            questionTablePanel.addQuestion(mcq);
            questionSet.add(mcq);
            addQuestionDialog.dispose();
        });
    }
}
