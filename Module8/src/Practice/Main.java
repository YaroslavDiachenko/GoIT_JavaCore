package Practice;


public class Main {

    static int x;

    public static void main(String[] args) {
        final int y = 20;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                x = 10;
                x = y;
                int y2 = y;
                y2 = 0;
                y2 = y-1;

            }
        };

        runnable.run();

        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();

    }
}