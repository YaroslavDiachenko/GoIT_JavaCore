package Program;


import YouTubeData_Channels.ChannelListResponse;
import YouTubeData_Channels.OneChannel;
import YouTubeData_Channels.Request1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.*;

import static Program.Main.*;

public class RequestOneChannel extends RequestScreen {

    Text name;
    Text description;
    TextField textField1;
    Button submitButton;

    public RequestOneChannel() {
        super();
        name = new Text();
        description = new Text();
        submitButton = new Button("Submit");
        addInterface();
        addInputInterface();
    }

    void addInterface() {
        screen.getChildren().addAll(name, description);
    }

    void addInputInterface() {
        textField1 = new TextField();
        textField1.setFocusTraversable(false);
        textField1.setPromptText("Enter YouTube channel ID:");
        screen.getChildren().addAll(textField1, submitButton);

        submitButton.setOnAction((ActionEvent e) -> {
            RequestResultScreen.data.clear();
            String channelId = textField1.getText();
            Channel channel = getChannel(channelId);
            RequestResultScreen.data.add(channel);
            pane.getChildren().clear();
            pane.getChildren().add(resultScreen.screen);
        });
    }

    Channel getChannel(String channelId) {
        try {
            if (programSettings.useCache) {
                System.out.println("Use cache option was checked and is 'true'.");
                if (checkIfCached(channelId)) {
                    System.out.println("Channel was checked if cached and is 'true'.");
                    System.out.println("Channel was converted from read cached data.");
                    return new Channel(convertStringToChannel(readFileToString(channelId)));
                }else {
                    System.out.println("Channel was checked if cached and is 'false'.");
                    String jsonString = Request1.getChannelDataAsString(channelId);
                    System.out.println("Channel data was requested from server and converted to Json string.");
                    writeCacheToFile(jsonString,channelId);
                    System.out.println("Json string was converted to object.\nFinish.\n");
                    return new Channel(convertStringToChannel(jsonString));
                }
            }else {
                return new Channel(Request1.getYouTubeChannelAsObject(channelId));
            }
        }catch (UnirestException e) {
            alert("UnirestException thrown","Cannot get channel.");
        }
        return null;
    }

    void writeCacheToFile(String jsonString, String channelId) {
        try {
            String savePath = programSettings.cacheDirectory + channelId + ".txt";
            File file = new File(savePath);
            FileWriter writer = new FileWriter(file);
            writer.write(jsonString);
            writer.flush();
            System.out.println("Channel has been successfully cached.");
        } catch (Exception e){
            alert("Exception thrown","Channel not cashed.");
        }
    }

    boolean checkIfCached(String channelId) {
        String channelIdFullName = channelId + ".txt";
        File cashDirectoryFile = new File(programSettings.cacheDirectory);
        File[] allFiles = cashDirectoryFile.listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (channelIdFullName.equals(file.getName())) return true;
            }
        }
        return false;
    }

    static String readFileToString(String channelName) {
        String cachedChannelPath = (programSettings.cacheDirectory + "/" + channelName + ".txt");
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

    OneChannel convertStringToChannel(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        ChannelListResponse channelsResponse = null;
        try {
            channelsResponse = objectMapper.readValue(jsonString, ChannelListResponse.class);
        } catch (IOException e) {
            alert("IOException thrown","Cannot convert a Json string to an object.");
        }
        return channelsResponse.items.get(0);
    }

    void generateRequest1() {
        name.setText(nameRequest1);
        description.setText("Shows global information about a channel.");
    }

    void generateRequest4() {
        name.setText(nameRequest4);
        description.setText("Shows information (including total number of comments) about a channel.");
    }
}
