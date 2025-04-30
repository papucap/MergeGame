package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Product.Product;

public class Shop extends JFrame implements ActionListener {
    private JButton buyButton;
    private Home home;

    public Shop(Home home) {
        this.home = home;
        this.setTitle("Shop");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            home.addProduct(new Product(1));
        }
    }
}