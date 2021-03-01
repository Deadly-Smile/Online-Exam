package view.homepage;

import model.Result;


import javax.swing.table.AbstractTableModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HistoryTableModel extends AbstractTableModel {
    private List<Result> history;
    private final List<String> fieldNames = Arrays.asList("Exam name", "Scored", "Out of", "Is passed");

    public HistoryTableModel(List<Result> history) {
        setHistory(history);
    }

    @Override
    public String getColumnName(int column) {
        return fieldNames.get(column);
    }

    @Override
    public int getRowCount() {
        return history.size();
    }

    @Override
    public int getColumnCount() {
        return fieldNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Result result = history.get(rowIndex);
        switch (columnIndex){
            case 0:
                return result.getExamName();
            case 1:
                return result.getAchievedMark();
            case 2:
                return result.getMaximumMark();
            case 3:
                return result.isPassed() ? "Passed" : "Failed";
        }
        return null;
    }

    public void setHistory(List<Result> history) {
        this.history = history;
        Collections.reverse(this.history);
    }
}
