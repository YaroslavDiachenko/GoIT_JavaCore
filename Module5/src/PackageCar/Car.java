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

import static java.util.Arrays.fill;

public class Car {

    // Fields:

    private final int productionDate;
    private String engineType;
    private double maxSpeed;
    private double time100kmReach;
    private int passengersCapacity;
    private int passengers;
    private double currentSpeed;
    private CarWheel[] wheels;
    private CarDoor[] doors;

    // Constructors:

    public Car(int productionDate) {
        this.productionDate = productionDate;
    }
    public Car(int productionDate, String engineType, double maxSpeed, double time100kmReach, int passengersCapacity, int passengers, double currentSpeed) {
        this.productionDate = productionDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.time100kmReach = time100kmReach;
        this.passengersCapacity = passengersCapacity;
        this.passengers = passengers;
        this.currentSpeed = currentSpeed;
    }

    // Methods:

    void changeCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    void addPassenger() {
        passengers++;
    }
    void removePassenger() {
        passengers--;
    }
    void removeAllPassengers() {
        passengers = 0;
    }
    CarDoor getDoor(int n) {
        return doors[n];
    }
    CarWheel getWheel(int n) {
        return wheels[n];
    }
    void removeAllWheels() {
        fill(wheels, null);
    }
    void addNewWheels(int n) {
        for (int i = 0; i < wheels.length; i++) {
            if (wheels[i] == null) {
                for (int j = i; j < i + n; j++) {
                    wheels[j] = new CarWheel();
                }
                break;
            }
        }
    }

    double getCurrentMaxSpeed() {
        if (passengers > 1) {
            double min = wheels[0].getTireWear();
            for (int i = 0; i < wheels.length; i++) {
                if (wheels[0].getTireWear() < min) min = wheels[0].getTireWear();
            }
            return maxSpeed * min;
        }else
            return 0.0;
    }

    void printObject() {
        System.out.println("Production date: " + productionDate);
        System.out.println("Maximum speed : " + maxSpeed);
        System.out.println("Acceleration till 100km per hour: " + time100kmReach);
        System.out.println("Passengers capacity: " + passengersCapacity);
        System.out.println("Quantity of passengers" + passengers);
        System.out.println("Current speed: " + currentSpeed);
        System.out.println(this.getCurrentMaxSpeed());
    }
}
