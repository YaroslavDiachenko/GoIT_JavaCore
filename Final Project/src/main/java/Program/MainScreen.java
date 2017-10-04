package Program;


import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.youTubeAnalytics.screen);
        });
        Hyperlink hyperlinkSettings = new Hyperlink("ProgramSettings");
        hyperlinkSettings.setFocusTraversable(false);
        hyperlinkSettings.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.programSettings.screen);
        });
        screen.getChildren().addAll(hello, version, hyperlinkYouTubeAnalytics, hyperlinkSettings);
    }

}
