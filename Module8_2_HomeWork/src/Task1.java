

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Task1 {

    static void returnInteger(Callable<Integer> callable) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println("Result: " + futureTask.get());
    }

    static void returnBoolean(Callable<Boolean> callable) throws ExecutionException, InterruptedException {
        FutureTask<Boolean> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println("Result: " + futureTask.get());
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number A: ");
        int A = in.nextInt();
        System.out.print("Input number B: ");
        int B = in.nextInt();
        System.out.print("Choose action (+, -, *, /, %, ==, >, <): ");
        in.nextLine();
        String action = in.nextLine();

        Callable<Integer> callable1;
        Callable<Boolean> callable2;

        switch (action) {
            case "+":
                callable1 = () -> A+B;
                returnInteger(callable1);
                break;
            case "-":
                callable1 = () -> A-B;
                returnInteger(callable1);
                break;
            case "*":
                callable1 = () -> A*B;
                returnInteger(callable1);
                break;
            case "/":
                callable1 = () -> A/B;
                returnInteger(callable1);
                break;
            case "%":
                callable1 = () -> A%B;
                returnInteger(callable1);
                break;
            case "==":
                callable2 = () -> A==B;
                returnBoolean(callable2);
                break;
            case ">":
                callable2 = () -> A>B;
                returnBoolean(callable2);
                break;
            case "<":
                callable2 = () -> A<B;
                returnBoolean(callable2);
                break;
        }
    }
}
