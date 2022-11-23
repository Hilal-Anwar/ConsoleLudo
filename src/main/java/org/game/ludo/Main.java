package org.game.ludo;

import org.game.jcengine.measurement.polygon.n_gon.N_Gon;
import org.game.jcengine.util.Point;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        N_Gon n_gon = /*new N_Gon(new Point(10,-30),new Point(50,-40),new Point(40,-30),new Point(90,10),
                new Point(70,20),new Point(80,50),new Point(50,40),new Point(50,50),
                new Point(30,40),new Point(40,90),new Point(20,70),new Point(0,100),
                new Point(-20,70),new Point(-40,80),new Point(-30,30),new Point(-50,60),
                new Point(-50,40),new Point(-80,50),new Point(-70,20),new Point(-90,10),
                new Point(-40,-30),new Point(-50,-40),
                new Point(0,-30),new Point(20,-70),new Point(20,-60));*/
                new N_Gon(new Point(-10,-80),
                        new Point(-10,-10),
                        new Point(-90,-10),
                        new Point(-90,10),
                        new Point(-10,10),
                        new Point(-10,80),
                        new Point(10,80),
                        new Point(10,10),
                        new Point(90,10),
                        new Point(90,-10),
                        new Point(10,-10),
                        new Point(10,-80));
        //new N_Gon(new Point(10,10),new Point(15,30),new Point(20,10));
        int c=1;
        Point []t=null;
        Terminal terminal;
        try {
            terminal = TerminalBuilder.terminal();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //new N_Gon(t).draw_filled();
        while (true) {
            terminal.puts(InfoCmp.Capability.clear_screen);
            n_gon.draw_hollow(8);
            t = n_gon.rotateClockWise(3);
            n_gon=new N_Gon(t);
            Thread.sleep(20);
        }
        //n_gon.draw_filled();
        //System.out.println(Arrays.toString(t));
    }
}