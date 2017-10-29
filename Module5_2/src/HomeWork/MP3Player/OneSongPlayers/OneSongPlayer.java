package HomeWork.MP3Player.OneSongPlayers;


import HomeWork.MP3Player.MP3Player;
import javafx.scene.text.Text;

public class OneSongPlayer extends MP3Player {

    OneSongPlayer(double price) {
        super(price);
    }

    public void setPlaylistView() {
        playlistView.getChildren().add(new Text(getMediaName(playlist.get(0))));
    }
}