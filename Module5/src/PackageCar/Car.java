package PackageCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.util.Arrays.copyOf;

public class Car {

    // Fields:

    private final int productionDate;
    private String engineType;
    private double maxSpeed;
    private double accelerationTime100kmph;
    private int passengersCapacity;
    private int passengersQuantity;
    private double currentSpeed;
    private CarWheel[] wheels;
    private CarDoor[] doors;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Constructors:

    public Car(int productionDate) {
        this.productionDate = productionDate;
        this.doors = new CarDoor[4];
        this.wheels = new CarWheel[4];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new CarDoor();
        }
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new CarWheel();
        }
    }
    public Car(int productionDate, String engineType, double maxSpeed, double accelerationTime100kmph, int passengersCapacity, int passengersQuantity, double currentSpeed) {
        this.productionDate = productionDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelerationTime100kmph = accelerationTime100kmph;
        this.passengersCapacity = passengersCapacity;
        this.passengersQuantity = (passengersQuantity <= passengersCapacity) ? passengersQuantity : 0;
        this.currentSpeed = 0;
        this.doors = new CarDoor[4];
        this.wheels = new CarWheel[4];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new CarDoor();
        }
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new CarWheel();
        }
    }

    // Getters:

    CarDoor getDoor(int index) {
        return doors[index-1];
    }
    CarWheel getWheel(int index) {
        return wheels[index-1];
    }

    // Methods:

    void changeCurrentSpeed(double speed) {
        if (speed > getCurrentMaxSpeed())
        this.currentSpeed = currentSpeed;
    }
    void addPassenger() {
        if (passengersQuantity == passengersCapacity) System.out.println("Car is already full.");
        else {
            passengersQuantity++;
            System.out.println("One passenger was wadded. Now " + passengersQuantity + " passenger(s).");
        }
    }
    void removePassenger() {
        if (passengersQuantity == 0) System.out.println("There are no passengers in the car.");
        else {
            passengersQuantity--;
            System.out.println("One passenger was removed. Now " + passengersQuantity + " passenger(s).");
        }
        if (passengersQuantity == 0) currentSpeed = 0;
    }
    void removeAllPassengers() {
        passengersQuantity = 0;
        currentSpeed = 0;
    }
    void removeAllWheels() {
        wheels = null;
    }
    void addNewWheels(int x) {
        if(wheels == null) {
            wheels = new CarWheel[x];
        }else {
            CarWheel[] temp = copyOf(wheels, wheels.length + x);
            wheels = temp;
        }

        for (int i = 0; i < wheels.length; i++) {
            if (wheels[i] == null) wheels[i] = new CarWheel();
        }
    }
    double getCurrentMaxSpeed() {
        if (passengersQuantity > 0 && wheels != null && wheels.length >= 4) {
            double min = 1;
            for(CarWheel i : wheels) {
                if(i.getTireWear() < min) min = i.getTireWear();
            }
            return maxSpeed * min;
        }else
            return 0.0;
    }
    void printCar() {
        System.out.println("\nInformation about the car:");
        System.out.println("  Production date: " + productionDate);
        System.out.println("  Type of engine: " + engineType);
        System.out.println("  Passengers capacity: " + passengersCapacity + " person(s)");
        System.out.println("  Acceleration time up to 100km/h: " + accelerationTime100kmph + " secs");
        System.out.println("  Maximum speed of a new car: " + maxSpeed + " km/h");
        System.out.println("  Current maximum speed: " + getCurrentMaxSpeed() + " km/h");
        System.out.println("  Quantity of passengers: " + passengersQuantity + " person(s)");
        System.out.println("  Current speed: " + currentSpeed + " km/h");

    }

    // additional methods:
    int validateWheel() {
        if (wheels == null) System.out.println("There are no wheels on the car.");
        else {
            do {
                try{
                    System.out.print("Enter wheel number: ");
                    String line = br.readLine();
                    if (line.equals("")) break;
                    int n = Integer.parseInt(line);
                    if (n < 1) {
                        System.out.println("Start from one.");
                        continue;
                    }
                    if (getWheel(n) == null) System.out.println("Missing wheel.");
                    else return n;
                }catch (NumberFormatException | IOException e){
                    System.out.println("Incorrect input format.");
                }catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Missing wheel.");
                }
            } while (true);
        }
        return -1;
    }
    int validateDoor() {
        do {
            try{
                System.out.print("Enter door number: ");
                String line = br.readLine();
                if (line.equals("")) break;
                int n = Integer.parseInt(line);
                if (n < 1) {
                    System.out.println("Start from one.");
                    continue;
                }
                return n;
            }catch (NumberFormatException | IOException e){
                System.out.println("Incorrect input format.");
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Missing door.");
            }
        } while (true);
        return -1;
    }
}