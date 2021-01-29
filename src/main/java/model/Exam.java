package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Exam {
    private String examName;
    private String examPassword;
    private LocalDateTime examStartingTime;
    private ArrayList<MultipleChoiceQuestion> questions;
    private int givenTimeInMinutes;

    /* This is This is prototype
//    private double marksPerQuestion;
//    private double penaltyPerMistake;
//
//    public Exam(String examName, String examPassword, LocalDateTime examStartingTime,
//                ArrayList<MultipleChoiceQuestion> questions, int givenTimeInMinutes,
//                double marksPerQuestion, double penaltyPerMistake) {
//        this.examName = examName;
//        this.examPassword = examPassword;
//        this.examStartingTime = examStartingTime;
//        this.questions = questions;
//        this.givenTimeInMinutes = givenTimeInMinutes;
//        this.marksPerQuestion = marksPerQuestion;
//        this.penaltyPerMistake = penaltyPerMistake;
//    }
    */

    public Exam() {
    }

    public Exam(String examName, String examPassword, LocalDateTime examStartingTime,
                ArrayList<MultipleChoiceQuestion> questions, int givenTimeInMinutes) {
        this.examName = examName;
        this.examPassword = examPassword;
        this.examStartingTime = examStartingTime;
        this.questions = questions;
        this.givenTimeInMinutes = givenTimeInMinutes;
    }

    public boolean isExamOver(){
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(this.examStartingTime);
    }

    public void addQuestion(MultipleChoiceQuestion anotherQuestion){
        questions.add(anotherQuestion);
    }

    /* This is prototype
    public double getMarksPerQuestion() {
        return marksPerQuestion;
    }

    public void setMarksPerQuestion(double marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }

    public double getPenaltyPerMistake() {
        return penaltyPerMistake;
    }

    public void setPenaltyPerMistake(double penaltyPerMistake) {
        this.penaltyPerMistake = penaltyPerMistake;
    }
    */

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamPassword() {
        return examPassword;
    }

    public void setExamPassword(String examPassword) {
        this.examPassword = examPassword;
    }

    public LocalDateTime getExamStartingTime() {
        return examStartingTime;
    }

    public void setExamStartingTime(LocalDateTime examStartingTime) {
        this.examStartingTime = examStartingTime;
    }

    public ArrayList<MultipleChoiceQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<MultipleChoiceQuestion> questions) {
        this.questions = questions;
    }

    public int getGivenTimeInMinutes() {
        return givenTimeInMinutes;
    }

    public void setGivenTimeInMinutes(int givenTimeInMinutes) {
        this.givenTimeInMinutes = givenTimeInMinutes;
    }
}
