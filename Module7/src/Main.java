import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    static Date setDate(String s) {
        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
        try {
            return format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void showFruits(List<Fruit> list) {
        int i = 1;
        for (Fruit e : list) {
            System.out.println("Fruit #" + i +
                    ":   Type: " + e.getType() +
                    ";   Shelf life: " + e.getShelfLife() +
                    ";   Date: " + e.getDate() +
                    ";   Price: " + e.getPrice()
            );
            i++;
        }
        System.out.println();
    }

    static void showClients(List<Client> list) {
        int i = 1;
        for (Client e : list) {
            System.out.println("Client #" + i +
                    ":   Name: " + e.name +
                    ";   Fruit type: " + e.type +
                    ";   Count: " + e.count
            );
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        String path1 = "/Users/test/IdeaProjects/GoIT_JavaCore/Module7/files/file1.txt";
        String path2 = "/Users/test/IdeaProjects/GoIT_JavaCore/Module7/files/file2.txt";

        Date date1 = setDate("2017-01-01");
        Date date2 = setDate("2017-01-02");
        Date date3 = setDate("2017-01-05");

        Shop shop = new Shop();

        shop.fruits.add(new Fruit(Fruit.Type.Banana,10, date1,8.3));
        shop.fruits.add(new Fruit(Fruit.Type.Apple,20, date2,5.5));
        shop.fruits.add(new Fruit(Fruit.Type.Strawberry,8, date1,14.8));
        shop.fruits.add(new Fruit(Fruit.Type.Pear,18, date2,6.2));
        shop.fruits.add(new Fruit(Fruit.Type.Pear,18, date2,6.2));
        shop.fruits.add(new Fruit(Fruit.Type.Grape,12, date1,5.5));
        shop.fruits.add(new Fruit(Fruit.Type.Lemon,30, date1,12.2));

        System.out.println("Money balance: " + shop.moneyBalance);
//        shop.load(path1);
        showFruits(shop.fruits);
        shop.sell(path2,date3);
        System.out.println("Money balance: " + shop.moneyBalance);
        showFruits(shop.fruits);

    }
}
