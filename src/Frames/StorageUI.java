package Frames;

import Product.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

// StorageUI class represents the user interface for managing storage

public class StorageUI extends JFrame {
    private Home home;
    private Storage storage;
    private JPanel panel;


    public StorageUI(Home home, Storage storage) {
        this.home = home;
        this.storage = storage;

        setTitle("Storage");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 4, 10, 10));
        refreshStorage();

        JScrollPane scrollPane = new JScrollPane(panel); //Internet: jak pouzivat JScrollPane https://www.geeksforgeeks.org/java-jscrollpane/

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Method to refresh the storage display
    private void refreshStorage() {
        panel.removeAll();
        List<Product> products = storage.getProducts();

        for (Product product : products) {
            JButton button = new JButton("Level " + product.getLevel(), product.getImage());
            button.setHorizontalTextPosition(JButton.CENTER);
            button.setVerticalTextPosition(JButton.BOTTOM);

            // Action listener for product button
            button.addActionListener((ActionEvent e) -> {
                String[] options = {"Add to Field", "Delete", "Cancel"};
                int choice = JOptionPane.showOptionDialog(this,
                        "What do you want to do?",
                        "Storage Option",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);

                if (choice == 0) {
                    if (home.addProductFromStorage(product)) {
                        storage.removeProduct(product); // Remove product from storage
                        refreshStorage();
                    } else {
                        JOptionPane.showMessageDialog(this, "No space on field!");
                    }
                } else if (choice == 1) {
                    storage.removeProduct(product); // Delete product from storage
                    refreshStorage();  // Refresh display
                }
            });

            panel.add(button);
        }

        panel.revalidate();
        panel.repaint();
    }
}
