package HomeWork.MP3Player.MultySongsPlayers;


import javafx.scene.media.MediaPlayer;

public class Player5 extends MultiSongsPlayer {
    public Player5(double price) {
        super(price);
    }

    @Override
    void playAllSongs() {
        for (int i = playlist.size() - 1; i >= 0; i--) {
            final MediaPlayer mediaPlayer = playlist.get(i);
            mediaPlayer.setOnPlaying(() -> playingSong.setText("Playing: " + getMediaName(mediaPlayer)));
            mediaPlayer.setOnEndOfMedia(() -> {
                playingSong.setText("Playing: ");
                mediaPlayer.stop();
                if (playlist.indexOf(mediaPlayer) > 0) {
                    mediaView.setMediaPlayer(playlist.get(playlist.indexOf(mediaPlayer) - 1));
                    mediaView.getMediaPlayer().setVolume(0.5);
                    mediaView.getMediaPlayer().play();
                }
            });
        }
        mediaView.setMediaPlayer(playlist.get(playlist.size() - 1));
        mediaView.getMediaPlayer().setVolume(0.5);
        mediaView.getMediaPlayer().play();
    }
}