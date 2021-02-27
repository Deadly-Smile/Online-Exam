package view.homepage;

import model.Result;
import view.TableStyle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryTablePanel extends JPanel {
    private final JTable historyTable;
    private final HistoryTableModel historyTableModel;

    public HistoryTablePanel(List<Result> history) {
        historyTableModel = new HistoryTableModel(history);
        historyTable = new JTable(historyTableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(historyTable),BorderLayout.CENTER);

        TableStyle tableStyle = new TableStyle(historyTable);
        tableStyle.StyleTheTable();

        Dimension dimension = getPreferredSize();
        dimension.width = 300;
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
}
