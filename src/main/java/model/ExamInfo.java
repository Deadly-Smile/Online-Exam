package model;

import org.bson.types.ObjectId;

import java.util.Date;

public class ExamInfo {
    private String examName;
    private ObjectId examID;
    private Date startingTime;

    public ExamInfo(String examName, ObjectId examID, Date startingTime) {
        this.examName = examName;
        this.examID = examID;
        this.startingTime = startingTime;
    }

    public ExamInfo(Object exam_name, Object exam_id, Object starting_time) {
        examName = (String) exam_name;
        examID = (ObjectId) exam_id;
        startingTime = (Date) starting_time;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public ObjectId getExamID() {
        return examID;
    }

    public void setExamID(ObjectId examID) {
        this.examID = examID;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }
}
