package Product;


import org.junit.jupiter.api.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

// SaveManageTest class contains unit tests for the SaveManage class

public class SaveManageTest {

    // Test to verify that saving the game creates a save file
    @Test
    public void testSaveGameCreatesFile() {
        Coin coin = new Coin(1000);
        Product[] field = new Product[6];
        Storage storage = new Storage();
        Statistics statistics = new Statistics();

        SaveManage.saveGame(coin, field, storage.getProducts(), statistics, 0);

        File saveFile = new File("save0.txt");
        assertTrue(saveFile.exists()); // Assert that the save file exists


        saveFile.delete(); // Delete the save file
    }
}
