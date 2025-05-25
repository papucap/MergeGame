package Product;

public class Statistics {
    private int merges;
    private int maxLevel;
    private int spendCoins;

    public Statistics() {
        this.merges = 0;
        this.maxLevel = 1;
        this.spendCoins = 0;
    }

    public void addMerges() {
        merges++;
    }

    public void addSpendCoins(int amount) {
        spendCoins += amount;
    }

    public void updateMaxLevel(int level) {
        if (level > maxLevel) {
            maxLevel = level;
        }
    }

    public int getMerges() {
        return merges;
    }

    public int getSpendCoins() {
        return spendCoins;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMerges(int merges) {
        this.merges = merges;
    }

    public void setSpendCoins(int spendCoins) {
        this.spendCoins = spendCoins;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}

