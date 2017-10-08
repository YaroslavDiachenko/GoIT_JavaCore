package Program;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class RequestScreen {
    public Button buttonBackAnalyticsScreen;
    public VBox screen;

    public RequestScreen() {
        screen = new VBox();
        graphicInterface();
        addButtonBackAnalyticsScreen();
    }

    void graphicInterface() {
        screen.setSpacing(5);
        screen.setPadding(new Insets(10));
    }

    void addButtonBackAnalyticsScreen() {
        buttonBackAnalyticsScreen = new Button();
        buttonBackAnalyticsScreen.setText("Back to YouTube Analytics");
        buttonBackAnalyticsScreen.setFocusTraversable(false);
        buttonBackAnalyticsScreen.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.youTubeAnalytics.screen);
        });
        screen.getChildren().add(buttonBackAnalyticsScreen);
    }
}
