package Product;

public class Product {
    private int level;

    public Product(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public Product merge(Product other) {
        if (this.level == other.level) {
            return new Product(this.level + 1);
        }
        return null;
    }
}
