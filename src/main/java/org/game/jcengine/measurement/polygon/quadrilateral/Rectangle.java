package org.game.jcengine.measurement.polygon.quadrilateral;

import java.util.Map;
import java.util.TreeMap;

public class Rectangle{
    private double length;
    private double breadth;
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    public Rectangle(double diagonal, Double angle) {
        length = Math.sin(Math.toRadians(angle)) * diagonal;
        breadth = Math.cos(Math.toRadians(angle)) * diagonal;
    }
    public Rectangle(Double area,Double angle){
         length=Math.sqrt(area*Math.tan(Math.toRadians(angle)));
         breadth=Math.sqrt(area*(1/Math.tan(Math.toRadians(angle))));
    }
    public double getBreadth() {
        return breadth;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return length*breadth;
    }

    public double getPerimeter() {
        return 2*(length+breadth);
    }
    public TreeMap<String,Double> getDiagonals(){
        return new TreeMap<>(Map.of("D1", Math.sqrt(length * length + breadth * breadth), "D2", Math.sqrt(length * length + breadth * breadth)));
    }
    public TreeMap<String,Double> getAngle(){
        return new TreeMap<>(Map.of("S1_S2",90.0,"S2_S3",90.0,"S3_S4",90.0,"S4_S1",90.0));
    }
}
