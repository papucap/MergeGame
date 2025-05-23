import Frames.MainMenu;
import Frames.Settings;
import Product.Coin;

public class Main {
    public static void main(String[] args) {

        Settings s = new Settings();
        MainMenu mainMenu = new MainMenu(new Coin(20000),s);

    }
}