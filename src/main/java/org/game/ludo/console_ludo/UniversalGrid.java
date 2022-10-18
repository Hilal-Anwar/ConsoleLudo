package org.game.ludo.console_ludo;

public class UniversalGrid {
    private int row;
    private int column;
    private int grid_width;
    private final boolean[][] dummy_grid;

    public UniversalGrid(int column, int row, int grid_width) {
        this.column = column;
        this.row = row;
        this.grid_width = grid_width;
        dummy_grid = new boolean[row][column];
    }

}
