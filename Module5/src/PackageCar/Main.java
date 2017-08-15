package PackageCar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car car = new Car(20170101);
        car.addNewWheels(4);
        if (car.getWheels() == null) System.out.println("OOps");
        System.out.println(car.getWheel(1).getTireWear());
        System.out.println(car.getWheel(1).getTireWear());


        car.validateWheel(1);

        Scanner sc = new Scanner(System.in);
        int option;
        String repeat = "NO";

        do {
            showOptions();
            option = sc.nextInt();

            switch (option)
            {
                case 0:
                    break;
                case 1:
                    System.out.println("Enter speed value:");
                    car.changeCurrentSpeed(sc.nextDouble());
                    break;
                case 2:
                    car.addPassenger();
                    System.out.println("One passenger added.");
                    break;
                case 3:
                    car.removePassenger();
                    System.out.println("One passenger removed.");
                    break;
                case 4:
                    car.removeAllPassengers();
                    System.out.println("All passengers removed.");
                    break;
                case 5:
                    car.removeAllWheels();
                    System.out.println("All wheels removed.");
                    break;
                case 6:
                    System.out.println("Enter number of wheels to be added:");
                    int a = sc.nextInt();
                    car.addNewWheels(a);
                    System.out.println(a + " new wheels have been added.");
                    break;
                case 7:
                    System.out.println("Current maximum speed is " + car.getMaxSpeedUsedCar() + " km/h.");
                    break;
                case 8:
                    car.printCar();
                    break;
                case 9:
                    if (car.getWheels() == null) System.out.println("There are no wheels on the car.");
                    else {
                        System.out.println("Enter wheel number:");
                        int input = sc.nextInt();
                        if(car.getWheel(input) == null) System.out.println("Missing wheel.");
                        else {
                            car.getWheel(input).renewTire();
                            System.out.println("Tire #" + input + " has been renewed.");
                        }
                    }
                    break;
                case 10:
                    if (car.getWheels() == null) System.out.println("There are no wheels on the car.");
                    else {
                        System.out.println("Enter wheel number:");
                        int input1 = sc.nextInt();
                        if(car.getWheel(input1) == null) System.out.println("Missing wheel.");
                        else {
                            System.out.println("Enter percentage:");
                            double input2 = sc.nextDouble();
                            car.getWheel(input1).wearTire(input2);
                            System.out.println("Tire #" + input1 + " has been worn at " + input2 + "%. " +
                                    "Wear level of the tire (from 0 to 1) now is "
                                    + car.getWheel(input1).getTireWear() + ".");
                        }
                    }
                    break;
                case 11:
                    if (car.getWheels() == null) System.out.println("There are no wheels on the car.");
                    else {
                        System.out.println("Enter wheel number:");
                        int input = sc.nextInt();
                        if (car.getWheel(input) == null) System.out.println("Missing wheel.");
                        else car.getWheel(input).printWheel();
                    }
                    break;
                case 12:
                    if (car.getWheels() == null) System.out.println("There are no wheels on the car.");
                    else {
                        int input;
                        do {
                            System.out.println("Enter wheel number:");
                            input = sc.nextInt();
                            if (car.getWheel(input) == null) System.out.println("Missing wheel.");
                        } while (car.getWheel(input) != null || input != 0);
                        if (car.getWheel(input) != null)
                            System.out.println("Wear level of the tire (from 0 to 1) is "
                                    + car.getWheel(input).getTireWear() + ".");
                    }
                    break;
                case 13:
                    if (car.getDoors() == null) System.out.println("There are no doors on the car.");
                    else {
                        System.out.println("Enter wheel number:");
                        int input = sc.nextInt();
                        if (car.getWheel(input) == null) System.out.println("Missing wheel.");
                        else car.getWheel(input).printWheel();
                    }

            }

            System.out.println("\nContinue? (Y/N)");
            sc.nextLine();
            repeat = sc.nextLine();
        } while (repeat.equals("Y"));

    }

    static void showOptions() {
        System.out.println(

                "\nChoose action:\n\n" +

                "   1 - change current speed;\n" +
                "   2 - add a passenger;\n" +
                "   3 - remove a passenger;\n" +
                "   4 - remove all passengers;\n" +
//                "5 - get a door;\n" +
//                "6 - get a wheel;\n" +
                "   5 - remove all wheels;\n" +
                "   6 - add new wheel(s);\n" +
                "   7 - get current maximum speed;\n" +
                "   8 - show all information about a car;\n\n" +

                "   9 - renew a tire;\n" +
                "   10 - wear a tire;\n" +
                "   11 - show all information about a car wheel;\n\n" +
                "   12 - get wear level of the tire;\n\n" +

                "   13 - open a door;\n" +
                "   14 - close a door;\n" +
                "   15 - open/close a door;\n" +
                "   16 - open a window;\n" +
                "   17 - close a window;\n" +
                "   18 - open/close a window;\n" +
                "   19 - show all information about a car door;\n\n" +

                "Press return to quit;\n"
        );
    }

}
