
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

package HomeWork;

        import javafx.scene.paint.Color;
        import javafx.scene.shape.Circle;

public class Task1 {

    static double randomDouble(double min,double max) {
        return Math.round(Math.random() * (max - min) + min);
    }

    static Color randomColor() {
        return Color.color(Math.random(),Math.random(),Math.random());
    }

    static Circle[] drawSnowman(int count) {

        Circle[] circles = new Circle[count];
        for (int i = 0; i < circles.length; i++) {
            if (i == 0) {
                circles[i] = new Circle(200, 500, randomDouble(20,50),randomColor());

            } else {
                circles[i] = new Circle(randomDouble(20,50));
                circles[i].setCenterX(200);
                circles[i].setCenterY(circles[i-1].getCenterY() - (circles[i-1].getRadius() + circles[i].getRadius() + 5));
            }
            circles[i].setFill(Color.WHITE);
            circles[i].setStroke(randomColor());
            circles[i].setStrokeWidth(5);
        }
        return circles;
    }
}

