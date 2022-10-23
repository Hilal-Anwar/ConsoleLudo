package org.game.ludo;

import org.game.jcengine.util.Colors;

import java.util.TreeMap;

/**
 * @author Helal anwar
 */
public class LudoTile
{
    private final long ludo_tile_no;
    private final int x;
    private final int y;
    private final int side;
    private final Colors color;
    private final TreeMap<TokensType,Token> tokenHashSet;
    public LudoTile(long ludo_tile_no,int x, int y, int side, TreeMap<TokensType,Token> tokenHashSet) {
        this.ludo_tile_no=ludo_tile_no;
        this.x = x;
        this.y = y;
        this.color=Colors.WHITE;
        this.side = side;
        this.tokenHashSet = tokenHashSet;
    }

    public LudoTile(long ludo_tile_no,int x, int y, int side, Colors color, TreeMap<TokensType, Token> tokenHashSet) {
        this.ludo_tile_no=ludo_tile_no;
        this.x = x;
        this.y = y;
        this.side = side;
        this.color = color;
        this.tokenHashSet = tokenHashSet;
    }
}
