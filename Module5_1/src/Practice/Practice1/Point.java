package Practice.Practice1;

/*
Создать класс Point
Хранит статик константу
ZERO (x=0, y=0) типа Point

Хранит не статик
double x, y;

Имеет не статик функции:

double calcLength(Point otherPoint)
Она возвращает расстояние между двумя точками


double calcLength()
Возвращает длину от точки ZERO до данной точки
Необходимо(!) использовать функцию calcLength(Point otherPoint) в расчетах


void normalize()
Нормализует вектор(точку)
Google в помощь.
Необходимо(!) использовать функцию calcLength() в расчетах

 */

public class Point {
    double x;
    double y;
    static final Point ZERO = new Point(0,0);

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double calcLength(Point otherPoint) {
        return Math.sqrt(Math.pow((this.y - otherPoint.y),2) + Math.pow((this.x - otherPoint.x),2));
    }

    double calcLength() {
        return calcLength(ZERO);
    }

    void normalize() {
        double length = calcLength();
        this.x /= length;
        this.y /= length;
    }

    public static void main(String[] args) {
        Point example = new Point(3,2);

    }
}