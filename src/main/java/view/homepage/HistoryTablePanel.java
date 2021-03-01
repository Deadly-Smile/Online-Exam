package view.homepage;

import model.Result;
import view.TableStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class HistoryTablePanel extends JPanel {
    private final HistoryTableModel historyTableModel;
    private List<Result> history;

    public HistoryTablePanel(List<Result> history, JFrame home) {
        HistoryTablePanel source = this;
        this.history = history;
        historyTableModel = new HistoryTableModel(history);
        JTable historyTable = new JTable(historyTableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(historyTable),BorderLayout.CENTER);

        TableStyle tableStyle = new TableStyle(historyTable);
        tableStyle.StyleTheTable();

        Dimension dimension = getPreferredSize();
        dimension.width = 320;
        setPreferredSize(dimension);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));

        historyTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    int index = table.getSelectedRow();
                    new ResultDetails(home, source.history.get(index).getExamName(),
                            false, source.history.get(index));
                }
            }
        });

        refresh();
    }
    public void refresh() {
        historyTableModel.fireTableDataChanged();
    }

    public void setHistory(List<Result> history) {
        this.history = history;
        historyTableModel.setHistory(history);
        refresh();
    }
}
