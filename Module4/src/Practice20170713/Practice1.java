package Practice20170713;

/*
Задача 1
Написать функцию - findMaxIndex которая принимает на вход массив чисел и возвращает индекс максимального числа.
Написать функцию - findMaxNumber которая принимает на вход массив чисел и возвращает максимальное число, используя
первую функцию - findMaxIndex. Перегрузить findMaxIndex и findMaxNumber для работы с int и float
*/

public class Practice1 {
    public static void main(String[] args) {
        int a = findMaxIndex(new int[]{1,2,3,4});
        System.out.println(a);
    }

    static int findMaxIndex(int[] array) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    static int findMaxNumber(int[] array) {
        return array[findMaxIndex(array)];
    }

    static int findMaxIndex(float[] array) {
        int index = 0;
        float max = Float.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    static float findMaxNumber(float[] array) {
        return array[findMaxIndex(array)];
    }
}
