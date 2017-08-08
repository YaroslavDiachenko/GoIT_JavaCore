package HomeWork;

import HomeWork.MP3Player.OneSongPlayers.Player1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setTitle("MP3Player");

        Player1 player1 = new Player1(10, "A song");

        Pane root = new Pane();
        player1.show(root);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}