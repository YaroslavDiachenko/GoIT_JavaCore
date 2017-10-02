package YouTubeData;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Channel {
    private final SimpleStringProperty channelName;
    private final SimpleIntegerProperty dateOfCreation;
    private final SimpleIntegerProperty numberOfSubscribers;
    private final SimpleIntegerProperty numberOfVideos;
    private final SimpleIntegerProperty numberOfViews;
    private final SimpleIntegerProperty numberOfComments;

    public Channel(String channelName, int dateOfCreation,int numberOfSubscribers,int numberOfVideos,int numberOfViews,int numberOfComments) {
        this.channelName = new SimpleStringProperty(channelName);
        this.dateOfCreation = new SimpleIntegerProperty(dateOfCreation);
        this.numberOfSubscribers = new SimpleIntegerProperty(numberOfSubscribers);
        this.numberOfVideos = new SimpleIntegerProperty(numberOfVideos);
        this.numberOfViews = new SimpleIntegerProperty(numberOfViews);
        this.numberOfComments = new SimpleIntegerProperty(numberOfComments);
    }

    public String getChannelName() {
        return channelName.get();
    }

    public int getDateOfCreation() {
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

    public int getNumberOfComments() {
        return numberOfComments.get();
    }

    public void setChannelName(String channelName) {
        this.channelName.set(channelName);
    }

    public void setDateOfCreation(int dateOfCreation) {
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

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments.set(numberOfComments);
    }
}

