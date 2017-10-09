package Program;


import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.*;

import static Program.Main.*;

public class ProgramSettings extends GeneralScreen {

 // setting ui and control elements:
    private RadioButton option1_ButtonYes;
    private RadioButton option1_ButtonNo;
    private ToggleGroup option1_ToggleGroup;
    private Text option2_CurrentCacheSavePath;
    private ToggleGroup option3_ToggleGroup;
    private RadioButton option3_ButtonYes;
    private RadioButton option3_ButtonNo;
    private TitledPane option1;
    private TitledPane option2;
    private TitledPane option3;

 // settings parameters:
    boolean useCache;
    boolean showExecutionTime;
    String savedSettingsPath;
    String cacheDirectory;

    public ProgramSettings() {
        savedSettingsPath = "/Users/test/IdeaProjects/GoIT_JavaCore/Final Project/settings.txt";
        downloadSavedSettings();
        addSettingsInterface();
    }

    void addSettingsInterface() {
        Text title = new Text("Settings");

     // use cache option
        Text option1_Title = new Text("Cache using:");
        option1_ToggleGroup = new ToggleGroup();
        option1_ButtonYes = new RadioButton("Yes");
        option1_ButtonYes.setToggleGroup(option1_ToggleGroup);
        option1_ButtonNo = new RadioButton("No");
        option1_ButtonNo.setToggleGroup(option1_ToggleGroup);
        Button option1SaveButton = new Button("Save");
        option1SaveButton.setOnAction(e -> {
            useCache = option1_ButtonYes.isSelected();
            alert("Use cache", useCache ? "Cache enabled." : "Cache disabled.");
        });
        option1 = new TitledPane("Cache using",new VBox(5,option1_Title, option1_ButtonYes, option1_ButtonNo,option1SaveButton));

     // cache saving directory option
        Text option2_Title = new Text("Current path to cache folder:");
        option2_CurrentCacheSavePath = new Text(cacheDirectory);
        Button option2_ClearCacheButton = new Button("Clear cache");
        option2_ClearCacheButton.setOnAction(e -> cleanFilesInCacheDirectory());
        TextField option2_NewCacheSavePath = new TextField();
        option2_NewCacheSavePath.setPromptText("Enter new path...");
        option2_NewCacheSavePath.setFocusTraversable(false);
        Button option2_SaveButton = new Button("Save");
        option2_SaveButton.setOnAction(e -> {
            cacheDirectory = option2_NewCacheSavePath.getText();
            option2_CurrentCacheSavePath.setText(cacheDirectory);
        });
        option2 = new TitledPane("Cache save path",new VBox(5,option2_Title,option2_CurrentCacheSavePath,option2_ClearCacheButton,option2_NewCacheSavePath,option2_SaveButton));

     // show execution time option
        Text option3Text = new Text("Show execution time spent?");
        option3_ToggleGroup = new ToggleGroup();
        option3_ButtonYes = new RadioButton("Yes");
        option3_ButtonYes.setToggleGroup(option3_ToggleGroup);
        option3_ButtonNo = new RadioButton("No");
        option3_ButtonNo.setToggleGroup(option3_ToggleGroup);
        Button option3SaveButton = new Button("Save");
        option3SaveButton.setOnAction(e -> {
            showExecutionTime = option3_ButtonYes.isSelected();
            alert("Execution time spent", useCache ? "Execution time spent enabled." : "Execution time spent disabled.");

        });
        option3 = new TitledPane("Execution time spent",new VBox(5,option3Text, option3_ButtonYes, option3_ButtonNo,option3SaveButton));

        screen.getChildren().addAll(title, option1, option2,option3);
    }

 // contract title panes and set ui elements according to up-to-date settings parameters values;
    void updateSettings() {
        option1_ToggleGroup.selectToggle(useCache ? programSettings.option1_ButtonYes : programSettings.option1_ButtonNo);
        option3_ToggleGroup.selectToggle(showExecutionTime ? programSettings.option3_ButtonYes : programSettings.option3_ButtonNo);
        option2_CurrentCacheSavePath.setText(cacheDirectory);
        option1.setExpanded(false);
        option2.setExpanded(false);
        option3.setExpanded(false);
    }

 // download from file settings parameters values (saved on last closing) - applied each time program is opened;
    void downloadSavedSettings() {
        try (BufferedReader br = new BufferedReader(new FileReader(savedSettingsPath))) {
            useCache = br.readLine().equals("true");
            cacheDirectory = br.readLine();
            showExecutionTime = br.readLine().equals("true");
        } catch (IOException e) {
            alert("IOException thrown","Cannot download from file saved settings.");
        }
    }

 // save up-to-date settings parameters values to file - applied each time program is closed;
    void saveSettings() {
        try {
            File file = new File(savedSettingsPath);
            FileWriter writer = new FileWriter(file);
            writer.write((useCache ? "true" : "false") + "\n");
            writer.write(cacheDirectory + "\n");
            writer.write(showExecutionTime ? "true" : "false");
            writer.flush();
        } catch (Exception e){
            alert("Exception thrown","Settings file not found.");
        }
    }

    void cleanFilesInCacheDirectory() {
        File folder = new File(cacheDirectory);
        for (File file : folder.listFiles()) file.delete();
    }

}
