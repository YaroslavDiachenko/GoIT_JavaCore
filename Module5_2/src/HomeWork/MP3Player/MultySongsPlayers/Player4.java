package HomeWork.MP3Player.MultySongsPlayers;


public class Player4 extends MultiSongsPlayer {
    public Player4(double price, String[] playlist) {
        super(price, playlist);
    }

    public void playSong() {
        System.out.println(playlist[playlist.length-1]);
    }
    public void playAllSongs() {
//        for(String i : playlist) {
//            System.out.println("Playing: " + i);
//        }
    }
}