import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {


    static Date setDate(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String setDatePrintable(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static void main(String[] args) throws IOException {

        String path1 = "files/file1.txt";
        String path2 = "files/file2.txt";

        Date date1 = setDate("2017-01-01");
        Date date2 = setDate("2017-01-02");
        Date date3 = setDate("2017-01-05");

        Shop shop1 = new Shop("Shop_1");

        shop1.fruits.add(new Fruit(Fruit.Type.Banana,10, date1,8.3));
        shop1.fruits.add(new Fruit(Fruit.Type.Apple,20, date2,5.5));
        shop1.fruits.add(new Fruit(Fruit.Type.Plum,8, date1,14.8));
        shop1.fruits.add(new Fruit(Fruit.Type.Pear,18, date2,6.2));
        shop1.fruits.add(new Fruit(Fruit.Type.Pear,18, date2,6.2));
        shop1.fruits.add(new Fruit(Fruit.Type.Grape,12, date1,5.5));
        shop1.fruits.add(new Fruit(Fruit.Type.Lemon,30, date1,12.2));

        Company company1 = new Company();
        company1.shops.add(shop1);
//        shop1.load(path1);
        company1.show();
        shop1.sell(path2,date3);
        company1.show();
    }
}
