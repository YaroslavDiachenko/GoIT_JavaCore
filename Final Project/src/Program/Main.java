package Program;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application{

    static String nameRequest1 = "Show channel info";
    static String nameRequest2 = "Compare channels info";
    static String nameRequest3 = "Sort channels";
    static String nameRequest4 = "Media resonans";
    static String nameRequest5 = "Compare media resonans";
    static String nameRequest6 = "Sort by media resonans";

    static String descriptionRequest1 = "Shows global information about a channel.";
    static String descriptionRequest2 = "Compares global information of two channels.";
    static String descriptionRequest3 = "Sorts all channels by their data.";
    static String descriptionRequest4 = "Shows total number of channel's comments.";
    static String descriptionRequest5 = "Compares total number of two channels' comments.";
    static String descriptionRequest6 = "Sorts channels by their total number of comments.";

    static Pane pane = new Pane();
    static MainScreen mainScreen = new MainScreen();
    ProgramMenu programMenu = new ProgramMenu();
    static ProgramSettings programSettings = new ProgramSettings();
    static YouTubeAnalytics youTubeAnalytics = new YouTubeAnalytics();
    static RequestScreen request1 = new RequestOneChannel(nameRequest1,descriptionRequest1);
    static RequestScreen request2 = new RequestManyChannels(nameRequest2,descriptionRequest2);
    static RequestScreen request3 = new RequestManyChannels(nameRequest3,descriptionRequest3);
    static RequestScreen request4 = new RequestOneChannel(nameRequest4,descriptionRequest4);
    static RequestScreen request5 = new RequestManyChannels(nameRequest5,descriptionRequest5);
    static RequestScreen request6 = new RequestManyChannels(nameRequest6,descriptionRequest6);

    static ResultScreen resultScreen = new ResultScreen();

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane.getChildren().add(mainScreen.screen);
        VBox layout = new VBox();
        layout.getChildren().addAll(ProgramMenu.menuBar, pane);
        Scene scene = new Scene(layout, 600, 400);

        primaryStage.setTitle("YouTube Analytics");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            boolean answer = confirm("Closing program", "Are you sure you want close the program?");
            if (answer) primaryStage.close();
        });
    }

    public void alert(String title, String message) {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(300);
        stage.setMinHeight(100);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
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
