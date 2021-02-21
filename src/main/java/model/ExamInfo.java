package model;

import java.util.Calendar;
import java.util.Date;

public class ExamInfo {
    public static final int OVER = 0;
    public static final int RUNNING = 1;
    public static final int HAS_NOT_STARTED_YET = 2;

    private String examName;
    private String examID;
    private Date startingTime;
    private int examDuration;

    public ExamInfo(String examName, String examID, Date startingTime, int examDuration) {
        this.examName = examName;
        this.examID = examID;
        this.startingTime = startingTime;
        this.examDuration = examDuration;
    }

    public ExamInfo(Object exam_name, Object exam_id, Object starting_time, Object exam_duration) {
        examName = (String) exam_name;
        examID = (String) exam_id;
        startingTime = (Date) starting_time;
        examDuration = (int) exam_duration;
    }

    public int getStatus() {
        if (startingTime.getTime() > new Date().getTime()) {
            return HAS_NOT_STARTED_YET;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startingTime);
            calendar.add(Calendar.MINUTE, examDuration);
            if(new Date().after(calendar.getTime())) {
                return OVER;
            } else {
                return RUNNING;
            }
        }
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }
}
