package Program;


import YouTubeData_Channels.Channel;
import YouTubeData_Channels.ChannelListResponse;
import YouTubeData_Channels.Request1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Program.Main.*;

public class RequestScreen {
    VBox layout;

    int requestNumber;
    int numberOfInputFields;

    Text requestName;
    Text requestDescription;
    Pane inputAndOutputArea;

    VBox inputInterface_oneChannel;
    VBox inputInterface_manyChannels;
    VBox inputInterface_manyChannelsAndSort;

    public RequestScreen() {
        layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);

        Button buttonBackAnalyticsScreen = new Button();
        buttonBackAnalyticsScreen.setText("Back to YouTube Analytics");
        buttonBackAnalyticsScreen.setFocusTraversable(false);
        buttonBackAnalyticsScreen.setOnAction(event -> {
            Main.pane.getChildren().clear();
            Main.pane.getChildren().add(mainScreen.layout);
        });

        requestName = new Text();
        requestDescription = new Text();

        inputAndOutputArea = new Pane();

        addInputInterface_OneChannel();
        addInputInterface_ManyChannels();
        addInputInterface_ManyChannelsAndSort();


        layout.getChildren().addAll(buttonBackAnalyticsScreen,requestName,requestDescription, inputAndOutputArea);

        layout.setSpacing(5);
        layout.setPadding(new Insets(10));

    }

    void addInputInterface_OneChannel() {
        inputInterface_oneChannel = new VBox();
        inputInterface_oneChannel.setPadding(new Insets(10));
        inputInterface_oneChannel.setSpacing(10);

        TextField textField1 = new TextField();
        textField1.setFocusTraversable(false);
        textField1.setPromptText("Enter YouTube channel ID:");
        Button submitButton = new Button("Submit");
        inputInterface_oneChannel.getChildren().addAll(textField1, submitButton);

        submitButton.setOnAction((ActionEvent e) -> {
            RequestResultScreen.data.clear();
            String channelId = textField1.getText();
            ChannelData channel = getChannelData(channelId);
            RequestResultScreen.data.add(channel);
            showOutputInterface(requestNumber);
        });
    }

    void addInputInterface_ManyChannels() {
        inputInterface_manyChannels = new VBox();
        inputInterface_manyChannels.setPadding(new Insets(10));
        inputInterface_manyChannels.setSpacing(10);

        Text text1 = new Text("Channel 1:");
        Text text2 = new Text("Channel 2:");
        VBox channelNumbers = new VBox(text1,text2);
        channelNumbers.setTranslateY(5);
        channelNumbers.setSpacing(16);

        TextField textField1_1 = new TextField();
        textField1_1.setPromptText("Enter channel ID..");
        textField1_1.setFocusTraversable(false);
        TextField textField2_2 = new TextField();
        textField2_2.setPromptText("Enter channel ID..");
        textField2_2.setFocusTraversable(false);
        VBox channelIdInputFields = new VBox(textField1_1,textField2_2);
        channelIdInputFields.setSpacing(5);
        numberOfInputFields = 2;

        Button addChannelButton = new Button("Add field");
        Button removeChannelButton = new Button("Remove field");

        HBox dataInputButtons = new HBox(15,addChannelButton,removeChannelButton);
        Button submitButton = new Button("Submit");

        HBox dataInput = new HBox(channelNumbers,channelIdInputFields,submitButton);
        dataInput.setSpacing(5);

        inputInterface_manyChannels.getChildren().addAll(dataInput,dataInputButtons,submitButton);

        addChannelButton.setOnAction(event -> {
            Text channelNumber = new Text("Channel " + ((numberOfInputFields++) + 1) + ":");
            channelNumbers.getChildren().add(channelNumber);
            TextField channelIdInput = new TextField();
            channelIdInput.setPromptText("Enter channel ID..");
            channelIdInputFields.getChildren().add(channelIdInput);
        });
        removeChannelButton.setOnAction(event -> {
            if (numberOfInputFields > 2) {
                channelNumbers.getChildren().remove(numberOfInputFields-1);
                channelIdInputFields.getChildren().remove(numberOfInputFields-1);
                numberOfInputFields--;
            }
        });
        submitButton.setOnAction(event -> {
            RequestResultScreen.data.clear();
            List<String> channelIDsList = new ArrayList<>();
            for (Node i : channelIdInputFields.getChildren()) {
                TextField t = (TextField) i;
                String s = t.getText();
                if (s != null && !"".equals(s.trim())) channelIDsList.add(s);
            }

            if (channelIDsList.size() >= 2) {
                for (String i : channelIDsList) {
                    ChannelData channelData = getChannelData(i);
                    if (channelData != null) RequestResultScreen.data.add(channelData);
                }
                if (RequestResultScreen.data.size() > 0) {
                    showOutputInterface(requestNumber);
                    channelNumbers.getChildren().clear();
                    channelIdInputFields.getChildren().clear();
                    textField1_1.clear();
                    textField2_2.clear();
                    channelNumbers.getChildren().addAll(text1,text2);
                    channelIdInputFields.getChildren().addAll(textField1_1, textField2_2);
                    numberOfInputFields = 2;
                }else alert("Invalid data","No channels found.");
            }else alert("Incomplete input","Please add at least two channel IDs.");
        });
    }

    void addInputInterface_ManyChannelsAndSort() {
        inputInterface_manyChannelsAndSort = new VBox();

    }

    void showRequestScreen() {
        showInputInterface();
        pane.getChildren().clear();
        pane.getChildren().add(layout);
    }

    void showInputInterface() {
        inputAndOutputArea.getChildren().clear();
        switch (requestNumber) {
            case 1:
                requestName.setText(nameRequest1);
                requestDescription.setText("Shows global information about a channel.");
                inputAndOutputArea.getChildren().add(inputInterface_oneChannel);
                break;
            case 2:
                requestName.setText(nameRequest2);
                requestDescription.setText("Shows global information about the list of specified channels.");
                inputAndOutputArea.getChildren().add(inputInterface_manyChannels);
                break;
            case 3:
                requestName.setText(nameRequest3);
                requestDescription.setText("Sorts the list of specified channels and their information by specified parameter.");
                inputAndOutputArea.getChildren().add(inputInterface_manyChannelsAndSort);
                break;
            case 4:
                requestName.setText(nameRequest4);
                requestDescription.setText("Shows information (including total number of comments) about a channel.");
                inputAndOutputArea.getChildren().add(inputInterface_oneChannel);
                break;
            case 5:
                requestName.setText(nameRequest5);
                requestDescription.setText("Shows information (including total number of comments) about the list of specified channels.");
                inputAndOutputArea.getChildren().add(inputInterface_manyChannels);
                break;
            case 6:
                requestName.setText(nameRequest6);
                requestDescription.setText("Sorts the list of specified channels and their information by total number of comments.");
                inputAndOutputArea.getChildren().add(inputInterface_manyChannels);
                break;
        }
    }

    void showOutputInterface(int requestNumber) {
        inputAndOutputArea.getChildren().clear();
        inputAndOutputArea.getChildren().add(requestResultScreen.layout);
    }

    ChannelData getChannelData(String channelId) {
        System.out.println("\nPASSED FOR EXECUTION: ChannelID: " + channelId);
        try {
            if (setting_useCache) {
                System.out.println("Use cache option was checked and is 'true'.");
                if (checkIfCached(channelId)) {
                    System.out.println("ChannelData was checked if cached and is 'true'.");
                    System.out.println("ChannelData was converted from read cached data.");
                    return new ChannelData(convertStringToChannel(readFileToString(channelId)));
                }else {
                    System.out.println("ChannelData was checked if cached and is 'false'.");
                    String jsonString = Request1.getChannelDataAsString(channelId);
                    System.out.println("ChannelData data was requested from server and converted to Json string.");
                    writeCacheToFile(jsonString,channelId);
                    Channel channel = convertStringToChannel(jsonString);
                    if (channel != null) return new ChannelData(channel);
                    return null;
                }
            }else {
                return new ChannelData(Request1.getYouTubeChannelAsObject(channelId));
            }
        }catch (UnirestException e) {
            alert("UnirestException thrown","Cannot get channel.");
        }
        return null;
    }

    void writeCacheToFile(String jsonString, String channelId) {
        try {
            String savePath = setting_cacheDirectory + channelId + ".txt";
            File file = new File(savePath);
            FileWriter writer = new FileWriter(file);
            writer.write(jsonString);
            writer.flush();
            System.out.println("ChannelData has been successfully cached.");
        } catch (Exception e){
            alert("Exception thrown","ChannelData not cashed.");
        }
    }

    boolean checkIfCached(String channelId) {
        String channelIdFullName = channelId + ".txt";
        File cashDirectoryFile = new File(setting_cacheDirectory);
        File[] allFiles = cashDirectoryFile.listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (channelIdFullName.equals(file.getName())) return true;
            }
        }
        return false;
    }

    static String readFileToString(String channelName) {
        String cachedChannelPath = (setting_cacheDirectory + "/" + channelName + ".txt");
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(cachedChannelPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            alert("IOException thrown","Cannot read cached file.");
        }
        return result.toString();
    }

    Channel convertStringToChannel(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ChannelListResponse channelsResponse = objectMapper.readValue(jsonString, ChannelListResponse.class);
            return channelsResponse.items.get(0);
        }catch (IOException e){
            alert("IOException thrown","Cannot convert a Json string to an object.");
        }catch (IndexOutOfBoundsException | NullPointerException e) {
            alert("IndexOutOfBoundsException thrown","Channel(s) not found.");
        }
        return null;
    }
}
