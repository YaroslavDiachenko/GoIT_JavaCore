package Practice20170713;

/*
Задача 2
Написать рекурсивную функцию возведения числа-Х в степень-N. Нельзя использовать циклы.
*/

public class Practice2 {

    static int power(int x, int n) {
        if (n > 1) x *= power(x,n-1);
        return x;
    }

    public static void main(String[] args) {
        System.out.println(power(3,3));
    }
}
