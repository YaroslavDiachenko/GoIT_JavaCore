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
    public double x;
    public double y;
    static final Point ZERO = new Point(0,0);

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcLength(Point otherPoint) {
        return Math.sqrt(Math.pow((this.y - otherPoint.y),2) + Math.pow((this.x - otherPoint.x),2));
    }

    public double calcLength() {
        return calcLength(ZERO);
    }

    public Point normalize() {
        double length = calcLength();
        this.x /= length;
        this.y /= length;
        return new Point(this.x,this.y);
    }

    public Point minus(Point a) {
        return new Point(this.x - a.x,this.y - a.y);
    }

    public Point plus(Point a) {
        return new Point(this.x + a.x,this.y + a.y);
    }

    public Point multiply(double n) {
        return new Point(this.x * n,this.y * n);
    }
}