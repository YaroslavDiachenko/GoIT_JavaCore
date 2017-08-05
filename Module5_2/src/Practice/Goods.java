package Practice;


public abstract class Goods implements IShow {

    int productID;
    String productName;
    int quantity;
    String description;
    double price;

    public void show() {
        System.out.println(
                "Product ID: " + productID +
                "\nProduct name: " + productName +
                "\nQuantity of products: " + quantity +
                "\nDescription of the product: " + description +
                "\nProduct's price: " + price + "\n"
        );
    }
}
