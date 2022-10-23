package org.game.jcengine.util;

public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getBlock() {
        return "\033[0;32m█\33[0m";
    }

}