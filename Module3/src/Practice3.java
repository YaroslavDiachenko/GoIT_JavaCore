/*
Программа считывает массив А
Программа считывает миссив B
Необходимо просумировать каждый i-тый элемент массива А с каждым i-тым элементом массива B.
Если i-того элемента нет - считать его нулем.
Вывести массив - результат всех сумм.
 */

import java.util.Scanner;

public class Practice3 {

    public static void main(String[] args) {

        int[] arrayA = MyMethods.initializeArray();
        int[] arrayB = MyMethods.initializeArray();

        int maxLength = arrayA.length > arrayB.length ? arrayA.length : arrayB.length;
        for (int i = 0; i < maxLength; i++) {
            int sum = 0;
            if ((i + 1) <= arrayA.length) sum += arrayA[i];
            if ((i + 1) <= arrayB.length) sum += arrayB[i];
            System.out.print(sum + ", ");
        }
    }
}
