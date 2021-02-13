package view.add_exam;

import javax.swing.*;
import java.awt.*;

public class AddExam extends JDialog {
    private ToolBarPanel toolBarPanel;
    private FromPanel fromPanel;
    private QuestionTablePanel questionTablePanel;
    private AddQuestionDialog addQuestionDialog;
    public AddExam(JFrame home ,String title, boolean model) throws HeadlessException {
        super(home,title,model);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(750,450));
        setLocationRelativeTo(home);

        setLayout(new BorderLayout());
        toolBarPanel = new ToolBarPanel();
        add(toolBarPanel,BorderLayout.NORTH);
        fromPanel = new FromPanel();
        add(fromPanel,BorderLayout.WEST);
        questionTablePanel = new QuestionTablePanel();
        add(questionTablePanel,BorderLayout.CENTER);

//        addQuestionDialog = new AddQuestionDialog(this,"Add Question");

        setVisible(true);
    }
}
