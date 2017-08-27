package HomeWork;


import java.util.Scanner;

public class Task3 {

    static void drawRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task #3 selected. Specify square's height(width): ");
        int a = sc.nextInt();
        System.out.println("Result: ");
        drawRectangle(a,a);
    }

    static void drawRectangle(int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("+ ");
            }
            System.out.print("\n");
        }
    }
}