package view.homepage;

import model.Result;
import model.User;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.Arrays;
import java.util.List;

public class HistoryTableModel extends AbstractTableModel {
    private final User user;
    private final List<String> fieldNames = Arrays.asList("Exam name", "Scored", "Out of");

    public HistoryTableModel(User user) {
        this.user = user;
    }

    @Override
    public String getColumnName(int column) {
        return fieldNames.get(column);
    }

    @Override
    public int getRowCount() {
        return user.getHistory().size();
//        return 0;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Result result = user.getHistory().get(rowIndex);
        switch (columnIndex){
            case 0:
                return result.getExamName();
            case 1:
                return result.getAchievedMark();
            case 2:
                return result.getMaximumMark();
        }
        return null;
    }
}
