package Product;

import javax.swing.ImageIcon;

public class Product {
    private int level;
    private ImageIcon image; // Add an image attribute

    public Product(int level) {
        this.level = level;
        this.image = loadImage(level); // Load the image based on the level
    }

    public int getLevel() {
        return level;
    }

    public ImageIcon getImage() {
        return image; // Getter for the image
    }

    public Product merge(Product other) {
        if (this.level == other.level) {
            return new Product(this.level + 1);
        }
        return null;
    }

    private ImageIcon loadImage(int level) {
        return new ImageIcon("images/" + level + ".png");
    }
}