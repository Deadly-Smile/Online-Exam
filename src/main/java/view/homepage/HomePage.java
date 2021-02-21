package view.homepage;

import controller.Controller;
import model.Exam;
import model.User;
import view.add_exam.AddExam;
import view.register.LogIn;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends JFrame {

    private HeaderPanel headerPanel;
    private HistoryTablePanel historyTablePanel;
    private ExamTablePanel examTablePanel;
    private StatusPanel statusPanel;
    private CreatedExam createdExam;
    private AddExam addExam;

    private List<Exam> exams = new ArrayList<>();
    private User user = null;
    private final Controller controller = new Controller();

    public HomePage(String title, boolean isStart) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800,500));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        if(isStart){
            new LogIn(this, "Log In", true); /* calling login frame */
        }
        setComponents();
    }

    private void setComponents() {
        statusPanel = new StatusPanel();
        add(statusPanel,BorderLayout.SOUTH);
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void lateSetting(){
        headerPanel = new HeaderPanel(user,this);
        add(headerPanel,BorderLayout.NORTH);

        examTablePanel = new ExamTablePanel(exams);
        historyTablePanel = new HistoryTablePanel(user.getHistory());
        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,historyTablePanel,examTablePanel),BorderLayout.CENTER);
    }

    public void startAddExam(){
        addExam = new AddExam(this, "Add Exam", true, user.getHandle());
    }

    public void callCreatedExamDialog() {
        createdExam = new CreatedExam(this,"Created Exams",false,user.getCreatedExams());
    }

    public void logOut() {
        new LogIn(this, "Log In", false); /* calling login frame */
    }

    public void createExam(Exam newExam) {
        int type;
        JLabel message = new JLabel();
        message.setForeground(Color.RED);
        message.setFont(new Font("FUTURA",Font.BOLD,13));
        try {
            if (controller.createANewExam(newExam)){
                message.setText("Exam created Successfully");
                type = JOptionPane.INFORMATION_MESSAGE;
                examTablePanel.setExams(controller.getExams());
                examTablePanel.refresh();
                user = controller.getUser(user.getHandle());
            } else {
                message.setText("Exam wasn't created");
                type = JOptionPane.ERROR_MESSAGE;
            }
        } catch (NullPointerException e) {
            message.setText("Something went wrong !!");
            type = JOptionPane.ERROR_MESSAGE;
            throw new NullPointerException("addExam is null");
        }
        JOptionPane.showMessageDialog(this, message, "Message", type);
    }
}
