package Frames;

import Product.*;
import javax.swing.*;
import java.awt.event.*;


public class Home extends JFrame {
    private Product[] productsOnField = new Product[6];
    private JButton[] productButtons = new JButton[6];

    private JButton mergeButton;
    private JButton storageButton;
    private Coin coin;
    private Storage storage;

    public Home(Coin coin) {
        this.coin = coin;
        this.storage = new Storage();

        this.setTitle("Home");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        for (int i = 0; i < 6; i++) {
            productButtons[i] = new JButton("Empty");
            productButtons[i].setBounds(300 + (i % 3) * 150, 100 + (i / 3) * 150, 120, 120);
            this.add(productButtons[i]);
        }


        mergeButton = new JButton("Merge");
        mergeButton.setBounds(100, 100, 150, 50);
        mergeButton.addActionListener(e -> checkForMerge());
        this.add(mergeButton);


        storageButton = new JButton("Open Storage");
        storageButton.setBounds(100, 200, 150, 50);
        storageButton.addActionListener(e -> new StorageUI(this, storage));
        this.add(storageButton);

        this.setVisible(true);
        updateFieldDisplay();
    }

    private void updateFieldDisplay() {
        for (int i = 0; i < productButtons.length; i++) {
            JButton btn = productButtons[i];
            Product product = productsOnField[i];


            for (ActionListener al : btn.getActionListeners()) {
                btn.removeActionListener(al);
            }

            if (product == null) {
                btn.setText("Empty");
                btn.setIcon(null);
                int finalI = i;
                btn.addActionListener(e -> tryBuyProduct(finalI));
            } else {
                btn.setText("Level " + product.getLevel());
                btn.setIcon(product.getImage());
                int finalI = i;
                btn.addActionListener(e -> showProductOptions(finalI));
            }
        }
    }

    private void tryBuyProduct(int index) {
        if (productsOnField[index] == null) {
            if (coin.getCoins() >= 100) {
                productsOnField[index] = new Product(1);
                coin.buy(100);
                updateFieldDisplay();
            } else {
                JOptionPane.showMessageDialog(this, "Not enough coins!");
            }
        }
    }

    private void showProductOptions(int index) {
        Product p = productsOnField[index];
        if (p == null) return;

        String[] options = {"Merge", "Storage", "Cancel"};
        int choice = JOptionPane.showOptionDialog(this,
                "Choose an action for level " + p.getLevel(),
                "Product Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        if (choice == 0) {
            tryMerge(p, index);
        } else if (choice == 1) {
            storage.addProduct(p);
            productsOnField[index] = null;
            updateFieldDisplay();
        }
    }

    private void tryMerge(Product product, int excludeIndex) {
        for (int i = 0; i < productsOnField.length; i++) {
            if (i != excludeIndex && productsOnField[i] != null &&
                    productsOnField[i].getLevel() == product.getLevel()) {

                productsOnField[excludeIndex] = null;
                productsOnField[i] = new Product(product.getLevel() + 1);
                updateFieldDisplay();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No matching product to merge.");
    }

    public boolean addProductFromStorage(Product product) {
        for (int i = 0; i < productsOnField.length; i++) {
            if (productsOnField[i] == null) {
                productsOnField[i] = product;
                updateFieldDisplay();
                return true;
            }
        }
        return false;
    }

    private void checkForMerge() {
        for (int i = 0; i < productsOnField.length; i++) {
            Product p1 = productsOnField[i];
            if (p1 == null) continue;

            for (int j = i + 1; j < productsOnField.length; j++) {
                Product p2 = productsOnField[j];
                if (p2 != null && p1.getLevel() == p2.getLevel()) {
                    productsOnField[i] = null;
                    productsOnField[j] = new Product(p1.getLevel() + 1);
                    updateFieldDisplay();
                    JOptionPane.showMessageDialog(this, "Merged to level " + (p1.getLevel() + 1));
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "No matching products to merge.");
    }

}
