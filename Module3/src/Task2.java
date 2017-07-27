/*
Задание 2 (дополнительное)
Добавить к программе из задания 1 следующее:
7. вывести в консоль максимальное кол-во повторений чисел в массиве

пример 1: массив 1, 2, 3, 4, 1, 6. Ответ 2. Так как число 1 повторяется 2 раза

пример 2: массив 1, 1, 1, 4, 6, 6. Ответ 3. Так как число 1 повторяется 3 раза. А число 6 повторяется
2 раза. Поскольку надо вывести максимум, выводим 3.

пример 3: массив 2, 3, 3, 5, 5, 6. Ответ 3. Так как 3 и 5 повторяются по 2 раза, не важное кого из них
подсчитывать, цель - вывести максимум. В этом примере максимум повторений чисел является 2 раза.

8. вывести в консоль минимальное кол-во повторений чисел в массиве
*/

/**

 "maxRepeatsNumber" - maximum number of repeats of particular value in array;
 "maxRepeatsValue" - value in the array that repeats maximum times;
 "repeatsNumber" - temporary counter of repeats of each value in array;

 ***/

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

        int[] array = MyMethods.initializeArray();
        Arrays.sort(array);

        int maxRepeatsNumber = 1;
        int maxRepeatsValue = array[0];
        int repeatsNumber = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) {
                repeatsNumber++;

                if (repeatsNumber > maxRepeatsNumber) {
                    maxRepeatsNumber = repeatsNumber;
                    maxRepeatsValue = array[i];
                }
            }else
                repeatsNumber = 1;
        }

        System.out.println("Maximum number of repeats: " + maxRepeatsNumber);
        System.out.println("Maximum times repeated value: " + maxRepeatsValue);

    }
}
