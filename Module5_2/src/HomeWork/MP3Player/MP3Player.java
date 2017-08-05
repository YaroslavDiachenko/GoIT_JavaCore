package HomeWork.MP3Player;


public abstract class MP3Player {
    private final double price;

    public MP3Player(double price) {
        this.price = price;
    }

    public abstract void playSong();
}
