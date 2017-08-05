package HomeWork.MP3Player.OneSongPlayers;


import HomeWork.MP3Player.MP3Player;

public class OneSongPlayer extends MP3Player {
    private String song = "The Bet Song";

    public OneSongPlayer(double price, String song) {
        super(price);
        this.song = song;
    }

    public void playSong() {
        System.out.println("Playing: " + song);
    }
}