package HomeWork.MP3Player.OneSongPlayers;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioTrack;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Player1 extends OneSongPlayer {
    public Player1(double price, String song) {
        super(price, song);
    }

    public void show(Pane root) {
        VBox mainBlock = new VBox();

        Text block1 = new Text("Player #1");
        block1.setFont(new Font(20));

        String path = "file:///Users/test/IdeaProjects/Songs/ShakiraDare.mp3";
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);

        Button block2 = new Button("Play song");
        block2.setOnAction(e -> mediaPlayer.play());

        HBox block3 = new HBox();
        Label label1 = new Label("Playing:");
        Label label2 = new Label();
        block3.getChildren().addAll(label1,label2);

        VBox block4 = new VBox();
        Label block4_1 = new Label("Song:");
        Label block4_2 = new Label("A song");
        block4.getChildren().addAll(block4_1,block4_2);

        mainBlock.getChildren().addAll(block1,block2,block3,block4);
        root.getChildren().add(mainBlock);
    }
}
