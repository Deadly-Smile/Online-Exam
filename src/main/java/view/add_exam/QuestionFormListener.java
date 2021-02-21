package view.add_exam;

import java.io.IOException;
import java.util.EventListener;

public interface QuestionFormListener extends EventListener {
    void questionFormEventOccurred(QuestionFormEvent Event);
}
