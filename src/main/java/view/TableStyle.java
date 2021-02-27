package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TableStyle {
    private final JTable table;

    public TableStyle(JTable table) {
        this.table = table;
    }

    public void StyleTheTable() {
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(0xFF31778B, true));
        header.setForeground(Color.WHITE);
        table.setRowHeight(20);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column)
            {
                final Component customTable = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                customTable.setBackground(row % 2 == 0 ? new Color(0x1A000000, true) : Color.WHITE);
                if(isSelected) {
                    setBackground(new Color(0x59276678, true));
                }
                this.setHorizontalAlignment(SwingConstants.CENTER);
                customTable.setFont(new Font("Arial",Font.PLAIN,14));
                return customTable;
            }
        });
    }
}
