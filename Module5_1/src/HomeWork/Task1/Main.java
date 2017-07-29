package HomeWork.Task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        // new object:
        Snowman object = new Snowman();

        // app main block:
        primaryStage.setWidth(600);
        primaryStage.setHeight(700);
        Pane root = new Pane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        // SCENARIO #1: Draw snowman with no fill and random colors
        {
            Button button1 = new Button("Draw snowman");
            TextField field1 = new TextField();
            TextField field2 = new TextField();
            TextField field3 = new TextField();
            Text message1 = new Text();

            button1.setTranslateX(180);
            button1.setTranslateY(10);
            root.getChildren().addAll(button1);

            field1.setPromptText("Number of circles");
            field1.setTranslateX(10);
            field1.setTranslateY(10);
            root.getChildren().addAll(field1);

            field2.setPromptText("Minimum random radius");
            field2.setTranslateX(10);
            field2.setTranslateY(40);
            root.getChildren().addAll(field2);

            field3.setPromptText("Maximum random radius");
            field3.setTranslateX(10);
            field3.setTranslateY(70);
            root.getChildren().addAll(field3);

            message1.setFont(Font.font ("Times New Roman", 16));
            message1.setX(12);
            message1.setY(160);

            button1.setOnAction((ActionEvent e) -> {
                if (object.circles != null) root.getChildren().removeAll(object.circles);
                if (field1.getText().isEmpty() || field2.getText().isEmpty() || field3.getText().isEmpty())
                    message1.setText("Input all data");
                else {
                    try {
                        int n1 = Integer.parseInt(field1.getText());
                        double n2 = Double.parseDouble(field2.getText());
                        double n3 = Double.parseDouble(field3.getText());

                        message1.setText("Snowman with " + n1 + " circles, minimum radius " + n2 + " and maximum radius " + n3 + ".");
                        root.getChildren().addAll(object.drawSnowman(n1,n2,n3));

                    }catch (NumberFormatException e2){
                        message1.setText("Incorrect format");
                    }
                }
                root.getChildren().addAll(message1);
            });
        }


        // SCENARIO #2: Paint snowman gradient with input color
        {
            Button button2 = new Button("Paint gradient");
            TextField field4 = new TextField ();
            Text message2 = new Text();

            button2.setTranslateX(180);
            button2.setTranslateY(110);
            root.getChildren().addAll(button2);

            field4.setPromptText("Color");
            field4.setTranslateX(10);
            field4.setTranslateY(110);
            root.getChildren().addAll(field4);

            message2.setFont(Font.font ("Times New Roman", 16));
            message2.setX(12);
            message2.setY(180);

            button2.setOnAction((ActionEvent e) -> {
                if (message2.getText() != null) root.getChildren().remove(message2);   // clear previous message;
                if (field4.getText() != null && !field4.getText().isEmpty()) {   // check if not empty input;
                    String s4 = field4.getText();

                    try{
                        object.paintAll(Color.valueOf(s4.toUpperCase()));   // convert to color by name from input string;
                        message2.setText(s4 + " snowman.");
                    }catch(IllegalArgumentException e3) {
                        message2.setText("Unknown color");   // missing static color in javafx.scene.paint.Color class
                    }
                    root.getChildren().add(message2);   // show new message;
                }
            });
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}