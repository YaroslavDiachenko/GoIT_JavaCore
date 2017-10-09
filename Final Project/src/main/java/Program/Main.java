package Program;


import YouTubeData_Channels.ChannelListResponse;
import YouTubeData_Channels.OneChannel;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application{

 // requests names
    static String nameRequest1 = "Show channel info";
    static String nameRequest2 = "Compare channels info";
    static String nameRequest3 = "Sort channels";
    static String nameRequest4 = "Media resonans";
    static String nameRequest5 = "Compare media resonans";
    static String nameRequest6 = "Sort by media resonans";

 // program objects
    static Pane pane = new Pane();
    static MainScreen mainScreen = new MainScreen();
    static ProgramMenu programMenu = new ProgramMenu();
    static ProgramSettings programSettings = new ProgramSettings();
    static YouTubeAnalytics youTubeAnalytics = new YouTubeAnalytics();
    static RequestOneChannel requestOneChannel = new RequestOneChannel();
    static RequestManyChannels requestManyChannels = new RequestManyChannels();
    static RequestResultScreen resultScreen = new RequestResultScreen();

 // opens separate window with error notification
    public static void alert(String title, String message) {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(300);
        stage.setMinHeight(100);

        Text text = new Text();
        text.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(text, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }

 // opens separate window requesting from user to make YES/NO choice
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

 // launches JavaFX application
    @Override
    public void start(Stage primaryStage) throws Exception {
        pane.getChildren().add(mainScreen.screen);
        VBox layout = new VBox();
        layout.getChildren().addAll(programMenu.menuBar, pane);
        Scene scene = new Scene(layout, 600, 400);

        primaryStage.setTitle("YouTube Analytics");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            boolean answer = confirm("Closing program", "Are you sure you want close the program?");
            if (answer) {
                programSettings.saveSettings();
                primaryStage.close();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
