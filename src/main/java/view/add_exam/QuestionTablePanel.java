package view.add_exam;

import model.MultipleChoiceQuestion;
import view.TableStyle;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuestionTablePanel extends JPanel {
    private final QuestionTableModel tableModel;

    public QuestionTablePanel() {
        tableModel = new QuestionTableModel();
        JTable table = new JTable(tableModel);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x03506f)));

        TableStyle tableStyle = new TableStyle(table);
        tableStyle.StyleTheTable();

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
