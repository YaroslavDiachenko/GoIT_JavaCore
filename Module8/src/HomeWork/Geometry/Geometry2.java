package HomeWork.Geometry;


import javafx.application.Platform;
import javafx.scene.control.Button;

public class Geometry2 extends Geometry1 {

    public Geometry2() {
        addSingleThreadButton();
    }

    void addSingleThreadButton() {
        Button button2 = new Button("Single Thread");
        buttons.getChildren().addAll(button2);

        button2.setOnMouseClicked(event -> {
            clearRectangles();
            int random = (int)randomDouble(3,10);
            rectangles = new MyRectangle[random];
            for (int i = 0; i < rectangles.length; i++) {
                rectangles[i] = new MyRectangle(randomDouble(0, number - 60), randomDouble(0, number/2 - 60), randomDouble(30, 60), randomDouble(30, 60),randomVector());
                rectangles[i].setFill(randomColor());
                pane.getChildren().add(rectangles[i]);
            }
            runSingleThread();
        });

    }

    void runSingleThread() {
        final Thread thread = new Thread(() -> {
            while(true) {
                for (MyRectangle i : rectangles) {
                    Platform.runLater(() -> move(i));
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
