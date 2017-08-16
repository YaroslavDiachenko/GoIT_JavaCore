package HomeWork.MP3Player.OneSongPlayers;


import HomeWork.MP3Player.MP3Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;

public class OneSongPlayer extends MP3Player {
    private String playerName;
    String song;
    Label playingSong;
    File file;
    Media media;
    MediaPlayer mediaPlayer;

    public String getPlayerName() {
        return playerName;
    }

    public OneSongPlayer(double price) {
        super(price);
        song = "/Users/test/IdeaProjects/Songs/Dare (La La La).mp3";
    }

    public void playSong() {
        mediaPlayer.play();
        playingSong.setText((String)media.getMetadata().get("title"));
    }

    public void show(Pane root) {
        playingSong = new Label();
        media = new Media(new File(song).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);

        VBox mainBlock = new VBox();
        mainBlock.setPadding(new Insets(20));
        mainBlock.setSpacing(20);

        Text playerNumber = new Text(getPlayerName());
        playerNumber.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));

        HBox block2 = new HBox();
        block2.setSpacing(10);
        Button block2_1 = new Button("Play song");
        block2_1.setOnAction(e -> {
            playSong();
        });
        Button block2_2 = new Button("Pause");
        block2_2.setOnAction(e -> mediaPlayer.pause());
        Button block2_3 = new Button("Stop");
        block2_3.setOnAction(e -> {
            mediaPlayer.stop();
            playingSong.setText(null);
        });
        Label block2_4 = new Label("Volume:");
        block2.setAlignment(Pos.CENTER);
        Slider block2_5 = new Slider();
        block2_5.setPrefWidth(70);
        block2_5.setMaxWidth(Region.USE_PREF_SIZE);
        block2_5.setMinWidth(30);
        block2_5.valueProperty().addListener((observable) -> {
            if (block2_5.isValueChanging()) {
                mediaPlayer.setVolume(block2_5.getValue() / 100.0);
            }
        });
        block2.getChildren().addAll(block2_1,block2_2,block2_3,block2_4,block2_5);

        HBox block3 = new HBox();
        block3.setSpacing(10);
        Label block3_1 = new Label("Playing:");
        block3.getChildren().addAll(block3_1,playingSong);

        mainBlock.getChildren().addAll(playerNumber,block2,block3);
        root.getChildren().add(mainBlock);
    }
}