package org.game.jcengine.util.shapes;

import org.game.jcengine.core.Entity;

public class Rectangle extends Entity {
    private int x;
    private int y;
    private int width;
    private int height;

    private Type type;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        type = Type.OUTLINE;
        init_rectangle();
    }

    public Rectangle(int x, int y, int width, int height, Type type) {
        super(x, y);
        init_rectangle();

    }

    public void addEntity(Entity entity) {

    }

    private void init_rectangle() {

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private boolean isOnRectangle(int x, int y) {
        return (y == this.y-height / 2 || y == this.y+height/2) && (x == this.x-width / 2 || x == this.x+width/2);
    }
    private boolean isInRectangle(int x,int y){
        return false;
    }

}
