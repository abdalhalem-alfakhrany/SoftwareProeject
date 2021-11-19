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

public class Register_Login extends JFrame {

    Map<String, String> loginDataMap = new HashMap<>();
    Map<String, String> registerDataMap = new HashMap<>();
    Main parent;

    public Register_Login(Main parent) {
        super();
        this.parent = parent;
        setLayout(new GridLayout(0, 2));

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 0, 0, 10));
        loginPanel.add(inputGroup("userName", "User Name : ", loginDataMap));
        loginPanel.add(inputGroup("password", "Passwor : ", loginDataMap));
        loginPanel.add(submitButton("Login", 1));

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(9, 0, 0, 10));
        // personal info
        registerPanel.add(inputGroup("firstName", "First Name : ", registerDataMap));
        registerPanel.add(inputGroup("lastName", "Last Name : ", registerDataMap));
        registerPanel.add(inputGroup("phoneNumber", "Phone Number : ", registerDataMap));
        registerPanel.add(inputGroup("address", "Adress : ", registerDataMap));
        registerPanel.add(inputGroup("age", "Age : ", registerDataMap));
        // login info
        registerPanel.add(inputGroup("userName", "User Name : ", registerDataMap));
        registerPanel.add(inputGroup("password", "Passwor : ", registerDataMap));
        registerPanel.add(inputGroup("confirmPassword", "Confrirm Password : ", registerDataMap));
        registerPanel.add(submitButton("Register", 2));

        add(loginPanel);
        add(registerPanel);

        setSize(400, 400);
        setVisible(true);
    }

    JPanel submitButton(String buttonLable, int functionId) {
        JPanel panel = new JPanel();
        JButton submitButton = new JButton(buttonLable);

        submitButton.addActionListener((event) -> {
            switch (functionId) {
            case 1:
                logIn();
                break;
            case 2:
                register();
                break;
            default:
                break;
            }
        });
        panel.add(submitButton);

        panel.add(submitButton);
        return panel;
    }

    private void logIn() {
        // login logic hear
        parent.logedIn = true;
        this.dispose();
    }

    private void register() {
        // registeration logic hear
        parent.logedIn = true;
        this.dispose();
    }

    JPanel inputGroup(String dataMapKey, String lableString, Map<String, String> dataMap) {
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
