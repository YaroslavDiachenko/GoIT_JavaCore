package HomeWork;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Task3 extends Application {

    static List<URL> links = new ArrayList<>();
    VBox mainLayout = new VBox();
    HBox buttons = new HBox();
    GridPane gridPane = new GridPane();

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button1 = new Button("Reload");
        buttons.setPadding(new Insets(10));

        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        String filePath = "/Users/test/IdeaProjects/GoIT_JavaCore/Module8_2/files/cars.txt";
        getLinksFromFile(filePath);
        generateImages();

        button1.setOnMouseClicked(event -> {
            gridPane.getChildren().clear();
            generateImages();
        });

        buttons.getChildren().add(button1);
        mainLayout.getChildren().addAll(buttons,gridPane);

        primaryStage.setScene(new Scene(mainLayout));
        primaryStage.show();
    }

    void getLinksFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String link;
            while ((link = br.readLine()) != null) {
                URL url = new URL(link);
                links.add(url);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    void generateImages() {
        int row = 0;
        int column = 0;
        for (int i = 0; i < 9; i++) {
            try {
                Image image = new Image(links.get(randomInteger(0, links.size() - 1)).openStream());
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(200);
                imageView.setFitWidth(200);
                ProgressBar progressBar = new ProgressBar(0);
                StackPane pane = new StackPane();
                pane.getChildren().add(imageView);
                pane.getChildren().add(progressBar);

                progressBar.progressProperty().bind(image.progressProperty());
                image.progressProperty().addListener((observable) -> {
                    if (progressBar.getProgress() == 1.0) {
                        pane.getChildren().remove(progressBar);
                    }
                });
                gridPane.add(pane,column,row);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (++column > 2) {
                column = 0;
                row++;
            }
        }
    }

    int randomInteger(int min,int max) {
        return (int) (Math.round(Math.random() * (max - min) + min));
    }
}
