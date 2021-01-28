package model;

import java.time.LocalDateTime;

public class Result {
    private String examName;
    private double maximumMark;
    private double achievedMark;
    private LocalDateTime timeOfExam;

    public Result() {
    }

    public Result(String examName, double maximumMark, double achievedMark,
                  LocalDateTime timeOfExam) {
        this.examName = examName;
        this.maximumMark = maximumMark;
        this.achievedMark = achievedMark;
        this.timeOfExam = timeOfExam;
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

    public void setAchievedMark(double achievedMark) {
        this.achievedMark = achievedMark;
    }

    public LocalDateTime getTimeOfExam() {
        return timeOfExam;
    }

    public void setTimeOfExam(LocalDateTime timeOfExam) {
        this.timeOfExam = timeOfExam;
    }
}
