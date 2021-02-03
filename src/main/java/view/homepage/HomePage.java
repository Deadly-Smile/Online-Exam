package view.homepage;

import view.StatusPanel;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    private HeaderPanel headerPanel;
    private HistoryTablePanel historyTablePanel;
    private ExamTablePanel examTablePanel;
    private StatusPanel statusPanel;

    public HomePage(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800,500));

        setLayout(new BorderLayout());
        headerPanel = new HeaderPanel();
        add(headerPanel,BorderLayout.NORTH);
        examTablePanel = new ExamTablePanel();
        add(examTablePanel,BorderLayout.CENTER);
        historyTablePanel = new HistoryTablePanel();
        add(historyTablePanel,BorderLayout.WEST);
        statusPanel = new StatusPanel();
        add(statusPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

}
