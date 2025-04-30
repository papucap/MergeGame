package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Product.Product;

public class Home extends JFrame implements ActionListener {
    private ArrayList<Product> products;
    private JButton mergeButton;
    private JButton shopButton;
    private JTextArea productDisplay; // Text area to display products

    public Home() {
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
        shopButton.addActionListener(e -> new Shop(this));
        this.add(shopButton);

        productDisplay = new JTextArea();
        productDisplay.setBounds(100, 300, 400, 300);
        productDisplay.setEditable(false);
        this.add(productDisplay);
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
            mergeProducts();
        }
    }

    private void mergeProducts() {
        // Logic to merge products
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                Product mergedProduct = products.get(i).merge(products.get(j));
                if (mergedProduct != null) {
                    products.remove(j); // Remove the second product
                    products.remove(i); // Remove the first product
                    products.add(mergedProduct); // Add the new merged product
                    updateProductDisplay(); // Update the display after merging
                    System.out.println("Merged to Level " + mergedProduct.getLevel());
                    return; // Exit after merging
                }
            }
        }
        System.out.println("No products to merge.");
    }

    private void updateProductDisplay() {
        StringBuilder displayText = new StringBuilder("Products:\n");
        for (Product product : products) {
            displayText.append("Level ").append(product.getLevel()).append("\n");
        }
        productDisplay.setText(displayText.toString()); // Update the text area with current products
    }
}