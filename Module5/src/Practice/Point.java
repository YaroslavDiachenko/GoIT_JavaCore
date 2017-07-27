package Practice;


public class Point {

    float x;
    float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    float calcLength(Point otherPoint) {
        return (float) Math.sqrt(Math.pow((this.y - otherPoint.y),2) + Math.pow((this.x - otherPoint.x),2));
    }
}
