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



    private ImageIcon loadImage(int level) {
        if (level < 15){
            return new ImageIcon("Image/Level/" + level + ".png");
        }
        else {
            return new ImageIcon("Image/Level/15.png");
        }
    }
}