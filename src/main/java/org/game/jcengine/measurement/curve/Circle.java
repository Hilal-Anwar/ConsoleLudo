package org.game.jcengine.measurement.curve;

public class Circle {
    double radius;
    public Circle(String point){
        double x= Double.parseDouble(point.substring(point.indexOf('(')+1,point.indexOf(',')));
        double y= Double.parseDouble(point.substring(point.indexOf(',')+1));
        radius=Math.sqrt(x*x+y*y);
    }
    public Circle (String center ,String point){

    }
    public Circle(double radius){

    }
    
    public double getArea(){
        return (Math.PI*radius*radius);
    }
}
