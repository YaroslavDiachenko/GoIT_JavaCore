package Program;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RequestResultScreen extends RequestScreen {

    static final ObservableList<ChannelData> data = FXCollections.observableArrayList();
    VBox layout;

    TableView<ChannelData> table;
    TableColumn column1;
    TableColumn column2;
    TableColumn column3;
    TableColumn column4;
    TableColumn column5;

    public RequestResultScreen() {
        layout = new VBox();
        layout.setSpacing(10);

        Text title = new Text("Table test");
        table = new TableView<>();
        addColumns();
        table.setItems(data);
        table.getColumns().addAll(column1,column2,column3,column4,column5);
//        column3.setSortType(TableColumn.SortType.ASCENDING);
//        table.getSortOrder().clear();
//        table.getSortOrder().add(column3);
        layout.setSpacing(5);
        layout.setPadding(new Insets(10, 0, 0, 10));
        layout.getChildren().addAll(title,table);
    }

    void addColumns() {
        column1 = new TableColumn("ChannelData requestName");
        column1.setCellValueFactory(new PropertyValueFactory<ChannelData,String>("channelName"));

        column2 = new TableColumn("Creation date");
        column2.setCellValueFactory(new PropertyValueFactory<ChannelData,Integer>("dateOfCreation"));

        column3 = new TableColumn("Subscribers");
        column3.setCellValueFactory(new PropertyValueFactory<ChannelData,Integer>("numberOfSubscribers"));

        column4 = new TableColumn("Videos");
        column4.setCellValueFactory(new PropertyValueFactory<ChannelData,Integer>("numberOfVideos"));

        column5 = new TableColumn("Views");
        column5.setCellValueFactory(new PropertyValueFactory<ChannelData,Integer>("numberOfViews"));
    }
}
