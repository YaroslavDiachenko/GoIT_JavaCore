package HomeWork;


import java.util.Scanner;

public class Task2 {

    static void drawRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Task #2 selected.");
        System.out.print("Specify rectangle's width: ");
        int a = sc.nextInt();
        System.out.print("Specify rectangle's height: ");
        int b = sc.nextInt();
        System.out.println("Result:");
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("+ ");
            }
            System.out.print("\n");
        }
    }
}
