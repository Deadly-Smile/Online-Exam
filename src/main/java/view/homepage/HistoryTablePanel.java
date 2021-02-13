package view.homepage;

import model.User;

import javax.swing.*;
import java.awt.*;

public class HistoryTablePanel extends JPanel {
    private JTable historyTable;
    private HistoryTableModel historyTableModel;

    public HistoryTablePanel(User user) {
        historyTableModel = new HistoryTableModel(user);
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

}
