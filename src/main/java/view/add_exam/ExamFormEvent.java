package view.add_exam;

import java.util.Date;
import java.util.EventObject;

public class ExamFormEvent extends EventObject {
    private String examName;
    private String examPass;
    private int penalty;
    private int examDuration;
    private Date startDate;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ExamFormEvent(Object source) {
        super(source);
    }

    public ExamFormEvent(Object source, String examName, String examPass,
                         int penalty, int examDuration, Date startDate) {
        super(source);
        this.examName = examName;
        this.examPass = examPass;
        this.penalty = penalty;
        this.examDuration = examDuration;
        this.startDate = startDate;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamPass() {
        return examPass;
    }

    public void setExamPass(String examPass) {
        this.examPass = examPass;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}
