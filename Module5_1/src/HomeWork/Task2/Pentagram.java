/*
Lesson
 */

package HomeWork.Task2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Pentagram {

    Line[] lines;
    VBox programLayout = new VBox(10);
    Pane pentagramPicture = new Pane();

    boolean answer;

    public Pentagram() {
        graphicInterface();
    }

    private void graphicInterface() {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,10,10,20));
        gridPane.setHgap(20);
        gridPane.setVgap(5);
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints(150);
        column2.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(column1, column2);

        Button button1 = new Button("Draw pentagram");
        Button button2 = new Button("Paint pentagram");
        Label label1 = new Label("X coordinate:");
        Label label2 = new Label("Y coordinate:");
        Label label3 = new Label("Radius:");
        Label label4 = new Label("Color:");
        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        ComboBox<String> comboBox = new ComboBox<>();
        Text message1 = new Text();
        message1.setTranslateX(20);

        comboBox.getItems().addAll("Red", "Orange", "Yellow", "Green", "LightBlue", "Blue", "Violet");
        comboBox.setEditable(true);

        gridPane.add(label1,0,0);
        gridPane.add(label2,0,1);
        gridPane.add(label3,0,2);
        gridPane.add(label4,0,3);
        gridPane.add(field1,1,0);
        gridPane.add(field2,1,1);
        gridPane.add(field3,1,2);
        gridPane.add(comboBox,1,3);

        gridPane.add(button1,2,0);
        gridPane.add(button2,2,3);


        programLayout.getChildren().addAll(gridPane,message1,pentagramPicture);

        button1.setOnAction((ActionEvent e) -> {
            if (field1.getText().isEmpty() || field2.getText().isEmpty() || field3.getText().isEmpty())
                alert("Error", "Please input data to all fields!");
            else {
                try {
                    double n1 = Double.parseDouble(field1.getText());
                    double n2 = Double.parseDouble(field2.getText());
                    double n3 = Double.parseDouble(field3.getText());
                    clearLines();
                    message1.setText(null);
                    pentagramPicture.getChildren().addAll(drawPentagram(n1,n2,n3));
                    message1.setText("Pentagram with coordinates x = " + n1 + " , y = " + n2 + ", radius = " + n3 + ".");
                }catch (NumberFormatException e2){
                    alert("Error", "Please input data in number format.");
                }
            }
        });

        button2.setOnAction(e -> {
            if (lines == null) alert("Error", "Draw pentagram first!");
            else if (comboBox.getValue() != null) {
                try{
                    paintLines(Color.valueOf(comboBox.getValue()));
                }catch(IllegalArgumentException e3) {
                    alert("Error", "Unknown color.");
                }
            }else alert("Error", "Please input a color.");
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
            pentagramPicture.getChildren().removeAll(lines);
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