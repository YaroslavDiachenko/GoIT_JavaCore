import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company {
    List<Shop> shops;

    public Company() {
        this.shops = new ArrayList<>();
    }

    void save(String pathToJsonFile) {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(pathToJsonFile);
            gson.toJson(this, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    void load(String pathToJsonFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToJsonFile));
            Gson gson = new Gson();
            String json = reader.readLine();
            Company temp = gson.fromJson(json, new TypeToken<Company>(){}.getType());
            this.shops = null;
            this.shops = temp.shops;
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    Shop getShop(int number) {
        return shops.get(number);
    }

    double getCompanyBalance() {
        double sum = 0;
        for (Shop i : shops) {
            sum += i.shopMoneyBalance;
        }
        return sum;
    }

    List<Fruit> getSpoiledFruits(Date date) {
        List<Fruit> companySpoiledFruits = new ArrayList<>();
        for (Shop i : shops) {
            companySpoiledFruits.addAll(i.getSpoiledFruits(date));
        }
        return companySpoiledFruits;
    }

    List<Fruit> getAvailableFruits(Date date) {
        List<Fruit> companyAvailableFruits = new ArrayList<>();
        for (Shop i : shops) {
            companyAvailableFruits.addAll(i.getAvailableFruits(date));
        }
        return companyAvailableFruits;
    }

    List<Fruit> getAddedFruits(Date date) {
        List<Fruit> companyAddedFruits = new ArrayList<>();
        for (Shop i : shops) {
            companyAddedFruits.addAll(i.getAddedFruits(date));
        }
        return companyAddedFruits;
    }

    List<Fruit> getSpoiledFruits(Date date, Fruit.Type type) {
        List<Fruit> companySpoiledFruits = new ArrayList<>();
        for (Shop i : shops) {
            companySpoiledFruits.addAll(i.getSpoiledFruits(date,type));
        }
        return companySpoiledFruits;
    }

    List<Fruit> getAvailableFruits(Date date, Fruit.Type type) {
        List<Fruit> companyAvailableFruits = new ArrayList<>();
        for (Shop i : shops) {
            companyAvailableFruits.addAll(i.getAvailableFruits(date,type));
        }
        return companyAvailableFruits;
    }

    List<Fruit> getAddedFruits(Date date, Fruit.Type type) {
        List<Fruit> companyAddedFruits = new ArrayList<>();
        for (Shop i : shops) {
            companyAddedFruits.addAll(i.getAddedFruits(date,type));
        }
        return companyAddedFruits;
    }

    void show() {
        System.out.println("\nCOMPANY INFO:");
        System.out.print("Money balance:\t" + getCompanyBalance());
        for (Shop i : shops) {
            i.show();
        }
    }
}
