package org.game.jcengine.measurement.polygon;

import org.game.jcengine.util.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;


abstract public class Polygon implements PolygonMeasurement {
    protected ArrayList<Double> xCoordinate = new ArrayList<>();
    protected ArrayList<Double> yCoordinate = new ArrayList<>();
    TreeSet<Integer> concaveVertex = new TreeSet<>();
    protected ArrayList<Side> sides = new ArrayList<>();

    public Polygon(String... vertex) {
        var point =new ArrayList<Point>();
        //int scale=10;
        Arrays.stream(vertex).forEachOrdered(s -> {
            var x=Double.parseDouble(s.substring(1, s.indexOf(',')));
            var y=Double.parseDouble(s.substring(s.indexOf(',') + 1, s.indexOf(')')));
            this.xCoordinate.add(x);
            this.yCoordinate.add(y);
            point.add(new Point((int)x,(int)y));
        });
        IntStream.range(0, point.size()-1).
                forEach(i -> this.sides.add(new Side(point.get(i), point.get(i+1))));
        this.sides.add(new Side(point.get(point.size()-1),point.get(0)));

    }

    public Polygon(Point... points) {
        int scale=10;
        Arrays.stream(points).forEachOrdered(s -> {
            this.xCoordinate.add(s.getX()*1.0);
            this.yCoordinate.add(s.getY()*1.0);
        });
        IntStream.range(0, points.length - 1).
                forEach(i -> this.sides.add(new Side(points[i], points[i + 1])));
        this.sides.add(new Side(points[points.length-1],points[0]));
    }

    @Override
    public double getArea() {
        double val1 = 0.0, val2 = 0.0;
        double area;
        for (int i = 0; i < xCoordinate.size() - 1; i++) {
            val1 = val1 + (xCoordinate.get(i) * yCoordinate.get(i + 1));
            val2 = val2 - (xCoordinate.get(i + 1) * yCoordinate.get(i));
        }
        area = 0.5 * (val1 + val2 + xCoordinate.get(xCoordinate.size() - 1) *
                yCoordinate.get(0) - xCoordinate.get(0) * yCoordinate.get(yCoordinate.size() - 1));
        return (area < 0) ? area * -1 : area;
    }

    @Override
    public double getPerimeter() {
        TreeMap<String, Double> treeMap = getSides();
        return IntStream.range(0, treeMap.size()).mapToDouble(i -> treeMap.get("side" + (i + 1))).sum();
    }

    @Override
    public TreeMap<String, Double> getDiagonals() {
        var hashMap = new TreeMap<String, Double>();
        int k = xCoordinate.size() - 3;
        int point;
        for (int i = 0; i < xCoordinate.size(); i++) {
            point = i + 2;
            if (i != 0 && i != 1)
                k--;
            for (int j = 1; j <= k; j++) {
                hashMap.put("D" + (i + 1), Math.sqrt(Math.pow((xCoordinate.get(i) - xCoordinate.get(point)), 2)
                        + Math.pow((yCoordinate.get(i) - yCoordinate.get(point)), 2)));
                point++;
            }
        }
        return hashMap;
    }

    @Override
    public TreeMap<String, Double> getAngles() {
        isConvex();
        var hashMap = new TreeMap<String, Double>();
        int point1, point2;
        for (int i = 0; i < xCoordinate.size(); i++) {
            if (i == 0) {
                point1 = xCoordinate.size() - 1;
                point2 = 1;
            } else if (i == xCoordinate.size() - 1) {
                point2 = 0;
                point1 = xCoordinate.size() - 2;
            } else {
                point1 = i - 1;
                point2 = i + 1;
            }
            double val1 = ((xCoordinate.get(i) - xCoordinate.get(point1)) * (xCoordinate.get(i) - xCoordinate.get(point2))) +
                    ((yCoordinate.get(i) - yCoordinate.get(point1)) * (yCoordinate.get(i) - yCoordinate.get(point2)));
            double val2 = Math.sqrt(Math.pow((xCoordinate.get(point1) - xCoordinate.get(i)), 2) +
                    Math.pow((yCoordinate.get(point1) - yCoordinate.get(i)), 2)) *
                    Math.sqrt(Math.pow((xCoordinate.get(point2) - xCoordinate.get(i)), 2) +
                            Math.pow((yCoordinate.get(point2) - yCoordinate.get(i)), 2));
            double angle = Math.toDegrees(Math.acos(val1 / val2));
            if (concaveVertex.contains(i) || (concaveVertex.contains(xCoordinate.size()) && i == xCoordinate.size() - 1))
                hashMap.put("S" + (i + 1) + "_" + "S" + (point1 + 1), 360.0 - angle);
            else
                hashMap.put("S" + (i + 1) + "_" + "S" + (point1 + 1), angle);
        }
        return hashMap;
    }

