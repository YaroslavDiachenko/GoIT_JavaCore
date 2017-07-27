/*
Задание 4
Написать функцию getMax которая принимает на вход два аргумента в виде чисел. А возврыщает максимальное из этих двух.
Так же, необходимо перегрузить эту функцию для работы с разными числовыми типами переменных (int, float)
*/

public class Task4 {

    static int getMax(int a, int b) {
        return (a > b ? a : b);
    }

    static float getMax(float a, float b) {
        return (a > b ? a : b);
    }

    static int getMax2(int... numbers) {
        int max = Integer.MIN_VALUE;
        for(int i : numbers) {
            if (i >  max) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMax(4,1));
        System.out.println(getMax(4.48786f,3.12432f));
        System.out.println(getMax2(-123,-5657,-7867,-234));
    }
}