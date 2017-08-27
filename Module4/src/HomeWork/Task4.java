package HomeWork;


import java.util.Scanner;

public class Task4 {

    static void getMax() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Task #4 selected.");
        System.out.print("Specify first number: ");

        int n1,n2;
        float f1,f2;

        try{
            n1 = sc.nextInt();
            System.out.print("Specify second number: ");
            n2 = sc.nextInt();
            System.out.println("Maximum number is " + getMax(n1,n2));
        }catch (Exception a) {
            try {
                f1 = sc.nextFloat();
                System.out.print("Specify second number: ");
                f2 = sc.nextFloat();
                System.out.println("Maximum number is " + getMax(f1,f2));
            }catch (Exception b) {
                System.out.println();
            }
        }
    }

    static int getMax(int a, int b) {
        return (a > b ? a : b);
    }

    static float getMax(float a, float b) {
        return (a > b ? a : b);
    }
}