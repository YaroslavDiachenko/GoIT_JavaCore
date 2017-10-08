package Program;


import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.*;

import static Program.Main.*;

public class ProgramSettings extends GeneralScreen {

    private RadioButton option1ButtonYes;
    private RadioButton option1ButtonNo;
    private ToggleGroup option1ToggleGroup;
    private Text option2CurrentSavePath;
    private ToggleGroup option3ToggleGroup;
    private RadioButton option3ButtonYes;
    private RadioButton option3ButtonNo;
    private TitledPane option1;
    private TitledPane option2;
    private TitledPane option3;

    // settings parameters
    boolean useCache;
    boolean showExecutionTime;
    String cacheFilePath;
    String savedSettingsPath;

    public ProgramSettings() {
/*
        useCache = false;
        showExecutionTime = false;
        cacheFilePath = "/Users/test/IdeaProjects/GoIT_JavaCore/Final Project/files/file1.txt";
*/
        savedSettingsPath = "/Users/test/IdeaProjects/GoIT_JavaCore/Final Project/files/settings.txt";
        downloadSavedSettings();

        addSettingsInterface();
    }

    void addSettingsInterface() {
        Text title = new Text("Settings");

        Text option1Text = new Text("Save cash?");
        option1ToggleGroup = new ToggleGroup();
        option1ButtonYes = new RadioButton("Yes");
        option1ButtonYes.setToggleGroup(option1ToggleGroup);
        option1ButtonNo = new RadioButton("No");
        option1ButtonNo.setToggleGroup(option1ToggleGroup);
        Button option1SaveButton = new Button("Save");
        option1SaveButton.setOnAction(e -> {
            useCache = option1ButtonYes.isSelected();
            if (!useCache) writeCacheToFile("");
            alert("Use cache", useCache ? "Cache enabled." : "Cache disabled.");
        });
        option1 = new TitledPane("Cash saving",new VBox(5,option1Text, option1ButtonYes, option1ButtonNo,option1SaveButton));

        Text option2Text = new Text("Current location of cache file:");
        option2CurrentSavePath = new Text(cacheFilePath);
        TextField option2NewSavePath = new TextField();
        option2NewSavePath.setPromptText("Enter new path...");
        option2NewSavePath.setFocusTraversable(false);
        Button option2SaveButton = new Button("Save");
        option2 = new TitledPane("Cash save path",new VBox(5,option2Text,option2CurrentSavePath,option2NewSavePath,option2SaveButton));
        option2.setExpanded(false);

        Text option3Text = new Text("Show execution time spent?");
        option3ToggleGroup = new ToggleGroup();
        option3ButtonYes = new RadioButton("Yes");
        option3ButtonYes.setToggleGroup(option3ToggleGroup);
        option3ButtonNo = new RadioButton("No");
        option3ButtonNo.setToggleGroup(option3ToggleGroup);
        Button option3SaveButton = new Button("Save");
        option3SaveButton.setOnAction(e -> {
            showExecutionTime = option3ButtonYes.isSelected();
            alert("Execution time spent", useCache ? "Execution time spent enabled." : "Execution time spent disabled.");

        });
        option3 = new TitledPane("Execution time spent",new VBox(5,option3Text, option3ButtonYes, option3ButtonNo,option3SaveButton));
        option3.setExpanded(false);

        screen.getChildren().addAll(title, option1, option2,option3);
    }

    void update() {
        option1ToggleGroup.selectToggle(useCache ? programSettings.option1ButtonYes : programSettings.option1ButtonNo);
        option3ToggleGroup.selectToggle(showExecutionTime ? programSettings.option3ButtonYes : programSettings.option3ButtonNo);
        option2CurrentSavePath.setText(cacheFilePath);
        option1.setExpanded(false);
        option2.setExpanded(false);
        option3.setExpanded(false);
    }

    void downloadSavedSettings() {
        try (BufferedReader br = new BufferedReader(new FileReader(savedSettingsPath))) {
            useCache = br.readLine().equals("true");
            cacheFilePath = br.readLine();
            showExecutionTime = br.readLine().equals("true");
        } catch (IOException e) {
            alert("IOException thrown","Cannot download from file saved settings.");
        }
    }

    void saveSettings() {
        try {
            File file = new File(savedSettingsPath);
            FileWriter writer = new FileWriter(file);
            writer.write((useCache ? "true" : "false") + "\n");
            writer.write(cacheFilePath + "\n");
            writer.write(showExecutionTime ? "true" : "false");
            writer.flush();
        } catch (Exception e){
            alert("Exception thrown","Settings file not found.");
        }
    }
}
