package model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Exam {

    public static final int OVER = 0;
    public static final int RUNNING = 1;
    public static final int HAS_NOT_STARTED_YET = 2;
    public static final int OVER_LONG_AGO = 3;

    private String id;
    private String examName;
    private String examSetterHandle;
    private String examPassword;
    private Date examStartingTime;
    private ArrayList<MultipleChoiceQuestion> questions;
    private int examDuration;
    private double penalty;

    public Exam(String examName, String examSetterHandle,
                String examPassword, Date examStartingTime,
                ArrayList<MultipleChoiceQuestion> questions,
                int examDuration, double penalty)
    {
        this.id = new ObjectId().toString();
        this.examName = examName;
        this.examSetterHandle = examSetterHandle;
        this.examPassword = examPassword;
        this.examStartingTime = examStartingTime;
        this.questions = questions;
        this.examDuration = examDuration;
        this.penalty = penalty;
    }

    public Exam() {

    }

    public int getStatus() {
        if (examStartingTime.getTime() > new Date().getTime()) {
            return HAS_NOT_STARTED_YET;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(examStartingTime);
            calendar.add(Calendar.MINUTE, examDuration);
            if(new Date().after(calendar.getTime())) {
                calendar.add(Calendar.HOUR,24);
                if(new Date().after(calendar.getTime())){
                    return OVER_LONG_AGO;
                }else{
                    return OVER;
                }
            } else {
                return RUNNING;
            }
        }
    }

    public void addQuestion(MultipleChoiceQuestion anotherQuestion){
        questions.add(anotherQuestion);
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamSetterHandle() {
        return examSetterHandle;
    }

    public void setExamSetterHandle(String examSetterHandle) {
        this.examSetterHandle = examSetterHandle;
    }

    public double getMaxMark(){
        double maxMark = 0.00;
        for (MultipleChoiceQuestion i:questions) {
            maxMark += i.getMark();
        }
        return maxMark;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
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
