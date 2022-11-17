package org.game.ludo;

import org.game.jcengine.measurement.polygon.n_gon.N_Gon;
import org.game.jcengine.util.Point;



public class Main {
    public static void main(String[] args) {
        var n_gon = /*new N_Gon(new Point(1,-3),new Point(5,-4),new Point(4,-3),new Point(9,1),
                new Point(7,2),new Point(8,5),new Point(5,4),new Point(5,5),
                new Point(3,4),new Point(4,9),new Point(2,7),new Point(0,10),
                new Point(-2,7),new Point(-4,8),new Point(-3,3),new Point(-5,6),
                new Point(-5,4),new Point(-8,5),new Point(-7,2),new Point(-9,1),
                new Point(-4,-3),new Point(-5,-4),new Point(0,-3),new Point(2,-7),new Point(2,-6));*/
                new N_Gon("(-20,-40)","(-50,30)","(0,80)","(60,50)","(60,-10)");
        n_gon.draw_filled();
    }
}