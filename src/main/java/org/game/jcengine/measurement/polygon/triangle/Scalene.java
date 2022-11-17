package org.game.jcengine.measurement.polygon.triangle;

import java.util.TreeMap;

public class Scalene {
    private double area;
    private double perimeter;
    private double s;//semi-perimeter
    private TreeMap<String,Double> angles;
    public TreeMap<String, Double> getAngles() {
        return angles;
    }
    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSemi_perimeter() {
        return s;
    }
    public Scalene(double a,double b,double c){
        this.s=(a+b+c)/2;
        this.perimeter=(a+b+c);
        this.area=Math.sqrt(this.s*(this.s-a)*(this.s-b)*(this.s-c));
        assert false;
        angles.put("angle1",Math.toDegrees(Math.acos((b*b+c*c-a*a)/2*b*c)));
        angles.put("angle2",Math.toDegrees(Math.acos((a*a+c*c-b*b)/2*a*c)));
        angles.put("angle3",Math.toDegrees(Math.acos((a*a+b*b-c*c)/2*a*b)));
    }
    public Scalene(){
    }
    public static  class method1{
        TreeMap<String,Double> sides;
        TreeMap<String,Double> angle;
        public double getArea() {
            return area;
        }
        private final double area;
            method1(double side1, double side2,double angle_BetweenSides){
                  this.area=side1*side2*Math.sin(Math.toDegrees(angle_BetweenSides))/2;
            }
    }
    public static  class method2{
        public double getArea() {
            return area;
        }

        private  final  double area;
           method2(double base,double height){
               this.area=0.5*base*height;
           }
    }
    public static  class method3{

    }
}
