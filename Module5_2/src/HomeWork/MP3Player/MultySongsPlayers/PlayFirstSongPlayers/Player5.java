package HomeWork.MP3Player.MultySongsPlayers.PlayFirstSongPlayers;


public class Player5 extends PlayFirstSongPlayer {
    public Player5(double price, String[] playlist) {
        super(price, playlist);
    }

    @Override
    public void playAllSongs() {
        for (int i = playlist.length; i > 0; i--) {
            System.out.println("Playing: " + i);
        }
    }
}