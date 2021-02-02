package view.homepage;

import model.Exam;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ExamTableModel extends AbstractTableModel {

    private List<Exam> examList;
    private final List<String> tableFields = Arrays.asList("Exam ID","Name","Setter","Starts","Duration(min)");

    public ExamTableModel() {

    }

    @Override
    public int getRowCount() {
//        return examList.size();
        return 0;
    }

    @Override
    public String getColumnName(int column) {
        return tableFields.get(column);
    }

    @Override
    public int getColumnCount() {
        return 5;
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
                return exam.getExamStartingTime();
            case 4:
                return exam.getGivenTimeInMinutes();
        }
        return null;
    }

    public void setData(List<Exam> examList) {
        this.examList = examList;
    }
}
