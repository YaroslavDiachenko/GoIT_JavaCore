package HomeWork;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class FlowersLoader {
    static Flower[] load(String fileName) {
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
}
