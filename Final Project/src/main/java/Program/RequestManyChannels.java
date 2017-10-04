package Program;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RequestManyChannels extends RequestOneChannel {


    public RequestManyChannels(int requestType) {
        super(requestType);
    }

    @Override
    String getInstruction() {
        String instruction = "Please enter IDs of channels from YouTube:";
        return instruction;
    }

    @Override
    void addInputInterface() {
        Text text1 = new Text("OneChannel 1:");
        Text text2 = new Text("OneChannel 2:");
        channelNumbers.getChildren().addAll(text1,text2);
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        channelIdInputFields.getChildren().addAll(textField1,textField2);
        Button addChannelButton = new Button("Add a channel");
        addChannelButton.setOnAction(e -> addInputRow());
        channelRemoveButtons.setTranslateY(50);
        dataInput.getChildren().addAll(channelNumbers,channelIdInputFields,channelRemoveButtons);
        screen.getChildren().addAll(dataInput,addChannelButton);
    }

    void addInputRow() {
        Text channelNumber = new Text();
        channelNumbers.getChildren().add(channelNumber);
        TextField channelIdInput = new TextField();
        channelIdInputFields.getChildren().add(channelIdInput);
        Button removeChannelButton = new Button("Remove");
        removeChannelButton.setOnAction(e -> {
            channelNumbers.getChildren().remove(channelNumber);
            channelIdInputFields.getChildren().removeAll(channelIdInput);
            channelRemoveButtons.getChildren().removeAll(removeChannelButton);
        });
        channelRemoveButtons.getChildren().add(removeChannelButton);
    }


}
