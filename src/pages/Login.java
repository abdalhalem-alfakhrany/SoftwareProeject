package pages;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {
    Main parent;
    Map<String, String> dataMap = new HashMap<>();

    public Login(Main parent) {
        super();
        this.parent = parent;
        setLayout(new GridLayout(3, 0, 0, 10));

        add(inputGroup("userName", "User Name : "));
        add(inputGroup("password", "Passwor : "));

        JPanel submitButtonPanel = new JPanel();
        JButton submitButton = new JButton("Login");

        submitButton.addActionListener((event) -> {
            // cardinals test
            parent.logedIn = true;
            super.dispose();
        });
        submitButtonPanel.add(submitButton);

        add(submitButtonPanel);

        setLocationRelativeTo(null);
        setSize(400, 200);
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
