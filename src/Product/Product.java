package Product;

import Frames.Settings;

import javax.swing.ImageIcon;

public class Product {
    private int level;
    private ImageIcon image; // Add an image attribute
    private Settings settings;

    public Product(int level, Settings settings) {
        this.level = level;
        this.image = loadImage(level, settings); // Load the image based on the level
    }

    public int getLevel() {
        return level;
    }

    public ImageIcon getImage() {
        return image; // Getter for the image
    }



    private ImageIcon loadImage(int level, Settings settings) {
        if (level < 15){
            return new ImageIcon("Image/" + settings.updateTheme() + "/Level/" + level + ".png");
        }
        else if (level == 50) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/Level/15.png");
        }
        else if (level == 51) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/Level/15.png");
        }
        else if (level == 52) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/Level/15.png");
        }
        else if (level == 53) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/Level/15.png");
        }
        else if (level == 54) {
            return new ImageIcon("Image/" + settings.updateTheme()+ "/Level/15.png");
        }
        else{
            return new ImageIcon("Image/" + settings.updateTheme()+ "/Level/15.png");
        }
    }
}