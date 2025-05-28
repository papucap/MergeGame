package Product;

import Product.Coin;
import Product.SaveManage;
import Product.Statistics;
import Product.Storage;
import org.junit.jupiter.api.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class SaveManageTest {

    @Test
    public void testSaveGameCreatesFile() {
        Coin coin = new Coin(1000);
        Product[] field = new Product[6];
        Storage storage = new Storage();
        Statistics statistics = new Statistics();

        SaveManage.saveGame(coin, field, storage.getProducts(), statistics, 0);

        File saveFile = new File("save0.txt");
        assertTrue(saveFile.exists());

        // Uklid po testu
        saveFile.delete();
    }
}
