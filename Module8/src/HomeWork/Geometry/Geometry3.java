package HomeWork.Geometry;


import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Geometry3 extends Geometry2 {

    public Geometry3() {
        addOptimalThreadsButton();
    }

    void addOptimalThreadsButton() {
        Button button3 = new Button("Optimal Threads");
        CheckBox checkBox = new CheckBox("Collide with each other");
        buttons.getChildren().addAll(button3,checkBox);

        button3.setOnMouseClicked(event -> {
            clearRectangles();
            int rectanglesQuantity = (int)randomDouble(3,10);
            rectangles = new MyRectangle[rectanglesQuantity];
            for (int i = 0; i < rectangles.length; i++) {
                rectangles[i] = new MyRectangle(randomDouble(0, number - 60), randomDouble(0, number/2 - 60), randomDouble(30, 60), randomDouble(30, 60),randomVector());
                rectangles[i].setFill(randomColor());
                pane.getChildren().add(rectangles[i]);
            }

            int coresQuantity = Runtime.getRuntime().availableProcessors();
            int rectanglesQuantityPerCore = (int) Math.ceil((double)rectanglesQuantity/coresQuantity);

            MyRectangle[][] rectanglesSplit = new MyRectangle[coresQuantity][rectanglesQuantityPerCore];

            for (int i = 0, tempArray = 0, tempElement = 0; i < rectangles.length; i++) {
                if (tempArray == coresQuantity) {
                    tempArray = 0;
                    tempElement++;
                }
                rectanglesSplit[tempArray++][tempElement] = rectangles[i];
            }
            runOptimalThreads(rectanglesSplit);
        });
    }

    void runOptimalThreads(MyRectangle[][] rectanglesSplit) {
        for (MyRectangle[] i : rectanglesSplit) {
            final Thread thread = new Thread(() -> {
                while(true) {
                    for (MyRectangle j : i) {
                        if (j != null) Platform.runLater(() -> move(j));
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


}
