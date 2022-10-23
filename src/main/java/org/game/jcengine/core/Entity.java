package org.game.jcengine.core;

import org.game.jcengine.util.Point;
import org.game.jcengine.util.Text;

import java.util.HashMap;

public class Entity {
   private final HashMap<Point, Text> entity=new HashMap<>();
   private int x,y;
   public Entity(int x,int y){
       this.x=x;
       this.y=y;
   }
   public void draw(Point point,Text text){
       entity.put(point,text);
   }

}
