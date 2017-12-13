package HomeWork;


public class Rose extends Flower {
    private static int price;

    public Rose() {
        price = 100;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        Rose.price = price;
    }
}
