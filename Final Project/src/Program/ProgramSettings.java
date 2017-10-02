package Program;


import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;

public class ProgramSettings extends GeneralScreen {

    public ProgramSettings() {
        addSettingsInterface();
    }

    void addSettingsInterface() {
        Text title = new Text("Settings");

        Text tex1 = new Text("Test1");
        TitledPane option1 = new TitledPane("Use cash",tex1);
        Text tex2 = new Text("Test1");
        TitledPane option2 = new TitledPane("Use cash",tex2);
        screen.getChildren().addAll(title, option1, option2);

    }
}
