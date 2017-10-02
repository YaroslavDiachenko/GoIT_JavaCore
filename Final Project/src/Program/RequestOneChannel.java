package Program;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static Program.Main.pane;
import static Program.Main.request1;

public class RequestOneChannel extends RequestScreen {

    VBox channelNumbers = new VBox();
    VBox channelIdInputFields = new VBox();
    VBox channelRemoveButtons = new VBox();
    HBox dataInput = new HBox();

    public RequestOneChannel(String requestName, String resultDescription) {
        addInterface(requestName,resultDescription);
    }

    void addInterface(String requestName, String resultDescription) {
        Text name = new Text(requestName);
        Text description = new Text(resultDescription);
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
            pane.getChildren().clear();
            pane.getChildren().add(Main.resultScreen.screen);
        });
        screen.getChildren().addAll(textField1, submitButton);
    }
}
