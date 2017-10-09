package Program;


import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import static Program.Main.*;

public class MainScreen {
    VBox screen = new VBox();

    public MainScreen() {
        graphicInterface();
    }

    void graphicInterface() {
        screen.setPadding(new Insets(10));
        Text hello = new Text("Welcome to YuTube Analytics!");
        Text version = new Text("YouTube Analytics program v1.0");
        Hyperlink hyperlinkYouTubeAnalytics = new Hyperlink("YouTube Analytics");
        hyperlinkYouTubeAnalytics.setFocusTraversable(false);
        hyperlinkYouTubeAnalytics.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(youTubeAnalytics.screen);
        });
        Hyperlink hyperlinkSettings = new Hyperlink("ProgramSettings");
        hyperlinkSettings.setFocusTraversable(false);
        hyperlinkSettings.setOnAction(event -> {
            programSettings.updateSettings();
            pane.getChildren().clear();
            pane.getChildren().add(programSettings.screen);
        });
        screen.getChildren().addAll(hello, version, hyperlinkYouTubeAnalytics, hyperlinkSettings);
    }

}
