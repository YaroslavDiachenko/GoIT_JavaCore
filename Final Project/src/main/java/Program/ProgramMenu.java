package Program;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import static Program.Main.*;

public class ProgramMenu {
    static MenuBar menuBar = new MenuBar();

    public ProgramMenu() {
        graphicInterface();
    }

    void graphicInterface() {
        Menu menuFile = new Menu("Go to");
        Menu fileMenuAnalytics = new Menu("YouTube Analytics");
        MenuItem menuItemRequest1 = new MenuItem(nameRequest1);
        menuItemRequest1.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(request1.screen);
        });
        MenuItem menuItemRequest2 = new MenuItem(nameRequest2);
        menuItemRequest2.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(request2.screen);
        });
        MenuItem menuItemRequest3 = new MenuItem(nameRequest3);
        menuItemRequest3.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(request3.screen);
        });
        MenuItem menuItemRequest4 = new MenuItem(nameRequest4);
        menuItemRequest4.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(request4.screen);
        });
        MenuItem menuItemRequest5 = new MenuItem(nameRequest5);
        menuItemRequest5.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(request5.screen);
        });
        MenuItem menuItemRequest6 = new MenuItem(nameRequest6);
        menuItemRequest6.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(request6.screen);
        });
        fileMenuAnalytics.getItems().addAll(menuItemRequest1, menuItemRequest2, menuItemRequest3, menuItemRequest4, menuItemRequest5, menuItemRequest6);
        MenuItem fileMenuSettings = new MenuItem("Settings");
        fileMenuSettings.setOnAction(event -> {
            pane.getChildren().clear();
            pane.getChildren().add(programSettings.screen);
        });
        menuFile.getItems().addAll(fileMenuAnalytics,fileMenuSettings);
        Menu menuEdit = new Menu("Other");
        menuBar.getMenus().addAll(menuFile, menuEdit);
    }
}
