package Frames;

import Product.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JFrame implements ActionListener {
    private JButton buyButton;
    private Home home;
    private Coin coin;



    public Shop(Home home, Coin coin) {
        this.home = home;
        this.coin = coin;
        this.setTitle("Shop");

        this.setLayout(null);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        buyButton = new JButton("BUY Level 1 Product 100Coins");
        buyButton.setBounds(200, 250, 200, 100);
        buyButton.addActionListener(this);
        this.add(buyButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buyButton) {
            if (home.getProductCount() < 6 && coin.getCoins() >= 100) { // Check if the maximum limit is reached
                home.addProduct(new Product(1));
                coin.buy(100);
            } else {
                JOptionPane.showMessageDialog(this, "Maximum product limit reached!");
            }
        }
    }


}