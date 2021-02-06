package view.homepage;

import controller.Controller;
import view.StatusPanel;
import view.add_exam.AddExam;
import view.attend_exam.ExamRoom;
import view.register.LogIn;
import view.register.SignIn;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    public static boolean isVisual = false;

    private HeaderPanel headerPanel;
    private HistoryTablePanel historyTablePanel;
    private ExamTablePanel examTablePanel;
    private StatusPanel statusPanel;

    public HomePage(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800,500));
        setLocationRelativeTo(null);

        new LogIn(this, "Log In");
//
//        new ExamRoom("Exam Room");
//        new AddExam("Add an Exam").setVisible(Controller.);

        setLayout(new BorderLayout());
        headerPanel = new HeaderPanel();
        add(headerPanel,BorderLayout.NORTH);
        examTablePanel = new ExamTablePanel();
        add(examTablePanel,BorderLayout.CENTER);
        historyTablePanel = new HistoryTablePanel();
        add(historyTablePanel,BorderLayout.WEST);
        statusPanel = new StatusPanel();
        add(statusPanel,BorderLayout.SOUTH);
    }
}
