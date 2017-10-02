package Program;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import static Program.Main.mainScreen;

public class GeneralScreen {
    VBox screen = new VBox();

    public GeneralScreen() {
        graphicInterface();
        addButtonBackMainScreen();
    }

    void graphicInterface() {
        screen.setPadding(new Insets(10));
    }

    void addButtonBackMainScreen() {
        Button buttonBackMainScreen = new Button("Back to main screen");
        buttonBackMainScreen.setFocusTraversable(false);
        buttonBackMainScreen.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(mainScreen.screen);
        });
        screen.getChildren().add(buttonBackMainScreen);
    }
}
