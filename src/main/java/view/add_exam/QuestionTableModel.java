package view.add_exam;

import model.MultipleChoiceQuestion;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class QuestionTableModel extends AbstractTableModel {
    private List<MultipleChoiceQuestion> questions;
    private final List<String> fieldName = Arrays.asList("No.", "Question Name");

    public QuestionTableModel() {
    }

    @Override
    public String getColumnName(int column) {
        return fieldName.get(column);
    }

    @Override
    public int getRowCount() {
//        return mcq.size();
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MultipleChoiceQuestion mcq = questions.get(rowIndex);
        switch (columnIndex){
            case 0:
                return mcq.getId();
            case 1:
                return mcq.getQuestion();
            default:
                return null;
        }
    }

    public void setData(List<MultipleChoiceQuestion> questions) {
        this.questions = questions;
    }
}
