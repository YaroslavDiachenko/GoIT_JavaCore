package HomeWork.Geometry;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Geometry1 geometry1 = new Geometry1();
        Geometry2 geometry2 = new Geometry2();
        Geometry3 geometry3 = new Geometry3();

        primaryStage.setTitle("Moving figures");

        primaryStage.setScene(new Scene(geometry3.layout));
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