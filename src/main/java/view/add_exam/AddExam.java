package view.add_exam;

import model.Exam;
import model.MultipleChoiceQuestion;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddExam extends JDialog {
    private ToolBarPanel toolBarPanel;
    private FromPanel fromPanel;
    private QuestionTablePanel questionTablePanel;
    private AddQuestionDialog addQuestionDialog;
    private Exam newExam;
    private MultipleChoiceQuestion mcq;
    private int questionID = 0;

    public AddExam(JFrame home ,String title, boolean model) {
        super(home,title,model);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(750,450));
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
            int examDuration = event.getExamDuration();
            int startsIn = event.getStartsIn();
//            System.out.println("Exam Name : " + examName + "\n"
//                               + "Exam Pass : " + examPass + "\n"
//                                + "Duration : " + examDuration + "\n"
//                                + "Stars In : " + startsIn
//            );
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
            mcq = new MultipleChoiceQuestion(questionID, question, choices, index);
            questionTablePanel.addQuestion(mcq);
            addQuestionDialog.dispose();
        });
    }
}
