/*
Lesson
 */

package HomeWork.Task2;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Pentagram {

    Line[] lines;
    Pane pentagramLayout = new Pane();
    boolean answer;

    public Pentagram() {
        graphicInterface();
    }

    private void graphicInterface() {

        Button button1 = new Button("Draw pentagram");
        Button button2 = new Button("Paint pentagram");
        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Red", "Orange", "Yellow", "Green", "LightBlue", "Blue", "Violet");

        Text message1 = new Text();

        button1.setTranslateX(190);
        button1.setTranslateY(10);

        button2.setTranslateX(180);
        button2.setTranslateY(110);

        field1.setPromptText("X coordinate");
        field1.setTranslateX(10);
        field1.setTranslateY(10);

        field2.setPromptText("Y coordinate");
        field2.setTranslateX(10);
        field2.setTranslateY(40);

        field3.setPromptText("Radius");
        field3.setTranslateX(10);
        field3.setTranslateY(70);

        choiceBox.setTranslateX(10);
        choiceBox.setTranslateY(110);

        message1.setX(12);
        message1.setY(165);

        pentagramLayout.getChildren().addAll(button1,button2,field1,field2,field3,choiceBox,message1);

        button1.setOnAction((ActionEvent e) -> {
            if (field1.getText().isEmpty() || field2.getText().isEmpty() || field3.getText().isEmpty())
                alert("Error", "Please input data to all fields!");
            else {
                try {
                    clearLines();
                    message1.setText(null);
                    double n1 = Double.parseDouble(field1.getText());
                    double n2 = Double.parseDouble(field2.getText());
                    double n3 = Double.parseDouble(field3.getText());
                    pentagramLayout.getChildren().addAll(drawPentagram(n1,n2,n3));
                    message1.setText("Pentagram with coordinates x = " + n1 + " , y = " + n2 + ", radius = " + n3 + ".");
                }catch (NumberFormatException e2){
                    alert("Error", "Please input data in number format.");
                }
            }
        });

        button2.setOnAction(e -> {
            if (lines == null) alert("Error", "Draw pentagram first!");
            else if (choiceBox.getValue() != null) paintLines(Color.valueOf(choiceBox.getValue()));
            else alert("Error", "Please input a color.");
        });
    }

    private Line[] drawPentagram(double x0, double y0, double radius) {

        final int n = 5;

        lines = new Line[n*2];

        double angle = 54;
        double fi1 = Math.toRadians(angle);
        double fi2 = Math.toRadians(Math.abs(angle + 180));
        double radiusOuter = radius;
        double radiusInner = (radius * Math.cos(Math.PI / 5 * 2)) / (Math.cos(Math.PI / 5 * (2 - 1)));


        for (int i = 0; i < 5; i++) {
            lines[i] = new Line(
                    Math.round(x0 + radiusOuter * Math.cos(fi1 + 2 * Math.PI * i / n)),
                    Math.round(y0 + radiusOuter * Math.sin(fi1 + 2 * Math.PI * i / n)),
                    Math.round(x0 + radiusInner * Math.cos(fi2 + 2 * Math.PI * (i-3) / n)),
                    Math.round(y0 + radiusInner * Math.sin(fi2 + 2 * Math.PI * (i-3) / n)));
        }

        for (int i = 0; i < 5; i++) {
            lines[i + 5] = new Line(
                    Math.round(x0 + radiusInner * Math.cos(fi2 + 2 * Math.PI * (i-2) / n)),
                    Math.round(y0 + radiusInner * Math.sin(fi2 + 2 * Math.PI * (i-2) / n)),
                    Math.round(x0 + radiusOuter * Math.cos(fi1 + 2 * Math.PI * i / n)),
                    Math.round(y0 + radiusOuter * Math.sin(fi1 + 2 * Math.PI * i / n)));
        }
        return lines;
    }

    private void paintLines(Color color) {
        if (this.lines == null) return;
        for (Line i : lines) {
            i.setStrokeWidth(3);
            i.setStroke(color);
        }
    }

    private void clearLines() {
        if (lines != null && lines.length > 0) {
            pentagramLayout.getChildren().removeAll(lines);
        }
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
            answer = true;
            stage.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
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

        return answer;
    }
}