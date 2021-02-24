package view.homepage;

import model.Result;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistoryTablePanel extends JPanel {
    private final JTable historyTable;
    private final HistoryTableModel historyTableModel;

    public HistoryTablePanel(List<Result> history) {
        historyTableModel = new HistoryTableModel(history);
        historyTable = new JTable(historyTableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(historyTable),BorderLayout.CENTER);

        stylingTable();

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
        historyTableModel.setHistory(history);
        refresh();
    }

    private void stylingTable() {
        historyTable.setRowSelectionAllowed(true);
        historyTable.setGridColor(Color.gray);
        historyTable.setSelectionBackground(new Color(0x94ebcd));
        historyTable.setSelectionForeground(new Color(0xE61548));
    }
}
