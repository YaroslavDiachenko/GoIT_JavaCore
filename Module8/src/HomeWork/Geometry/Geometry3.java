package HomeWork.Geometry;


import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Geometry3 extends Geometry2 {
    static int coresQuantity = Runtime.getRuntime().availableProcessors();

    public Geometry3() {
        addOptimalThreadsButton();
    }

    void addOptimalThreadsButton() {
        Button button3 = new Button("Optimal Threads");
        CheckBox checkBox = new CheckBox("Collide with each other");
        buttons.getChildren().addAll(button3,checkBox);

        button3.setOnMouseClicked(event -> {
            buttonClickAction();
            int[] array = defineBounds(rectangles.length, coresQuantity);

            for (int i = 0; i < array.length; i++) {
                int left = array[i];
                int right = i == array.length-1 ? rectangles.length : array[i+1];
                runOptimalThreads(left,right);
            }
        });
    }

    public int[] defineBounds(int rectanglesQuantity, int coresQuantity) {
        int[] bounds = new int[coresQuantity];
        int a = rectanglesQuantity / coresQuantity;
        int b = rectanglesQuantity % coresQuantity;

        for (int i = 1; i < bounds.length; i++) {
            if (b-- > 0) bounds[i] = bounds[i-1] + a + 1;
            else bounds[i] = bounds[i-1] + a;
        }
        return bounds;
    }

    void runOptimalThreads(int left, int right) {
        final CyclicBarrier BARRIER = new CyclicBarrier(coresQuantity);
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

                for (int i = left; i < right; i++) {
                    final MyRectangle temp = rectangles[i];
                    Platform.runLater(() -> moveRectangle(temp));
                }
            }
        });
        thread.start();
        threads.add(thread);
    }
}
