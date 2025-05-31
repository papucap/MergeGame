package Frames;
import Product.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Home class represents the main interface of the application

public class Home extends JFrame implements ActionListener  {

    // Array to hold products displayed on the field
    private Product[] productsOnField = new Product[6];

    // Array of buttons for each product
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
    private JLabel backgroundLabel;
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
        this.setUndecorated(true);

        // Initialize product buttons
        for (int i = 0; i < 6; i++) {
            productButtons[i] = new JButton();
            productButtons[i].setBounds(500 + (i % 3) * 300, 200 + (i / 3) * 300, 192, 199);
            productButtons[i].setOpaque(false);
            productButtons[i].setContentAreaFilled(false);
            productButtons[i].setFocusable(false);
            productButtons[i].setBorderPainted(false);
            this.add(productButtons[i]);
        }
        ImageIcon mergeIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/Buttons/merge.png"));
        mergeButton = new JButton(mergeIcon);
        mergeButton.setBounds(500, 850, 304, 96);
        mergeButton.addActionListener(this);
        this.add(mergeButton);

        ImageIcon storageIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/Buttons/open_storage.png"));
        storageButton = new JButton(storageIcon);
        storageButton.setBounds(850, 850, 304, 96);
        storageButton.addActionListener(this);
        this.add(storageButton);

        ImageIcon saveIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/Buttons/save.png"));
        saveButton = new JButton(saveIcon);
        saveButton.setBounds(1200, 950, 304, 96);
        saveButton.addActionListener(this);
        this.add(saveButton);

        ImageIcon loadIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/Buttons/load.png"));
        loadButton = new JButton(loadIcon);
        loadButton.setBounds(1200, 850, 304, 96);
        loadButton.addActionListener(this);
        this.add(loadButton);

        ImageIcon settingsIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/Buttons/settings.png"));
        settingsButton = new JButton(settingsIcon);
        settingsButton.setBounds(850, 950, 304, 96);
        settingsButton.addActionListener(this);
        this.add(settingsButton);

        ImageIcon exit = new ImageIcon(getClass().getResource("/Image/Exit.png"));
        exitButton = new JButton(exit);
        exitButton.setBounds(0, 850, 248, 183);
        exitButton.addActionListener(this);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);
        this.add(exitButton);

        ImageIcon tutorialIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/Buttons/tutorial.png"));
        tutorialButton = new JButton(tutorialIcon);
        tutorialButton.setBounds(1550, 850, 304, 96);
        tutorialButton.addActionListener(this);
        this.add(tutorialButton);

        ImageIcon statisticsIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/Buttons/stats.png"));
        statisticsButton = new JButton(statisticsIcon);
        statisticsButton.setBounds(1550, 950, 304, 96);
        statisticsButton.addActionListener(this);
        this.add(statisticsButton);

        ImageIcon specialIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/Buttons/special_merge.png"));
        specialMergeButton = new JButton(specialIcon);
        specialMergeButton.setBounds(500, 950, 304, 96);
        specialMergeButton.addActionListener(this);
        this.add(specialMergeButton);

        coinLabel = new JLabel("Coins: "+ coin.getCoins());
        updateCoinLabel();
        coinLabel.setBounds(1200,0,1000,100);
        coinLabel.setFont(new Font("Arial", Font.BOLD,82));
        coinLabel.setForeground(Color.WHITE);
        this.add(coinLabel);
        this.setVisible(true);
        updateFieldDisplay();

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/Image/"+settings.updateTheme()+"/BackgroundHome.png"));
        backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setSize(1920, 1080);
        this.add(backgroundLabel);
    }

    public Product[] getProductsOnField() {
        return productsOnField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == statisticsButton) {
            StatsFrame statsFrame = new StatsFrame(statistics, settings);
        }
        if (e.getSource() == tutorialButton) {
            Tutorial tutorial = new Tutorial(settings);
        }
        if (e.getSource() == saveButton) {
            SaveFrame saveFrame = new SaveFrame(coin,storage,this,statistics,settings);
        }
        if (e.getSource() == mergeButton) {
            checkForMerge();
        }
        if (e.getSource() == storageButton) {
            new StorageUI(this, storage);
        }
        if (e.getSource() == loadButton) {
            LoadFrame loadFrame = new LoadFrame(coin,storage,this,statistics,settings);
            loadGame();
        }
        if (e.getSource() == settingsButton) {
            SaveManage.saveGame(coin, productsOnField, storage.getProducts(),statistics,4);
            this.dispose();
            Settings settings = new Settings(coin,statistics,storage);
        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
        if (e.getSource() == specialMergeButton) {
            specialMerge();
        }
    }

    // Method to load game data
    public void loadGame() {
        for (int i = 0; i < productButtons.length; i++) {
            updateFieldDisplay();
        }
        updateCoinLabel();
    }

    //Generated by AI
    // Method to update the display of products on the field
    public void updateFieldDisplay() {
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

    // Method to attempt to buy a product
    public void tryBuyProduct(int index) {
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

    // Method to add a product to storage
    public void addProductToStorage(int index) {
        Product p = productsOnField[index];
        storage.addProduct(p);
        productsOnField[index] = null;
        updateFieldDisplay();

        JOptionPane.showMessageDialog(this, "Product moved to storage!");
    }

    // Method to add a product from storage to the field
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

    // Method to check for mergeable products
    public void checkForMerge() {
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
    //Generated by AI
    // Method to check special Merge combination
    public void specialMerge() {
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
                        statistics.unlockSpecialLevel(combo[2]);
                        JOptionPane.showMessageDialog(this, "Special Merge: " + lvl1 + " + " + lvl2 + " → " + combo[2]);
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(this, "No special combinations found to merge.");
    }

    // Method to update the coin label display
    private void updateCoinLabel() {
        coinLabel.setText("Coins: "+coin.getCoins());
    }
}
