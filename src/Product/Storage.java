package Product;

import java.util.ArrayList;
import java.util.List;

// Storage class manages the products stored by the user

public class Storage {
    public Storage() {
    }

    private List<Product> storedProducts = new ArrayList<>();  // List to hold stored products

    // Method to add a product to storage
    public void addProduct(Product product) {
        storedProducts.add(product);
    }

    // Method to remove a product from storage
    public void removeProduct(Product product) {
        storedProducts.remove(product);
    }

    // Method to get the list of stored products
    public List<Product> getProducts() {
        return storedProducts;
    }



}
