/*
Задание 5
Решить задачу 1, без использования циклов. Использовав рекурсию.
*/

public class Task5 {

    static void count(int a) {
        count(a, 1);
    }

    static void count(int a, int b) {
        if (b <= a) {
            System.out.println(b++);
            count(a,b);
        }

    }

    public static void main(String[] args) {
        count(5);
    }
}
