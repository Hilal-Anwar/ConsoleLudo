package org.game.ludo;

import org.game.jcengine.util.shapes.Rectangle;
import org.game.jcengine.util.shapes.Type;

public class Dice extends Rectangle {
    Dice(int x,int y,int width,int height){
        super(x,y,width,height, Type.OUTLINE);
    }
    public static int _roll_dice() {
        return (int) (Math.random() * 6 + 1);
    }

}
