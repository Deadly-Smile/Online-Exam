package view.add_exam;

import javax.swing.*;
import java.awt.*;

public class AddExam extends JFrame {
    private ToolBarPanel toolBarPanel;
    private FromPanel fromPanel;
    private QuestionTablePanel questionTablePanel;
    private AddQuestionDialog addQuestionDialog;
    public AddExam(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800,500));

        setLayout(new BorderLayout());
        toolBarPanel = new ToolBarPanel();
        add(toolBarPanel,BorderLayout.NORTH);
        fromPanel = new FromPanel();
        add(fromPanel,BorderLayout.WEST);
        questionTablePanel = new QuestionTablePanel();
        add(questionTablePanel,BorderLayout.CENTER);

        addQuestionDialog = new AddQuestionDialog(this,"Add Question");

        setVisible(true);
    }
}
