package HomeWork.Geometry;


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
            int cores = Runtime.getRuntime().availableProcessors();
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



}
