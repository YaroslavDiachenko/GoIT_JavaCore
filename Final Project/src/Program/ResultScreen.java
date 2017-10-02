package Program;


import YouTubeData.Channel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ResultScreen extends RequestScreen {

    private final ObservableList<Channel> data = FXCollections.observableArrayList(
            new Channel("Test1",5,10,15,20,25),
            new Channel("Test2",3,10,16,14,12),
            new Channel("Test3",7,10,17,3,34),
            new Channel("Test4",1,10,18,90,7)
    );

    public ResultScreen() {
        addInterface();
    }

    void addInterface() {
        Text title = new Text("Table test");

        TableView<Channel> table = new TableView<>();
        TableColumn column1 = new TableColumn("Channel name");
        column1.setCellValueFactory(new PropertyValueFactory<Channel,String>("channelName"));

        TableColumn column2 = new TableColumn("Creation date");
        column2.setCellValueFactory(new PropertyValueFactory<Channel,Integer>("dateOfCreation"));

        TableColumn column3 = new TableColumn("Subscribers");
        column3.setCellValueFactory(new PropertyValueFactory<Channel,Integer>("numberOfSubscribers"));

        TableColumn column4 = new TableColumn("Videos");
        column4.setCellValueFactory(new PropertyValueFactory<Channel,Integer>("numberOfVideos"));

        TableColumn column5 = new TableColumn("Views");
        column5.setCellValueFactory(new PropertyValueFactory<Channel,Integer>("numberOfViews"));

        TableColumn column6 = new TableColumn("Comments");
        column6.setCellValueFactory(new PropertyValueFactory<Channel,Integer>("numberOfComments"));

        table.setItems(data);
        table.getColumns().addAll(column1,column2,column3,column4,column5,column6);
        screen.setSpacing(5);
        screen.setPadding(new Insets(10, 0, 0, 10));
        screen.getChildren().addAll(title,table);
    }
}
