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

public class Register extends JFrame {
    Map<String, String> dataMap = new HashMap<>();

    public Register() {
        super();
        setLayout(new GridLayout(9, 0, 0, 10));

        // personal info
        add(inputGroup("firstName", "First Name : "));
        add(inputGroup("lastName", "Last Name : "));
        add(inputGroup("phoneNumber", "Phone Number : "));
        add(inputGroup("address", "Adress : "));
        add(inputGroup("age", "Age : "));

        // login info
        add(inputGroup("userName", "User Name : "));
        add(inputGroup("password", "Passwor : "));
        add(inputGroup("confirmPassword", "Confrirm Password : "));

        JPanel submitButtonPanel = new JPanel();
        JButton submitButton = new JButton("Register");
        submitButtonPanel.add(submitButton);
        add(submitButtonPanel);

        setLocationRelativeTo(null);
        setSize(400, 400);
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
