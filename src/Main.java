import Frames.MainMenu;
import Frames.Settings;
import Product.Coin;
import Product.Statistics;
import Product.Storage;

import java.io.IOException;

// Main class to start the application
public class Main {
    public static void main(String[] args) throws IOException {

        Coin coin = new Coin(500);

        MainMenu mainMenu = new MainMenu(coin);  // Initialize the main menu
    }
}