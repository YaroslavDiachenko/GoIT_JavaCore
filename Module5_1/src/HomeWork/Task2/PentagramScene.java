/*
Lesson
 */

package HomeWork.Task2;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PentagramScene {

    Line[] lines;
    Pane root = new Pane();


    public PentagramScene(Stage primaryStage) {
        graphicInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void graphicInterface() {

        Button button1 = new Button("Draw pentagram");
        Button button2 = new Button("Paint pentagram");

        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field4 = new TextField ();

        Text message1 = new Text();
        Text message2 = new Text();

        button1.setTranslateX(180);
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

        field4.setPromptText("Color");
        field4.setTranslateX(10);
        field4.setTranslateY(110);

        message1.setFont(Font.font ("Times New Roman", 16));
        message1.setX(12);
        message1.setY(165);

        message2.setFont(Font.font ("Times New Roman", 16));
        message2.setX(12);
        message2.setY(185);

        root.getChildren().addAll(button1,button2,field1,field2,field3,field4,message1,message2);

        button1.setOnAction((ActionEvent e) -> {
            clearLines();
            message1.setText("");
            message2.setText("");
            if (field1.getText().isEmpty() || field2.getText().isEmpty() || field3.getText().isEmpty())
                message1.setText("Please input data to all fields!");
            else {
                try {
                    double n1 = Double.parseDouble(field1.getText());
                    double n2 = Double.parseDouble(field2.getText());
                    double n3 = Double.parseDouble(field3.getText());
                    root.getChildren().addAll(drawPentagram(n1,n2,n3));
                    message1.setText("Pentagram with coordinates x: " + n1 + " , y: " + n2 + " and radius: " + n3 + ".");
                }catch (NumberFormatException e2){
                    message1.setText("Incorrect! Please input data in number format.");
                }
            }
        });

        button2.setOnAction((ActionEvent e) -> {
            if (lines == null) message2.setText("Draw snowman first!");
            else if (!field4.getText().isEmpty()) {
                String s4 = field4.getText();

                try{
                    paintLines(Color.valueOf(s4.toUpperCase()));
                }catch(IllegalArgumentException e3) {
                    message2.setText("Unknown color");
                }
            }
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
            root.getChildren().removeAll(lines);
        }
    }

}

