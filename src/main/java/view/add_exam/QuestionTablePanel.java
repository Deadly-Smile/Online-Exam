package view.add_exam;

import model.Exam;
import model.MultipleChoiceQuestion;
import view.TableStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class QuestionTablePanel extends JPanel {
    private final QuestionTableModel tableModel;

    public QuestionTablePanel(SetExam setExam, Exam exam) {
        tableModel = new QuestionTableModel();
        JTable table = new JTable(tableModel);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x03506f)));

        TableStyle tableStyle = new TableStyle(table);
        tableStyle.StyleTheTable();

        if (exam != null) {
            setData(exam.getQuestions());
        }

        setLayout(new BorderLayout());
        add(new JScrollPane(table),BorderLayout.CENTER);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    int id = (int) table.getValueAt(table.getSelectedRow(), 0);
                    setExam.editQuestion(id);
                }
            }
        });
    }

    public void setData(List<MultipleChoiceQuestion> questions){
        tableModel.setData(questions);
        refresh();
    }

    public void addQuestion(MultipleChoiceQuestion mcq){
        tableModel.addQuestion(mcq);
        refresh();
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
