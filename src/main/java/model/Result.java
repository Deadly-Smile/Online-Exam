package model;

public class Result {
    private String examId;
    private String examName;
    private double maximumMark;
    private double achievedMark;

    public Result() {
    }

    public Result(String examId, String examName, double maximumMark, double achievedMark) {
        this.examId = examId;
        this.examName = examName;
        this.maximumMark = maximumMark;
        this.achievedMark = achievedMark;
    }

    public Result(Object exam_id, Object exam_name, Object maximum_mark, Object achieved_mark) {
        this.examId = (String) exam_id;
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
                '}';
    }
}
