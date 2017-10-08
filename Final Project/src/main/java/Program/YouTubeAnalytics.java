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
        Hyperlink hyperlinkRequest2 = new Hyperlink(nameRequest2);
        Hyperlink hyperlinkRequest3 = new Hyperlink(nameRequest3);
        Hyperlink hyperlinkRequest4 = new Hyperlink(nameRequest4);
        Hyperlink hyperlinkRequest5 = new Hyperlink(nameRequest5);
        Hyperlink hyperlinkRequest6 = new Hyperlink(nameRequest6);
        screen.getChildren().addAll(title, text, hyperlinkRequest1, hyperlinkRequest2, hyperlinkRequest3, hyperlinkRequest4, hyperlinkRequest5, hyperlinkRequest6);

        hyperlinkRequest1.setOnAction(event -> {
            pane.getChildren().clear();
            requestOneChannel.generateRequest1();
            pane.getChildren().add(requestOneChannel.screen);
        });
        hyperlinkRequest2.setOnAction(event -> {
            pane.getChildren().clear();
            requestManyChannels.generateRequest2();
            requestManyChannels.reset();
            pane.getChildren().add(requestManyChannels.screen);
        });
        hyperlinkRequest3.setOnAction(event -> {
            pane.getChildren().clear();
            requestManyChannels.generateRequest3();
            requestManyChannels.reset();
            pane.getChildren().add(requestManyChannels.screen);
        });
        hyperlinkRequest4.setOnAction(event -> {
            pane.getChildren().clear();
            requestOneChannel.generateRequest4();
            pane.getChildren().add(requestOneChannel.screen);
        });
        hyperlinkRequest5.setOnAction(event -> {
            pane.getChildren().clear();
            requestManyChannels.generateRequest5();
            requestManyChannels.reset();
            pane.getChildren().add(requestManyChannels.screen);
        });
        hyperlinkRequest6.setOnAction(event -> {
            pane.getChildren().clear();
            requestManyChannels.generateRequest6();
            requestManyChannels.reset();
            pane.getChildren().add(requestManyChannels.screen);
        });
    }
}
