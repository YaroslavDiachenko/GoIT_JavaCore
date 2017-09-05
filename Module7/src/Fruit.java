import java.util.Calendar;
import java.util.Date;

public class Fruit {

    enum Type {Strawberry,Apple,Pear,Banana,Grape,Lemon,Orange,Pineapple,Blackberry,Kiwifruit}

    private Type type;
    private int shelfLife;
    private Date date;
    private double price;

    Type getType() {
        return type;
    }
    int getShelfLife() {
        return shelfLife;
    }
    Date getDate() {
        return date;
    }
    public double getPrice() {
        return price;
    }

    Date getExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,shelfLife-1);
        return calendar.getTime();
    }

    Fruit(Type type, int shelfLife, Date date, double price) {
        this.type = type;
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }
}
