package PackageCar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car car = new Car(20170101,"Internal Combustion",300.0,8.0,4,4,0.0);

        Scanner sc = new Scanner(System.in);
        double inputDouble;
        int inputInt;

        showOptions();
        do {
            System.out.print("\nPlease choose an option: ");
            inputInt = sc.nextInt();
            if (inputInt == 0) break;

            switch (inputInt) {

                case 1:
                    System.out.print("Enter new speed value: ");
                    inputDouble = sc.nextDouble();
                    car.changeCurrentSpeed(inputDouble);
                    System.out.println("Current speed was changed to " + inputDouble + " km/h.");
                    break;
                case 2:
                    car.addPassenger();
                    break;
                case 3:
                    car.removePassenger();
                    break;
                case 4:
                    car.removeAllPassengers();
                    System.out.println("All passengers were removed.");
                    break;
                case 5:
                    car.removeAllWheels();
                    System.out.println("All wheels were removed.");
                    break;
                case 6:
                    System.out.print("Enter number of wheels to be added: ");
                    int a = sc.nextInt();
                    car.addNewWheels(a);
                    System.out.println(a + " new wheels have been added.");
                    break;
                case 7:
                    System.out.println("Current maximum speed is " + car.getCurrentMaxSpeed() + " km/h.");
                    break;
                case 8:
                    car.printCar();
                    break;
                case 9:
                    inputInt = car.validateWheel();
                    if (inputInt != -1)
                        if (car.getWheel(inputInt).getTireWear() == 1.0) System.out.println("Tire is already new.");
                        else {
                            car.getWheel(inputInt).renewTire();
                            System.out.println("Tire #" + inputInt + " has been renewed.");
                        }
                    break;
                case 10:
                    inputInt = car.validateWheel();
                    if (inputInt != -1) {
                        System.out.print("Enter percentage (0.0 - 100.0%): ");
                        double percentage = sc.nextDouble();
                        car.getWheel(inputInt).wearTire(percentage);
                        System.out.println("Tire #" + inputInt + " has been worn at " + percentage + "%. " +
                                "Wear level of the tire (from 0 to 1) now is "
                                + car.getWheel(inputInt).getTireWear() + ".");
                    }
                    break;
                case 11:
                    inputInt = car.validateWheel();
                    if (inputInt != -1) System.out.println("Wear level of the tire (from 0.0 to 1.0) is "
                            + car.getWheel(inputInt).getTireWear() + ".");
                    break;
                case 12:
                    inputInt = car.validateDoor();
                    if (inputInt != -1) {
                        if (car.getDoor(inputInt).getDoorState()) System.out.println("Door is already open.");
                        else {
                            car.getDoor(inputInt).openDoor();
                            System.out.println("Door #" + inputInt + " was opened.");
                        }
                    }
                    break;
                case 13:
                    inputInt = car.validateDoor();
                    if (inputInt != -1) {
                        if (!car.getDoor(inputInt).getDoorState()) System.out.println("Door is already closed.");
                        else {
                            car.getDoor(inputInt).closeDoor();
                            System.out.println("Door #" + inputInt + " was closed.");
                        }
                    }
                    break;
                case 14:
                    inputInt = car.validateDoor();
                    if (inputInt != -1) {
                        car.getDoor(inputInt).openOrCloseDoor();
                        System.out.print("Door #" + inputInt + " was ");
                        System.out.println(car.getDoor(inputInt).getDoorState() ? "opened." : "closed.");
                    }
                    break;
                case 15:
                    inputInt = car.validateDoor();
                    if (inputInt != -1) {
                        if (car.getDoor(inputInt).getWindowState()) System.out.println("Window is already open.");
                        else {
                            car.getDoor(inputInt).openWindow();
                            System.out.println("Window in door #" + inputInt + " was opened.");
                        }
                    }
                    break;
                case 16:
                    inputInt = car.validateDoor();
                    if (inputInt != -1) {
                        if (!car.getDoor(inputInt).getWindowState()) System.out.println("Window is already closed.");
                        else {
                            car.getDoor(inputInt).closeWindow();
                            System.out.println("Window in door #" + inputInt + " was closed.");
                        }
                    }
                    break;
                case 17:
                    inputInt = car.validateDoor();
                    if (inputInt != -1) {
                        car.getDoor(inputInt).openOrCloseWindow();
                        System.out.print("Window in door #" + inputInt + " was ");
                        System.out.println(car.getDoor(inputInt).getWindowState() ? "opened." : "closed.");
                    }
                    break;
                case 18:
                    inputInt = car.validateDoor();
                    if (inputInt != -1) car.getDoor(inputInt).printDoor();
                    break;
                default:
                    System.out.println("There is no such option.");
            }

        } while (true);

    }

    static void showOptions() {
        System.out.println(

                "Available options:\n\n" +

                "   1 - change current speed;\n" +
                "   2 - add a passenger;\n" +
                "   3 - remove a passenger;\n" +
                "   4 - remove all passengers;\n" +
                "   5 - remove all wheels;\n" +
                "   6 - add new wheel(s);\n" +
                "   7 - get current maximum speed;\n" +
                "   8 - show all information about the car;\n\n" +

                "   9 - renew a tire;\n" +
                "   10 - wear a tire;\n" +
                "   11 - get wear level of the tire;\n\n" +

                "   12 - open a door;\n" +
                "   13 - close a door;\n" +
                "   14 - open/close a door;\n" +
                "   15 - open a window;\n" +
                "   16 - close a window;\n" +
                "   17 - open/close a window;\n" +
                "   18 - show all information about a car door;\n\n" +
                "   0 - exit."
        );
    }

}
