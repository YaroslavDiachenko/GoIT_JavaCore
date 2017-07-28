package HomeWork.Task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        Circles object = new Circles();
        primaryStage.setWidth(400);
        primaryStage.setHeight(600);

        Pane root = new Pane();
        root.getChildren().addAll(object.drawSnowman(5, 10, 70));

        Button button1 = new Button("Paint red");
        button1.setTranslateX(100);
        button1.setTranslateY(20);
        button1.setOnAction((ActionEvent e) -> object.paintAll());
        root.getChildren().add(button1);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}