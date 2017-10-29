package HomeWork.MP3Player.MultySongsPlayers;


import HomeWork.MP3Player.MP3Player;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class MultiSongsPlayer extends MP3Player {

    public MultiSongsPlayer(double price) {
        super(price);
        addPlayAllSongsButton();
    }

    public void setPlaylistView() {
        playlistView.getChildren().clear();
        for (MediaPlayer i : playlist) {
            playlistView.getChildren().add(new Text(getMediaName(i)));
        }
    }

    private void addPlayAllSongsButton() {
        Button button_playAll = new Button("Play all songs");
        button_playAll.setOnAction(e -> playAllSongs());
        playerControls.getChildren().add(1,button_playAll);
    }

    void playAllSongs() {
        for (int i = 0; i < playlist.size(); i++) {
            final MediaPlayer mediaPlayer = playlist.get(i);
            mediaPlayer.setOnPlaying(() -> playingSong.setText("Playing: " + getMediaName(mediaPlayer)));
            mediaPlayer.setOnEndOfMedia(() -> {
                playingSong.setText("Playing: ");
                mediaPlayer.stop();
                if (playlist.indexOf(mediaPlayer) < playlist.size() - 1) {
                    mediaView.setMediaPlayer(playlist.get(playlist.indexOf(mediaPlayer) + 1));
                    mediaView.getMediaPlayer().play();
                }
            });
        }
        mediaView.setMediaPlayer(playlist.get(0));
        mediaView.getMediaPlayer().play();
    }
}
