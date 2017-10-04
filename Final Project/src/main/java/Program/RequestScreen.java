package Program;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class RequestScreen {
    VBox screen = new VBox();

    public RequestScreen() {
        graphicInterface();
        addButtonBackAnalyticsScreen();
    }

    void graphicInterface() {
        screen.setPadding(new Insets(10));
    }

    void addButtonBackAnalyticsScreen() {
        Button buttonBackAnalyticsScreen = new Button("Back to YouTube Analytics");
        buttonBackAnalyticsScreen.setFocusTraversable(false);
        buttonBackAnalyticsScreen.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.youTubeAnalytics.screen);
        });
        screen.getChildren().add(buttonBackAnalyticsScreen);
    }

}
