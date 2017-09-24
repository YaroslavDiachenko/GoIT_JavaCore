package HomeWork.Geometry;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

public class Geometry1 {

    // Interface consists of main layout (Vbox) containing buttons (Hbox) and moving rectangles (Pane)
    VBox layout = new VBox();
    int number = 600;
    HBox buttons = new HBox(10);
    Pane pane = new Pane();
    MyRectangle[] rectangles;
    List<Thread> threads;

    public Geometry1() {
        graphicInterface();
        addMultiThreadsButton();
    }

    void graphicInterface() {
        pane.setMinSize(number,number/2);
        pane.setMaxSize(number,number/2);
        buttons.setPadding(new Insets(10,10,10,10));
        buttons.setMinWidth(number);
        buttons.setStyle("-fx-background-color: LIGHTGREY;");
        layout.getChildren().addAll(buttons, pane);
    }
    void addMultiThreadsButton() {
        Button button1 = new Button("Multi Threads");
        buttons.getChildren().add(button1);
        button1.setOnMouseClicked(event -> {
            buttonClickAction();
            runMultiThreads();
        });
    }
    void runMultiThreads() {
        final CyclicBarrier BARRIER = new CyclicBarrier(rectangles.length);
        for (MyRectangle i : rectangles) {
            final Thread thread = new Thread(() -> {
                while(true) {
                    try {
                        BARRIER.await();
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        break;
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> moveRectangle(i));
                }
            });
            thread.start();
        }
    }

    // Methods perform rectangle's one moveRectangle and change direction (vector) for its next moveRectangle (if needed)
    void moveRectangle(MyRectangle rectangle) {
        switch (rectangle.vector) {
            case UpRight:
                rectangle.setX(rectangle.getX() + 1);
                rectangle.setY(rectangle.getY() - 1);
                if (rectangle.getY() <= 0) rectangle.vector = MyRectangle.Vector.DownRight;
                if ((rectangle.getX() + rectangle.getWidth()) >= pane.getMinWidth()) rectangle.vector = MyRectangle.Vector.UpLeft;

                break;
            case DownRight:
                rectangle.setX(rectangle.getX() + 1);
                rectangle.setY(rectangle.getY() + 1);
                if ((rectangle.getY() + rectangle.getHeight()) >= pane.getMinHeight()) rectangle.vector = MyRectangle.Vector.UpRight;
                if ((rectangle.getX() + rectangle.getWidth()) >= pane.getMinWidth()) rectangle.vector = MyRectangle.Vector.DownLeft;
                break;
            case UpLeft:
                rectangle.setX(rectangle.getX() - 1);
                rectangle.setY(rectangle.getY() - 1);
                if (rectangle.getY() <= 0) rectangle.vector = MyRectangle.Vector.DownLeft;
                if (rectangle.getX() <= 0) rectangle.vector = MyRectangle.Vector.UpRight;
                break;
            case DownLeft:
                rectangle.setX(rectangle.getX() - 1);
                rectangle.setY(rectangle.getY() + 1);
                if ((rectangle.getY() + rectangle.getHeight()) >= pane.getMinHeight()) rectangle.vector = MyRectangle.Vector.UpLeft;
                if (rectangle.getX() <= 0) rectangle.vector = MyRectangle.Vector.DownRight;
                break;
        }
    }

    // Randomizing methods
    double randomDouble(double min,double max) {
        return Math.round(Math.random() * (max - min) + min);
    }
    Color randomColor() {
        return Color.color(Math.random(),Math.random(),Math.random());
    }
    MyRectangle.Vector randomVector() {
        double n = Math.random();
        if (n < 0.25) return MyRectangle.Vector.UpRight;
        else if (n < 0.5) return MyRectangle.Vector.DownRight;
        else if (n < 0.75) return MyRectangle.Vector.UpLeft;
        else return MyRectangle.Vector.DownLeft;
    }

    // Aimed to clear/fill pane, called per setOnMouseClicked event
    void buttonClickAction() {
        if (threads == null) threads = new ArrayList<>();
        breakRunningTasks();
        clearRectangles();
        generateRectangles();
    }
    void breakRunningTasks() {
        if (threads != null) {
            for (Thread i : threads) {
                i.interrupt();
            }
        }
    }
    void clearRectangles() {
        if (rectangles != null && rectangles.length > 0) {
            pane.getChildren().removeAll(rectangles);
        }
        rectangles = null;
    }
    void generateRectangles() {
        int random = (int)randomDouble(3,10);
        rectangles = new MyRectangle[random];
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new MyRectangle(randomDouble(0, number - 60), randomDouble(0, number/2 - 60), randomDouble(30, 60), randomDouble(30, 60), randomVector());
            rectangles[i].setFill(randomColor());
            pane.getChildren().add(rectangles[i]);
        }
    }
}