package HomeWork.MP3Player.MultySongsPlayers;


import HomeWork.MP3Player.MP3Player;

public abstract class MultiSongsPlayer extends MP3Player {
    public String[] playlist;

    public MultiSongsPlayer(double price, String[] playlist) {
        super(price);
        this.playlist = playlist;
    }

    public abstract void playSong();
    public abstract void playAllSongs();
}
