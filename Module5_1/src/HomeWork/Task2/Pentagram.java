package HomeWork.Task2;


import javafx.scene.shape.Path;

public class Pentagram {

    Path path = new Path();

    Path drawPentagram(double x0, double y0, double radius) {
//        double[] axisX = new double[5];
//        double[] axisY = new double[5];

//        for (int i = 0; i < axisX.length; i++) {
//            axisX[i] = x0 + radius * Math.round(Math.cos(2 * Math.PI / 5 * i * 2 + 36));
//        }
//        for (int i = 0; i < axisY.length; i++) {
//            axisY[i] = y0 + radius * Math.round(Math.sin(2 * Math.PI / 5 * i * 2 + 36));
//        }

        final double arc = Math.PI / 5;
        final double rad = Math.sin (Math.PI / 10) / Math.sin (3 * Math.PI/10);
        for (int i = 0; i < 5; i++) {
//            this.path.lineTo(rad * Math.cos ((1 +2 * i) * arc), rad * Math.sin ((1 +2 * i) * arc));
//            this.path.lineTo(Math.cos (2 * (i +1) * arc), Math.sin (2 * (i +1) * arc));
        }
        return this.path;
    }
}
