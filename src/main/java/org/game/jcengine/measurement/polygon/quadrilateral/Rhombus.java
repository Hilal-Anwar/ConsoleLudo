package org.game.jcengine.measurement.polygon.quadrilateral;
import java.util.TreeMap;

public class Rhombus {
    public double getCommonSide() {
        return commonSide;
    }

    public double getDiagonal1() {
        return diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public TreeMap<String, Double> getAngles() {
        return angles;
    }

    private final double commonSide;
    private final double diagonal1;
    private final double diagonal2;
    private final double area;
    private final double perimeter;
    TreeMap<String,Double> angles;
    public Rhombus(double diagonal1,double diagonal2){
        this.diagonal1=diagonal1;
        this.diagonal2=diagonal2;
        commonSide=Math.sqrt(0.5*this.diagonal1*this.diagonal1+0.5*this.diagonal2*this.diagonal2);
        angles.put("angle1",2*Math.toDegrees(Math.atan(this.diagonal1/this.diagonal2)));
        angles.put("angle2",2*Math.toDegrees(Math.atan(this.diagonal2/this.diagonal1)));
        angles.put("angle3",2*Math.toDegrees(Math.atan(this.diagonal1/this.diagonal2)));
        angles.put("angle4",2*Math.toDegrees(Math.atan(this.diagonal2/this.diagonal1)));
        this.area=0.5*this.diagonal2*this.diagonal1;
        this.perimeter=4*this.commonSide;
    }
}
