package Product;

// Statistics class tracks game statistics such as merges, max level, and coins spent

public class Statistics {
    private int merges;
    private int maxLevel;
    private int spendCoins;
    private boolean[] specialLevels = new boolean[5];

    public Statistics() {
        this.merges = 0;
        this.maxLevel = 1;
        this.spendCoins = 0;
    }

    // Method to increment the merge count
    public void addMerges() {
        merges++;
    }

    // Method to add to the total spent coins
    public void addSpendCoins(int amount) {
        spendCoins += amount;
    }

    // Method to update the maximum level if the new level is higher
    public void updateMaxLevel(int level) {
        if (level > maxLevel) {
            maxLevel = level;
        }
    }

    // Method to unlock a special level (picture in stats)
    public void unlockSpecialLevel(int level) {
        if (level >= 50 && level <= 54) {
            specialLevels[level-50] = true;
        }
    }

    // Method to check if a special level is unlocked
    public boolean isSpecialLevelUnlocked(int level) {
        if (level >= 50 && level <= 54 && specialLevels[level-50] == true) {
            return true;
        }
        return false;
    }


    // Getter methods for statistics
    public int getMerges() {
        return merges;
    }

    public int getSpendCoins() {
        return spendCoins;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    // Setter methods for statistics
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

