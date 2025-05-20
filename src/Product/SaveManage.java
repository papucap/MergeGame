package Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveManage {

    public static void saveGame(Coin coin, Product[] products, List<Product> storageList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt"))) {
            writer.write(String.valueOf(coin.getCoins()));
            writer.newLine();

            for (int i = 0; i < products.length; i++) {
                if (products[i] != null) {
                    writer.write(String.valueOf(products[i].getLevel()));
                } else {
                    writer.write("0");
                }
                if (i < products.length - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();
            for (int i = 0; i < storageList.size(); i++) {
                writer.write(String.valueOf(storageList.get(i).getLevel()));
                if (i < storageList.size() - 1) {
                    writer.write(",");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadGame(Coin coin, Product[] product, List<Product> storageList) {
        try (BufferedReader reader = new BufferedReader(new FileReader("save.txt"))) {

            int coins = Integer.parseInt(reader.readLine());
            coin.setCoins(coins);


            String[] productLevel = reader.readLine().split(",");
            for (int i = 0; i < productLevel.length && i < productLevel.length; i++) {
                int lvl = Integer.parseInt(productLevel[i]);
                product[i] = (lvl > 0) ? new Product(lvl) : null;
            }

            storageList.clear();
            String storageLine = reader.readLine();
            if (storageLine != null && !storageLine.isEmpty()) {
                String[] storageLevels = storageLine.split(",");
                for (String s : storageLevels) {
                    int lvl = Integer.parseInt(s);
                    storageList.add(new Product(lvl));
                }
            }

        } catch (IOException e) {
            System.out.println("No save file found.");
        }
    }
}