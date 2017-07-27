/*
Программа считывает массив А
Отсортировать массив по убыванию и вывести в консоль
 */


import java.util.Arrays;

public class Practice4 {
    public static void main(String[] args) {

        int[] array = MyMethods.initializeArray();
        Arrays.sort(array);
        MyMethods.reverseArray(array);
        MyMethods.printArray(array);
    }
}
