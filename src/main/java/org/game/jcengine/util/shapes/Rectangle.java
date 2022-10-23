package org.game.jcengine.util.shapes;

import org.game.jcengine.core.Entity;

public class Rectangle extends Entity {
     private int x,y,width,height;

     private Type type;
     public Rectangle(int x,int y,int width,int height){
          super(x,y);
          type=Type.OUTLINE;
     }
     public Rectangle(int x,int y,int width,int height,Type type){
          super(x,y);

     }
     public void addEntity(Entity entity){

     }
}
