package PackageCar;

public class CarWheel {

    // Fields:

    private double tireWear;

    // Constructors:

    public CarWheel() {
        this(1.0);
    }
    public CarWheel(double tireWear) {
        this.tireWear = tireWear;
    }

    // Getters:

    public double getTireWear() {
        return tireWear;
    }

    // Methods:

    void renewTire() {
        tireWear = 1.0;
    }
    void wearTire(double percentage) {
        this.tireWear = this.tireWear - (this.tireWear * percentage / 100);
    }
    void printWheel() {
        System.out.println("Wear level of the tire (from 0 to 1) is " + tireWear + ".");
    }
}
