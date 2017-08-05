package HomeWork.MP3Player.MultySongsPlayers.PlayFirstSongPlayers;


import java.util.Random;

public class Player6 extends PlayFirstSongPlayer {
    public Player6(double price, String[] playlist) {
        super(price, playlist);
    }

    public void shuffle() {
        int n = playlist.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            String temp = playlist[i];
            playlist[i] = playlist[change];
            playlist[change] = temp;
        }
    }

}
