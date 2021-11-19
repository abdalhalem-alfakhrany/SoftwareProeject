package pages;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {

    public Boolean logedIn = false;

    JButton listAllDataPage = new JButton("list all medicines");
    JButton addNewDataPage = new JButton("add new medicine");
    JButton searchPage = new JButton("search for medicine");
    JButton registerPage = new JButton("register");

    public Main() {
        GridLayout layout = new GridLayout(2, 2);
        layout.setVgap(100);
        layout.setHgap(100);
        setSize(400, 400);
        setLayout(layout);

        Login login = new Login(this);

        listAllDataPage.addActionListener((event) -> {
            if (logedIn) {
                new ListAll();
                login.dispose();
            } else {
                login.setVisible(true);
            }
        });
        addNewDataPage.addActionListener((event) -> {
            if (logedIn) {
                new AddNew();
                login.dispose();
            } else {
                login.setVisible(true);
            }
        });
        searchPage.addActionListener((event) -> {
            if (logedIn) {
                new Search();
                login.dispose();
            } else {
                login.setVisible(true);
            }
        });
        registerPage.addActionListener((event) -> {
            login.dispose();
            new Register();
        });

        add(listAllDataPage);
        add(addNewDataPage);
        add(searchPage);
        add(registerPage);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}