package view.add_exam;

import javax.swing.*;
import java.awt.*;

public class FromPanel extends JPanel {

    private Label labelPanel;
    private Form formPanel;
    private Note notePanel;

    public FromPanel() {
        initializeComponent();
        setComponent();
    }

    private void initializeComponent() {
        labelPanel = new Label();
        formPanel = new Form();
        notePanel = new Note();
    }

    private void setComponent() {
        Dimension dimension = getPreferredSize();
        dimension.width = 300;
        setPreferredSize(dimension);
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createMatteBorder(1,1,1,1,new Color(0x03506f))
                ,"Form Panel"));
        setLayout(new BorderLayout());
        add(labelPanel,BorderLayout.NORTH);
        add(formPanel,BorderLayout.CENTER);
        add(notePanel,BorderLayout.SOUTH);

    }
    private class Label extends JPanel{

        public Label() {
            JLabel requestLabel = new JLabel("Please Fill the form");
            requestLabel.setForeground(new Color(0x350b40));
            requestLabel.setFont(new Font("Arial",Font.BOLD,20));

            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(requestLabel);
        }
    }
    private class Form extends JPanel{
        private JLabel examNameLabel;
        private JLabel examPassLabel;
        private JLabel durationLabel;
        private JLabel startTimeLabel;
        private JTextField examNameField;
        private JTextField examPassField;
        private JSpinner durationSpinner;
        private JSpinner startTimeSpinner;
        private JButton createButton;

        public Form() {
            initializeComponent();
            setComponent();
        }
        private void initializeComponent() {
            examNameLabel = new JLabel("Exam Name :");

            examPassLabel = new JLabel("Set Password :");

            durationLabel = new JLabel("Set Duration :");

            startTimeLabel = new JLabel("Start Time :");

            examNameField = new JTextField(10);

            examPassField = new JTextField(10);

            SpinnerModel durationSinnerModel =
                    new SpinnerNumberModel(10,2,180,1);
            durationSpinner = new JSpinner(durationSinnerModel);

            SpinnerModel timeSinnerModel =
                    new SpinnerNumberModel(10,5,1000,1);
            startTimeSpinner = new JSpinner(timeSinnerModel);

            createButton = new JButton("Create");
        }

        private void setComponent() {
            /*  Initialization  */
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 10;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.NONE;

            /* First Row */
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0,0,5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(examNameLabel, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0,0,0);
            add(examNameField, gbc);

            /*  Next Row */
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0,0,5);
            add(examPassLabel, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(-10,0,-10,0);
            add(examPassField, gbc);

            /*  Next Row */
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0,0,5);
            add(durationLabel, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0,0,0);
            add(durationSpinner, gbc);

            /*  Next Row */
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0,0,5);
            add(startTimeLabel, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0,0,0);
            add(startTimeSpinner, gbc);

            /* Last Row */
            gbc.gridy++;
            gbc.weighty = 5;
            gbc.insets = new Insets(0,0,0,0);
            gbc.anchor = GridBagConstraints.LINE_START;
            add(createButton,gbc);
        }
    }
    private class Note extends JPanel{
        public Note() {
            JLabel note = new JLabel("Note : time is calculated by minutes.");
            note.setForeground(new Color(0xec4646));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(note);
        }
    }
}
