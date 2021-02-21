package view.homepage;

import model.Exam;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class ExamTableModel extends AbstractTableModel {

    private List<Exam> examList;
    private final List<String> tableFields =
            Arrays.asList("Exam ID","Name","Setter","Starts in",
                    "Start date","Status","Duration(min)","Penalty");

    public ExamTableModel(List<Exam> exams) {
        examList = exams;
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
        SimpleDateFormat dateFormat;
        switch (columnIndex){
            case 0:
                return exam.getId();
            case 1:
                return exam.getExamName();
            case 2:
                return exam.getExamSetterHandle();
            case 3:
                dateFormat = new SimpleDateFormat("hh:mm:ss a");
                return dateFormat.format(exam.getExamStartingTime());
            case 4:
                dateFormat = new SimpleDateFormat("E, MMM dd yyyy");
                return dateFormat.format(exam.getExamStartingTime());
            case 5:
                switch (exam.getStatus()){
                    case 0:
                        return "Over";
                    case 1:
                        return "Running";
                    case 2:
                        return "Hasn't started";
                    case 3:
                        return "Finished long age";
                }
            case 6:
                return exam.getExamDuration();
            case 7:
                return exam.getPenalty();
            case 8:
                return exam.getMaxMark();
        }
        return null;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }
}
