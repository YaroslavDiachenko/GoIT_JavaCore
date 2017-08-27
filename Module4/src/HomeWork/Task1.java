package HomeWork;


import java.util.Scanner;

public class Task1 {

    static void countArguments(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Task #1 selected. Specify integer number: ");
        int n = sc.nextInt();
        System.out.print("Result: ");
        for (int i = 1; i <= n; i++) {
            if (i == n) System.out.println(i);
            else System.out.print(i + ", ");
        }
    }
}
