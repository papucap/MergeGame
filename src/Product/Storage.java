package Product;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Product> storedProducts = new ArrayList<>();

    public void addProduct(Product product) {
        storedProducts.add(product);
    }

    public void removeProduct(Product product) {
        storedProducts.remove(product);
    }

    public List<Product> getProducts() {
        return storedProducts;
    }
}
