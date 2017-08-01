package HomeWork.Task2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static final float WIDTH = 500;
    public static final float HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        PentagramScene pentagramScene = new PentagramScene(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}