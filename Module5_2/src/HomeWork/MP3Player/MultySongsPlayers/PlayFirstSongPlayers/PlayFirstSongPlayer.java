package HomeWork.MP3Player.MultySongsPlayers.PlayFirstSongPlayers;


import HomeWork.MP3Player.MultySongsPlayers.MultiSongsPlayer;

public class PlayFirstSongPlayer extends MultiSongsPlayer {
    public PlayFirstSongPlayer(double price, String[] playlist) {
        super(price, playlist);
    }

    @Override
    public void playSong() {
        System.out.println(playlist[0]);
    }

    public void playAllSongs() {
        for(String i : playlist) {
            System.out.println("Playing: " + i);
        }
    }
}