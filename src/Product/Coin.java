package Product;

public class Coin {
    private int coins;

    public Coin(int coins) {
        this.coins = coins;
    }


    public void buy (int amount){
        if (coins >= amount){
            setCoins(coins - amount);
        }
    }

    public void sell (int amount){
        setCoins(coins+amount);
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }


}

