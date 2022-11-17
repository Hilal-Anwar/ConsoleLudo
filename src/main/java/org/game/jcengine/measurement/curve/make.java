package org.game.jcengine.measurement.curve;


import org.game.jcengine.measurement.polygon.n_gon.N_Gon;
import org.game.jcengine.measurement.polygon.quadrilateral.Quadrilateral;
import org.game.jcengine.measurement.polygon.quadrilateral.Rectangle;

public class make {
    public static void main(String[] args) {

        var rectangle=new Quadrilateral("(0,0)","(5,0)","(5,6)","(0,6)");
        System.out.println(rectangle.getDiagonals());
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getAngles());
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getAngleBetweenAdjacentSide(1,4));
        //N_Gon n_gon=new N_Gon("(-2,-4)","(-5,3)","(0,8)","(6,5)","(6,-1)");
        N_Gon n_gon=new N_Gon("(-5,-5)","(5,-5)","(5,5)","(-5,5)");
        System.out.println(n_gon.getDiagonals());
        System.out.println("The area of polygon"+n_gon.getArea());
        System.out.println("The perimeter of polygon"+n_gon.getPerimeter());
        System.out.println(n_gon.getAngles());
        System.out.println(n_gon.isRegular());
        System.out.println(n_gon.getIncenter());
        System.out.println(n_gon.getCircumcentre());
        System.out.println();
        N_Gon n_gon1=new N_Gon("(3,4)","(5,11)","(12,8)","(9,5)","(5,6)");
        System.out.println(n_gon1.getDiagonals());
        System.out.println(n_gon1.getArea());
        System.out.println(n_gon1.getAngles());
        System.out.println("The perimeter of polygon"+n_gon1.getPerimeter());
        System.out.println(n_gon1.isRegular());
        System.out.println();
        N_Gon n_gon2 =new N_Gon("(1,-3)","(5,-4)","(4,-3)","(9,1)",
                "(7,2)","(8,5)","(5,4)","(5,5)",
                "(3,4)","(4,9)","(2,7)","(0,10)",
                "(-2,7)","(-4,8)","(-3,3)","(-5,6)",
                "(-5,4)","(-8,5)","(-7,2)","(-9,1)",
                "(-4,-3)","(-5,-4)","(0,-3)","(2,-7)","(2,-6)");
        System.out.println(n_gon2.getSides());
        System.out.println(n_gon2.getSides().size());
        System.out.println(n_gon2.getArea());
        System.out.println(n_gon2.getAngles());
        System.out.println(n_gon2.getDiagonals());
        System.out.println(n_gon2.getAngleBetweenAdjacentSide(7,8));
        System.out.println("The perimeter of polygon"+n_gon2.getPerimeter());
        System.out.println(n_gon2.isRegular());
        System.out.println(n_gon2.getCircumcentre());
        Rectangle rectangle1=new Rectangle(25,36);
        System.out.println(rectangle1.getArea());
    }
}
