package Program;


import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class RequestResultScreenExt extends RequestResultScreen {
    public RequestResultScreenExt() {
        super();
        addCommentsColumn();
    }

    void addCommentsColumn() {
        TableColumn column6 = new TableColumn("Comments");
        column6.setCellValueFactory(new PropertyValueFactory<ChannelData,Integer>("numberOfComments"));
        table.getColumns().add(column6);
    }
}
