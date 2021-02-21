package view.homepage;

import model.Result;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistoryTablePanel extends JPanel {
    private JTable historyTable;
    private HistoryTableModel historyTableModel;

    private List<Result> history;

    public HistoryTablePanel(List<Result> history) {
        this.history = history;
        historyTableModel = new HistoryTableModel(history);
        historyTable = new JTable(historyTableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(historyTable),BorderLayout.CENTER);

        Dimension dimension = getPreferredSize();
        dimension.width = 250;
        setPreferredSize(dimension);
        setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(0x726a95)));
        refresh();
    }
    public void refresh() {
        historyTableModel.fireTableDataChanged();
    }

    public void setHistory(List<Result> history) {
        this.history = history;
    }
}
