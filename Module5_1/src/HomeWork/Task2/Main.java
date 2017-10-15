package HomeWork.Task2;

import HomeWork.Task1.SnowmanScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Pentagram");
        Pentagram pentagram = new Pentagram();
        Scene scene = new Scene(pentagram.programLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            boolean answer = pentagram.confirm("Closing program", "Are you sure you want close the program?");
            if (answer) primaryStage.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}