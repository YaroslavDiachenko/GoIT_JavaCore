/*
Задание 6
Решить задачу 2, без использования циклов. Использовав рекурсию.
*/

/**
 "width" - rectangle's width;
 "height" - rectangle's height;
 "temp_width" - decreasing temporary counter of rectangle's width; is recovered within each new line;
**/

public class Task6 {

    static void drawRectangle(int width, int height) {
        drawRectangle(width,width,height);
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

    public static void main(String[] args) {
        drawRectangle(5,3);
    }
}
