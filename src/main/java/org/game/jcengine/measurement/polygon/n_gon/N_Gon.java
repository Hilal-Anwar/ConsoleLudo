package org.game.jcengine.measurement.polygon.n_gon;


import org.game.jcengine.measurement.polygon.Polygon;
import org.game.jcengine.util.Colors;
import org.game.jcengine.util.Point;
import org.game.jcengine.util.Text;

import java.util.ArrayList;



public class N_Gon extends Polygon {
    private double MAX_X, MIN_X;
    private double MAX_Y, MIN_Y;

    public N_Gon(String... vertex) {
        super(vertex);
        MAX_X = this.xCoordinate.stream().max(Double::compareTo).orElse(MAX_X);
        MAX_Y = this.yCoordinate.stream().max(Double::compareTo).orElse(MAX_Y);
        MIN_X = this.xCoordinate.stream().min(Double::compareTo).orElse(MIN_X);
        MIN_Y = this.yCoordinate.stream().min(Double::compareTo).orElse(MIN_Y);
        //System.out.println(getMIN_X() + " " + " " + getMAX_X() + " " + getMIN_Y() + " " + getMAX_Y());
    }

    public N_Gon(Point... points) {
        super(points);
        MAX_X = this.xCoordinate.stream().max(Double::compareTo).orElse(MAX_X);
        MAX_Y = this.yCoordinate.stream().max(Double::compareTo).orElse(MAX_Y);
        MIN_X = this.xCoordinate.stream().min(Double::compareTo).orElse(MIN_X);
        MIN_Y = this.yCoordinate.stream().min(Double::compareTo).orElse(MIN_Y);
        //System.out.println(getMIN_X() + " " + " " + getMAX_X() + " " + getMIN_Y() + " " + getMAX_Y());
    }

    public Point[] rotateClockWise(double angle) {
        Point[] point = new Point[xCoordinate.size()];
        angle = Math.toRadians(angle);
        for (int i = 0; i < xCoordinate.size(); i++) {
            double x = xCoordinate.get(i);
            double y = yCoordinate.get(i);
            double X = (getMAX_X() + getMIN_X()) / 2;
            double Y = (getMAX_Y() + getMIN_Y()) / 2;
            double arg = Math.atan2(y-Y, x-X);
            double d = arg - angle;
            double sqrt = Math.sqrt((X-x) * (X-x) + (Y-y) * (Y-y));
            //System.out.printf("%.3f %.3f  %.3f\n",sqrt, (sqrt * Math.cos(d)), (sqrt * Math.sin(d)));
            point[i] = new Point((sqrt * Math.cos(d)), (sqrt * Math.sin(d)));
        }
        return point;
    }

    public void rotateCounterClockWise() {

    }

    @Override
    public boolean isConvex() {
        return super.isConvex();
    }

    public double getMAX_X() {
        return MAX_X;
    }

    public double getMAX_Y() {
        return MAX_Y;
    }

    public double getMIN_X() {
        return MIN_X;
    }

    public double getMIN_Y() {
        return MIN_Y;
    }

    public ArrayList<Double> xCoordinateInOROnPolygon(double y) {
        ArrayList<Double> list = new ArrayList<>();
        for (var side : sides) {
            if ((y >= Math.min(side.point1().getY(), side.point2().getY())
                    && y <= Math.max(side.point1().getY(), side.point2().getY()))) {
                var p = getPoint(y, side.point1().getY(),
                        side.point2().getY(), side.point1().getX(), side.point2().getX());
                list.add(p.getX());
            }
        }
        list.sort(Double::compareTo);
        return list;
    }

    private Point getPoint(double y, double y1, double y2, double x1, double x2) {
        return new Point(getSlope(y, x1, x2, y1, y2) + x1, y);
    }

    private double getSlope(double y, double x1, double x2, double y1, double y2) {
        try {
            return (y - y1) * (x2 - x1) / (y2 - y1);
        } catch (ArithmeticException arithmeticException) {
            return 0;
        }

    }

    public void draw_filled() {
        String text=new Text("██", Colors.RED).getTextWithColor();
        StringBuilder stringBuilder = new StringBuilder();
        for (double i = getMAX_Y(); i >= getMIN_Y(); i--) {
            var points = xCoordinateInOROnPolygon(i);
            if (!points.isEmpty()) {
                for (double j = getMIN_X(); j <= getMAX_X(); j++) {
                    if (getPointInRange(points, j))
                        stringBuilder.append(text);
                    else stringBuilder.append("  ");
                }
                stringBuilder.append('\n');
            }
        }
        //System.out.println("\n".repeat(3));
        System.out.println(stringBuilder);
    }

    public void draw_hollow(int thickness) {
        String text=new Text("██", Colors.RED).getTextWithColor();
        StringBuilder stringBuilder = new StringBuilder();
        for (double i = getMAX_Y(); i >= getMIN_Y(); i--) {
            var points = xCoordinateInOROnPolygon((int) i);
            if (!points.isEmpty()) {
                for (double j = getMIN_X(); j <= getMAX_X(); j++) {
                    if (getPointInRange(points, j, thickness))
                        stringBuilder.append(text);
                    else stringBuilder.append("  ");
                }
                stringBuilder.append('\n');
            }
        }
        //System.out.println("\n".repeat(20));
        System.out.println(stringBuilder.toString());
    }

    private boolean getPointInRange(ArrayList<Double> points, double j) {
        if (points.size() == 1 && j == points.get(0))
            return true;
        for (int i=0;i<points.size()-1;i=i+2) {
                double p=points.get(i);
                double x = points.get(i+1);
                if ((int) j >= (int)p && (int) j <= (int) x)
                    return true;
        }
        return false;
    }

    private boolean getPointInRange(ArrayList<Double> points, double j, int thickness) {
        if (points.size() == 1 && j == points.get(0))
            return true;
        var it = points.iterator();
        it.next();
        for (var p : points) {
            if (it.hasNext()) {
                double x = it.next();
                if ((int) j >= p.intValue() && (int) j <= p.intValue() + thickness)
                    return true;
                if ((int) j >= (int) x && (int) j <= (int) x + thickness)
                    return true;
            }
        }
        return false;
    }

}
