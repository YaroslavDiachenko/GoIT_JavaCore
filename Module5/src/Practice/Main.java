package Practice;

public class Main {
    public static void main(String[] args) {

        Point p1 = new Point(2,2);
        Point p2 = new Point(1,1);

        System.out.println(p1.calcLength(p2));
        System.out.println("------------------------");

        Circle c1 = new Circle(5,p1);
        Circle c2 = new Circle(3,p2);

        System.out.println(c1.collisionCheck(c2));
        c1.printCircle();

        CircleGenerator generator = new CircleGenerator();
        generator.generate(3);

        for (Circle i : generator.array) {
            i.printCircle();
        }
        generator.countOfCollisions();
    }

    // test comment 2
}