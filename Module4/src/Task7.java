/*
Задание 7 (дополнительно)
Написать программу, в которой выполнены все шесть предыдущих заданий. Каждое задание выполняется в отдельной функции.
В пределах этой же функции происходит ввод с консоли необходимых данных. Программа спрашивает пользователя какую задачу
он хочет решить (от 1 до 6). Затем программа вызывает соответствующую функцию для решения этой задачи. По окончанию
решения задачи, программа спрашивает пользователя, хочет ли он продолжить решать задачи. Если да - опять спрашивает
какую задачу.
 */

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String reply = "NO";

        do {
            System.out.println("Please choose task (from 1 to 6): ");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("ok - 1");
                    break;
                case 2:
                    System.out.println("ok - 2");
                    break;
                default:
                    System.out.println("Do you want to try again? (Y/N)");
                    reply = sc.nextLine();
            }
        } while (reply.equals("YES"));
    }
}
