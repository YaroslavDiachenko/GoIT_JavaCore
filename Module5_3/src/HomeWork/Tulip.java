package HomeWork;


public class Tulip extends Flower {
    private static int price;

    public Tulip() {
        price = 45;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Tulip.price = price;
    }
}
