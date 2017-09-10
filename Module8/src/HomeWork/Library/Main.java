package HomeWork.Library;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;

public class Main {

    private static int peopleCount;
    private static int maxCount;
    private static int counter;

    static {
        try {
            System.out.println("Enter people count:");
            peopleCount = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            System.out.println("Enter maximum count:");
            maxCount = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } catch (IOException e) {
        }
    }

    private static final Semaphore SEMAPHORE_LIBRARY = new Semaphore(maxCount);
    private static final Semaphore SEMAPHORE_DOOR = new Semaphore(1);

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= peopleCount; i++) {
            new Thread(new Visitor(i)).start();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Visitor implements Runnable {
        private int visitorNumber;

        public Visitor(int visitorNumber) {
            this.visitorNumber = visitorNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Посетитель %d пришел ко входу в библиотеку\n", visitorNumber);
                if (counter >= maxCount) System.out.printf("Посетитель %d ждет входа в библиотеку\n", visitorNumber);
                SEMAPHORE_LIBRARY.acquire();
                counter++;
                System.out.printf("Посетитель %d подошел к двери с улицы\n", visitorNumber);

                    SEMAPHORE_DOOR.acquire();
                    System.out.printf("Посетитель %d проходит через дверь внутрь\n", visitorNumber);
                    Thread.sleep(500);
                    System.out.printf("Посетитель %d прошел через дверь внутрь\n", visitorNumber);
                    SEMAPHORE_DOOR.release();

                System.out.printf("Посетитель %d вошел в библиотеку\n", visitorNumber);
                System.out.printf("Посетитель %d читает книгу\n", visitorNumber);
                Thread.sleep((int)((Math.random() * 4000) + 1000));
                System.out.printf("Посетитель %d подошел к двери изнутри\n", visitorNumber);

                    SEMAPHORE_DOOR.acquire();
                    System.out.printf("Посетитель %d проходит через дверь наружу\n", visitorNumber);
                    Thread.sleep(500);
                    System.out.printf("Посетитель %d прошел через дверь наружу\n", visitorNumber);
                    SEMAPHORE_DOOR.release();

                SEMAPHORE_LIBRARY.release();
                counter--;
                System.out.printf("Посетитель %d вышел из библиотеки\n", visitorNumber);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}