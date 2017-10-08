package Program;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static Program.Main.*;

public class RequestManyChannels extends RequestOneChannel {
    private int numberOfInputFields;
    Text text1;
    Text text2;
    VBox channelNumbers;
    TextField textField1_1;
    TextField textField2_2;
    VBox channelIdInputFields;

    public RequestManyChannels() {
        super();
        this.numberOfInputFields = 2;
    }

    @Override
    void addInputInterface() {
        text1 = new Text("Channel 1:");
        text2 = new Text("Channel 2:");
        channelNumbers = new VBox(text1,text2);
        channelNumbers.setTranslateY(5);
        channelNumbers.setSpacing(16);

        textField1_1 = new TextField();
        textField1_1.setPromptText("Enter YouTube channel ID:");
        textField1_1.setFocusTraversable(false);
        textField2_2 = new TextField();
        textField2_2.setPromptText("Enter YouTube channel ID:");
        textField2_2.setFocusTraversable(false);
        channelIdInputFields = new VBox(textField1_1,textField2_2);
        channelIdInputFields.setSpacing(5);

        Button addChannelButton = new Button("Add field");
        Button removeChannelButton = new Button("Remove field");
        HBox dataInputButtons = new HBox(15,addChannelButton,removeChannelButton);

        HBox dataInput = new HBox(channelNumbers,channelIdInputFields);
        dataInput.setSpacing(5);

        screen.getChildren().addAll(dataInput,dataInputButtons);

        addChannelButton.setOnAction(e1 -> {
            Text channelNumber = new Text("Channel " + ((numberOfInputFields++) + 1) + ":");
            channelNumbers.getChildren().add(channelNumber);
            TextField channelIdInput = new TextField();
            channelIdInput.setPromptText("Enter YouTube channel ID:");
            channelIdInputFields.getChildren().add(channelIdInput);
        });

        removeChannelButton.setOnAction(e2 -> {
            if (numberOfInputFields > 2) {
                channelNumbers.getChildren().remove(numberOfInputFields-1);
                channelIdInputFields.getChildren().remove(numberOfInputFields-1);
                numberOfInputFields--;
            }
        });

    }

    void reset() {
        channelNumbers.getChildren().clear();
        channelIdInputFields.getChildren().clear();

        textField1_1.clear();
        textField2_2.clear();

        channelNumbers.getChildren().addAll(text1,text2);
        channelIdInputFields.getChildren().addAll(textField1_1, textField2_2);
        numberOfInputFields = 2;
    }

    void generateRequest2() {
        name.setText(nameRequest2);
        description.setText("Shows global information about the list of specified channels.");
    }

    void generateRequest3() {
        name.setText(nameRequest3);
        description.setText("Sorts the list of specified channels and their information by specified parameter.");
    }

    void generateRequest5() {
        name.setText(nameRequest5);
        description.setText("Shows information (including total number of comments) about the list of specified channels.");
    }

    void generateRequest6(){
        name.setText(nameRequest6);
        description.setText("Sorts the list of specified channels and their information by total number of comments.");
    }
}
