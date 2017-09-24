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
            buttonClickAction();
            runSingleThread();
        });
    }

    void runSingleThread() {
        final Thread thread = new Thread(() -> {
            while(true) {
                for (MyRectangle i : rectangles) {
                    Platform.runLater(() -> moveRectangle(i));
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        thread.start();
        threads.add(thread);
    }
}
