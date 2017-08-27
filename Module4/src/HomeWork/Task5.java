package HomeWork;


import java.util.Scanner;

public class Task5 {

    static void count() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task #5 selected. Specify integer number: ");
        int a = sc.nextInt();
        System.out.print("Result: ");
        count(a, 1);
    }

    static void count(int a, int b) {
        if (b <= a) {
            System.out.println(b++);
            count(a,b);
        }
    }
}
