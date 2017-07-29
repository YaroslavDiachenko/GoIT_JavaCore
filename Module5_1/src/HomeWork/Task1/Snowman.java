/*
Задание 1
Создать оконное приложение на JavaFX
Необходимо нарисовать снеговика исходя из пожеланий пользователя. Снеговик состоит из кругов.
Каждый последующий круг находиться над предыдущим, касаясь его(!). Если круг будет налазить на другой круг, либо между
ними будет пробел - значит снеговик отрисован не верно. Радиусы кругов рандомизированы.
Цвета кругов должны быть рандомизированы.
На голове снеговика(верхний круг) из кругов должен быть отрисован нос и 2 глаза (меньше головы).
Круги на теле должны быть рандомизированы. Нет последовательности на уменьшение или увеличение.
Данные вводятся через консоль:
1. кол-во кругов
2. мин. радиус круга
3. макс. радиус круга

Дополнительные задания
1. Убрать ввод с консоли и заменить его на UI элементы (кнопки и поля для ввода)
2. Добавить кнопку - покрасить все круги в красный. Она красит все ранее нарисованные круги в красный цвет.
3. Добавить кнопку - Gradient. Она красит все круги начиная от нижнего к верхнему серыми оттенками. К примеру нижний
круг полностью черный, а каждый круг выше становиться более светлым. И в конечном счете верхний круг снеговика должен
быть светло серым.
 */

package HomeWork.Task1;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Snowman {

    Circle[] circles;

    double randomDouble(double min,double max) {
        return Math.round(Math.random() * (max - min) + min);
    }

    Color randomColor() {
        return Color.color(Math.random(),Math.random(),Math.random());
    }

    void paintAll(Color color) {
        if (this.circles == null) return;
        double saturation = color.getSaturation();
        for (int i = 0; i < this.circles.length; i++) {
            this.circles[i].setFill(Color.hsb(color.getHue(), saturation,color.getBrightness()));
            this.circles[i].setStroke(Color.hsb(color.getHue(), saturation,color.getBrightness()));
            saturation -= color.getSaturation()/this.circles.length;
        }
    }

    Circle[] drawSnowman(int count, double min, double max) {

        this.circles = new Circle[count+3];
        for (int i = 0; i < circles.length; i++) {

            if (i == 0) { // bottom circle;
                circles[i] = new Circle(300, 600, randomDouble(min,max),randomColor());

            } else if (i == circles.length - 3) { // nose;
                circles[i] = new Circle(
                        circles[circles.length-4].getCenterX(),
                        circles[circles.length-4].getCenterY(),
                        randomDouble(circles[circles.length-4].getRadius()/8,circles[circles.length-4].getRadius()/4),
                        randomColor());

            } else if (i == circles.length - 2) { // left eye;
                circles[i] = new Circle(
                        circles[circles.length-4].getCenterX() - circles[circles.length-4].getRadius()/2,
                        circles[circles.length-4].getCenterY() - circles[circles.length-4].getRadius()/2,
                        randomDouble(circles[circles.length-4].getRadius()/8,circles[circles.length-4].getRadius()/4),
                        randomColor());

            } else if (i == circles.length - 1) { // right eye;
                circles[i] = new Circle(
                        circles[circles.length-4].getCenterX() + circles[circles.length-4].getRadius()/2,
                        circles[circles.length-4].getCenterY() - circles[circles.length-4].getRadius()/2,
                        randomDouble(circles[circles.length-4].getRadius()/8,circles[circles.length-4].getRadius()/4),
                        randomColor());

            }else { // other body circles;
                circles[i] = new Circle(randomDouble(min,max));
                circles[i].setCenterX(300);
                circles[i].setCenterY(circles[i-1].getCenterY() - (circles[i-1].getRadius() + circles[i].getRadius() + 3));
            }
            circles[i].setFill(Color.WHITE);
            circles[i].setStroke(randomColor());
            circles[i].setStrokeWidth(3);
        }
        return circles;
    }
}