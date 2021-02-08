package model;

public class Result {
    private String examName;
    private double maximumMark;
    private double achievedMark;

    public Result() {
    }

    public Result(String examName, double maximumMark, double achievedMark) {
        this.examName = examName;
        this.maximumMark = maximumMark;
        this.achievedMark = achievedMark;
    }

    public Result(Object exam_name, Object maximum_mark, Object achieved_mark) {
        this.examName = exam_name.toString();
        this.maximumMark = (double) maximum_mark;
        this.achievedMark = (double) achieved_mark;
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
}
