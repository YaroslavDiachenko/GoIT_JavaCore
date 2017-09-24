package HomeWork.Geometry;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Geometry1 geometry1 = new Geometry1();
        Geometry2 geometry2 = new Geometry2();
        Geometry3 geometry3 = new Geometry3();

        primaryStage.setScene(new Scene(geometry3.layout));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}