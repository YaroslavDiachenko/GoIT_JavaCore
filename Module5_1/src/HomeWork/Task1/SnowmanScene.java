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

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SnowmanScene {

    private Circle[] circles;
    private Pane root = new Pane();

    public SnowmanScene(Stage primaryStage) {
        graphicInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    void graphicInterface() {

        Button button1 = new Button("Draw snowman");
        Button button2 = new Button("Paint gradient");

        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field4 = new TextField ();

        Text message1 = new Text();
        Text message2 = new Text();

        button1.setTranslateX(180);
        button1.setTranslateY(10);

        button2.setTranslateX(180);
        button2.setTranslateY(110);

        field1.setPromptText("Number of circles");
        field1.setTranslateX(10);
        field1.setTranslateY(10);

        field2.setPromptText("Minimum random radius");
        field2.setTranslateX(10);
        field2.setTranslateY(40);

        field3.setPromptText("Maximum random radius");
        field3.setTranslateX(10);
        field3.setTranslateY(70);

        field4.setPromptText("Color");
        field4.setTranslateX(10);
        field4.setTranslateY(110);

        message1.setFont(Font.font ("Times New Roman", 16));
        message1.setX(12);
        message1.setY(165);

        message2.setFont(Font.font ("Times New Roman", 16));
        message2.setX(12);
        message2.setY(185);

        root.getChildren().addAll(button1,button2,field1,field2,field3,field4,message1,message2);

        button1.setOnAction((ActionEvent e) -> {
            clearCircles();
            message1.setText("");
            message2.setText("");
            if (field1.getText().isEmpty() || field2.getText().isEmpty() || field3.getText().isEmpty())
                message1.setText("Input all data");
            else {
                try {
                    int n1 = Integer.parseInt(field1.getText());
                    double n2 = Double.parseDouble(field2.getText());
                    double n3 = Double.parseDouble(field3.getText());
                    root.getChildren().addAll(drawSnowman(n1,n2,n3));
                    message1.setText("Snowman with " + n1 + " circles, minimum radius " + n2 + " and maximum radius " + n3 + ".");
                }catch (NumberFormatException e2){
                    message1.setText("Incorrect format");
                }
            }
        });

        button2.setOnAction((ActionEvent e) -> {
            if (circles == null) message2.setText("Draw snowman first!");
            else if (!field4.getText().isEmpty()) {
                String s4 = field4.getText();

                try{
                    paintAll(Color.valueOf(s4.toUpperCase()));
                    message2.setText("Painted with " + s4 + " gradient.");
                }catch(IllegalArgumentException e3) {
                    message2.setText("Unknown color");
                }
            }
        });
    }

    private double randomDouble(double min,double max) {
        return Math.round(Math.random() * (max - min) + min);
    }

    private Color randomColor() {
        return Color.color(Math.random(),Math.random(),Math.random());
    }

    private void paintAll(Color color) {
        if (this.circles == null) return;
        double saturation = color.getSaturation();
        for (int i = 0; i < this.circles.length; i++) {
            this.circles[i].setFill(Color.hsb(color.getHue(), saturation,color.getBrightness()));
            this.circles[i].setStroke(Color.hsb(color.getHue(), saturation,color.getBrightness()));
            saturation -= color.getSaturation()/this.circles.length;
        }
    }

    private Circle[] drawSnowman(int count, double min, double max) {

        clearCircles();
        circles = new Circle[count+3];
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

    private void clearCircles() {
        if (circles != null && circles.length > 0) {
            root.getChildren().removeAll(circles);
        }
    }
}