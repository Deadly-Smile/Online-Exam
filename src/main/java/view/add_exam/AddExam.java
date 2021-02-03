package view.add_exam;

import javax.swing.*;
import java.awt.*;

public class AddExam extends JFrame {
    private ToolBarPanel toolBarPanel;
    private FromPanel fromPanel;
    private QuestionTablePanel questionTablePanel;
    private AddQDialog addQDialog;
    public AddExam() throws HeadlessException {
        super("Add an Exam");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800,500));

        setLayout(new BorderLayout());
        toolBarPanel = new ToolBarPanel();
        add(toolBarPanel,BorderLayout.NORTH);
        fromPanel = new FromPanel();
        add(fromPanel,BorderLayout.WEST);
        questionTablePanel = new QuestionTablePanel();
        add(questionTablePanel,BorderLayout.CENTER);

        addQDialog = new AddQDialog(this,"Add Question");

        setVisible(true);
    }
}
