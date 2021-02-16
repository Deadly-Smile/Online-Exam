package model;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Exam {
    private ObjectId id;
    private String examName;
    private String examSetterHandle;
    private String examPassword;
    private Date examStartingTime;
    private ArrayList<MultipleChoiceQuestion> questions;
    private int examDuration;

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

    public ObjectId getId() {
        return id;
    }

    public String getExamSetterHandle() {
        return examSetterHandle;
    }

    public void setExamSetterHandle(String examSetterHandle) {
        this.examSetterHandle = examSetterHandle;
    }

    public Exam(ObjectId id, String examName, String examSetterHandle,
                String examPassword, Date examStartingTime,
                ArrayList<MultipleChoiceQuestion> questions,
                int examDuration) {
        this.id = id;
        this.examName = examName;
        this.examSetterHandle = examSetterHandle;
        this.examPassword = examPassword;
        this.examStartingTime = examStartingTime;
        this.questions = questions;
        this.examDuration = examDuration;
    }

    public boolean isExamOver(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(examStartingTime);
        calendar.add(Calendar.MINUTE, examDuration);
        return new Date().after(calendar.getTime());
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

    public Date getExamStartingTime() {
        return examStartingTime;
    }

    public void setExamStartingTime(Date examStartingTime) {
        this.examStartingTime = examStartingTime;
    }

    public ArrayList<MultipleChoiceQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<MultipleChoiceQuestion> questions) {
        this.questions = questions;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", examSetterHandle='" + examSetterHandle + '\'' +
                ", examPassword='" + examPassword + '\'' +
                ", examStartingTime=" + examStartingTime +
                ", questions=" + questions +
                ", examDuration=" + examDuration +
                '}';
    }
}
