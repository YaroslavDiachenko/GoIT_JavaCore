/*
Задание 3
Перегрузить функцию drawRectangle (задание 2) таким образом, что бы она могла принимать на вход только 1 параметр
(ширина квадрата) и рисовать квадрат с равными сторонами
Например 2 Вывод программы: + + + +
Например 3 Вывод программы: + + + + + + + + +
*/

public class Task3 {

    static void drawRectangle(int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("+");
            }
            System.out.print("\n");
        }
    }

    static void drawRectangle(int a) {
        drawRectangle(a,a);
    }

    public static void main(String[] args) {
        drawRectangle(5);
    }
}