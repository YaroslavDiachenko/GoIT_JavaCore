

import java.util.Scanner;
import java.util.concurrent.*;

public class Task2 {

    static final Semaphore SEMAPHORE = new Semaphore(1);
    static int size = 1000000;

    static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    static void calculate(int[] array) throws InterruptedException, ExecutionException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input N: ");
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("\nCycle " + (i+1) + ":");
            System.out.println("\nTime spent:");
            SEMAPHORE.acquire();
            long checkPoint1 = System.currentTimeMillis();

            double d1 = calculateInOneThread(array);
            long checkPoint2 = System.currentTimeMillis();
            System.out.println("One thread: \t" + (checkPoint2 - checkPoint1) + " milliseconds; Result: " + d1);

            double d2 = calculateInMultiThreads(array);
            long checkPoint3 = System.currentTimeMillis();
            System.out.println("Multi threads: \t" + (checkPoint3 - checkPoint2) + " milliseconds; Result: " + d2);

            double d3 = calculateInThreadPool(array);
            long checkPoint4 = System.currentTimeMillis();
            System.out.println("Thread pool: \t" + (checkPoint4 - checkPoint3) + " milliseconds; Result: " + d3);
            SEMAPHORE.release();
        }
    }

    static double calculateInOneThread(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Math.sin(array[i]) + Math.cos(array[i]);
        }
        return sum;
    }

    static double calculateInMultiThreads(int[] array) throws ExecutionException, InterruptedException {

        double totalSum = 0;
        final int coresNumber = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < coresNumber; i++) {
            final int left = array.length / coresNumber * i;
            final int right = array.length / coresNumber * (i + 1);

            Callable<Double> callable = () -> {
                double partSum = 0;
                for (int j = left; j < right; j++) {
                    partSum += Math.sin(array[j]) + Math.cos(array[j]);
                }
                return partSum;
            };

            FutureTask<Double> futureTask = new FutureTask<>(callable);
            new Thread(futureTask).start();
            totalSum += futureTask.get();
        }
        return totalSum;
    }

    static double calculateInThreadPool(int[] array) throws ExecutionException, InterruptedException {

        double totalSum = 0;
        final int coresNumber = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(coresNumber);

        for (int i = 0; i < coresNumber; i++) {
            final int left = array.length / coresNumber * i;
            final int right = array.length / coresNumber * (i + 1);

            Callable<Double> callable = () -> {
                double partSum = 0;
                for (int j = left; j < right; j++) {
                    partSum += Math.sin(array[j]) + Math.cos(array[j]);
                }
                return partSum;
            };

            FutureTask<Double> futureTask = new FutureTask<>(callable);
            executor.submit(futureTask);
            totalSum += futureTask.get();
        }
        executor.shutdown();
        return totalSum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        calculate(createArray(size));
    }
}
