package Frames;
import Product.Coin;
import Product.SaveManage;
import Product.Statistics;
import Product.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Settings class allows the user to change application settings

public class Settings extends JFrame implements ActionListener {

    private JButton darkButton;
    private JButton lightButton;
    private JButton exitButton;
    private JLabel label;
    private Coin coin;
    private Statistics statistics;
    private Home home;
    private Storage storage;


    public Settings(Coin coin, Statistics statistics,Storage storage) {
        this.coin = coin;
        this.statistics = statistics;
        this.storage = storage;


        this.setTitle("Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1024, 1024);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        ImageIcon backgroundImage = new ImageIcon("Image/Settings.png");
        this.setVisible(true);


        darkButton = new JButton();
        darkButton.setBounds(200, 550, 625, 200);
        darkButton.addActionListener(this);
        darkButton.setOpaque(false);
        darkButton.setContentAreaFilled(false);
        darkButton.setFocusable(false);
        darkButton.setBorderPainted(false);
        this.add(darkButton);

        lightButton = new JButton();
        lightButton.setBounds(200, 300, 625, 200);
        lightButton.addActionListener(this);
        lightButton.setOpaque(false);
        lightButton.setContentAreaFilled(false);
        lightButton.setFocusable(false);
        lightButton.setBorderPainted(false);
        this.add(lightButton);

        ImageIcon exit = new ImageIcon("Image/Exit.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(0, 850, 248, 183);
        exitButton.addActionListener(this);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);
        this.add(exitButton);

        label = new JLabel(backgroundImage);
        label.setSize(1024, 1024);
        this.add(label);
    }

    // Variable to track if dark mode is enabled
    private boolean isDarkMode = false;

    // Method to toggle the theme between dark and light
    private void toggleTheme() {
        isDarkMode = !isDarkMode;
        updateTheme();
    }

    // Method to update the theme based on the current mode
    public String updateTheme() {
        if (isDarkMode) {
            return "Dark";
        } else {
            return "Light";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lightButton) {
            Home home = new Home(coin,this,statistics);
            SaveManage.loadGame(coin, home.getProductsOnField(), storage.getProducts(),this,statistics,4);
            home.loadGame();
            this.dispose();
        }
        if (e.getSource() == darkButton) {
            toggleTheme();
            Home home = new Home(coin,this,statistics);
            SaveManage.loadGame(coin, home.getProductsOnField(), storage.getProducts(),this,statistics,4);
            home.loadGame();
            this.dispose();
        }
        if (e.getSource() == exitButton) {
            new Home(coin,this,statistics);
            this.dispose();
        }
    }
}
