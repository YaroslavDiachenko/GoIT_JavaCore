package HomeWork.MP3Player.MultySongsPlayers;


import HomeWork.MP3Player.MP3Player;
import javafx.scene.media.Media;

public abstract class MultiSongsPlayer extends MP3Player {
    public Media[] playlist;

    public MultiSongsPlayer(double price, String[] playlist) {
        super(price);
    }

    public abstract void playSong();
    public abstract void playAllSongs();
}
