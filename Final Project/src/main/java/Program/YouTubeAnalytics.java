package Program;


import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import static Program.Main.*;

public class YouTubeAnalytics extends GeneralScreen {

    public YouTubeAnalytics() {
        addAnalyticsInterface();
    }

    void addAnalyticsInterface() {
        Text title = new Text("YouTube Analytics");
        Text text = new Text("Choose task:");
        Hyperlink hyperlinkRequest1 = new Hyperlink(nameRequest1);
        hyperlinkRequest1.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.request1.screen);
        });
        Hyperlink hyperlinkRequest2 = new Hyperlink(nameRequest2);
        hyperlinkRequest2.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.request2.screen);
        });
        Hyperlink hyperlinkRequest3 = new Hyperlink(nameRequest3);
        hyperlinkRequest3.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.request3.screen);
        });
        Hyperlink hyperlinkRequest4 = new Hyperlink(nameRequest4);
        hyperlinkRequest4.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.request4.screen);
        });
        Hyperlink hyperlinkRequest5 = new Hyperlink(nameRequest5);
        hyperlinkRequest5.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.request5.screen);
        });
        Hyperlink hyperlinkRequest6 = new Hyperlink(nameRequest6);
        hyperlinkRequest6.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(Main.request6.screen);
        });
        screen.getChildren().addAll(title, text, hyperlinkRequest1, hyperlinkRequest2, hyperlinkRequest3, hyperlinkRequest4, hyperlinkRequest5, hyperlinkRequest6);
    }
}
