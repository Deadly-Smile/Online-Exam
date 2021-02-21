package view.add_exam;

import model.MultipleChoiceQuestion;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionTableModel extends AbstractTableModel {
    private List<MultipleChoiceQuestion> questions;
    private final List<String> fieldName = Arrays.asList("No.", "Question Name");

    public QuestionTableModel() {
        questions = new ArrayList<>();
    }

    @Override
    public String getColumnName(int column) {
        return fieldName.get(column);
    }

    @Override
    public int getRowCount() {
        return questions.size();
//        return 0;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return questions.get(rowIndex).getId();
            case 1:
                return questions.get(rowIndex).getQuestion();
            default:
                return null;
        }
    }

    public void setData(List<MultipleChoiceQuestion> questions) {
        this.questions = questions;
    }

    public void addQuestion(MultipleChoiceQuestion mcq){
        questions.add(mcq);
    }
}
