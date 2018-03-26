package HomeWork.Util;


import HomeWork.Entities.Camomile;
import HomeWork.Entities.Flower;
import HomeWork.Entities.Rose;
import HomeWork.Entities.Tulip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class FlowersLoader {
    public static Flower[] load(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            ArrayList<Flower> bouquet = new ArrayList<>();
            String[] elements = br.readLine().split(", ");
            for(String i : elements) {
                switch (i) {
                    case "Rose":
                        bouquet.add(new Rose());
                        break;
                    case "Camomile":
                        bouquet.add(new Camomile());
                        break;
                    case "Tulip":
                        bouquet.add(new Tulip());
                        break;
                }
            }
            return bouquet.toArray(new Flower[bouquet.size()]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int loadPrice(String flowerName) {
        try {
            String filePath = "files\\Prices.txt";
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] elements = line.split("_");
                if (elements[0].equals(flowerName))
                    return Integer.parseInt(elements[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
