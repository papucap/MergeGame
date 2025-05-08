package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Product.*;

public class Home extends JFrame implements ActionListener {
    private ArrayList<Product> products;
    private JButton mergeButton;
    private JButton shopButton;
    private JPanel productPanel; // Panel to display products

    private JLabel label;
    private Coin coin;

    // Product buttons
    private JButton[] productButtons;

    public Home(Coin coin) {
        this.coin = coin;
        products = new ArrayList<>();
        this.setTitle("Home");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        mergeButton = new JButton("Merge Products");
        mergeButton.setBounds(100, 100, 200, 50);
        mergeButton.addActionListener(this);
        this.add(mergeButton);

        shopButton = new JButton("Go to Shop");
        shopButton.setBounds(100, 200, 200, 50);
        shopButton.addActionListener(e -> new Shop(this, coin));
        this.add(shopButton);

        // Increase the size of the product display panel
        productPanel = new JPanel();
        productPanel.setBounds(300, 0, 800, 800); // Increased width and height
        productPanel.setLayout(new GridLayout(0, 1)); // Vertical layout for products
        this.add(productPanel);

        label = new JLabel();
        label.setBounds(1000, 50, 100, 100);
        label.setVisible(true);
        this.add(label);

        // Initialize product buttons
        productButtons = new JButton[6];
        for (int i = 0; i < productButtons.length; i++) {
            productButtons[i] = new JButton();
            productButtons[i].setBounds(100, 400 + (i * 60), 200, 50);
            productButtons[i].setIcon(new ImageIcon("path/to/level1_image.png")); // Set image for level 1
            final int productLevel = 1; // All buttons will buy level 1 products
            productButtons[i].addActionListener(e -> buyProduct(productLevel));
            this.add(productButtons[i]);
        }
    }

    private void buyProduct(int level) {
        if (coin.getCoins() >= 100) { // Assuming each product costs 100 coins
            if (products.size() < 6) { // Limit to 6 products
                addProduct(new Product(level));
                coin.buy(100);
                checkForMerge(); // Check for merging after buying
            } else {
                JOptionPane.showMessageDialog(this, "Maximum of 6 products reached!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Not enough coins to buy Product " + level + "!");
        }
    }

    private void checkForMerge() {
        // Check for merging any products of the same level
        boolean merged = true; // Flag to check if any merging happened
        while (merged) {
            merged = false; // Reset the flag
            for (int i = 0; i < products.size(); i++) {
                for (int j = i + 1; j < products.size(); j++) {
                    if (products.get(i).getLevel() == products.get(j).getLevel()) {
                        mergeProducts(products.get(i).getLevel()); // Merge if levels are the same
                        merged = true; // Set flag to true if a merge happened
                        break; // Exit inner loop to restart checking
                    }
                }
                if (merged) break; // Exit outer loop if a merge happened
            }
        }
    }

    private void mergeProducts(int level) {
        ArrayList<Product> toMerge = new ArrayList<>();
        for (Product product : products) {
            if (product.getLevel() == level) {
                toMerge.add(product);
            }
        }
        if (toMerge.size() >= 2) {
            // Create a new merged product
            Product mergedProduct = new Product(level + 1);
            products.removeAll(toMerge); // Remove the products being merged
            products.add(mergedProduct); // Add the new merged product
            updateProductDisplay(); // Update the display after merging
            System.out.println("Merged to Level " + mergedProduct.getLevel());
            coin.sell(150); // Assuming selling gives back coins
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        updateProductDisplay(); // Update the display after adding a product
        System.out.println("Product added: Level " + product.getLevel());
    }

    public int getProductCount() {
        return products.size(); // Return the current number of products
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mergeButton) {
            // Merging logic can be handled in buyProduct now
        }
    }

    private void updateProductDisplay() {
        productPanel.removeAll(); // Clear previous products
        for (Product product : products) {
            JLabel productLabel = new JLabel("Level " + product.getLevel(), product.getImage(), JLabel.LEFT);
            productPanel.add(productLabel); // Add product image and level to the panel
        }
        productPanel.revalidate(); // Refresh the panel
        productPanel.repaint(); // Repaint the panel
    }
}