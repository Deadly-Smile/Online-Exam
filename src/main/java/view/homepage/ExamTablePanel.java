package view.homepage;

import model.Exam;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExamTablePanel extends JPanel{
    private JTable examTable;
    private ExamTableModel examTableModel;

    public ExamTablePanel() {
        examTableModel = new ExamTableModel();
        examTable = new JTable(examTableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(examTable),BorderLayout.CENTER);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

    }

    public void setData(List<Exam> examList){
        examTableModel.setData(examList);
    }

    public void refresh() {
        examTableModel.fireTableDataChanged();
    }
}
