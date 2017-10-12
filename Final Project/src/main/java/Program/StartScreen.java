package Program;


import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import static Program.Main.*;

public class StartScreen {
    VBox layout;

    public StartScreen() {
        layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);

        Text hello = new Text("Welcome to YouTube Analytics!");
        Text version = new Text("YouTube Analytics program v1.0");
        Hyperlink hyperlinkYouTubeAnalytics = new Hyperlink("YouTube Analytics");
        hyperlinkYouTubeAnalytics.setFocusTraversable(false);
        hyperlinkYouTubeAnalytics.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(mainScreen.layout);
        });
        Hyperlink hyperlinkSettings = new Hyperlink("SettingsScreen");
        hyperlinkSettings.setFocusTraversable(false);
        hyperlinkSettings.setOnAction(event -> {
            settingsScreen.updateSettings();
            pane.getChildren().clear();
            pane.getChildren().add(settingsScreen.layout);
        });
        layout.getChildren().addAll(hello, version, hyperlinkYouTubeAnalytics, hyperlinkSettings);
    }
}
