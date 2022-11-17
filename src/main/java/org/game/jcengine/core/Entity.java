package org.game.jcengine.core;

import org.game.jcengine.util.Point;
import org.game.jcengine.util.Text;

import java.util.HashMap;

abstract public class Entity {
    public HashMap<Point, Text> getEntity() {
        return entity;
    }
    private final HashMap<Point, Text> entity=new HashMap<>();
   private int x,y;
   protected Entity(int x,int y){
       this.x=x;
       this.y=y;
   }
   protected void draw(Point point,Text text){
       entity.put(point,text);
   }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
