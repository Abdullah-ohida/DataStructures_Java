package Linear.tictactoe;

import java.util.Arrays;
import static Linear.tictactoe.Cell.*;

public class TicTacToe extends Playable {
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

    @Override
    public void play(int rowCount, int columnCount) {
        if(rowCount < 0 || rowCount > cell.length - 1 || columnCount < 0 || columnCount > cell.length - 1){
            throw new IllegalArgumentException("Invalid cell position");
        }
        if(cell[rowCount][columnCount] != Cell.EMPTY){
            throw new IllegalArgumentException("Cell board is occupied");
        }else{
            cell[rowCount][columnCount] = player;
            switchPlayer();
        }
    }

    public Cell getPlayer() {
        return player;
    }

    private void playOn(int rowCount, int columnCount) {
        cell[rowCount][columnCount] = player;
        switchPlayer();
    }

}

