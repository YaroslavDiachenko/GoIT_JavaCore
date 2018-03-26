

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**

    Main borderPane (Border Pane):

     -----------------------
    |          TOP          |
     -----------------------
    |      |        |       |
    | LEFT | CENTER | RIGHT |
    |      |        |       |
     -----------------------
    |        BOTTOM         |
     -----------------------

    Top:    Title
    Left:   Labels
    Center: Text fields
    Right:  Buttons
    Bottom: Status and progress bar

     **/

public class Task4 extends Application {

    private BorderPane borderPane;

    private Button button_load;
    private Button button_fibonacci;
    private Button button_save;
    private Button button_cancel;

    private TextField textfield_filepath;
    private TextField textfield_number;
    private TextArea textArea;

    private final int coresNumber = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor = Executors.newFixedThreadPool(coresNumber);

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setInterface();
        configureEvents();

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            boolean answer = confirm("Closing program", "Are you sure you want close the program?");
            if (answer) {
                executor.shutdown();
                primaryStage.close();
            }
        });
    }

    private void setInterface() {
        borderPane = new BorderPane();

        VBox top = new VBox();
        VBox left = new VBox();
        VBox center = new VBox();
        VBox right = new VBox();
        HBox bottom = new HBox();

        // top:
        Text title = new Text();
        title.setText("Welcome to text editor!");
        title.setFill(Color.DIMGREY);
        top.setPadding(new Insets(15));
        top.setStyle("-fx-background-color: GAINSBORO");
        top.getChildren().add(title);
        borderPane.setTop(top);

        // left:
        Text label1 = new Text("Link:");
        Text label2 = new Text("X Number:");
        Text label3 = new Text("Text area:");
        left.getChildren().addAll(label1, label2, label3);
        left.setPadding(new Insets(20,5,20,10));
        left.setSpacing(15);
        left.setTranslateY(5);
        left.setAlignment(Pos.TOP_RIGHT);
        borderPane.setLeft(left);

        // center:
        textfield_filepath = new TextField("files/texteditor.txt");
        textfield_filepath.setFocusTraversable(false);
        textfield_number = new TextField();
        textfield_number.setFocusTraversable(false);
        textArea = new TextArea();
        textArea.setFocusTraversable(false);
        textArea.setWrapText(true);
        textArea.setMinHeight(200);
        center.setPrefWidth(400);
        center.getChildren().addAll(textfield_filepath,textfield_number,textArea);
        center.setPadding(new Insets(20,5,20,5));
        center.setSpacing(5);
        borderPane.setCenter(center);

        // right:
        button_load = new Button("Load");
        button_fibonacci = new Button("Fibonacci");
        button_save = new Button("Save");
        button_cancel = new Button("Cancel");
        right.getChildren().addAll(button_load, button_fibonacci, button_save, button_cancel);
        right.setPadding(new Insets(20,10,20,5));
        right.setSpacing(5);
        borderPane.setRight(right);

        // bottom:
        Text label = new Text("Progress bar:");
        label.setFill(Color.DIMGREY);
        Text status = new Text("Unknown");
        status.setFill(Color.GREY);
        StackPane stackPane = new StackPane();
        ProgressBar progressBar = new ProgressBar();
        Text progress = new Text("Loading");
        progress.setFill(Color.GREY);
        stackPane.getChildren().addAll(progressBar,progress);
        bottom.setStyle("-fx-background-color: LiGHTGREY");
        bottom.getChildren().addAll(label,status,stackPane);
        bottom.setPadding(new Insets(10));
        bottom.setSpacing(10);
        borderPane.setBottom(bottom);
    }

    private void configureEvents() {
        button_load.setOnMouseClicked(event -> {
            if (textfield_filepath.getText().isEmpty())
                alert("Error", "Please input path to file.");
            else {
                String filePath = textfield_filepath.getText();
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    textArea.clear();
                    String line;
                    while ((line = br.readLine()) != null) {
                        textArea.appendText(line + "\n");
                    }
                } catch (FileNotFoundException e) {
                    alert("Error","File not found.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        button_fibonacci.setOnMouseClicked(event -> executor.submit(() -> Platform.runLater(() -> {
            try {
                int n = Integer.parseInt(textfield_number.getText());
                StringBuilder stringBuilder = new StringBuilder();
                BigInteger t1 = BigInteger.valueOf(0);
                BigInteger t2 = BigInteger.valueOf(1);
                for (int i = 1; i <= n; ++i) {
                    stringBuilder.append(String.valueOf(t1));
                    if (i != n) stringBuilder.append(" + ");
                    BigInteger sum = t1.add(t2);
                    t1 = t2;
                    t2 = sum;
                }
                Thread.sleep(3000);

                FileWriter writer = new FileWriter(textfield_filepath.getText());
                writer.write(stringBuilder.toString());
                writer.flush();
                alert("Saving","Data has been successfully saved.");
            }catch (NumberFormatException e) {
                alert("Invalid number","Please input valid number");
            }catch (Exception e){
                alert("Error","Cannot write data to file.");
            }
        })));

        button_save.setOnMouseClicked(event -> {
            try {
                String string = textArea.getText();
                FileWriter writer = new FileWriter(textfield_filepath.getText());
                writer.write(string);
                writer.flush();
                textArea.setText(null);
                alert("Saving","Data has been successfully saved.");
            } catch (Exception e){
                alert("Error","Cannot write data to file.");
            }
        });

        button_cancel.setOnMouseClicked(event -> {
        });
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    private void alert(String title, String message) {
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

    private boolean confirm(String title, String message) {
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
}
