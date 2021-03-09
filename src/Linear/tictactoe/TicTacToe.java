package Linear.tictactoe;

import java.util.Arrays;
import static Linear.tictactoe.Cell.*;

public class TicTacToe extends Playable implements Referable {
    private Cell player;

    public TicTacToe(char player) {
        this.cell = new Cell[3][3];
        this.player = player == 'X' ? X : O;
        for (Cell[] cells : cell) {
            Arrays.fill(cells, EMPTY);
        }
    }

    public void switchPlayer() {
        if (isEmpty(player, O)) player = X;
        else player = O;
    }

    public void play(int rowCount, int columnCount) {
        boolean isInvalidCell = rowCount < 0 || rowCount > cell.length - 1 || columnCount < 0 || columnCount > cell.length - 1;
        if(isInvalidCell) throw new IllegalArgumentException("Invalid cell position");

        boolean isOccupied = cell[rowCount][columnCount] != EMPTY;
        if(isOccupied) throw new IllegalArgumentException("Cell board is occupied");

        else playOn(rowCount, columnCount);

    }

    public Cell getPlayer() {
        return player;
    }

    private void playOn(int rowCount, int columnCount) {
        cell[rowCount][columnCount] = player;
        switchPlayer();
    }

}

