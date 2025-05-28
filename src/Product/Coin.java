package Product;

// Coin class represents the currency in the game
public class Coin {
    private int coins;

    public Coin(int coins) {
        this.coins = coins;
    }

    // Method to buy an item, deducting the specified amount from coins
    public void buy (int amount){
        if (coins >= amount){
            setCoins(coins - amount);
        }
    }

    // Method to sell an item, adding the specified amount to coins
    public void sell (int amount){
        setCoins(coins+amount);
    }

    // Getter method to retrieve the current amount of coins
    public int getCoins() {
        return coins;
    }

    // Setter method to update the amount of coins
    public void setCoins(int coins) {
        this.coins = coins;
    }


}

