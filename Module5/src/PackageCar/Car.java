/*
Класс Car.
На прямую к переменным этого класса никто не может, только через методы
--------------------
Хранит:
дата производства (не изменна после создания объекта)
тип двигателя
максимальная скорость машины (если она новая)
время разгона до 100км/ч
пассажировместимость
кол-во пасажиров внутри в данный момент
текущая скорость
массив колес
массив дверей

Конструктор
--------------------
Нет пустого конструктора. Так как есть поля в классе, которые нельзя изменять после создания объекта. Например дата
производства.
Конструктор с датой производства.
Конструктор со всеми полями, кроме массива колес и массива дверей.

Методы
--------------------
Изменить текущую скорость
Посадить 1 пассажира в машину
Высадить 1 пассажира
Высадить всех пассажиров
Получить дверь по индексу
Получить колесо по индексу
Снять все колеса с машины
Установить на машину X новых колесу (в добаков к имеющимся, то есть если было 4 колеса, после вызова метода с Х
аргументом равным трем, колес будет 4+3=7)
Вычислить текущую возможную максимальную скорость (Скорость машины вычисляется так. Максимальная скорость новой
машины множиться на самое стертое колесо в машине. Максимальная скорость равна 0 если в машине нет ни одного пассажира,
так как некому ее вести)
Вывести в консоль данные об объекте (все поля и вычисленную максимальную скорость в зависимости от целостности колес и
наличия водителя)
 */

package PackageCar;

import static java.util.Arrays.copyOf;

public class Car {

    // Fields:

    private final int productionDate;
    private String engineType;
    private double maxSpeedNewCar;
    private double accelerationTime100kmph;
    private int passengersCapacity;
    private int passengersQuantity;
    private double currentSpeed;
    private CarWheel[] wheels;
    private CarDoor[] doors;

    // Constructors:

    public Car(int productionDate) {
        this.productionDate = productionDate;
    }
    public Car(int productionDate, String engineType, double maxSpeed, double accelerationTime100kmph, int passengersCapacity, int passengersQuantity, double currentSpeed) {
        this.productionDate = productionDate;
        this.engineType = engineType;
        this.maxSpeedNewCar = maxSpeed;
        this.accelerationTime100kmph = accelerationTime100kmph;
        this.passengersCapacity = passengersCapacity;
        this.passengersQuantity = passengersQuantity;
        this.currentSpeed = currentSpeed;
    }

    // Getters:

    public CarWheel[] getWheels() {
        return wheels;
    }
    public CarDoor[] getDoors() {
        return doors;
    }
    CarDoor getDoor(int index) {
        return doors[index-1];
    }
    CarWheel getWheel(int index) {
        return wheels[index-1];
    }

    // Methods:

    void changeCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    void addPassenger() {
        passengersQuantity++;
    }
    void removePassenger() {
        passengersQuantity--;
    }
    void removeAllPassengers() {
        passengersQuantity = 0;
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
            if (wheels[i] == null) wheels[i] = new CarWheel(0.8);
        }
    }
    double getMaxSpeedUsedCar() {
        if (passengersQuantity > 0) {
            double min = 1;
            for(CarWheel i : wheels) {
                if(i != null && i.getTireWear() < min) min = i.getTireWear();
            }
            return maxSpeedNewCar * min;
        }else
            return 0.0;
    }
    void printCar() {
        System.out.println("Production date: " + productionDate);
        System.out.println("Maximum speed of a new car: " + maxSpeedNewCar);
        System.out.println("Acceleration time up to 100km per hour: " + accelerationTime100kmph);
        System.out.println("Passengers capacity: " + passengersCapacity);
        System.out.println("Quantity of passengers: " + passengersQuantity);
        System.out.println("Current speed: " + currentSpeed);
        System.out.println("Current maximum speed of this car: " + getMaxSpeedUsedCar());
    }
    boolean validateWheel(int n) {
        String message1 = "There are no wheels on the car.";
        String message2 = "The wheel is missing.";
        String message3 = "The wheel is present.";
        if (wheels == null) System.out.println(message1);
        else {
            boolean a = false;
            for (CarWheel i : wheels) {
                if (i != null) a = true;
            }
            if (!a) System.out.println(message1);
            else {
                if (wheels[n - 1] == null) System.out.println(message2);
                else {
                    System.out.println(message3);
                    return true;
                }
            }
        }
        return false;
    }
}