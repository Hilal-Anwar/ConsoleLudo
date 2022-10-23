package org.game.ludo;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {

            var cl = Class.forName("org.game.jcengine.core.Rendering");
            try {
                System.out.println(cl.getMethod("hiddenMessage").invoke(cl.getDeclaredConstructor().newInstance()));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                     InstantiationException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}