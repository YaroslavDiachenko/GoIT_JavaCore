package Practice;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {



    public static void main(String[] args) throws IOException {
        long startTime;
        long endTime;

        String path = "/Users/test/IdeaProjects/GoIT_JavaCore/Module8/files/10 000 000 Numbers.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));

        Gson gson = new Gson();
        String json = reader.readLine();
        int[] array = gson.fromJson(json, new TypeToken<int[]>(){}.getType());

        startTime = System.currentTimeMillis();
        System.out.println(sum1(array));
        System.out.println(multiple(array));
        System.out.println(divide(array));
        System.out.println(minus(array));

        endTime = System.currentTimeMillis();

        System.out.println("Time: " + (endTime - startTime));




    }


    // 1
    static int sum1(int[] array) {
        int sum = 0;
        for (int e : array) {
            sum += e;
        }
        return sum;
    }
    // 2
    static int multiple(int[] array) {
        int multiple = 1;
        for (int e : array) {
            multiple *= e;
        }
        return multiple;
    }
    // 3
    static int divide(int[] array) {
        int sum = 0;
        int index = 1;
        for (int e : array) {
            sum += e/index;
            index++;
        }
        return sum;
    }
    // 4
    static int minus(int[] array) {
        int minus = 0;
        for (int e : array) {
            minus -= e;
        }
        return minus;
    }


    static void sum2(int[] array,int a,int b) {
        Runnable runnable = () -> {
            int temp = 0;
            for (int i = a; i < b; i++) {
                temp += array[i];
            }
            sum += temp;
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }



    static int sum = 0;




}