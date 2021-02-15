package view.add_exam;

import java.util.EventObject;

public class ExamFormEvent extends EventObject {
    private String examName;
    private String examPass;
    private int examDuration;
    private int startsIn;

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
                         int examDuration, int startsIn) {
        super(source);
        this.examName = examName;
        this.examPass = examPass;
        this.examDuration = examDuration;
        this.startsIn = startsIn;
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

    public int getStartsIn() {
        return startsIn;
    }

    public void setStartsIn(int startsIn) {
        this.startsIn = startsIn;
    }
}
