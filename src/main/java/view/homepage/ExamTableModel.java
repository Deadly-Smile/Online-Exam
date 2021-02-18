package view.homepage;

import model.Exam;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExamTableModel extends AbstractTableModel {

    private List<Exam> examList;
    private final List<String> tableFields =
            Arrays.asList("Exam ID","Name","Setter","Starts in",
                    "Start date","Status","Duration(min)");

    private String examStartTime;

    public ExamTableModel() {
        examList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return examList.size();
    }

    @Override
    public String getColumnName(int column) {
        return tableFields.get(column);
    }

    @Override
    public int getColumnCount() {
        return tableFields.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exam exam = examList.get(rowIndex);
        switch (columnIndex){
            case 0:
                return exam.getId();
            case 1:
                return exam.getExamName();
            case 2:
                return exam.getExamSetterHandle();
            case 3:
                examStartTime = exam.getExamStartingTime().getHours() +
                ": " + exam.getExamStartingTime().getMinutes();
                return examStartTime;
            case 4:
                return exam.getExamStartingTime().getDay()
                        + " " + exam.getExamStartingTime().getDate()
                        + " /" + exam.getExamStartingTime().getMonth()
                        + " /" + exam.getExamStartingTime().getYear();
            case 5:
                switch (exam.getStatus()){
                    case 0:
                        return "Over";
                    case 1:
                        return "Running";
                    case 2:
                        return "Not started";
                }
            case 6:
                return exam.getExamDuration();
        }
        return null;
    }

    public void setData(List<Exam> examList) {
        this.examList = examList;
    }
}
