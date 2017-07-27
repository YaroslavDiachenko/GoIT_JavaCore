/*
Класс CarWheel
На прямую к переменным этого класса никто не может, только через методы
--------------------
Хранит:
Состояние целостности шины (дробное число от 0-стерта до 1-новая)

Конструктор
--------------------
Аналогичный принцип как в классе CarDoor

Методы
--------------------
Сменить шину на новую
Стереть шину на X%
Получить состояние (return)
Вывести в консоль данные об объекте
 */

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

    // Methods:

    void renewTire() {
        tireWear = 1.0;
    }
    void wearTire(double tireWare) {
        this.tireWear = tireWare;
    }
    public double getTireWear() {
        return tireWear;
    }
    void printObject() {
        System.out.println("Tire wear level is " + tireWear);
    }
}
