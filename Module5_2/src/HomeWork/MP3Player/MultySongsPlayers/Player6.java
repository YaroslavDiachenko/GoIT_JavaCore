package HomeWork.MP3Player.MultySongsPlayers;


import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.util.Random;

public class Player6 extends MultiSongsPlayer {


    public Player6(double price) {
        super(price);
        addShuffleButton();
    }

    private void addShuffleButton() {
        Button button_shuffle = new Button("Shuffle");
        button_shuffle.setOnAction(e -> shuffle());
        playerControls.getChildren().add(2,button_shuffle);
    }

    private void shuffle() {
        int n = playlist.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            if (change == i) change = (i + 1)%playlist.size();
            MediaPlayer temp = playlist.get(i);
            playlist.set(i,playlist.get(change));
            playlist.set(change,temp);

            setPlaylistView();
        }
    }
}
