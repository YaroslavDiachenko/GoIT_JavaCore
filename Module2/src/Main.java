/*
Домашнее Задание №2

1. Создать новый проект на своем компе
2. Создать новый проект на GitHub и объеденить проекст локальный с проектом на GitHub
3. Написать программу, которая делает следующее:
3.1 спрашивает у пользователя имя (String)
3.2 спрашивает у пользователя город проживания (String)
3.3 спрашивает у пользователя возраст (int)
3.5 спрашивает у пользователя хобби (String)
3.6 перед каждым вводом данных, программа должна вывести информацию пользователю с требованием ввода соответствующей информации.
3.7 прогрмма выводит красиво оформленно всю информацию о пользователе в трех разных вариантах:
----------------------------------
Вариант 1 (табличный):
Имя: хххххх
Город: хххххх
Возраст: хххххх
Хобби: хххххх
----------------------------------
Вариант 2 (текстовый):
Человек по имени хххххх живет в городе хххххх.
Этому человеку хххххх лет и любит он заниматься хххххх.
----------------------------------
Вариант 3 (иной):
хххххх - имя
хххххх - город
хххххх - возраст
хххххх - хобби
----------------------------------
4. По ходу решения задачи, пушить изменения на GitHub
5. Финальный рабочий код программы которая соответствует всем подпунктам пункта 3, залить на GitHub
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner i = new Scanner(System.in);

        // Data input:
        System.out.println("Please input your name:");
        String name = i.nextLine();
        System.out.println("Please input your city of residence:");
        String city = i.nextLine();
        System.out.println("Please input your age:");
        int age = i.nextInt();
        System.out.println("Please input your hobby:");
        i.nextLine();
        String hobby = i.nextLine();

        // Data output:
        System.out.println("Please choose display format: 1 - tabular, 2 - text, 3 - other: ");
        int f = i.nextInt();

        switch (f) {
            case 1: // Option #1 (tabular):
                System.out.printf("\n----------------\nName: %s \nCity: %s \nAge: %d \nHobby: %s\n----------------\n", name, city, age, hobby);
                break;
            case 2: // option #2 (text):
                System.out.printf("\n----------------\nA person named %s lives in %s city.\nHe is %d years old and likes %s.\n----------------\n", name, city, age, hobby);
                break;
            case 3: // Option #3 (other):
                System.out.printf("\n----------------\n%s - name \n%s - city \n%d - age \n%s - hobby\n----------------\n", name, city, age, hobby);
                break;
        }

    }
}

