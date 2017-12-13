package HomeWork;


public class Camomile extends Flower {
    static int price;

    public Camomile() {
        price = 70;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Camomile.price = price;
    }
}