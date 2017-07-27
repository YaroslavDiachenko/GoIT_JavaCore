/*
Пользователь вводит 2 числа.
Программа сохраняет два числа в две переменных.
Первая переменная - А, вторая переменная - B.
Необходимо вывести оба числа, в обратное последовательности.
Но первой на вывод должна идти переменная А, второй - B.
 */

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input first value:");
        int a = in.nextInt();
        System.out.println("Input second value:");
        int b = in.nextInt();

        int temp;
        temp = a;
        a = b;
        b = temp;

        System.out.println(a);
        System.out.println(b);
    }
}
