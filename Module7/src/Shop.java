import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Shop {

    double moneyBalance;
    List<Fruit> fruits;
    List<Client> clients;

    public Shop() {
        this.fruits = new ArrayList<>();
    }

    public Shop(List<Fruit> fruits) {
        this.fruits = fruits;
        this.moneyBalance = 0;
    }

    void addFruits(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        try {
            Gson gson = new Gson();
            String json = reader.readLine();
            Shop temp = gson.fromJson(json, new TypeToken<Shop>(){}.getType());
            this.fruits.addAll(temp.fruits);
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    void load(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        try {
            Gson gson = new Gson();
            String json = reader.readLine();
            Shop temp = gson.fromJson(json, new TypeToken<Shop>(){}.getType());
            this.fruits = temp.fruits;
            this.moneyBalance = temp.moneyBalance;
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    void save(String path) throws IOException {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(path);
            gson.toJson(this, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
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
            if (e.getDate().equals(date)) fruits.add(e);
        }
        return fruits;
    }

    List<Fruit> getSpoiledFruits(Date date, Fruit.Type type) {
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (e.getType().equals(type) && e.getExpiryDate().before(date)) fruits.add(e);
        }
        return fruits;
    }
    List<Fruit> getAvailableFruits(Date date,Fruit.Type type) {
        Date today = new Date();
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (e.getType().equals(type) && !e.getExpiryDate().before(date)) fruits.add(e);
        }
        return fruits;
    }
    List<Fruit> getAddedFruits(Date date, Fruit.Type type) {
        List<Fruit> fruits = new ArrayList<>();
        for (Fruit e : this.fruits) {
            if (e.getType().equals(type) && e.getDate().equals(date)) fruits.add(e);
        }
        return fruits;
    }

    void sell(String path, Date date) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        try {
            Gson gson = new Gson();
            String json = reader.readLine();
            Shop temp = gson.fromJson(json, new TypeToken<Shop>(){}.getType());

            for (Client e : temp.clients) {
                System.out.print("Client: " + e.name + "; Product type: " + e.type + "; Quantity: " + e.count);
                List<Fruit> list = getAvailableFruits(date, e.type);
                if (list.size() > 0 && e.count <= list.size()) {
                    for (int i = 0, j = 0; j < e.count; i++) {
                        Fruit fruit  = fruits.get(i);
                        if (fruit.getType().equals(e.type)) {
                            moneyBalance += fruit.getPrice();
                            fruits.remove(i);
                            i--;
                            j++;
                        }
                    }
                    System.out.println("; Status: Sold.");
                }else System.out.println("; Status: Not sold.");
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

}