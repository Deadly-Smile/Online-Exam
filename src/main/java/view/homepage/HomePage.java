package view.homepage;

import controller.Controller;
import model.Exam;
import model.Result;
import model.User;
import view.add_exam.SetExam;
import view.attend_exam.AnswerPanel;
import view.attend_exam.ExamRoom;
import view.attend_exam.WaitingRoom;
import view.register.LogIn;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomePage extends JFrame {

    private HeaderPanel headerPanel;
    private HistoryTablePanel historyTablePanel;
    private ExamTablePanel examTablePanel;
    private StatusPanel statusPanel;
    private CreatedExam createdExam;
    private SetExam setExam;
    private ExamRoom myExamRoom = new ExamRoom();
    private WaitingRoom waitingRoom = new WaitingRoom();

    private List<Exam> exams = new ArrayList<>();
    private User user = null;
    private final Controller controller = new Controller();

    public HomePage(String title, boolean isStart) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(950,580));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("src/main/resources/Free Stolen Logo.png");
        setIconImage(icon.getImage());

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

        examTablePanel = new ExamTablePanel(exams, this);
        historyTablePanel = new HistoryTablePanel(user.getHistory(), this);
        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,historyTablePanel,examTablePanel),BorderLayout.CENTER);
    }

    public void startSettingExam(){
        setExam = new SetExam(this, "Set Exam", true, user.getHandle(), null);
    }

    public void callCreatedExamDialog() {
        createdExam = new CreatedExam(this,"Created Exams",false,user.getCreatedExams());
    }

    public void logOut() {
        new LogIn(this, "Log In", false); /* calling login frame */
    }

    public void createExam(Exam newExam, boolean isEdit, Date oldStartTime) {
        int type;
        JLabel message = new JLabel();
        message.setFont(new Font("FUTURA",Font.BOLD,15));
        if(isEdit) {
            Calendar examTime = Calendar.getInstance();
            examTime.setTime(oldStartTime);
            Calendar now = Calendar.getInstance();
            now.add(Calendar.MINUTE,4);
            if(examTime.after(now)) {
                controller.deleteExam(newExam.getId());
            } else {
                message = new JLabel("Exam is going to start soon, you can't edit now.");
                message.setForeground(new Color(0xaa2b1d));
                message.setFont(new Font("FUTURA",Font.PLAIN,15));
                JOptionPane.showMessageDialog(this,message,
                        "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        try {
            if (controller.createANewExam(newExam)){
                message.setText("Exam created Successfully");
                message.setForeground(new Color(0x295939));
                type = JOptionPane.INFORMATION_MESSAGE;
                examTableRefresh();
                user = controller.getUser(user.getHandle());
            } else {
                message.setText("Exam wasn't created");
                message.setForeground(Color.RED);
                type = JOptionPane.ERROR_MESSAGE;
            }
        } catch (NullPointerException e) {
            message.setText("Something went wrong !!");
            message.setForeground(Color.RED);
            throw new NullPointerException("addExam is null");
        }

        JOptionPane.showMessageDialog(this, message, "Message", type);
    }

    public void examTableRefresh() {
        examTablePanel.setExams(controller.getExams());
        examTablePanel.refresh();
    }

    public void attemptToGoExamRoom(String examId) {
        Exam exam = controller.getExam(examId);
        if (exam.getStatus() == Exam.OVER) {
            JLabel message = new JLabel("Sorry, the exam is over");
            message.setForeground(new Color(0xaa2b1d));
            message.setFont(new Font("FUTURA", Font.PLAIN, 15));
            JOptionPane.showMessageDialog(this, message, "Message",
                    JOptionPane.WARNING_MESSAGE);
        } else if(exam.getExamSetterHandle().equals(Controller.getCurrentHandle())){
            if (exam.getStatus() == Exam.RUNNING) {
                JLabel message = new JLabel("Too late to edit now");
                message.setForeground(new Color(0xaa2b1d));
                message.setFont(new Font("FUTURA", Font.PLAIN, 15));
                JOptionPane.showMessageDialog(this, message, "Message",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            Calendar examTime = Calendar.getInstance();
            examTime.setTime(exam.getExamStartingTime());
            Calendar now = Calendar.getInstance();
            now.add(Calendar.MINUTE,5);
            if(examTime.after(now)) {
                setExam = new SetExam(this,"Set Exam", true, user.getHandle(), exam);
            } else {
                JLabel message = new JLabel("Exam is going to start soon, you can't edit now.");
                message.setForeground(new Color(0xaa2b1d));
                message.setFont(new Font("FUTURA",Font.PLAIN,15));
                JOptionPane.showMessageDialog(this,message,
                        "Warning",JOptionPane.WARNING_MESSAGE);
            }

        } else if (isExamIsAlreadyGiven(examId)) {
            JLabel message = new JLabel("Sorry, you already attended the exam.");
            message.setForeground(new Color(0xaa2b1d));
            message.setFont(new Font("FUTURA",Font.PLAIN,15));

            JOptionPane.showMessageDialog(this,message,
                    "Warning",JOptionPane.WARNING_MESSAGE);
        } else {
            String enteredPass = JOptionPane.showInputDialog(this,
                    "Enter password to enter the exam :","Password",JOptionPane.QUESTION_MESSAGE);
            if(enteredPass != null) {
                if (exam.getExamPassword().equals(enteredPass)) {
                    if ((exam.getExamStartingTime().getTime() - new Date().getTime()) > 500) {
                        waitingRoom = new WaitingRoom(this, false, exam);
                    } else {
                        goToExamRoom(exam);
                    }
                } else {
                    JLabel message = new JLabel("Wrong password, try again");
                    message.setForeground(Color.red);
                    message.setFont(new Font("FUTURA", Font.PLAIN, 15));
                    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private boolean isExamIsAlreadyGiven(String examId) {
        List<Result> results = controller.getCurrentUser().getHistory();

        for (Result i : results) {
            if(i.getExamId().equals(examId)) {
                return true;
            }
        }
        return false;
    }

    public void goToExamRoom(Exam exam) {
        waitingRoom.dispose();
        myExamRoom = new ExamRoom(this,exam.getExamName(),exam,true);
    }

    public void submitOMRList(List<AnswerPanel> omrList,Exam exam) {
        myExamRoom.dispose();
        Result result;
        double mark = 0.00;
        int rightAnswered = 0;
        int wrongAnswered = 0;
        for (int i = 0; i < omrList.size(); i++) {
            boolean isWronged = false;
            for (int j = 0; j < omrList.get(i).getChoiceButtons().size(); j++) {
                if(omrList.get(i).getChoiceButtons().get(j).isSelected()){
                    if (j == exam.getQuestions().get(i).getRightIndex()) {
                        mark += exam.getQuestions().get(i).getMark();
                        rightAnswered++;
                    } else {
                        wrongAnswered++;
                        isWronged = true;
                    }
                }
            }
            if (isWronged) {
                double penalty = (double) exam.getPenalty() / 100;
                mark = mark - (exam.getQuestions().get(i).getMark() * penalty);
            }
        }
        mark = Math.round(mark * 100);
        mark /= 100;
        boolean isPassed = ((mark / exam.getMaxMark()) * 100) >= exam.getPassingPercent();

        result = new Result(exam.getId(), exam.getExamName(), exam.getMaxMark(),
                mark, exam.getPenalty(), exam.getExamStartingTime(), exam.getExamSetterHandle(),
                exam.getQuestions().size(), exam.getExamDuration(), isPassed, rightAnswered,
                wrongAnswered, exam.getQuestions().size() - (rightAnswered+wrongAnswered));
        controller.addResult(result);
        historyTablePanel.setHistory(controller.getCurrentUser().getHistory());
    }
    public void searchExam(String key) {
        List<Exam> exams = controller.getSearchedExam(key);
        if (exams == null) {
            JLabel message = new JLabel("No exam found");
            message.setForeground(Color.red);
            message.setFont(new Font("FUTURA",Font.PLAIN,15));
            JOptionPane.showMessageDialog(this,message, "Message",JOptionPane.WARNING_MESSAGE);
        } else if(exams.size() == 0){
            JLabel message = new JLabel("No exam found");
            message.setForeground(Color.red);
            message.setFont(new Font("FUTURA",Font.PLAIN,15));
            JOptionPane.showMessageDialog(this,message, "Message",JOptionPane.WARNING_MESSAGE);
        } else {
            examTablePanel.setExams(exams);
            examTablePanel.refresh();
        }
    }
}
