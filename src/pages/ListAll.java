package pages;

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

    public ListAll() {
        super();
        setLayout(new GridLayout(1, 0));
        setSize(400, 400);

        List<Medicine> medicines = new ArrayList<>();
        medicines.add(new Medicine(1, "name", "expirationDate", "activeIngredient", 10));
        medicines.add(new Medicine(2, "name", "expirationDate", "activeIngredient", 10));
        medicines.add(new Medicine(3, "name", "expirationDate", "activeIngredient", 10));
        medicines.add(new Medicine(4, "name", "expirationDate", "activeIngredient", 10));

        JPanel dataListPanel = new JPanel();
        dataListPanel.setLayout(new GridLayout(Math.max(medicines.size(), 1), 0, 0, 10));

        for (Medicine medicine : medicines) {
            dataListPanel.add(dataRecord(medicine));
        }

        JScrollPane dataListScrollPane = new JScrollPane();
        dataListScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        dataListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        dataListScrollPane.setViewportView(dataListPanel);
        add(dataListScrollPane);

        setLocationRelativeTo(null);
        setVisible(true);
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
