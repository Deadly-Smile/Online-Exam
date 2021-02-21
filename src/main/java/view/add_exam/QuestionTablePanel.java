package view.add_exam;

import model.MultipleChoiceQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuestionTablePanel extends JPanel {
    private final JTable table;
    private final QuestionTableModel tableModel;

    public QuestionTablePanel() {
        tableModel = new QuestionTableModel();
        table = new JTable(tableModel);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x03506f)));

        setLayout(new BorderLayout());
        add(new JScrollPane(table),BorderLayout.CENTER);
    }

    public void setData(List<MultipleChoiceQuestion> questions){
        tableModel.setData(questions);
    }

    public void addQuestion(MultipleChoiceQuestion mcq){
        tableModel.addQuestion(mcq);
        refresh();
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
