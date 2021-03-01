package model;

import java.util.Date;

public class Result {
    private String examId;
    private String examName;
    private double maximumMark;
    private double achievedMark;
    private int penalty;
    private Date examStartTime;
    private String examSetter;
    private int numberOfQuestion;
    private int examDuration;
    private boolean isPassed;
    private int rightAnswered;
    private int wrongAnswered;
    private int notAnswered;

    public Result(String examId, String examName, double maximumMark, double achievedMark, int penalty,
                  Date examStartTime, String examSetter, int numberOfQuestion, int examDuration,
                  boolean isPassed, int rightAnswered, int wrongAnswered, int notAnswered)
    {
        this.examId = examId;
        this.examName = examName;
        this.maximumMark = maximumMark;
        this.achievedMark = achievedMark;
        this.penalty = penalty;
        this.examStartTime = examStartTime;
        this.examSetter = examSetter;
        this.numberOfQuestion = numberOfQuestion;
        this.examDuration = examDuration;
        this.isPassed = isPassed;
        this.rightAnswered = rightAnswered;
        this.wrongAnswered = wrongAnswered;
        this.notAnswered = notAnswered;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public Date getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(Date examStartTime) {
        this.examStartTime = examStartTime;
    }

    public String getExamSetter() {
        return examSetter;
    }

    public void setExamSetter(String examSetter) {
        this.examSetter = examSetter;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public int getRightAnswered() {
        return rightAnswered;
    }

    public void setRightAnswered(int rightAnswered) {
        this.rightAnswered = rightAnswered;
    }

    public int getWrongAnswered() {
        return wrongAnswered;
    }

    public void setWrongAnswered(int wrongAnswered) {
        this.wrongAnswered = wrongAnswered;
    }

    public int getNotAnswered() {
        return notAnswered;
    }

    public void setNotAnswered(int notAnswered) {
        this.notAnswered = notAnswered;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public double getMaximumMark() {
        return maximumMark;
    }

    public void setMaximumMark(double maximumMark) {
        this.maximumMark = maximumMark;
    }

    public double getAchievedMark() {
        return achievedMark;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public void setAchievedMark(double achievedMark) {
        this.achievedMark = achievedMark;
    }

    @Override
    public String toString() {
        return "Result{" +
                "examId='" + examId + '\'' +
                ", examName='" + examName + '\'' +
                ", maximumMark=" + maximumMark +
                ", achievedMark=" + achievedMark +
                ", penalty=" + penalty +
                ", examStartTime=" + examStartTime +
                ", examSetter='" + examSetter + '\'' +
                ", numberOfQuestion=" + numberOfQuestion +
                ", examDuration=" + examDuration +
                ", isPassed=" + isPassed +
                ", rightAnswered=" + rightAnswered +
                ", wrongAnswered=" + wrongAnswered +
                ", notAnswered=" + notAnswered +
                '}';
    }
}
