package HomeWork;


public class Main {
    public static void main(String[] args) {
        MP3player player1 = new Player1(10);
        MP3player player2 = new Player2(20);

        System.out.println(player1.getPrice());
        System.out.println(player2.getPrice());


    }
}
