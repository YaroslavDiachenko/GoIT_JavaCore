/*
Программа считывает массив А
Перевернуть массив (отзеркалить массив) и вывести его в консоль
 */

import java.util.Scanner;

public class Practice2 {

    public static void main(String[] args) {

        int[] array = MyMethods.initializeArray();
        MyMethods.reverseArray(array);
        MyMethods.printArray(array);
    }
}
