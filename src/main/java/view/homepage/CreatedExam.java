package view.homepage;


import model.ExamInfo;
import view.TableStyle;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CreatedExam extends JDialog {

    private JTable table;
    private JPanel labelPanel;
    private CreatedExamTableModel tableModel;

    private List<ExamInfo> examInfoList;

    public CreatedExam(HomePage home, String title, boolean model, List<ExamInfo> examInfoList) {
        super(home,title,model);

        this.examInfoList = examInfoList;

        setSize(new Dimension(600,350));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(home);

        initialization(examInfoList);
        setComponents();
        TableStyle tableStyle = new TableStyle(table);
        tableStyle.StyleTheTable();
        setVisible(true);
    }

    private void setComponents() {
        setLayout(new BorderLayout());
        add(labelPanel,BorderLayout.NORTH);
        add(new JScrollPane(table),BorderLayout.CENTER);
    }

    private void initialization(List<ExamInfo> examInfoList) {
        tableModel = new CreatedExamTableModel(examInfoList);
        table = new JTable(tableModel);

        labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("My created exams");
        label.setForeground(new Color(0x413c69));
        label.setFont(new Font("FUTURA",Font.BOLD,15));
        label.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        labelPanel.add(label);
    }

    public void refresh(){
        tableModel.setExamInfoList(examInfoList);
        tableModel.fireTableDataChanged();
    }

    public void setExamInfoList(List<ExamInfo> examInfoList) {
        this.examInfoList = examInfoList;
    }
}
