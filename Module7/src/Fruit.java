import java.util.Calendar;
import java.util.Date;

public class Fruit {

    enum Type {Peach,Apple,Pear,Banana,Grape,Lemon,Orange,Mango,Cherry,Plum}

    private Type fruitType;
    private int shelfLife;
    private Date deliveryDate;
    private double price;

    Fruit(Type fruitType, int shelfLife, Date deliveryDate, double price) {
        this.fruitType = fruitType;
        this.shelfLife = shelfLife;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    Type getFruitType() {
        return fruitType;
    }
    int getShelfLife() {
        return shelfLife;
    }
    Date getDeliveryDate() {
        return deliveryDate;
    }
    public double getPrice() {
        return price;
    }

    Date getExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(deliveryDate);
        calendar.add(Calendar.DATE,shelfLife-1);
        return calendar.getTime();
    }

}
