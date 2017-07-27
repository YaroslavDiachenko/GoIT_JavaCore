import java.util.Scanner;

class MyMethods {

    static int[] initializeArray() {

        // 1. Input string (list of numbers)
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input array:");
        String s = sc.nextLine();

        // 2. Split string to string array
        String[] stringArray = s.split(",");

        // 3. Parse string array to integer array
        int[] array = new int[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }

        return array;
    }

    static void reverseArray(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
    }

    static void printArray(int[] array) {
        System.out.print("\nOutput result: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i == array.length-1 ? array[i]+"\n" : array[i]+", ");
        }
    }
}
