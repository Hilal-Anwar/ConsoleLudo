package org.game.ludo;

public class Dice {
    public static int _roll_dice() {
        return (int) (Math.random() * 6 + 1);
    }

}
