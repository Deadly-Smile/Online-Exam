package model;

import java.util.ArrayList;

public class MultipleChoiceQuestion {
    private String question;
    private ArrayList<String> choices;
    private int rightIndex;

    public MultipleChoiceQuestion() {
    }

    public MultipleChoiceQuestion(String question, ArrayList<String> choices,
                                  int rightIndex) {
        this.question = question;
        this.choices = choices;
        this.rightIndex = rightIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }
}
