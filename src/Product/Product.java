package Product;

import Frames.Settings;

import javax.swing.ImageIcon;

// Product class represents an item in the game
public class Product {
    private int level; // Level of the product
    private ImageIcon image; // Image representation of the product
    private Settings settings;

    public Product(int level, Settings settings) {
        this.level = level;
        this.image = loadImage(level, settings);
    }

    // Getter method to retrieve the product level
    public int getLevel() {
        return level;
    }

    // Getter method to retrieve the product image
    public ImageIcon getImage() {
        return image;
    }


    // Method to load the image based on the product level
    private ImageIcon loadImage(int level, Settings settings) {
        if (level < 15){
            return new ImageIcon("Image/" + settings.updateTheme() + "/Level/" + level + ".png");
        }
        else if (level == 50) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/true/50.png");
        }
        else if (level == 51) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/true/51.png");
        }
        else if (level == 52) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/true/52.png");
        }
        else if (level == 53) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/true/53.png");
        }
        else if (level == 54) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/true/54.png");
        }
        else{
            return new ImageIcon("Image/" + settings.updateTheme()+ "/Level/15.png");
        }
    }
}