package Practice20170713;

/*
Задача 3
Задача на рекурсию. Даны два целых числа A и В (каждое в отдельной строке).
Выведите все числа от A до B включительно, в порядке возрастания
*/

public class Practice3 {

    public static void printRange(int a, int b) {

        if (a > b) {
            System.out.print(b + " ");
            printRange(a,b + 1);
        } else if (a < b) {
            System.out.print(a + " ");
            printRange(a + 1, b);
        }else
            System.out.println(a);
    }

    public static void main(String[] args) {
        printRange(3, 7);
        printRange(10, 2);
    }
}