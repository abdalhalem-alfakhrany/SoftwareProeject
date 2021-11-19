package pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNew extends JFrame {

    Map<String, String> dataMap = new HashMap<>();

    public AddNew() {
        super();
        setSize(400, 400);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        add(inputGroup("1", "name1"));
        add(inputGroup("2", "name2"));
        add(inputGroup("3", "name3"));
        add(inputGroup("4", "name4"));

        JPanel submitButtoPanel = new JPanel();
        JButton submitButton = new JButton("submit");
        submitButton.addActionListener((event) -> {
            System.out.println(dataMap);
        });
        submitButtoPanel.add(submitButton);

        add(submitButtoPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel inputGroup(String dataMapKey, String lableString) {
        JPanel panel = new JPanel();

        JLabel label = new JLabel(lableString);
        JTextField inputField = new JTextField();
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                dataMap.put(dataMapKey, inputField.getText());
            }
        });

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(8, 8, 8, 8);
        panel.add(label, constraints);

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        panel.add(inputField, constraints);

        return panel;
    }
}
