package HomeWork;


import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "List of tasks: \n" +
                "  1 - count arguments;\n" +
                "  2 - draw rectangle;\n" +
                "  3 - draw square;\n" +
                "  4 - get max number;\n" +
                "  5 - count arguments (recursion);\n" +
                "  6 - draw rectangle (recursion).\n"
        );

        String reply;

        do {
            System.out.print("Select task (from 1 to 6): ");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    Task1.countArguments();
                    break;
                case 2:
                    Task2.drawRectangle();
                    break;
                case 3:
                    Task3.drawRectangle();
                    break;
                case 4:
                    Task4.getMax();
                    break;
                case 5:
                    Task5.count();
                    break;
                case 6:
                    Task6.drawRectangle();
            }
            System.out.print("\nDo you want to try again? (Y/N) ");
            sc.nextLine();
            reply = sc.nextLine();
        } while (reply.equals("Y"));
    }
}
