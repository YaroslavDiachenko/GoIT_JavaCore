package HomeWork.MP3Player.MultySongsPlayers;


import javafx.scene.media.MediaPlayer;

public class Player4 extends MultiSongsPlayer {
    public Player4(double price) {
        super(price);
    }


    @Override
    public void playSong() {
        mediaView.setMediaPlayer(playlist.get(playlist.size() - 1));
        MediaPlayer mediaPlayer = mediaView.getMediaPlayer();
        mediaPlayer.setOnPlaying(() -> playingSong.setText("Playing: " + getMediaName(mediaPlayer)));
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.stop();
            playingSong.setText("Playing: ");
        });
        mediaPlayer.play();
    }}