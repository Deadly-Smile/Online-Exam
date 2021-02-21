package view.homepage;

import model.Exam;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExamTablePanel extends JPanel{
    private JTable examTable;
    private ExamTableModel examTableModel;

    private List<Exam> exams = new ArrayList<>();

    public ExamTablePanel(List<Exam> exams) {
        this.exams = exams;
        examTableModel = new ExamTableModel(exams);
        examTable = new JTable(examTableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(examTable),BorderLayout.CENTER);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

        refresh();
    }

    public void refresh() {
        examTableModel.setExamList(exams);
        examTableModel.fireTableDataChanged();
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}
