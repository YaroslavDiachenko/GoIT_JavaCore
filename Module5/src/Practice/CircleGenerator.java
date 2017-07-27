package Practice;


import java.util.Random;

public class CircleGenerator {
    Circle[] array;

    void generate(int countOfCircles) {
        this.array = new Circle[countOfCircles];
        Random r = new Random();
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = new Circle(r.nextFloat(), new Point(r.nextFloat(), r.nextFloat()));
        }
    }

    void countOfCollisions() {
        for (int i = 0; i < this.array.length; i++) {
            for (int j = i + 1; j < this.array.length; j++) {
                System.out.println(this.array[j].collisionCheck(this.array[j-1]));
            }
        }
    }

    // test comment 1
}