    @Override
    public TreeMap<String, Double> getSides() {
        var sides = new TreeMap<String, Double>();
        var size = xCoordinate.size();
        IntStream.range(0, size).forEachOrdered(i -> sides.put("side" + (i + 1),
                Math.sqrt(Math.pow((xCoordinate.get((i + 1) % size) - xCoordinate.get(i)), 2)
                        + Math.pow((yCoordinate.get((i + 1) % size) - yCoordinate.get(i)), 2))));
        return sides;
    }

    @Override
    public String getIncenter() {
        if (isRegular()) {
            var x1 = xCoordinate.get(0);
            var y1 = yCoordinate.get(0);
            var x2 = xCoordinate.get(1);
            var y2 = yCoordinate.get(1);
            var x3 = xCoordinate.get(2);
            var y3 = yCoordinate.get(2);
            double v1 = (x2 * x2 - x1 * x1) + (y2 * y2 - y1 * y1);
            double v2 = (x3 * x3 - x2 * x2) + (y3 * y3 - y1 * y1);
            var y = ((x3 - x2) * v1 - (x2 - x1) * v2) /
                    (2 * ((y2 - y1) * (x3 - x2) - (y3 - y2) * (x2 - x1)));
            var x = ((y3 - y2) * v1 - (y2 - y1) * v2) /
                    (2 * ((x2 - x1) * (y3 - y2) - (x3 - x2) * (y2 - y1)));
            return ("(" + x + "," + y + ")");
        }
        return "Polygon is not regular";

    }

    @Override
    public String getCircumcentre() {
        if (isConvex()) {
            var x1 = xCoordinate.get(0);
            var x2 = xCoordinate.get(1);
            var x3 = xCoordinate.get(2);
            var y1 = yCoordinate.get(0);
            var y2 = yCoordinate.get(1);
            var y3 = yCoordinate.get(2);
            var m1 = (y2 - y1) / (x2 - x1);
            var m2 = (y3 - y2) / (x3 - x2);
            var x = (m1 * m2 * (y2 - y3) - m1 * m2 * (y1 - y2) - (x1 + x2) + (x2 + x3)) / (2 * (m1 - m2));
            var y = (-m2 * (x2 + x3 - y2 - y3) - m1 * (x1 + x2 - y1 - y2)) / (2 * (m2 - m1));
            if (m1 == Double.POSITIVE_INFINITY || m2 == Double.POSITIVE_INFINITY) {
                return ("(" + ((x1 + x2) / 2) + "," + ((y2 + y3) / 2) + ")");
            } else
                return ("(" + x + "," + y + ")");
        } else
            return "Polygon is not convex";
    }

    @Override
    public double getAngleBetweenAdjacentSide(int side_Num1, int side_Num2) {
        return getAngles().containsKey("S" + side_Num1 + "_" + "S" + side_Num2) ?
                getAngles().get("S" + side_Num1 + "_" + "S" + side_Num2) :
                getAngles().get("S" + side_Num2 + "_" + "S" + side_Num1);
    }

    @Override
    public double getDistanceBetween(int v1, int v2) {
        return Math.sqrt(Math.pow((xCoordinate.get(v2) - xCoordinate.get(v1)), 2) + Math.pow(((yCoordinate.get(v2) - yCoordinate.get(v1))), 2));
    }

    @Override
    public boolean isRegular() {
        return getSides().get("side1") * xCoordinate.size() == getPerimeter();
    }

    protected boolean isConvex() {
        if (xCoordinate.size() < 4)
            return true;
        boolean sign = false;
        int n = xCoordinate.size();
        for (int i = 0; i < n; i++) {
            double dx1 = xCoordinate.get((i + 2) % n) - xCoordinate.get((i + 1) % n);
            double dy1 = yCoordinate.get((i + 2) % n) - yCoordinate.get((i + 1) % n);
            double dx2 = xCoordinate.get(i) - xCoordinate.get((i + 1) % n);
            double dy2 = yCoordinate.get(i) - yCoordinate.get((i + 1) % n);
            double CrossProduct = dx1 * dy2 - dy1 * dx2;
            if (i == 0)
                sign = CrossProduct > 0;
            else if (sign != (CrossProduct > 0)) {
                if ((i + 2) > n) {
                    concaveVertex.add(0);
                    break;
                } else
                    concaveVertex.add((i + 2));
            }
        }
        return concaveVertex.isEmpty();
    }
}
