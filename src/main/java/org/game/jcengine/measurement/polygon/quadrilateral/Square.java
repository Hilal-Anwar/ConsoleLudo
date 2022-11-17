package org.game.jcengine.measurement.polygon.quadrilateral;

public class Square {
    public double getSide() {
        return side;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    private final double side,diagonal,area,perimeter;
    public Square(double side){
          this.side=side;
          this.area=side*side;
          this.perimeter=4*side;
          this.diagonal=side*Math.sqrt(2);
    }
    public Square(Double diagonal){
        this.side=diagonal/Math.sqrt(2);
        this.diagonal=diagonal;
        this.area=this.side*this.side;
        this.perimeter=4*this.side;
    }
}
