package org.game.jcengine.util;

import org.game.jcengine.core.Scene;

import java.io.IOException;

public class KeyBoardInput {
    private Key keyBoardKey = Key.NONE;

    public KeyBoardInput(Scene scene) {
        new Thread(() -> {
            while (true) {
                try {
                    setKeyBoardKey(getKeys(scene.getTerminal().reader().read()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private static Key getKeys(int ch) {
        return switch (ch) {
            case 9 -> Key.TAB;
            case 13 -> Key.ENTER;
            case 27 -> Key.ESC;
            case 8 -> Key.BACKSPACE;
            case 65, 119 -> Key.UP;
            case 32 -> Key.SPACE;
            case 66, 115 -> Key.DOWN;
            case 68, 97 -> Key.LEFT;
            case 67, 100 -> Key.RIGHT;
            case 104 -> Key.HOLD;
            default -> Key.NONE;
        };
    }

    public Key getKeyBoardKey() {
        return keyBoardKey;
    }

    public void setKeyBoardKey(Key keyBoardKey) {
        this.keyBoardKey = keyBoardKey;
    }

    public enum Key {
        RIGHT,LEFT,UP,DOWN,SPACE,ENTER,TAB,ESC,BACKSPACE,HOLD,NONE
    }
}
