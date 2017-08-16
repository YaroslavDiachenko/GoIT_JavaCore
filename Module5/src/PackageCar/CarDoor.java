/*
Класс CarDoor
На прямую к переменным этого класса никто не может, только через методы
--------------------
Хранит:
состояние двери(открыта/закрыта)
состояние окна (открыто/закрыто)

Конструктор
--------------------
Требуется насколько конструкторов на различные случаи
Один без аргументов. Он должен присвоить переменым значения на случай если данных нет.
Один конструктор принимает оба состояния, двери и окна. Присваивает эти значения переменным внутри объекта.

Методы
--------------------
открыть дверь
закрыть дверь
открыть/закрыть дверь (если дверь открыта и вызывается эта функция, значит дверь необходимо закрыть и наоборот)
открыть окно
закрыть окно
открыть/закрыть окно(если дверь открыта и вызывается эта функция, значит дверь необходимо закрыть и наоборот)
Вывести в консоль данные об объекте
 */

package PackageCar;

public class CarDoor {

    // Fields:

    private boolean doorState;    // true - open, false - closed;
    private boolean windowState;  // true - open, false - closed;

    // Constructors:

    public CarDoor() {
        this(false, false);
    }
    public CarDoor(boolean doorState, boolean windowState) {
        this.doorState = doorState;
        this.windowState = windowState;
    }

    // Getters:

    public boolean getDoorState() {
        return doorState;
    }
    public boolean getWindowState() {
        return windowState;
    }

    // Methods:

    void openDoor() {
        doorState = true;
    }
    void closeDoor() {
        doorState = false;
    }
    void openOrCloseDoor() {
        doorState = !doorState;
    }

    void openWindow() {
        windowState = true;
    }
    void closeWindow() {
        windowState = false;
    }
    void openOrCloseWindow() {
        windowState = !windowState;
    }

    void printDoor() {
        System.out.println("\nInformation about the door:");
        System.out.print(doorState ? "  The door is open and " : "  The door is closed and ");
        System.out.println(windowState ? "window in the door is open." : "window in the door is closed.");
    }
}
