package org.game.jcengine.util;


public class Text {
    private String text;
    private Colors colors;
    public Text(String text,Colors colors){
        this.text=String.valueOf(text.charAt(0));
        this.colors=colors;
    }
    public static String getColorText(String text, Colors colors){
        return colors.getColor()+text+"\33[0m";
    }
}
