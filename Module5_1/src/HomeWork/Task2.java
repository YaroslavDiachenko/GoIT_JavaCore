package HomeWork;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;

public class Task2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        Pane root = new Pane();
        root.getChildren().addAll(drawSnowman(2));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private Circle[] drawSnowman(int count) {

        Random random = new Random();

        Circle[] circles = new Circle[count];
        for (int i = 0; i < circles.length; i++) {
            if (i == 0) {
                circles[i] = new Circle(200, 300, 60);
                circles[i].setFill(Paint.valueOf("#111111"));
            } else {
                circles[i] = new Circle(30);
                circles[i].setCenterX(200);
                circles[i].setCenterY(circles[i-1].getCenterY() - (circles[i-1].getRadius() + circles[i].getRadius()));
            }

        }
        return circles;
    }

}
