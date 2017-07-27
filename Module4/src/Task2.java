/*
Задание 2
Написать функцию drawRectangle которая рисует в консоли прямоугольник из символов '+'
Аргументы функции: ширина прямугольника в символах, высота прямоугольника в символах
Например 3 на 2
Вывод программы: + + + + + +
*/

public class Task2 {

    static void drawRectangle(int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("+");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        drawRectangle(5,3);
    }
}
