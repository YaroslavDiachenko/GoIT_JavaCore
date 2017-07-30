package HomeWork.Task1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    public static final float WIDTH = 600;
    public static final float HEIGHT = 700;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        SnowmanScene snowmanScene = new SnowmanScene(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}