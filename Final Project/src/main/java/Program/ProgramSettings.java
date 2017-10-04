package Program;


import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ProgramSettings extends GeneralScreen {

    public ProgramSettings() {
        addSettingsInterface();
    }

    void addSettingsInterface() {
        Text title = new Text("Settings");

        Text option1Text = new Text("Save cash?");
        ToggleGroup option1Group = new ToggleGroup();
        RadioButton option1YesButton = new RadioButton("Yes");
        option1YesButton.setToggleGroup(option1Group);
        RadioButton option1NoButton2 = new RadioButton("No");
        option1NoButton2.setToggleGroup(option1Group);
        Button option1SaveButton = new Button("Save");
        TitledPane option1 = new TitledPane("Cash saving",new VBox(option1Text,option1YesButton,option1NoButton2,option1SaveButton));
        option1.setExpanded(false);

        Text option2Text = new Text("Current save path");
        Text option2CurrentSavePath = new Text("current_path");
        TextField option2NewSavePath = new TextField();
        Button option2SaveButton = new Button("Save");
        TitledPane option2 = new TitledPane("Cash save path",new VBox(option2Text,option2CurrentSavePath,option2NewSavePath,option2SaveButton));
        option2.setExpanded(false);

        Text option3Text = new Text("Show execution time spent?");
        ToggleGroup option3Group = new ToggleGroup();
        RadioButton option3YesButton = new RadioButton("Yes");
        option3YesButton.setToggleGroup(option3Group);
        RadioButton option3NoButton2 = new RadioButton("No");
        option3NoButton2.setToggleGroup(option3Group);
        Button option3SaveButton = new Button("Save");
        TitledPane option3 = new TitledPane("Execution time spent",new VBox(option3Text,option3YesButton,option3NoButton2,option3SaveButton));
        option3.setExpanded(false);

        screen.getChildren().addAll(title, option1, option2,option3);
    }
}
