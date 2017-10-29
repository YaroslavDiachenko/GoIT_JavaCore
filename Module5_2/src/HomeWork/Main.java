package HomeWork;

import HomeWork.MP3Player.MultySongsPlayers.Player3;
import HomeWork.MP3Player.MultySongsPlayers.Player4;
import HomeWork.MP3Player.MultySongsPlayers.Player5;
import HomeWork.MP3Player.MultySongsPlayers.Player6;
import HomeWork.MP3Player.OneSongPlayers.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        Player1 player1 = new Player1(60.0);
        Player2 player2 = new Player2(40.0);
        Player3 player3 = new Player3(90.0);
        Player4 player4 = new Player4(110.0);
        Player5 player5 = new Player5(130.3);
        Player6 player6 = new Player6(180.0);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tab1 = new Tab();
        tab1.setText("Player1");
        tab1.setContent(player1.getPlayerLayout());

        Tab tab2 = new Tab();
        tab2.setText("Player2");
        tab2.setContent(player2.getPlayerLayout());

        Tab tab3 = new Tab();
        tab3.setText("Player3");
        tab3.setContent(player3.getPlayerLayout());

        Tab tab4 = new Tab();
        tab4.setText("Player4");
        tab4.setContent(player4.getPlayerLayout());

        Tab tab5 = new Tab();
        tab5.setText("Player5");
        tab5.setContent(player5.getPlayerLayout());

        Tab tab6 = new Tab();
        tab6.setText("Player6");
        tab6.setContent(player6.getPlayerLayout());

        tabPane.getTabs().addAll(tab1,tab2,tab3,tab4,tab5,tab6);

        primaryStage.setTitle("MP3Player");
        primaryStage.setScene(new Scene(tabPane, 600, 400));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            boolean answer = confirm("Closing program", "Are you sure you want close the program?");
            if (answer) {
                primaryStage.close();
            }
        });

    }

    public boolean confirm(String title, String message) {
        final boolean[] answer = new boolean[1];
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(300);
        stage.setMinHeight(100);
        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setMinWidth(60);
        noButton.setMinWidth(60);

        yesButton.setOnAction(e -> {
            answer[0] = true;
            stage.close();
        });
        noButton.setOnAction(e -> {
            answer[0] = false;
            stage.close();
        });

        VBox layout = new VBox(10);
        HBox layout2 = new HBox(7);

        //Add buttons
        layout2.getChildren().addAll(yesButton,noButton);
        layout.getChildren().addAll(label, layout2);
        layout.setAlignment(Pos.CENTER);
        layout2.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
        return answer[0];
    }

    public static void main(String[] args) {
        launch(args);
    }
}