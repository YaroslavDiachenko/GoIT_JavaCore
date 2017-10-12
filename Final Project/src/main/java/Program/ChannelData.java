package Program;


import YouTubeData_Channels.Channel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ChannelData {
    private final SimpleStringProperty channelName;
    private final SimpleStringProperty dateOfCreation;
    private final SimpleIntegerProperty numberOfSubscribers;
    private final SimpleIntegerProperty numberOfVideos;
    private final SimpleIntegerProperty numberOfViews;

    public ChannelData(Channel channel) {
        this.channelName = new SimpleStringProperty(channel.snippet.title);
        this.dateOfCreation = new SimpleStringProperty(channel.snippet.publishedAt);
        this.numberOfSubscribers = new SimpleIntegerProperty(channel.statistics.subscriberCount);
        this.numberOfVideos = new SimpleIntegerProperty(channel.statistics.videoCount);
        this.numberOfViews = new SimpleIntegerProperty(channel.statistics.viewCount);
    }

    public String getChannelName() {
        return channelName.get();
    }

    public String getDateOfCreation() {
        return dateOfCreation.get();
    }

    public int getNumberOfSubscribers() {
        return numberOfSubscribers.get();
    }

    public int getNumberOfVideos() {
        return numberOfVideos.get();
    }

    public int getNumberOfViews() {
        return numberOfViews.get();
    }

    public void setChannelName(String channelName) {
        this.channelName.set(channelName);
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation.set(dateOfCreation);
    }

    public void setNumberOfSubscribers(int numberOfSubscribers) {
        this.numberOfSubscribers.set(numberOfSubscribers);
    }

    public void setNumberOfVideos(int numberOfVideos) {
        this.numberOfVideos.set(numberOfVideos);
    }

    public void setNumberOfViews(int numberOfViews) {
        this.numberOfViews.set(numberOfViews);
    }
}

