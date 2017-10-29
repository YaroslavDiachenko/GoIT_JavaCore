import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Shop {

    double shopMoneyBalance;
    String name;
    List<Fruit> fruits;
    List<Client> clients;

    public Shop(String name) {
        this.name = name;
        this.fruits = new ArrayList<>();
    }

    public Shop(String name, List<Fruit> fruits) {
        this.name = name;
        this.fruits = fruits;
        this.shopMoneyBalance = 0;
    }

    void addFruits(String path){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            String json = reader.readLine();
            Shop temp = gson.fromJson(json, new TypeToken<Shop>(){}.getType());
            System.out.println("\nNEW DELIVERY:\n");

            this.fruits.addAll(temp.fruits);
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    void load(String path){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            String json = reader.readLine();
            Shop temp = gson.fromJson(json, new TypeToken<Shop>(){}.getType());
            this.fruits = null;
            this.fruits = temp.fruits;
            this.shopMoneyBalance = temp.shopMoneyBalance;
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    void save(String path){
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(path);
            gson.toJson(this, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    List<Fruit> getSpoiledFruits(Date date) {
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (e.getExpiryDate().before(date)) fruits.add(e);
        }
        return fruits;
    }
    List<Fruit> getAvailableFruits(Date date) {
        Date today = new Date();
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (!e.getExpiryDate().before(date)) fruits.add(e);
        }
        return fruits;
    }
    List<Fruit> getAddedFruits(Date date) {
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (e.getDeliveryDate().equals(date)) fruits.add(e);
        }
        return fruits;
    }

    List<Fruit> getSpoiledFruits(Date date, Fruit.Type type) {
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (e.getFruitType().equals(type) && e.getExpiryDate().before(date)) fruits.add(e);
        }
        return fruits;
    }
    List<Fruit> getAvailableFruits(Date date,Fruit.Type type) {
        Date today = new Date();
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (e.getFruitType().equals(type) && !e.getExpiryDate().before(date)) fruits.add(e);
        }
        return fruits;
    }
    List<Fruit> getAddedFruits(Date date, Fruit.Type type) {
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (e.getFruitType().equals(type) && e.getDeliveryDate().equals(date)) fruits.add(e);
        }
        return fruits;
    }

    void sell(String path, Date date) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            String json = reader.readLine();
            Shop temp = gson.fromJson(json, new TypeToken<Shop>(){}.getType());
            if (temp.clients != null && temp.clients.size() > 0) {
                System.out.println("\nSELL REQUEST:");
                for (Client e : temp.clients) {
                    boolean sellStatus = false;
                    List<Fruit> availableFruits = getAvailableFruits(date, e.fruitType);
                    if (availableFruits.size() > 0 && e.fruitCount <= availableFruits.size()) {
                        for (int i = 0, j = 0; j < e.fruitCount; i++) {
                            Fruit fruit  = fruits.get(i);
                            if (fruit.getFruitType().equals(e.fruitType)) {
                                shopMoneyBalance += fruit.getPrice();
                                fruits.remove(i);
                                i--;
                                j++;
                                sellStatus = true;
                            }
                        }
                    }
                    System.out.println(e.fruitCount + " " + e.fruitType.toString()
                            + (e.fruitCount > 1 ? "s were" : " was")
                            + (sellStatus ? " sold" : " not sold") + " to " + e.name + ";");
                }
            }

        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    void show() {
        System.out.println("\n\t"+ name  +":\n\tMoney balance:\t" + shopMoneyBalance + "\n\tProducts:");
        showFruits(fruits);
    }

    void showFruits(List<Fruit> fruits) {
        for (Fruit i : fruits) {
            System.out.println("\t\t" + i.getFruitType() + "\t" + i.getShelfLife() + "\t" + Main.setDatePrintable(i.getDeliveryDate()) + "\t" + i.getPrice());
        }
    }

}