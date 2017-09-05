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


    int moneyBalance;
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

//    void sell(String path) throws IOException {
//        List<Client> clients;
//        BufferedReader reader = new BufferedReader(new FileReader(path));
//        try {
//            String json = reader.readLine();
//            clients = JSON.parseArray(json, Client.class);
//            Date today = new Date();
//
//            for (Client e : clients) {
//                if (e.count >= getAvailableFruits(today,e.type).size())
//            }
//
//
//
//        } catch (Exception e) {
//            System.err.println("Error");
//        }
//
//    }

}
