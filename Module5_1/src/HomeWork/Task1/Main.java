package HomeWork.Task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        // new object:
        Snowman object = new Snowman();

        // app main block:
        primaryStage.setWidth(400);
        primaryStage.setHeight(600);
        Pane root = new Pane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        // draw a snowman:
        root.getChildren().addAll(object.drawSnowman(5, 10, 70));

        // set button #1:
        Button button1 = new Button("Draw snowman");
        button1.setTranslateX(180);
        button1.setTranslateY(10);
        root.getChildren().addAll(button1);

        // text field for :
        TextField input = new TextField ();
        input.setPromptText("Enter color..");
        input.setTranslateX(10);
        input.setTranslateY(10);
        root.getChildren().addAll(input);

        // output message:
        Text message = new Text();
        message.setX(18);
        message.setY(60);

        button1.setOnAction((ActionEvent e) -> {
            if (message.getText() != null) root.getChildren().remove(message);   // clear previous message;
            if (input.getText() != null && !input.getText().isEmpty()) {   // check if not empty input;
                String s = input.getText();

                try{
                    object.paintAll(Color.valueOf(s.toUpperCase()));   // convert to color by name from input string;
                    message.setText(s + " snowman");
                }catch(IllegalArgumentException a) {
                    message.setText("Unknown color");   // missing static color in javafx.scene.paint.Color class
                }
                root.getChildren().add(message);   // show new message;
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}