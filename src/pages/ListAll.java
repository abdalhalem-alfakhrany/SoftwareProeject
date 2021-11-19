package pages;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import models.Medicine;

public class ListAll extends JFrame {

    List<Medicine> dataList = new ArrayList<>();

    public ListAll() {
        super();
        setLayout(new GridBagLayout());
        setSize(400, 400);

        dataList.add(new Medicine(1, "name", "expirationDate", "activeIngredient", 10));
        dataList.add(new Medicine(2, "name", "expirationDate", "activeIngredient", 10));
        dataList.add(new Medicine(3, "name", "expirationDate", "activeIngredient", 10));
        dataList.add(new Medicine(4, "name", "expirationDate", "activeIngredient", 10));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        add(dataColumns(), constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;
        constraints.gridy = 1;
        add(dataListPanel(dataList), constraints);

        setLocationRelativeTo(null);
        setVisible(true);
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

    JPanel dataColumns() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(0, 10, 0, 10);
        panel.add(new JLabel("Name"), constraints);
        panel.add(new JLabel("Expiration Date"), constraints);
        panel.add(new JLabel("Active Ingredient"), constraints);
        panel.add(new JLabel("amount"), constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.weightx = 1.0;
        JPanel spacer = new JPanel();
        panel.add(spacer, constraints);

        return panel;
    }

    JPanel dataRecord(Medicine medicine) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        constraints.insets = new Insets(0, 10, 0, 10);

        JLabel name = new JLabel(medicine.getName());
        JLabel expirationDate = new JLabel(medicine.getExpirationDate());
        JLabel activeIngredient = new JLabel(medicine.getActiveIngredient());
        JLabel amount = new JLabel(medicine.getAmount() + "");

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

        Color editButtonBGColor = new Color(255, 193, 7);
        JButton edit = new JButton("edit data");
        edit.setBackground(editButtonBGColor);

        edit.addActionListener((event) -> {
            new Edit("1");
        });
        Color deleteButtonBGColor = new Color(187, 45, 59);
        JButton delete = new JButton("delete data");
        delete.setBackground(deleteButtonBGColor);

        actionsPanel.add(edit);
        actionsPanel.add(delete);
        panel.add(actionsPanel);

        return panel;
    }

}
