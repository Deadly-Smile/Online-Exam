package view.add_exam;

import java.util.EventListener;

public interface ExamFormListener extends EventListener {
    void examFormEventOccurred(ExamFormEvent event);
}
