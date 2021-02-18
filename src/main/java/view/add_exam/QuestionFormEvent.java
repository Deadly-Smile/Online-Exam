package view.add_exam;

import java.util.EventObject;

public class QuestionFormEvent extends EventObject {
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private double mark;
    private String rightChoice;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public QuestionFormEvent(Object source) {
        super(source);
    }

    public QuestionFormEvent(Object source, String question,
                             String choice1, String choice2,
                             String choice3, String choice4,
                             double mark, String rightChoice) {
        super(source);
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.mark = mark;
        this.rightChoice = rightChoice;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getRightChoice() {
        return rightChoice;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setRightChoice(String rightChoice) {
        this.rightChoice = rightChoice;
    }
}
