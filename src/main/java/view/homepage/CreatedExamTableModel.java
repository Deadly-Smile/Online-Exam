package view.homepage;

import model.ExamInfo;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class CreatedExamTableModel extends AbstractTableModel {

    private List<ExamInfo> examInfoList;
    private final List<String> tableFields =
            Arrays.asList("Exam ID", "Name", "Start time", "Status");

    public CreatedExamTableModel(List<ExamInfo> examInfoList) {
        this.examInfoList = examInfoList;
    }

    @Override
    public String getColumnName(int column) {
        return tableFields.get(column);
    }

    @Override
    public int getRowCount() {
        return examInfoList.size();
    }

    @Override
    public int getColumnCount() {
        return tableFields.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ExamInfo examInfo = examInfoList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return examInfo.getExamID();
            case 1:
                return examInfo.getExamName();
            case 2:
                SimpleDateFormat dateFormat =
                        new SimpleDateFormat("E, MMM dd yyyy hh:mm:ss a");
                return dateFormat.format(examInfo.getStartingTime());
            case 3:
                switch (examInfo.getStatus()) {
                    case 0:
                        return "Over";
                    case 1:
                        return "Running";
                    case 2:
                        return "Hasn't started";
                }
        }
        return null;
    }

    public void setExamInfoList(List<ExamInfo> examInfoList) {
        this.examInfoList = examInfoList;
    }
}
