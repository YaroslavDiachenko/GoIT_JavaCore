package Program;


import YouTubeData_Channels.Request1;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import static Program.Main.*;

public class RequestOneChannel extends RequestScreen {

    Text name;
    Text description;
    Button submitButton;

    public RequestOneChannel() {
        super();
        name = new Text();
        description = new Text();

        addInterface();
        addInputInterface();
    }

    void addInterface() {
        screen.getChildren().addAll(name, description);
    }

    void addInputInterface() {
        TextField textField1 = new TextField();
        textField1.setFocusTraversable(false);
        submitButton = new Button("Submit");
        textField1.setPromptText("Enter YouTube channel ID:");
        screen.getChildren().addAll(textField1, submitButton);

        submitButton.setOnAction((ActionEvent e) -> {
            Channel channel = null;
            String path = textField1.getText();
            try {
                if (programSettings.useCache) {
                    String readString = readFileToString();
                    if (readString != null && !"".equals(readString)) {
                        channel = new Channel(convertStringToChannel(readString));
                    }else {
                        String jsonString = Request1.getChannelDataAsString(path);
                        writeCacheToFile(jsonString);
                        channel = new Channel(convertStringToChannel(jsonString));
                    }
                }else {
                    channel = new Channel(Request1.getYouTubeChannelAsObject(path));
                }
            }catch (UnirestException e2) {
                alert("Error","Invalid link(s)");
            }
            RequestResultScreen.data.clear();
            RequestResultScreen.data.add(channel);
            pane.getChildren().clear();
            pane.getChildren().add(resultScreen.screen);

        });
    }

    void generateRequest1() {
        name.setText(nameRequest1);
        description.setText("Shows global information about a channel.");
    }

    void generateRequest4() {
        name.setText(nameRequest4);
        description.setText("Shows information (including total number of comments) about a channel.");
    }
}
