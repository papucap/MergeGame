import Frames.MainMenu;
import Frames.Settings;
import Product.Coin;
import Product.Statistics;
import Product.Storage;

public class Main {
    public static void main(String[] args) {

        Coin coin = new Coin(20000);

        MainMenu mainMenu = new MainMenu(coin);
    }
}