package HomeWork.MP3Player.OneSongPlayers;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.File;

public class Player1 extends OneSongPlayer {

    Label playingSong = new Label();
    final String path = "/Users/test/IdeaProjects/Songs/Shakira - Dare.mp3";
    Media media;
    MediaPlayer mediaPlayer;

    public Player1(double price, String song) {
        super(price, song);
    }

    public void show(Pane root) {
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);

        VBox mainBlock = new VBox();
        mainBlock.setPadding(new Insets (20));
        mainBlock.setSpacing(20);

        Text block1 = new Text("Player #1");
        block1.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));



        HBox block2 = new HBox();
        block2.setSpacing(10);
        Button block2_1 = new Button("Play song");
        block2_1.setOnAction(e -> {
            mediaPlayer.play();
//            playingSong.setText((String)getMedia(path).getMetadata().get("title"));
        });
        Button block2_2 = new Button("Pause");
        block2_2.setOnAction(e -> mediaPlayer.pause());
        Button block2_3 = new Button("Stop");
        block2_3.setOnAction(e -> {
            mediaPlayer.stop();
            playingSong.setText(null);
        });
        block2.getChildren().addAll(block2_1,block2_2,block2_3);

        HBox block3 = new HBox();
        block3.setSpacing(10);
        Label block3_1 = new Label("Playing:");
        block3.getChildren().addAll(block3_1,playingSong);

        mainBlock.getChildren().addAll(block1,block2,block3);
        root.getChildren().add(mainBlock);
    }

    public Media getMedia(String path) {
        File file = new File(path);
        Media media = new Media(file.toURI().toString());
        return media;
    }
}
