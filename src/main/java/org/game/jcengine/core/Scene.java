package org.game.jcengine.core;


import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

import java.io.IOException;
import java.util.HashSet;

public class Scene {
    private final int width;
    private final int height;
    Terminal terminal;
    public Scene(int width,int height){
        this.width=width;
        this.height=height;
        init_terminal();
    }

    private void init_terminal() {
        try {
            terminal = TerminalBuilder.terminal();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clear_scene(){
        terminal.puts(InfoCmp.Capability.clear_screen);
    }
    private HashSet<Entity> entityHashMap;

}
