package Product;

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

    public void unlockSpecialLevel(int level) {
        if (level >= 50 && level <= 54) {
            specialLevels[level-50] = true;
        }
    }

    public boolean isSpecialLevelUnlocked(int level) {
        if (level >= 50 && level <= 54 && specialLevels[level-50] == true) {
            return true;
        }
        return false;
    }

    public boolean[] getSpecialLevels() {
        return specialLevels;
    }

    public void setSpecialLevels(boolean[] specialLevels) {
        this.specialLevels = specialLevels;
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

