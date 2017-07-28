package Practice.Practice2;

/*
Задание 2 - Line
Создать класс Line
Хранит не статик
Point p1, p2; точки начала и конца линии
Line lineFx; из пакета javafx для рисования

Имеет не статик функции:

double calcLength()
возвращает длину линии.
Необходимо(!) использовать -
- функцию calcLength(Point otherPoint) из класса Point


Point getPointOnLine(float percent)
percent от 0.0f (0%) до 1.0f (100%)
Возвращает точку, которая находиться на данной линии.

0% точка находиться в начале линии, то есть на p1
50% точка находиться в центре линии
100% точка находиться в конце линии, то есть на p2
значение percent может быть любым в диапазоне от 0.0f до 1.0f

Необходимо(!) использовать:
функцию normalize() из класса Point
функцию calcLength() из класса Line


void draw()
рисует линию


void clear()
стирает себя (линию)
 */

import Practice.Practice1.Point;
import javafx.scene.layout.Pane;

public class Line {

    Point p1, p2;
    private javafx.scene.shape.Line lineFx;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    double calcLength() {
        return p1.calcLength(p2);
    }

    Point getPointOnLine(float percent) {

        // 1:
        Point direction = p2.minus(p1);

        // 2:
        Point normalizedDirection = direction.normalize();

        // 3:
        double length = calcLength();
        double lengthToPoint = (double) (length * percent);

        // 4:
        Point resultPointOnVector = normalizedDirection.multiply(lengthToPoint);

        // 5:
        Point resultPoint = resultPointOnVector.plus(p1);

        return resultPoint;
    }

    void draw(Pane root) {
        lineFx = new javafx.scene.shape.Line(p1.x,p1.y,p2.x,p2.y);
        root.getChildren().addAll(lineFx);
    }

}