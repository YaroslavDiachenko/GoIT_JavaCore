/*
Задание 1
Написать функцию которая считает в консоли до числа Х. Аргументы функции: число Х Например Х = 5.
Вывод программы: 1 2 3 4 5
*/

public class Task1 {

    static void countArguments(int n){
        for (int i = 1; i <= n; i++) {
            System.out.print (i + " ");
        }
    }

    public static void main(String[] args) {
        countArguments(5);
    }
}
