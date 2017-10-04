package Program;


import YouTubeData.Request;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import static Program.Main.*;

public class RequestOneChannel extends RequestScreen {

    VBox channelNumbers = new VBox();
    VBox channelIdInputFields = new VBox();
    VBox channelRemoveButtons = new VBox();
    HBox dataInput = new HBox();
    int requestType;

    public RequestOneChannel(int requestType) {
        this.requestType = requestType;
        addInterface(requestType);
    }

    void addInterface(int requestType) {
        Text name = new Text();
        Text description = new Text();
        switch (requestType) {
            case 1:
                name.setText(nameRequest1);
                description.setText("Shows global information about a channel.");
                break;
            case 2:
                name.setText(nameRequest2);
                description.setText("Compares global information of two channels.");
                break;
            case 3:
                name.setText(nameRequest3);
                description.setText("Sorts all channels by their data.");
                break;
            case 4:
                name.setText(nameRequest4);
                description.setText("Shows total number of channel's comments.");
                break;
            case 5:
                name.setText(nameRequest5);
                description.setText("Compares total number of two channels' comments.");
                break;
            case 6:
                name.setText(nameRequest6);
                description.setText("Sorts channels by their total number of comments.");
                break;
        }
        Text inputInstruction = new Text(getInstruction());
        screen.getChildren().addAll(name, description, inputInstruction);
        addInputInterface();
    }

    String getInstruction() {
        String instruction = "Please enter ID of any channel from YouTube:";
        return instruction;
    }

    void addInputInterface() {
        TextField textField1 = new TextField();
        textField1.setPromptText("Enter channel ID:");
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            try {
                Channel channel = new Channel(Request.requestYouTubeChannel(textField1.getText()));
                RequestResultScreen.data.clear();
                RequestResultScreen.data.add(channel);
                pane.getChildren().clear();
                pane.getChildren().add(resultScreen.screen);
            } catch (UnirestException e1) {
                System.out.println("Error");
            }
        });
        screen.getChildren().addAll(textField1, submitButton);
    }
}
