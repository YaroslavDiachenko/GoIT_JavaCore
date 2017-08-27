package HomeWork;


import java.util.Scanner;

/**
 "width" - rectangle's width;
 "height" - rectangle's height;
 "temp_width" - decreasing temporary counter of rectangle's width; is recovered within each new line;
**/

public class Task6 {

    static void drawRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Task #6 selected.");
        System.out.print("Specify rectangle's width: ");
        int width = sc.nextInt();
        System.out.print("Specify rectangle's height: ");
        int height = sc.nextInt();
        System.out.println("Result:");
        drawRectangle(width,width,height);
        System.out.println();
    }

    static void drawRectangle(int temp_width, int width, int height) {
        if (temp_width > 0) {
            System.out.print("+ ");
            drawRectangle(temp_width - 1, width, height);
        }
        else if ((temp_width == 0) && (height > 1)) {
            System.out.println("");
            drawRectangle(width, width, height - 1);
        }
    }
}
