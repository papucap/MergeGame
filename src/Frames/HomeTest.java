package Frames;

import Product.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeTest {

    private Home home;
    private Coin coin;
    private Storage storage;
    private Settings settings;
    private Statistics statistics;

    @BeforeEach
    public void setUp() {
        coin = new Coin(10000);
        settings = new Settings(coin,statistics,storage);
        statistics = new Statistics();
        home = new Home(coin, settings, statistics);
        storage = new Storage();
    }

    @Test
    public void testTryBuyProduct() {
        home.getProductsOnField()[0] = null;
        int coinsBefore = coin.getCoins();

        home.getProductsOnField()[0] = null;
        home.tryBuyProduct(0);

        assertNotNull(home.getProductsOnField()[0]);
        assertEquals(coinsBefore - 100, coin.getCoins());
    }


    @Test
    public void testAddProductFromStorage() {
        Product product = new Product(1, settings);
        boolean added = home.addProductFromStorage(product);

        assertTrue(added);
        assertTrue(containsProduct(home.getProductsOnField(), product));
    }

    @Test
    public void testCheckForMerge() {
        home.getProductsOnField()[0] = new Product(1, settings);
        home.getProductsOnField()[1] = new Product(1, settings);

        home.checkForMerge();

        assertNull(home.getProductsOnField()[0]);
        assertEquals(2, home.getProductsOnField()[1].getLevel());
    }

    @Test
    public void testSpecialMerge() {
        home.getProductsOnField()[0] = new Product(13, settings);
        home.getProductsOnField()[1] = new Product(15, settings);

        home.specialMerge();

        Product merged = home.getProductsOnField()[1];
        assertNotNull(merged);
        assertEquals(50, merged.getLevel());
        assertNull(home.getProductsOnField()[0]);
    }


    @Test
    public void testLoadGameUpdatesDisplay() {
        home.getProductsOnField()[0] = new Product(2, settings);
        home.loadGame();

        assertEquals(2, home.getProductsOnField()[0].getLevel());
    }




    private boolean containsProduct(Product[] array, Product product) {
        for (Product p : array) {
            if (p == product) return true;
        }
        return false;
    }
}
