package Program;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class DataInputRow extends HBox{
    Text channelNumber = new Text("Channel :");
    TextField channelIdInputField = new TextField("Test");
    Button removeRowButton = new Button("Remove");

    public DataInputRow() {
        this.getChildren().addAll(channelNumber, channelIdInputField, removeRowButton);
    }
}
