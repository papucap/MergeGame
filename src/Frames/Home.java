package Frames;

import Product.*;
import javax.swing.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener  {
    private Product[] productsOnField = new Product[6];
    private JButton[] productButtons = new JButton[6];

    private JButton mergeButton;
    private JButton storageButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton settingsButton;
    private JButton exitButton;
    private JButton tutorialButton;
    private JButton statisticsButton;
    private JButton specialMergeButton;
    private JLabel coinLabel;
    private Coin coin;
    private Storage storage;
    private Settings settings;
    private Statistics statistics;


    public Home(Coin coin, Settings settings, Statistics statistics) {
        this.coin = coin;
        this.storage = new Storage();
        this.settings = settings;
        this.statistics = statistics;

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
        mergeButton.setBounds(500, 950, 200, 50);
        mergeButton.addActionListener(this);
        this.add(mergeButton);


        storageButton = new JButton("Open Storage");
        storageButton.setBounds(250, 950, 200, 50);
        storageButton.addActionListener(this);
        this.add(storageButton);

        saveButton = new JButton("Save Game");
        saveButton.setBounds(1250, 950, 200, 50);
        saveButton.addActionListener(this);
        this.add(saveButton);

        loadButton = new JButton("Load");
        loadButton.setBounds(750, 950, 200, 50);
        loadButton.addActionListener(this);
        this.add(loadButton);

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(1000, 950, 200, 50);
        settingsButton.addActionListener(this);
        this.add(settingsButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(0, 950, 200, 50);
        exitButton.addActionListener(this);
        this.add(exitButton);

        tutorialButton = new JButton("Tutorial");
        tutorialButton.setBounds(1500, 950, 200, 50);
        tutorialButton.addActionListener(this);
        this.add(tutorialButton);

        statisticsButton = new JButton("Statistics");
        statisticsButton.setBounds(1700, 950, 200, 50);
        statisticsButton.addActionListener(this);
        this.add(statisticsButton);

        specialMergeButton = new JButton("Special Merge");
        specialMergeButton.setBounds(500, 650, 200, 50);
        specialMergeButton.addActionListener(this);
        this.add(specialMergeButton);

        coinLabel = new JLabel(String.valueOf(coin.getCoins()));
        coinLabel.setBounds(1500,200,200,50);
        this.add(coinLabel);

        this.setVisible(true);
        updateFieldDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == statisticsButton) {
            StatsFrame statsFrame = new StatsFrame(statistics);
        }
        if (e.getSource() == tutorialButton) {
            Tutorial tutorial = new Tutorial();
        }
        if (e.getSource() == saveButton) {
            SaveManage.saveGame(coin, productsOnField, storage.getProducts(),statistics);
            JOptionPane.showMessageDialog(this, "Save Complete.");
        }
        if (e.getSource() == mergeButton) {
            checkForMerge();
        }
        if (e.getSource() == storageButton) {
            new StorageUI(this, storage);
        }
        if (e.getSource() == loadButton) {
            loadGame();
        }
        if (e.getSource() == settingsButton) {
            Settings settings = new Settings();
        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
        if (e.getSource() == specialMergeButton) {
            specialMerge();
        }
    }


    private void loadGame() {
        SaveManage.loadGame(coin,productsOnField,storage.getProducts(),settings,statistics);
        for (int i = 0; i < productButtons.length; i++) {
            updateFieldDisplay();
        }
        JOptionPane.showMessageDialog(this, "Load complete.");
        updateCoinLabel();
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
                statistics.addSpendCoins(100);
                updateFieldDisplay();
                updateCoinLabel();
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

    private void checkForMerge() {
        for (int i = 0; i < productsOnField.length; i++) {
            Product p1 = productsOnField[i];
            if (p1 == null) continue;

            for (int j = i + 1; j < productsOnField.length; j++) {
                Product p2 = productsOnField[j];
                if (p2 != null && p1.getLevel() == p2.getLevel()) {
                    int newLevel = p1.getLevel() + 1;

                    if (newLevel > 15) {
                        JOptionPane.showMessageDialog(this, "Maximum level is 15. Merge not allowed.");
                        return;
                    }

                    productsOnField[i] = null;
                    productsOnField[j] = new Product(p1.getLevel() + 1,settings);
                    coin.sell(100 * p1.getLevel());
                    statistics.addMerges();
                    statistics.updateMaxLevel(p1.getLevel()+1);
                    updateFieldDisplay();
                    updateCoinLabel();
                    JOptionPane.showMessageDialog(this, "Merged to level " + (p1.getLevel() + 1) + "\nCoins Added: " + 100 * p1.getLevel());
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "No matching products to merge.");
    }

    //Vygenerovano AI
    private void specialMerge() {
        int[][] specialCombinations = {
                {13, 15, 50},
                {10, 13, 51},
                {11, 15, 52},
                {1, 15, 53},
                {4, 15, 54}
        };

        for (int i = 0; i < productsOnField.length; i++) {
            Product p1 = productsOnField[i];
            if (p1 == null) continue;

            for (int j = i + 1; j < productsOnField.length; j++) {
                Product p2 = productsOnField[j];
                if (p2 == null) continue;

                int lvl1 = p1.getLevel();
                int lvl2 = p2.getLevel();

                for (int[] combo : specialCombinations) {
                    if ((lvl1 == combo[0] && lvl2 == combo[1]) || (lvl1 == combo[1] && lvl2 == combo[0])) {
                        productsOnField[i] = null;
                        productsOnField[j] = new Product(combo[2], settings);
                        coin.sell(10000);
                        statistics.addMerges();
                        statistics.updateMaxLevel(combo[2]);
                        updateFieldDisplay();
                        updateCoinLabel();
                        JOptionPane.showMessageDialog(this, "Special Merge: " + lvl1 + " + " + lvl2 + " → " + combo[2]);
                        return;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(this, "No special combinations found to merge.");
    }


    private void updateCoinLabel() {
        coinLabel.setText(""+coin.getCoins());
    }

}
