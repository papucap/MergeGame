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
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: Level " + product.getLevel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mergeButton) {
            mergeProducts();
        }
    }

    private void mergeProducts() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                Product mergedProduct = products.get(i).merge(products.get(j));
                if (mergedProduct != null) {
                    products.remove(j);
                    products.remove(i);
                    products.add(mergedProduct);
                    System.out.println("Merged to Level " + mergedProduct.getLevel());
                    return;
                }
            }
        }
        System.out.println("No products to merge.");
    }
}