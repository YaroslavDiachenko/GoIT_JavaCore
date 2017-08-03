package HomeWork;

import java.util.Random;

abstract class MP3player {

    // class fields:
    private final double price;
    private String song = "The Bet Song";
    private String[] playlist = new String[] {"The best song", "Good song", "Super song"};

    // constructor:
    MP3player(double price) {
        this.price = price;
    }

    // getters:
    double getPrice() {
        return price;
    }
    String[] getPlaylist() {
        return playlist;
    }

    // functions:
    void playSong() {
        System.out.println("Playing: " + song);
    }
    void playAllSongs() {
        for(String i : playlist) {
            System.out.println("Playing: " + i);
        }
    }

}


/*
Плеер 1.
Имеет final цену(задается в конструкторе) и геттер
Имеет только 1 песню (нельзя объявить эту переменную в классе этого плеера)
playSong Может проиграть песню.
*/
class Player1 extends MP3player {
    Player1(double price) {
        super(price);
    }

    @Override
    void playSong() {
        super.playSong();
    }
    @Override
    void playAllSongs() {
    }
}

/*
Плеер 2.
Имеет final цену(задается в конструкторе) и геттер
Имеет только 1 песню (нельзя объявить эту переменную в классе этого плеера)
playSong Пытаясь проиграть песню выдает ошибку в консоль - “error”.
 */
class Player2 extends MP3player {
    Player2(double price) {
        super(price);
    }

    @Override
    void playSong() {
        System.out.println("error");
    }
    @Override
    void playAllSongs() {
    }
}

/*
Плеер 3.
Имеет final цену(задается в конструкторе) и геттер
Имеет плейлист
playSong Может проиграть первую песню
playAllSongs может проиграть все песни
 */
class Player3 extends MP3player {
    Player3(double price) {
        super(price);
    }

    @Override
    void playSong() {
        System.out.println("Playing: " + getPlaylist()[0]);
    }
    @Override
    void playAllSongs() {
        super.playAllSongs();
    }
}

/*
Плеер 4.
Имеет final цену(задается в конструкторе) и геттер
Имеет плейлист
playSong Может проиграть последнюю песню
playAllSongs может проиграть все песни
 */
class Player4 extends MP3player {
    Player4(double price) {
        super(price);
    }

    @Override
    void playSong() {
        System.out.println("Playing: " + getPlaylist()[getPlaylist().length - 1]);
    }
    @Override
    void playAllSongs() {
        super.playAllSongs();
    }
}

/*
Плеер 5.
Имеет final цену(задается в конструкторе) и геттер
Имеет плейлист
playSong Может проиграть первую песню
playAllSongs может проиграть все песни с конца плейлиста в начало
 */
class Player5 extends MP3player {
    Player5(double price) {
        super(price);
    }

    @Override
    void playSong() {
        System.out.println("Playing: " + getPlaylist()[0]);
    }
    @Override
    void playAllSongs() {
        for (int i = getPlaylist().length; i > 0; i--) {
            System.out.println("Playing: " + i);
        }
    }
}

/*
Плеер 6.
Имеет final цену(задается в конструкторе) и геттер
Имеет плейлист
playSong Может проиграть первую песню
playAllSongs может проиграть все песни
Имеет метод public void shuffle() - перемешивает все песни в плейлисте местами
 */
class Player6 extends MP3player {
    Player6(double price) {
        super(price);
    }

    @Override
    void playSong() {
        System.out.println("Playing: " + getPlaylist()[0]);
    }
    @Override
    void playAllSongs() {
        super.playAllSongs();
    }
    void shuffle() {
        int n = getPlaylist().length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            String temp = getPlaylist()[i];
            getPlaylist()[i] = getPlaylist()[change];
            getPlaylist()[change] = temp;
        }
    }
}



