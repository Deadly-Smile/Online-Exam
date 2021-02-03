package view.homepage;

import model.Result;
import model.User;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class HistoryTableModel extends AbstractTableModel {
    private User user;
    private final List<String> fieldNames = Arrays.asList("Exam name", "Score");

    public HistoryTableModel() {
    }

    @Override
    public String getColumnName(int column) {
        return fieldNames.get(column);
    }

    @Override
    public int getRowCount() {
//        return user.getHistory().size();
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Result result = user.getHistory().get(rowIndex);
        switch (columnIndex){
            case 0:
                return result.getExamName();
            case 1:
                return result.getAchievedMark() + "" + "/" + result.getMaximumMark();
        }
        return null;
    }

    public void setData(User user) {
        this.user = user;
    }
}
