package view.add_exam;

import javax.swing.*;
import java.awt.*;

public class FromPanel extends JPanel {

    private JPanel labelPanel;
    private JPanel formPanel;
    private JPanel notePanel;
    private JLabel examNameLabel;
    private JLabel examPassLabel;
    private JLabel durationLabel;
    private JLabel startTimeLabel;
    private JLabel invalidLabel;
    private JTextField examNameField;
    private JPasswordField examPassField;
    private JSpinner durationSpinner;
    private JSpinner startTimeSpinner;
    private JButton createButton;
    private ExamFormListener examFormListener;

    public FromPanel() {
        initializeComponent();
        setComponent();

        createButton.addActionListener(e -> {
            String examName = examNameField.getText();
            char[] pass = examPassField.getPassword();
            String examPass = new String(pass);
            int examDuration = (int) durationSpinner.getValue();
            int startsIn = (int) startTimeSpinner.getValue();

            if((examName.length() > 3 && examPass.length() > 4)
                && ((examDuration >= 5) && (examDuration <= 180))
                && ((startsIn >= 5) && (startsIn <= 1000)))
            {
                invalidLabel.setVisible(false);
                ExamFormEvent event = new ExamFormEvent(
                        this,examName,examPass,examDuration,startsIn
                );
                examNameField.setText(null);
                examPassField.setText(null);
                if(examFormListener != null){
                    examFormListener.examFormEventOccurred(event);
                }
            } else {
                invalidLabel.setVisible(true);
            }
        });
    }

    private void initializeComponent() {
        labelPanel = new JPanel();
        setLabelPanel();
        formPanel = new JPanel();
        setFormPanel();
        notePanel = new JPanel();
        setNotePanel();
    }

    private void setNotePanel() {
        JLabel note = new JLabel("Note : time is calculated by minutes.");
        note.setForeground(new Color(0xec4646));
        note.setLayout(new FlowLayout(FlowLayout.CENTER));
        notePanel.add(note);
    }

    private void setLabelPanel() {
        JLabel requestLabel = new JLabel("Please Fill the form");
        requestLabel.setForeground(new Color(0x350b40));
        requestLabel.setFont(new Font("Arial",Font.BOLD,20));

        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelPanel.add(requestLabel);
    }

    private void setFormPanel() {
        initializeFormComponent();
        setFormComponent();
    }

    private void setFormComponent() {
        /*  Initialization  */
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 10;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

        /* First Row */
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(examNameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        formPanel.add(examNameField, gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        formPanel.add(examPassLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(-10,0,-10,0);
        formPanel.add(examPassField, gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        formPanel.add(durationLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        formPanel.add(durationSpinner, gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        formPanel.add(startTimeLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,0);
        formPanel.add(startTimeSpinner, gbc);

        /*  Next Row */
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,0,0,5);
        formPanel.add(invalidLabel, gbc);

        /* Last Row */
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.weighty = 4;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(createButton,gbc);
    }

    private void initializeFormComponent() {
        examNameLabel = new JLabel("Exam Name :");

        examPassLabel = new JLabel("Set Password :");

        durationLabel = new JLabel("Set Duration :");

        startTimeLabel = new JLabel("Start Time :");

        invalidLabel = new JLabel("Invalid information");
        invalidLabel.setForeground(Color.RED);
        invalidLabel.setVisible(false);

        examNameField = new JTextField(10);

        examPassField = new JPasswordField(10);

        SpinnerModel durationSinnerModel =
                new SpinnerNumberModel(10,2,180,1);
        durationSpinner = new JSpinner(durationSinnerModel);

        SpinnerModel timeSinnerModel =
                new SpinnerNumberModel(10,5,1000,1);
        startTimeSpinner = new JSpinner(timeSinnerModel);

        createButton = new JButton("Create");
        createButton.setFocusPainted(false);
        createButton.setBackground(new Color(0xeabf9f));
        createButton.setForeground(new Color(0x383e56));
    }

    public void setExamFormListener(ExamFormListener examFormListener) {
        this.examFormListener = examFormListener;
    }

    private void setComponent() {
        Dimension dimension = getPreferredSize();
        dimension.width = 300;
        this.setPreferredSize(dimension);
        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createMatteBorder(
                        1,1,1,1,new Color(0x03506f))
                        ,"Form Panel")
        );
        this.setLayout(new BorderLayout());
        this.add(labelPanel,BorderLayout.NORTH);
        this.add(formPanel,BorderLayout.CENTER);
        this.add(notePanel,BorderLayout.SOUTH);
    }

}
