package HomeWork.Task2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // new object:
        Pentagram pentagram = new Pentagram();

        // app main block:
        primaryStage.setWidth(600);
        primaryStage.setHeight(700);
        Pane root = new Pane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        root.getChildren().addAll(pentagram.drawPentagram(100,100,50));

    }
}
