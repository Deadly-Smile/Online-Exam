package view.add_exam;

import model.Exam;
import model.MultipleChoiceQuestion;
import view.homepage.HomePage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SetExam extends JDialog {
    private ToolBarPanel toolBarPanel;
    private FromPanel fromPanel;
    private QuestionTablePanel questionTablePanel;
    private setQuestionDialog setQuestionDialog;
    private Exam newExam;
    private ArrayList<MultipleChoiceQuestion> questionSet = new ArrayList<>();
    private int questionID;

    public SetExam(HomePage home , String title, boolean model, String handle, Exam exam) {
        super(home,title,model);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(750,450));
        setLocationRelativeTo(home);
        ImageIcon icon = new ImageIcon("src/main/resources/Free Stolen Logo.png");
        setIconImage(icon.getImage());
        setComponents(exam);

        questionID = 0;

        if(exam != null) {
            questionID = exam.getQuestions().size();
            fromPanel.setFields(exam);
            questionSet = exam.getQuestions();
        }

        fromPanel.setExamFormListener(event -> {
            String examName = event.getExamName();
            String examPass = event.getExamPass();
            int passingPercent = event.getPassPercent();
            int penalty = event.getPenalty();
            int examDuration = event.getExamDuration();
            Date startsDate = event.getStartDate();
            if(exam != null) {
                newExam = new Exam(exam.getId(), examName, handle, examPass, startsDate,
                        questionSet, examDuration, penalty, passingPercent);
                home.createExam(newExam, true, exam.getExamStartingTime());
            } else {
                newExam = new Exam(examName, handle, examPass, startsDate,
                        questionSet, examDuration, penalty, passingPercent);
                home.createExam(newExam, false, null);
            }

        });
        setVisible(true);
    }

    private void setComponents(Exam exam) {
        setLayout(new BorderLayout());
        toolBarPanel = new ToolBarPanel();
        toolBarPanel.setAddExam(this);
        add(toolBarPanel,BorderLayout.NORTH);
        fromPanel = new FromPanel();
        add(fromPanel,BorderLayout.WEST);
        questionTablePanel = new QuestionTablePanel(this, exam);
        add(questionTablePanel,BorderLayout.CENTER);
    }

    public void backOperationOfToolbar(){
        this.dispose();
    }

    public void setQuestion(MultipleChoiceQuestion initialQuestion){
        setQuestionDialog = new setQuestionDialog(this,"Set Question",false,initialQuestion);
        setQuestionDialog.setQuestionFormListener(questionFormEvent -> {
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
            if (initialQuestion == null) {
                questionID++;
                MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(questionID, question, choices, index, mark);
                questionSet.add(mcq);
                questionTablePanel.setData(questionSet);
            } else {
                MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(initialQuestion.getId(), question, choices, index, mark);
                questionSet.set(initialQuestion.getId() - 1,mcq);
                questionTablePanel.setData(questionSet);
            }
            setQuestionDialog.dispose();
        });
    }

    public void editQuestion(int id) {
        setQuestion(questionSet.get(id-1));
    }
}
