package Frames;

import Product.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JFrame implements ActionListener {
    private JButton buyButton;
    private Home home;

    public Shop(Home home) {
        this.home = home;
        this.setTitle("Shop");

        this.setLayout(null);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        buyButton = new JButton("BUY Level 1 Product");
        buyButton.setBounds(200, 250, 200, 100);
        buyButton.addActionListener(this);
        this.add(buyButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buyButton) {
            if (home.getProductCount() < 6) { // Check if the maximum limit is reached
                home.addProduct(new Product(1)); // Add a level 1 product to Home
            } else {
                JOptionPane.showMessageDialog(this, "Maximum product limit reached!");
            }
        }
    }
}