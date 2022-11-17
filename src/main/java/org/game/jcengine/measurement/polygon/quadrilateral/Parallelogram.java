package org.game.jcengine.measurement.polygon.quadrilateral;

import java.util.Map;
import java.util.TreeMap;

public class Parallelogram {
    public method1 setParallelogramValue(double base, double height) {
        return new method1(base, height);
    }

    public method2 setParallelogramValue(double base, double height, double angle) {
        return new method2(base, height, angle);
    }

    public static class method1 {
        double base, height;

        method1(double base, double height) {
            this.base = base;
            this.height = height;
        }

        public double getArea() {
            return base * height;
        }
    }

    public static class method2 {
        double base, height, angle;

        method2(double base, double height, double angle) {
            this.base = base;
            this.height = height;
            this.angle = angle;
        }

        public double getArea() {
            return base * height;
        }

        public double getPerimeter() {
            return 2 * base + 2 * height * 1 / Math.sin(Math.toRadians(angle));
        }

        public TreeMap<String, Double> getDiagonals() {
            return new TreeMap<>(Map.of("D1", Math.sqrt(base * base + (height * height / Math.sin(Math.toRadians(angle))) + 2 * base * height / Math.tan(Math.toRadians(angle))), "D2", Math.sqrt(base * base + (height * height / Math.sin(Math.toRadians(angle))) - 2 * base * height / Math.tan(Math.toRadians(angle)))));
        }

        public TreeMap<String, Double> getSides() {
            return new TreeMap<>(Map.of("side1", base, "side2", height / Math.sin(Math.toRadians(angle)), "side3", base, "side4", height / Math.sin(Math.toRadians(angle))));
        }

        public TreeMap<String, Double> getAngle() {
            return new TreeMap<>(Map.of("angle1", angle, "angle2", 180 - angle, "angle3", angle, "angle4", 180 - angle));
        }
    }
}
