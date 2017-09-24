package HomeWork.Geometry;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

import static HomeWork.Geometry.MyRectangle.Vector.UpLeft;

public class Geometry1 {
    VBox layout = new VBox();
    int number = 700;
    HBox buttons = new HBox(10);
    Pane pane = new Pane();
    MyRectangle[] rectangles;
    List<Thread> threads;
    TextField textField;
    long speed;

    public Geometry1() {
        graphicInterface();
        addMultiThreadsButton();
    }

    void graphicInterface() {
        Platform.runLater(() -> layout.requestFocus());
        pane.setMinSize(number,number/2);
        pane.setMaxSize(number,number/2);
        buttons.setPadding(new Insets(10,10,10,10));
        buttons.setMinWidth(number);
        buttons.setStyle("-fx-background-color: LIGHTGREY;");
        textField = new TextField();
        textField.setPrefWidth(70);
        textField.setPromptText("Millis..");
        buttons.getChildren().add(textField);
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
                        Thread.sleep(speed);
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

    void moveRectangle(MyRectangle r) {
        switch (r.vector) {
            case UpRight:
                r.setX(r.getX() + 1);
                r.setY(r.getY() - 1);
                if (r.getY() <= 0) r.vector = MyRectangle.Vector.DownRight;
                if ((r.getX() + r.getWidth()) >= pane.getMinWidth()) r.vector = UpLeft;

                break;
            case DownRight:
                r.setX(r.getX() + 1);
                r.setY(r.getY() + 1);
                if ((r.getY() + r.getHeight()) >= pane.getMinHeight()) r.vector = MyRectangle.Vector.UpRight;
                if ((r.getX() + r.getWidth()) >= pane.getMinWidth()) r.vector = MyRectangle.Vector.DownLeft;
                break;
            case UpLeft:
                r.setX(r.getX() - 1);
                r.setY(r.getY() - 1);
                if (r.getY() <= 0) r.vector = MyRectangle.Vector.DownLeft;
                if (r.getX() <= 0) r.vector = MyRectangle.Vector.UpRight;
                break;
            case DownLeft:
                r.setX(r.getX() - 1);
                r.setY(r.getY() + 1);
                if ((r.getY() + r.getHeight()) >= pane.getMinHeight()) r.vector = UpLeft;
                if (r.getX() <= 0) r.vector = MyRectangle.Vector.DownRight;
                break;
        }
    }
    void moveRectangleBounce(MyRectangle rectangle) {
        MyRectangle future = new MyRectangle(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight(),rectangle.vector);
        switch (future.vector) {
            case UpRight:
                rectangle.setX(future.getX() + 1);
                rectangle.setY(future.getY() - 1);

                future.setX(future.getX() + 1);
                future.setY(future.getY() - 1);

                for (MyRectangle i : rectangles) {
                    if (future.getBoundsInLocal().intersects(i.getBoundsInLocal())) {
                        switch (i.vector) {
                            case DownRight:
                                if (future.getY() == i.getY()+i.getHeight()) {
                                    rectangle.vector = MyRectangle.Vector.DownRight;
                                    i.vector = MyRectangle.Vector.UpRight;
                                }
                                break;
                            case UpLeft:
                                if (future.getX()+future.getWidth() == i.getX()) {
                                    rectangle.vector = MyRectangle.Vector.UpLeft;
                                    i.vector = MyRectangle.Vector.UpRight;
                                }
                                break;
                            case DownLeft:
                                if (future.getX()+future.getWidth() == i.getX()) {
                                    rectangle.vector = MyRectangle.Vector.UpLeft;
                                    i.vector = MyRectangle.Vector.DownRight;
                                }
                                if (future.getY() == i.getY()+i.getHeight()) {
                                    rectangle.vector = MyRectangle.Vector.DownRight;
                                    i.vector = MyRectangle.Vector.UpLeft;
                                }
                                break;
                        }
                    }
                }

                if (rectangle.getY() <= 0) rectangle.vector = MyRectangle.Vector.DownRight;
                if ((rectangle.getX() + rectangle.getWidth()) >= pane.getMinWidth()) rectangle.vector = UpLeft;
                break;

            case DownRight:
                rectangle.setX(future.getX() + 1);
                rectangle.setY(future.getY() + 1);

                future.setX(future.getX() + 1);
                future.setY(future.getY() + 1);

                for (MyRectangle i : rectangles) {
                    if (future.getBoundsInLocal().intersects(i.getBoundsInLocal())) {
                        switch (i.vector) {
                            case UpRight:
                                if (future.getY()+future.getHeight() == i.getY()) {
                                    rectangle.vector = MyRectangle.Vector.UpRight;
                                    i.vector = MyRectangle.Vector.DownRight;
                                }
                                break;
                            case DownLeft:
                                if (future.getX()+future.getWidth() == i.getX()) {
                                    rectangle.vector = MyRectangle.Vector.DownLeft;
                                    i.vector = MyRectangle.Vector.DownRight;
                                }
                                break;
                            case UpLeft:
                                if (future.getX() + future.getWidth() == i.getX()) {
                                    rectangle.vector = MyRectangle.Vector.DownLeft;
                                    i.vector = MyRectangle.Vector.UpRight;
                                }
                                if (future.getY() + future.getHeight() == i.getY()) {
                                    rectangle.vector = MyRectangle.Vector.UpRight;
                                    i.vector = MyRectangle.Vector.DownLeft;
                                }
                                break;
                        }
                    }
                }

                if ((rectangle.getY() + rectangle.getHeight()) >= pane.getMinHeight()) rectangle.vector = MyRectangle.Vector.UpRight;
                if ((rectangle.getX() + rectangle.getWidth()) >= pane.getMinWidth()) rectangle.vector = MyRectangle.Vector.DownLeft;
                break;

            case UpLeft:
                rectangle.setX(future.getX() - 1);
                rectangle.setY(future.getY() - 1);

                future.setX(future.getX() - 1);
                future.setY(future.getY() - 1);

                for (MyRectangle i : rectangles) {
                    if (future.getBoundsInLocal().intersects(i.getBoundsInLocal())) {
                        switch (i.vector) {
                            case DownLeft:
                                if (future.getY() == i.getY()+i.getHeight()) {
                                    rectangle.vector = MyRectangle.Vector.DownLeft;
                                    i.vector = MyRectangle.Vector.UpLeft;
                                }
                                break;
                            case UpRight:
                                if (future.getX() == i.getX()+i.getWidth()) {
                                    rectangle.vector = MyRectangle.Vector.UpRight;
                                    i.vector = MyRectangle.Vector.UpLeft;
                                }
                                break;
                            case DownRight:
                                if (future.getX() == i.getX()+i.getWidth()) {
                                    rectangle.vector = MyRectangle.Vector.UpRight;
                                    i.vector = MyRectangle.Vector.DownLeft;
                                }
                                if (future.getY() == i.getY()+i.getHeight()) {
                                    rectangle.vector = MyRectangle.Vector.DownLeft;
                                    i.vector = MyRectangle.Vector.UpRight;
                                }
                                break;
                        }
                    }
                }

                if (rectangle.getY() <= 0) rectangle.vector = MyRectangle.Vector.DownLeft;
                if (rectangle.getX() <= 0) rectangle.vector = MyRectangle.Vector.UpRight;
                break;

            case DownLeft:
                rectangle.setX(future.getX() - 1);
                rectangle.setY(future.getY() + 1);

                future.setX(future.getX() - 1);
                future.setY(future.getY() + 1);

                for (MyRectangle i : rectangles) {
                    if (future.getBoundsInLocal().intersects(i.getBoundsInLocal())) {
                        switch (i.vector) {
                            case UpLeft:
                                if (future.getY()+future.getHeight() == i.getY()) {
                                    rectangle.vector = MyRectangle.Vector.UpLeft;
                                    i.vector = MyRectangle.Vector.DownLeft;
                                }
                                break;
                            case DownRight:
                                if (future.getX() == i.getX()+i.getWidth()) {
                                    rectangle.vector = MyRectangle.Vector.DownRight;
                                    i.vector = MyRectangle.Vector.DownLeft;
                                }
                                break;
                            case UpRight:
                                if (future.getX() == i.getX()+i.getWidth()) {
                                    rectangle.vector = MyRectangle.Vector.DownRight;
                                    i.vector = MyRectangle.Vector.UpLeft;
                                }
                                if (future.getY() + future.getHeight() == i.getY()) {
                                    rectangle.vector = MyRectangle.Vector.UpLeft;
                                    i.vector = MyRectangle.Vector.DownRight;
                                }
                                break;
                        }
                    }
                }

                if ((rectangle.getY() + rectangle.getHeight()) >= pane.getMinHeight()) rectangle.vector = UpLeft;
                if (rectangle.getX() <= 0) rectangle.vector = MyRectangle.Vector.DownRight;
                break;
        }
    }

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
        else if (n < 0.75) return UpLeft;
        else return MyRectangle.Vector.DownLeft;
    }

    void buttonClickAction() {
        speed = Long.parseLong(textField.getText());
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
            rectangles[i] = new MyRectangle(randomDouble(0,number-60), randomDouble(0,number/2-60), randomDouble(40,80), randomDouble(40,80), randomVector());
            rectangles[i].setFill(randomColor());
            pane.getChildren().add(rectangles[i]);
        }
    }
}