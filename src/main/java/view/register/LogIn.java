package view.register;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame {
    public LogIn(String title) throws HeadlessException {
        super(title);
        setSize(new Dimension(380,320));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
