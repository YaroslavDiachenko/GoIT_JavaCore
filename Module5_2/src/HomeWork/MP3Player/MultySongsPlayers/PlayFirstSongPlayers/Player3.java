package HomeWork.MP3Player.MultySongsPlayers.PlayFirstSongPlayers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Player3 extends PlayFirstSongPlayer {
    public Player3(double price, String[] playlist) {
        super(price, playlist);
    }

    public void show(Pane root) {
        VBox mainBlock = new VBox();
        mainBlock.setPadding(new Insets(20));
        mainBlock.setSpacing(20);

        Text block1 = new Text("Player #1");
        block1.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));

        final String path = "/Users/test/IdeaProjects/Songs/Shakira - Dare.mp3";
        File file = new File(path);
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);
//        String title = (String)media.getMetadata().get("artist");
//        System.out.println(title);

        HBox block2 = new HBox();
        block2.setSpacing(10);
        Button block2_1 = new Button("Play song");
//        block2_1.setOnAction(e -> mediaPlayer.play());
        block2_1.setOnAction(e -> getFilesFromFolder());
        Button block2_2 = new Button("Stop");

        HBox block3 = new HBox();
        Label label1 = new Label("Playing:");
        Label label2 = new Label();
        block3.getChildren().addAll(label1,label2);

        VBox block4 = new VBox();
        Label block4_1 = new Label("Song:");
        Label block4_2 = new Label("A song");
        block4.getChildren().addAll(block4_1,block4_2);

        mainBlock.getChildren().addAll(block1,block2_2,block3,block4);
        root.getChildren().add(mainBlock);
    }
    public void getFilesFromFolder() {
        String dirName = "/Users/test/IdeaProjects/Songs";
        ObservableList<File> observableList = FXCollections.observableArrayList();
        File dir = new File(dirName);
        File[] files = dir.listFiles((File dir1, String filename) -> filename.endsWith(".mp3"));
        observableList.addAll(files);
        for(File i : observableList)
            System.out.println(i.toString());
    }

}