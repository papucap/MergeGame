package Frames;

import Product.*;
import javax.swing.*;
import java.awt.event.*;


public class Home extends JFrame {
    private Product[] productsOnField = new Product[6];
    private JButton[] productButtons = new JButton[6];

    private JButton mergeButton;
    private JButton storageButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton settingsButton;
    private Coin coin;
    private Storage storage;
    private Settings settings;


    public Home(Coin coin) {
        this.coin = coin;
        this.storage = new Storage();

        this.setTitle("Home");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        for (int i = 0; i < 6; i++) {
            productButtons[i] = new JButton("Empty");
            productButtons[i].setBounds(100 + (i % 3) * 200, 100 + (i / 3) * 200, 192, 199);
            this.add(productButtons[i]);
        }


        mergeButton = new JButton("Merge");
        mergeButton.setBounds(100, 500, 200, 50);
        mergeButton.addActionListener(e -> checkForMerge());
        this.add(mergeButton);


        storageButton = new JButton("Open Storage");
        storageButton.setBounds(100, 600, 200, 50);
        storageButton.addActionListener(e -> new StorageUI(this, storage));
        this.add(storageButton);

        saveButton = new JButton("Save Game");
        saveButton.setBounds(800, 300, 200, 50);
        saveButton.addActionListener(e -> {
            SaveManage.saveGame(coin, productsOnField, storage.getProducts());
            JOptionPane.showMessageDialog(this, "Save Complete.");
        });
        this.add(saveButton);

        loadButton = new JButton("Load");
        loadButton.setBounds(745, 410, 350, 120);
        loadButton.addActionListener(e -> loadGame());
        this.add(loadButton);

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(800, 400, 200, 50);
        settingsButton.addActionListener(e -> new Settings());

        this.setVisible(true);
        updateFieldDisplay();
    }

    private void loadGame() {
        SaveManage.loadGame(coin,productsOnField,storage.getProducts(),settings);
        for (int i = 0; i < productButtons.length; i++) {
            updateFieldDisplay();
        }
        JOptionPane.showMessageDialog(this, "Load complete.");
    }
    //Vygenerovano AI
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
                btn.addActionListener(e -> addProductToStorage(finalI));
            }
        }
    }

    private void tryBuyProduct(int index) {
        if (productsOnField[index] == null) {
            if (coin.getCoins() >= 100) {
                productsOnField[index] = new Product(1,settings);
                coin.buy(100);
                updateFieldDisplay();
            } else {
                JOptionPane.showMessageDialog(this, "Not enough coins!");
            }
        }
    }

    private void addProductToStorage(int index) {
        Product p = productsOnField[index];
        storage.addProduct(p);
        productsOnField[index] = null;
        updateFieldDisplay();

        JOptionPane.showMessageDialog(this, "Product moved to storage!");
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

    //Vygenerovano AI
    private void checkForMerge() {
        for (int i = 0; i < productsOnField.length; i++) {
            Product p1 = productsOnField[i];
            if (p1 == null) continue;

            for (int j = i + 1; j < productsOnField.length; j++) {
                Product p2 = productsOnField[j];
                if (p2 != null && p1.getLevel() == p2.getLevel()) {
                    productsOnField[i] = null;
                    productsOnField[j] = new Product(p1.getLevel() + 1,settings);
                    coin.sell(100 * p1.getLevel());
                    updateFieldDisplay();
                    JOptionPane.showMessageDialog(this, "Merged to level " + (p1.getLevel() + 1) + "\nCoins Added: " + 100 * p1.getLevel());
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "No matching products to merge.");
    }

}
