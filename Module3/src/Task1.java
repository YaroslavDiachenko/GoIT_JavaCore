/*
Задание 1
Создать новый проект на GitHub и на локальном компе Написать программу которая:
1. на вход через консоль принимает размер массива
2. на вход через консоль принимает массив чисел
3. найти минимальное число в массиве и вывести в консоль (без использования сортировки)
4. найти максимальное число в массиве и вывести в консоль (без использования сортировки)
5. посчитать кол-во повторений числа 5 и вывести в консоль
6. вывести в консоль отсортированный массив
*/

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        // 2.

        int[] array = MyMethods.initializeArray();

        // 3.

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        System.out.println("Minimum array's value is: " + min);

        // 4.

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        System.out.println("Maximum array's value is: " + max);

        // 5.

        int count = 0;
        for (int element : array) {
            if (element == 5) count++;
        }
        System.out.println("Number of array's elements equal to five is: " + count);

        // 6 (BubbleSort)

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j-1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }

        MyMethods.printArray(array);
    }

}
