package pages;

import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {

    public Boolean logedIn = false;

    Register_Login register_login = new Register_Login(this);

    JButton listAllDataPage = new JButton("list all medicines");
    JButton addNewDataPage = new JButton("add new medicine");
    JButton searchPage = new JButton("search for medicine");

    public Main() {
        setSize(400, 400);
        setLayout(new GridBagLayout());

        listAllDataPage.setSize(150, 40);
        addNewDataPage.setSize(150, 40);
        searchPage.setSize(150, 40);

        listAllDataPage.addActionListener((event) -> {
            pageRouter(1);
        });
        addNewDataPage.addActionListener((event) -> {
            pageRouter(2);
        });
        searchPage.addActionListener((event) -> {
            pageRouter(3);
        });

        JLabel iconLabel = new JLabel(new ImageIcon("src/images/pharmacyIcon.png"));

        JPanel pagesButtonsPanel = new JPanel();
        pagesButtonsPanel.setLayout(new GridLayout(3, 0, 0, 40));

        pagesButtonsPanel.add(listAllDataPage);
        pagesButtonsPanel.add(addNewDataPage);
        pagesButtonsPanel.add(searchPage);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        add(iconLabel, constraints);
        constraints.insets = new Insets(5, 5, 5, 5);
        add(pagesButtonsPanel, constraints);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void pageRouter(int pageId) {
        if (!logedIn) {
            register_login.setVisible(true);
            return;
        }
        switch (pageId) {
        case 1:
            new ListAll();
            break;
        case 2:
            new AddNew();
            break;
        case 3:
            new Search();
            break;
        default:
            break;
        }
        register_login.dispose();
    }
}