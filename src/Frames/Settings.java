package Frames;
import Product.Coin;
import Product.Statistics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame implements ActionListener {

    private JButton themeButton;
    private JButton exitButton;
    private JLabel label;
    private Coin coin;
    private Statistics statistics;
    private Home home;


    public Settings(Coin coin, Statistics statistics) {
        this.coin = coin;
        this.statistics = statistics;


        this.setTitle("Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        //ImageIcon backgroundImage = new ImageIcon("Image/MainMenu.png");
        this.setVisible(true);


        themeButton = new JButton("DARK MODE");
        themeButton.setBounds(500, 500, 200, 50);
        themeButton.addActionListener(this);
        this.add(themeButton);

        exitButton = new JButton("LIGHT MODE");
        exitButton.setBounds(0, 500, 200, 50);
        exitButton.addActionListener(this);
        this.add(exitButton);

        label = new JLabel();
        label.setSize(1000, 1000);
        this.add(label);
    }

    private boolean isDarkMode = false;

    private void toggleTheme() {
        isDarkMode = !isDarkMode;
        updateTheme();
    }

    public String updateTheme() {
        if (isDarkMode) {
            return "Dark";
        } else {
            return "Light";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            JOptionPane.showMessageDialog(this, "Please load your game again");
            new Home(coin,this,statistics);
            this.dispose();
        }
        if (e.getSource() == themeButton) {
            toggleTheme();
            JOptionPane.showMessageDialog(this, "Please load your game again");
            new Home(coin,this,statistics);
            this.dispose();
        }
    }
}
