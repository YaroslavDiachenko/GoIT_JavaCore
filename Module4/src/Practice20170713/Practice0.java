package Practice20170713;

/*
Функция находит среднее арифметическое от всех элементов массива. Затем, находит элемент массива который максимально
приближен к среднему арифметическому. Если найдено несколько берем наименьшее.
*/

/**

"sum" - sum of values of all array's elements
"averageValue" - average value of all array's elements
"difference" - difference between value of array's element and average value of all array's elements
"closestValue" - the closest value in the array to the average one
"closestElement" - element in the array containing the closest value to the average one

**/

public class Practice0 {

    static void findClosestElement(int[] array) {

        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double averageValue = sum / array.length;
        double difference = Double.MAX_VALUE;
        int closestElement = 1;

        for (int i = 1; i < array.length; i++) {
            if ((Math.abs(array[i] - averageValue)) < difference) {
                closestElement = i;
                difference = Math.abs(array[i] - averageValue);
            }else if ((Math.abs(array[i] - averageValue) == difference) && (array[i] < array[closestElement])) {
                closestElement = i;
                difference = Math.abs(array[i] - averageValue);
            }
        }

        System.out.println("Element #" + closestElement + " contains the closest value (" + array[closestElement] +
                        ") in the array to the average one (" + averageValue + ")");
    }

    public static void main(String[] args) {
        findClosestElement(new int [] {3,5,1,8,6,2,7,4});
    }

}
