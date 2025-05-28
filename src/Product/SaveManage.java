package Product;

import Frames.Settings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveManage {
    private Settings settings;

    public static void saveGame(Coin coin, Product[] products, List<Product> storageList, Statistics statistics,int index) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("save"+index+".txt"))) {
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
            writer.newLine();
            writer.write(statistics.getMerges() + "," + statistics.getMaxLevel() + "," + statistics.getSpendCoins());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadGame(Coin coin, Product[] product, List<Product> storageList,Settings settings, Statistics statistics,int index ) {
        try (BufferedReader reader = new BufferedReader(new FileReader("save"+index+".txt"))) {

            int coins = Integer.parseInt(reader.readLine());
            coin.setCoins(coins);


            String[] productLevel = reader.readLine().split(",");
            for (int i = 0; i < productLevel.length && i < productLevel.length; i++) {
                int lvl = Integer.parseInt(productLevel[i]);
                product[i] = (lvl > 0) ? new Product(lvl,settings) : null;
            }

            storageList.clear();
            String storageLine = reader.readLine();
            if (storageLine != null && !storageLine.isEmpty()) {
                String[] storageLevels = storageLine.split(",");
                for (String s : storageLevels) {
                    int lvl = Integer.parseInt(s);
                    storageList.add(new Product(lvl,settings));
                }
            }
            String statsLine = reader.readLine();
            if (statsLine != null && !statsLine.isEmpty()) {
                String[] parts = statsLine.split(",");
                statistics.setMerges(Integer.parseInt(parts[0]));
                statistics.setMaxLevel(Integer.parseInt(parts[1]));
                statistics.setSpendCoins(Integer.parseInt(parts[2]));
            }


        } catch (IOException e) {
            System.out.println("No save file found.");
        }
    }
}