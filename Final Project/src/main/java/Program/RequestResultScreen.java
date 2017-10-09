package Program;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class RequestResultScreen extends RequestScreen {

    public static final ObservableList<Channel> data = FXCollections.observableArrayList();

    public RequestResultScreen() {
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
