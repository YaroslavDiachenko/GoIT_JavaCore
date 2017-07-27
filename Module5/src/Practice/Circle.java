package Practice;


public class Circle {
    float r; // radius
    Point point;

    public Circle(float r, Point point) {
        this.r = r;
        this.point = point;
    }

    boolean collisionCheck(Circle otherCircle) {
        double radiusSum = this.r + otherCircle.r;
        return radiusSum > (double) this.point.calcLength(otherCircle.point);
    }

    void printCircle() {
        System.out.println("Radius: " + this.r);
        System.out.println("Point x: " + this.point.x);
        System.out.println("Point y: " + this.point.y);
    }
}