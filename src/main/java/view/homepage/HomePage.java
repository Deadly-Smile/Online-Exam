package view.homepage;

import controller.Controller;
import model.User;
import view.StatusPanel;
import view.add_exam.AddExam;
import view.attend_exam.ExamRoom;
import view.register.LogIn;
import view.register.SignIn;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    private HeaderPanel headerPanel;
    private HistoryTablePanel historyTablePanel;
    private ExamTablePanel examTablePanel;
    private StatusPanel statusPanel;
    private JDialog addExam;

    public HomePage(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800,500));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        new LogIn(this, "Log In"); /* calling login frame */
        setComponents();
    }

    private void setComponents() {
        /* adding panels */
        statusPanel = new StatusPanel();
        add(statusPanel,BorderLayout.SOUTH);
    }

    public void addHistoryTable(User user){
        headerPanel = new HeaderPanel(user,this);
        add(headerPanel,BorderLayout.NORTH);
        historyTablePanel = new HistoryTablePanel(user);
        examTablePanel = new ExamTablePanel();
        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,historyTablePanel,examTablePanel),BorderLayout.CENTER);
    }

    public void startAddExam(){
        addExam = new AddExam(this,"Add Exam", true);
    }
}
