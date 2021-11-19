package pages;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import models.Medicine;

public class Search extends JFrame {

    List<Medicine> dataList = new ArrayList<>();
    JScrollPane dataListPanel = dataListPanel(dataList);
    GridBagConstraints constraints = new GridBagConstraints();

    public Search() {
        super();

        setSize(400, 400);
        setLayout(new GridBagLayout());
        dataList.add(new Medicine(1, "abdalhalem", "expirationDate", "activeIngredient", 10));
        dataList.add(new Medicine(2, "abdalrahman", "expirationDate", "activeIngredient", 10));
        dataList.add(new Medicine(3, "mohamed", "expirationDate", "activeIngredient", 10));
        dataList.add(new Medicine(4, "hani", "expirationDate", "activeIngredient", 10));
        dataList.add(new Medicine(5, "ahmed", "expirationDate", "activeIngredient", 10));

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(searchPanel(), constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;
        constraints.weightx = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(dataListPanel, constraints);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel searchPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JTextField searchInput = new JTextField();
        searchInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                List<Medicine> searchResult = new ArrayList<>();
                if (searchInput.getText().length() != 0) {
                    for (Medicine medicine : dataList) {
                        if (medicine.getName().substring(0, Math.min(medicine.getName().length(), 5))
                                .contains(searchInput.getText())) {
                            searchResult.add(medicine);
                        }
                    }
                }
                remove(dataListPanel);
                dataListPanel = dataListPanel(searchResult);

                constraints.fill = GridBagConstraints.BOTH;
                constraints.weighty = 1.0;
                constraints.weightx = 1.0;
                constraints.gridx = 0;
                constraints.gridy = 1;

                add(dataListPanel, constraints);
                revalidate();
                repaint();
            }
        });

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(searchInput, constraints);

        return panel;
    }

    JScrollPane dataListPanel(List<Medicine> dataList) {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(Math.max(dataList.size(), 1), 0, 0, 10));
        for (Medicine medicine : dataList) {
            panel.add(dataRecord(medicine));
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(panel);

        return scrollPane;
    }

    JPanel dataRecord(Medicine medicine) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        constraints.insets = new Insets(0, 10, 0, 10);

        JLabel name = new JLabel("Name : " + medicine.getName());
        JLabel expirationDate = new JLabel("Expiration Date : " + medicine.getExpirationDate());
        JLabel activeIngredient = new JLabel("Active Ingredient : " + medicine.getActiveIngredient());
        JLabel amount = new JLabel("amount : " + medicine.getAmount());

        panel.add(name, constraints);
        panel.add(expirationDate, constraints);
        panel.add(activeIngredient, constraints);
        panel.add(amount, constraints);

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        JPanel spacerPanel = new JPanel();
        panel.add(spacerPanel, constraints);

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new GridLayout(2, 0, 0, 10));
        JButton edit = new JButton("edit data");
        edit.addActionListener((event) -> {
            new Edit("1");
        });
        JButton delete = new JButton("delete data");

        actionsPanel.add(edit);
        actionsPanel.add(delete);
        panel.add(actionsPanel);

        return panel;
    }
}
