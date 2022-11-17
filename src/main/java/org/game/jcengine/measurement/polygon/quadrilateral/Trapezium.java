package org.game.jcengine.measurement.polygon.quadrilateral;

import java.util.Map;
import java.util.TreeMap;

public class Trapezium {
    public method1 setTrapeziumValues(double a, double b, double height) {
        return new method1(a, b, height);
    }
    public method1 setTrapeziumValues(double area,double height,float times) {
        return new method1(area,height,times);
    }
    public method1 setTrapeziumValues(Double area,double a,double b) {
        return new method1(area,a,b);
    }
    public method1 setTrapeziumValues(Double area,double height,float constant) {
        return new method1(area,height,constant);
    }
    public method2 setTrapeziumValues(double a,double height, double base_angle1, double base_angle2) {
        return new method2(a,height,base_angle1,base_angle2);
    }
    public method3 set_IsoscelesTrapeziumValues(double a, double b, double height) {
        return new method3(a, b, height);
    }
    final public static class method1{
        private double a;
        private double b;
        private final double height;
        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getHeight() {
            return height;
        }
        method1(double a, double b, double height) {
            this.a = a;
            this.b = b;
            this.height = height;
        }
        method1(double area, double height, float times) {
            this.a = 2*area/((times+1)*height);
            this.b =(this.a)*times;
            this.height = height;
        }
        method1(Double area, double a, double b) {
            this.a = a;
            this.b = b;
            this.height = 2*area/(a+b);
        }
        method1(Double area, double height, float constant) {
            this.a = ((2*area/height)-constant)/2;
            this.b = (this.a)+constant;
            this.height = height;
        }
        public double getArea() {
            return 0.5*(a+b)*height;
        }
    }
    final public static class method2{
        private double a;
        private double b;
        private double height;
        private double base_angle1;
        private double base_angle2;
        method2(double a,double height, double base_angle1, double base_angle2) {
            this.a = a;
            this.b = a+height*(1/Math.tan(Math.toRadians(base_angle1))+1/Math.tan(Math.toRadians(base_angle2)));
            this.height=height;
            this.base_angle1 = base_angle1;
            this.base_angle2 = base_angle2;
        }
        public double getArea() {
            return 0.5*(a+b)*height;
        }

        public double getPerimeter() {
            return (a+b+height*(1/Math.sin(Math.toRadians(base_angle1)))+1/Math.sin(Math.toRadians(base_angle2)));
        }

        public TreeMap<String, Double> getDiagonals() {
            return new TreeMap<>(Map.of("D1",Math.sqrt(height*height+(a+height*1/Math.tan(Math.toRadians(base_angle1)))),"D2",Math.sqrt(height*height+(a+height*1/Math.tan(Math.toRadians(base_angle2))))));
        }

        public TreeMap<String, Double> getAngles() {
            return new TreeMap<>(Map.of("angle1",base_angle1,"angle2",180-base_angle1,"angle3",180-base_angle2,"angle4",base_angle2));
        }

        public TreeMap<String, Double> getSides() {
            return new TreeMap<>(Map.of("side1",a,"side2",height/Math.sin(Math.toRadians(base_angle1)),"side3",b
                    ,"side4",height/Math.sin(Math.toRadians(base_angle2))));
        }
    }
    final public static class method3 {
        private double a, b, height,angle;
        method2 trapezium;
        method3(double a, double b, double height) {
            this.a = a;
            this.b = b;
            this.height = height;
            this.angle=Math.toDegrees(Math.atan(2*height/(this.b-this.a)));
            trapezium=new method2(a,height,angle,angle);
        }
        public double getArea() {
            return trapezium.getArea();
        }

        public double getPerimeter() {
            return trapezium.getPerimeter();
        }

        public TreeMap<String, Double> getDiagonals() {
            return trapezium.getDiagonals();
        }

        public TreeMap<String, Double> getAngles() {
            return trapezium.getAngles();
        }

        public TreeMap<String, Double> getSides() {
            return trapezium.getSides();
        }
    }
}
