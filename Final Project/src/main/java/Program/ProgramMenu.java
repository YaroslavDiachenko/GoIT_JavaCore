package Program;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import static Program.Main.*;

public class ProgramMenu{
    MenuBar menuBar;

    public ProgramMenu() {
        menuBar = new MenuBar();
        graphicInterface();
    }

    void graphicInterface() {
        Menu menuFile = new Menu("Go to");

            Menu fileMenuAnalytics = new Menu("YouTube Analytics");
            MenuItem menuItemRequest1 = new MenuItem(nameRequest1);
            MenuItem menuItemRequest2 = new MenuItem(nameRequest2);
            MenuItem menuItemRequest3 = new MenuItem(nameRequest3);
            MenuItem menuItemRequest4 = new MenuItem(nameRequest4);
            MenuItem menuItemRequest5 = new MenuItem(nameRequest5);
            MenuItem menuItemRequest6 = new MenuItem(nameRequest6);
            fileMenuAnalytics.getItems().addAll(menuItemRequest1, menuItemRequest2, menuItemRequest3, menuItemRequest4, menuItemRequest5, menuItemRequest6);

            menuItemRequest1.setOnAction(event -> {
                pane.getChildren().clear();
                requestOneChannel.generateRequest1();
                pane.getChildren().add(requestOneChannel.screen);
            });
            menuItemRequest2.setOnAction(event -> {
                pane.getChildren().clear();
                requestManyChannels.generateRequest2();
                pane.getChildren().add(requestManyChannels.screen);
            });
            menuItemRequest3.setOnAction(event -> {
                pane.getChildren().clear();
                requestManyChannels.generateRequest3();
                pane.getChildren().add(requestManyChannels.screen);
            });
            menuItemRequest4.setOnAction(event -> {
                pane.getChildren().clear();
                requestOneChannel.generateRequest4();
                pane.getChildren().add(requestOneChannel.screen);
            });
            menuItemRequest5.setOnAction(event -> {
                pane.getChildren().clear();
                requestManyChannels.generateRequest5();
                pane.getChildren().add(requestManyChannels.screen);
            });
            menuItemRequest6.setOnAction(event -> {
                pane.getChildren().clear();
                requestManyChannels.generateRequest6();
                pane.getChildren().add(requestManyChannels.screen);
            });

            MenuItem fileMenuSettings = new MenuItem("Settings");
            fileMenuSettings.setOnAction(event -> {
                programSettings.updateSettings();
                pane.getChildren().clear();
                pane.getChildren().add(programSettings.screen);
            });
            menuFile.getItems().addAll(fileMenuAnalytics,fileMenuSettings);

        Menu menuEdit = new Menu("Edit");
        menuBar.getMenus().addAll(menuFile, menuEdit);
    }
}
