package HomeWork.MP3Player;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public abstract class MP3Player {

    protected ArrayList<MediaPlayer> playlist;
    private File directory;
    private VBox playerLayout;
    private Text playerPrice;
    protected HBox playerControls;
    protected Text playingSong;
    protected VBox playlistView;
    protected MediaView mediaView;
    protected final double price;

    public MP3Player(double price) {
        this.price = price;
        this.directory = new File("media/");
        this.playlist = new ArrayList<>();
        this.mediaView = new MediaView();
        this.playerLayout = new VBox(10);
        this.playerLayout.setPadding(new Insets(10));
        this.playerPrice = new Text("Price: $" + ((Double)price).toString());
        this.playerControls = new HBox();
        this.playingSong = new Text("Playing: ");
        this.playlistView = new VBox();
        this.playlistView.setTranslateX(20);
        this.playerLayout.getChildren().addAll(playerPrice,playerControls,playingSong,new Text("Playlist:"), playlistView);

        setPlayerControls();
        getSongsFromDirectory();
        setPlaylistView();
    }

    public VBox getPlayerLayout() {
        return playerLayout;
    }

    private void setPlayerControls() {
        playerControls.setAlignment(Pos.CENTER_LEFT);
        playerControls.setSpacing(10);
        Button button_play = new Button("Play song");
        button_play.setOnAction(e -> playSong());

        Button button_pause = new Button("Pause");
        button_pause.setOnAction(e -> mediaView.getMediaPlayer().pause());

        Button button_stop = new Button("Stop");
        button_stop.setOnAction(e -> {
            mediaView.getMediaPlayer().stop();
            playingSong.setText("Playing: ");
        });
        Text volume_label = new Text("Volume:");
        Slider volume_slider = new Slider(1,100,100);
        volume_slider.setPrefWidth(70);
        volume_slider.setMaxWidth(Region.USE_PREF_SIZE);
        volume_slider.valueProperty().addListener((observable) -> {
            if (mediaView.getMediaPlayer() != null && mediaView.getMediaPlayer().getStatus().equals(MediaPlayer.Status.PLAYING)) {
                if (volume_slider.isValueChanging()) {
                    mediaView.getMediaPlayer().setVolume(volume_slider.getValue() / 100.0);
                }
            }
        });
        playerControls.getChildren().addAll(button_play,button_pause,button_stop,volume_label,volume_slider);
    }

    public abstract void setPlaylistView();

    private void getSongsFromDirectory() {
        File[] songsList = directory.listFiles();
        if (songsList != null) {
            for (File i : songsList) {
                if (i.getName().endsWith(".mp3")) {
                    playlist.add(new MediaPlayer(new Media(i.toURI().toString())));
                }
            }
        }
        if (playlist.size() == 0) alert("No songs found in the specified directory.");
    }

    public void playSong() {
        mediaView.setMediaPlayer(playlist.get(0));
        MediaPlayer mediaPlayer = mediaView.getMediaPlayer();
        mediaPlayer.setOnPlaying(() -> playingSong.setText("Playing: " + getMediaName(mediaPlayer)));
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.stop();
            playingSong.setText("Playing: ");
        });
        mediaPlayer.play();
    }

    protected static void alert(String message) {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Error");
        stage.setMinWidth(300);
        stage.setMinHeight(100);

        Text text = new Text();
        text.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(text, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }

    protected String getMediaName(MediaPlayer mediaPlayer) {
        String source = mediaPlayer.getMedia().getSource();
        source = source.substring(0, source.length() - 4);
        source = source.substring(source.lastIndexOf("/") + 1).replaceAll("%20", " ");
        return source;
    }
}
