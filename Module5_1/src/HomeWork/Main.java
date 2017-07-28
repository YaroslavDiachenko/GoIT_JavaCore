package HomeWork;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(400);
        primaryStage.setHeight(600);

        Pane root = new Pane();
        root.getChildren().addAll(Task1.drawSnowman(5));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}