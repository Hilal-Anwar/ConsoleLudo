package org.game.jcengine.measurement.polygon.n_gon;


import org.game.jcengine.measurement.polygon.Polygon;
import org.game.jcengine.util.Point;

import java.util.TreeSet;


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

    public TreeSet<Integer> xCoordinateInOROnPolygon(int y) {
        TreeSet<Integer> list = new TreeSet<>();
        for (var side : sides) {
            if ((y >= Math.min(side.point1().getY(), side.point2().getY())
                    && y <= Math.max(side.point1().getY(), side.point2().getY()))) {
                var p = getPoint(y, side.point1().getY(),
                        side.point2().getY(), side.point1().getX(), side.point2().getX());
                list.add(p.getX());
            }
        }
        return list;
    }

    private Point getPoint(int y, int y1, int y2, int x1, int x2) {
        return new Point((y - y1) * (x2 - x1) / (y2 - y1) + x1, y);
    }

    public void draw_filled() {
        StringBuilder stringBuilder = new StringBuilder();
        for (double i = getMAX_Y(); i >= getMIN_Y(); i--) {
            var points = xCoordinateInOROnPolygon((int) i);
            if (!points.isEmpty()) {
                for (double j = getMIN_X(); j <= getMAX_X(); j++) {
                    if (getPointInRange(points, j))
                        stringBuilder.append("██");
                    else stringBuilder.append("  ");
                }
                stringBuilder.append('\n');
            }
        }
        System.out.println(stringBuilder);
    }
    public void draw_hollow(int thickness) {
        StringBuilder stringBuilder = new StringBuilder();
        for (double i = getMAX_Y(); i >= getMIN_Y(); i--) {
            var points = xCoordinateInOROnPolygon((int) i);
            if (!points.isEmpty()) {
                for (double j = getMIN_X(); j <= getMAX_X(); j++) {
                    if (getPointInRange(points, j,thickness))
                        stringBuilder.append("██");
                    else stringBuilder.append("  ");
                }
                stringBuilder.append('\n');
            }
        }
        System.out.println(stringBuilder);
    }

    private boolean getPointInRange(TreeSet<Integer> points, double j) {
        if(points.size()==1 && j==points.first())
            return true;
        var it = points.iterator();
        it.next();
        for (var p : points) {
            if (it.hasNext()) {
                int x = it.next();
                if (j >= p && j <= x)
                    return true;
            }
        }
        return false;
    }
    private boolean getPointInRange(TreeSet<Integer> points, double j,int thickness) {
        if(points.size()==1 && j==points.first())
            return true;
        var it = points.iterator();
        it.next();
        for (var p : points) {
            if (it.hasNext()) {
                int x = it.next();
                if (j >= p && j <= p+thickness)
                    return true;
                if (j >= x && j <= x+thickness)
                    return true;
            }
        }
        return false;
    }

}
