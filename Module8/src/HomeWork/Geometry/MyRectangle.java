package HomeWork.Geometry;


import javafx.scene.shape.Rectangle;

public class MyRectangle extends Rectangle{
    Vector vector;
    enum Vector {UpRight,DownRight,UpLeft,DownLeft}

    public MyRectangle(double x, double y, double width, double height, Vector vector) {
        super(x, y, width, height);
        this.vector = vector;
    }
}
