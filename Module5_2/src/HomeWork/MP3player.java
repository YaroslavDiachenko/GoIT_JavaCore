package HomeWork;

public class MP3player {

    private double price;
    private String song;
    private String[] playlist;

    public MP3player() {
    }
    public MP3player(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    void playSong() {
        System.out.println("Playing: " + song);
    }

}

class Player1 extends MP3player {
    public Player1(double price) {
        super(price);
    }
}

class Player2 extends MP3player {
    public Player2(double price) {
        super(price);
    }
}

class Player3 extends MP3player {

}

class Player4 extends MP3player {

}

class Player5 extends MP3player {

}

class Player6 extends MP3player {

}



